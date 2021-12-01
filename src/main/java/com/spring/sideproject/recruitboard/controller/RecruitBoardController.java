package com.spring.sideproject.recruitboard.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.lucy.security.xss.XssFilter;
import com.spring.sideproject.common.constant.MasterCodeConstants;
import com.spring.sideproject.common.mimetype.ExtFilter;
import com.spring.sideproject.common.mimetype.ExtensionFilter;
import com.spring.sideproject.common.mimetype.ExtensionFilterFactory;
import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.common.session.Session;
import com.spring.sideproject.common.utils.DownloadUtil;
import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.recruitboard.service.RecruitBoardService;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.service.BasicInfoService;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;


@Controller
public class RecruitBoardController {
	
	private Logger logger = LoggerFactory.getLogger(RecruitBoardController.class);
	
	@Autowired
	private String uploadFilePath;
	
	@Autowired
	private RecruitBoardService recruitBoardService;
	
	@Autowired
	private BasicInfoService basicInfoService;
	
	@RequestMapping("/recruitBoard/recruitBoardInit.do") 
	public String viewRecruitBoardListPageForInitiate(HttpSession session) {
		
		session.removeAttribute(Session.RECRUIT_BOARD_SEARCH);
		return MasterCodeConstants.REDIRECT_RECRUIT_BOARD_LIST;
	}
	
	
	@RequestMapping("/recruitBoard/recruitBoardList.do")
	public ModelAndView viewBoardListPaga(
			@ModelAttribute RecruitBoardSearchVo recruitBoardSearchVo
			,HttpSession session) {
		
		if( recruitBoardSearchVo.getSearchKeyword() == null ) {
			recruitBoardSearchVo = (RecruitBoardSearchVo) session.getAttribute(Session.RECRUIT_BOARD_SEARCH);
			
			if ( recruitBoardSearchVo == null ) {
				recruitBoardSearchVo = new RecruitBoardSearchVo();
				recruitBoardSearchVo.setPageNo(0);
			}
		}
		
		PageExplorer pageExplorer = this.recruitBoardService.readAllRecruitBoardsService(recruitBoardSearchVo);
		
		session.setAttribute(Session.RECRUIT_BOARD_SEARCH, recruitBoardSearchVo);
		
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("recruitBoardVoList", pageExplorer.getList());
		view.addObject("pagenation", pageExplorer.make());
		view.addObject("size", pageExplorer.getTotalCount());
		view.addObject("recruitBoardSearchVo", recruitBoardSearchVo);
		
		return view;
	}
	
	@GetMapping("/recruitBoard/recruitBoardWrite.do")
	public String viewRecruitBoardWritePage(
			@RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}		
		
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitBoard/recruitBoardWrite.do")
	public ModelAndView doRecruitBoardWriteAction(
			@Valid @ModelAttribute RecruitBoardVo recruitBoardVo
			, Errors errors
			, HttpSession session
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		
		recruitBoardVo.setTitle(filter.doFilter(recruitBoardVo.getTitle()));
		recruitBoardVo.setContent(filter.doFilter(recruitBoardVo.getContent()));
		
		if ( !recruitBoardVo.getToken().equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		ModelAndView view = new ModelAndView(MasterCodeConstants.REDIRECT_RECRUIT_BOARD_LIST);
		
		// Validation Annotation이 실패했는지 체크
		if ( errors.hasErrors() ) {
			view.setViewName(HttpRequestHelper.getJspPath());
			view.addObject("recruitBoardVO", recruitBoardVo);
			return view;
		}
		
		MultipartFile uploadFile = recruitBoardVo.getFile();
		
		if ( !uploadFile.isEmpty() ) {
			// 실제 파일 이름
			String originFileName = uploadFile.getOriginalFilename();
			// 파일 시스템에 저장될 파일의 이름(난수)
			String fileName = UUID.randomUUID().toString();
			
			File uploadDir = new File(this.uploadFilePath);
			
			// 폴더가 존재하지 않는다면 생성
			if ( !uploadDir.exists() ) {
				uploadDir.mkdirs();
			}
			
			// 파일이 업로드될 경로 지정
			File destFile = new File(this.uploadFilePath, fileName);
						
			try {
				// 업로드
				uploadFile.transferTo(destFile);
				// DB에 File 정보 저장하기 위한 정보 셋팅
				recruitBoardVo.setOriginFileName(originFileName);
				recruitBoardVo.setFileName(fileName);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		RecruitMemberVo loginRecruitMember = (RecruitMemberVo) session.getAttribute(Session.USER);
		String email = loginRecruitMember.getEmail();
		recruitBoardVo.setRecruitMemberVo(loginRecruitMember);
		recruitBoardVo.setEmail(email);
		
		boolean isSuccess = this.recruitBoardService.createOneRecruitBoardService(recruitBoardVo, loginRecruitMember);
		
		return view;
	}
	
	@RequestMapping("/recruitBoard/recruitBoardImageFileUpload.do")
	@ResponseBody
	public Map<String, Object> doRecruitBoardImageFileUploadAction(
			MultipartHttpServletRequest multiFile) {
		
		Map<String, Object> result = new HashMap<>();
		MultipartFile uploadFile = multiFile.getFile(MasterCodeConstants.UPLOAD);
		
		if( !uploadFile.isEmpty() ) {
			String fileName = UUID.randomUUID().toString();
			
			File uploadDir = new File(this.uploadFilePath);
			
			if ( !uploadDir.exists() ) {
				uploadDir.mkdirs();
			}
			
			File destFile = new File(this.uploadFilePath, fileName);
			
            try {
            	uploadFile.transferTo(destFile);
            } catch (IllegalStateException | IOException e) {
            	throw new RuntimeException(e.getMessage(), e);
            } finally {
            	
            	if ( destFile.exists() ) {
           		 
            		ExtensionFilter filter = ExtensionFilterFactory.getFilter(ExtFilter.APACHE_TIKA);
            		boolean isImageFile = filter.doFilter(destFile.getAbsolutePath()
            																		,MasterCodeConstants.IMAGE_JPG_PATH
            																		,MasterCodeConstants.IMAGE_BMP_PATH
            																		,MasterCodeConstants.IMAGE_JPEG_PATH
            																		,MasterCodeConstants.IMAGE_GIF_PATH
            																		,MasterCodeConstants.IMAGE_PNG_PATH );
           		 
            		if ( !isImageFile ) {
            			destFile.delete();
            			throw new RuntimeException("이미지 파일이 아닙니다.");
            		}            		 
            	}
            }
            result.put(MasterCodeConstants.UPLOADED, true);
            result.put(MasterCodeConstants.URL, MasterCodeConstants.RECRUIT_BOARD_IMAGE_DOWNLOADED + fileName);
            
            return result;
		}
		throw new RuntimeException("파일이 존재하지 않습니다.");
	}
	
	@RequestMapping("/recruitBoard/recruitBoardImageDownloaded.do/{fileName}")
	public void recruitBoardImageDownload(
			@PathVariable String fileName
			, HttpServletRequest request
			, HttpServletResponse response) {
		
		try {
			new DownloadUtil(this.uploadFilePath + File.separator + fileName).download(request, response, fileName);
		} catch ( UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}	
	}
	
	@RequestMapping("/recruitBoard/recruitBoardDetail.do/{boardId}")
	public ModelAndView viewRecruitBoardDetailPage(
			@PathVariable int boardId
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo) {
		
		RecruitBoardVo readRecruitBoard = this.recruitBoardService.readOneRecruitBoardService(boardId, recruitMemberVo);
		
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("recruitBoardVo", readRecruitBoard);
		
		return view;
	}
	
	@RequestMapping("/recruitBoard/recruitBoardFileDownload.do/{boardId}")
	public void doRecruitBoardFileDownloadAction (
			@PathVariable int boardId
			, HttpServletRequest request
			, HttpServletResponse response
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo) {
		
		RecruitBoardVo recruitBoard = this.recruitBoardService.readOneRecruitBoardService(boardId);
		
		String originFileName = recruitBoard.getOriginFileName();
		String fileName = recruitBoard.getFileName();
		
		try {
			new DownloadUtil(this.uploadFilePath + File.separator + fileName)
			 .download(request, response, originFileName);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@GetMapping("/recruitBoard/recruitBoardUpdate.do/{boardId}")
	public ModelAndView viewRecruitBoardUpdatePage(
			@PathVariable int boardId
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		RecruitBoardVo recruitBoard = this.recruitBoardService.readOneRecruitBoardService(boardId);
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("recruitBoardVo", recruitBoard);
		
		return view;
	}
	
	@PostMapping("/recruitBoard/recruitBoardUpdate.do/{boardId}")
	public ModelAndView doRecruitUpdateAction(
			@PathVariable int boardId
			, @Valid @ModelAttribute RecruitBoardVo recruitBoardVo
			, Errors errors
			, HttpSession session) {

		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");		
		recruitBoardVo.setTitle(filter.doFilter(recruitBoardVo.getTitle()));
		recruitBoardVo.setContent(filter.doFilter(recruitBoardVo.getContent()));
		
		ModelAndView view = new ModelAndView(MasterCodeConstants.REDIRECT_RECRUIT_BOARD_DETAIL + "/" + boardId);
		
		if ( errors.hasErrors() ) {
			view.setViewName(HttpRequestHelper.getJspPath());
			view.addObject("recruitBoardVo", recruitBoardVo);
			return view;
		}
		
		MultipartFile uploadFile = recruitBoardVo.getFile();
		
		if ( !uploadFile.isEmpty() ) {
			// 실제 파일 이름
			String originFileName = uploadFile.getOriginalFilename();
			// 파일 시스템에 저장될 파일의 이름(난수)
			String fileName = UUID.randomUUID().toString();
			
			File uploadDir = new File(this.uploadFilePath);
			
			// 폴더가 존재하지 않는다면 생성
			if ( !uploadDir.exists() ) {
				uploadDir.mkdirs();
			}
			
			// 파일이 업로드될 경로 지정
			File destFile = new File(this.uploadFilePath, fileName);
						
			try {
				// 업로드
				uploadFile.transferTo(destFile);
				// DB에 File 정보 저장하기 위한 정보 셋팅
				recruitBoardVo.setOriginFileName(originFileName);
				recruitBoardVo.setFileName(fileName);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		RecruitMemberVo loginRecruitMember = (RecruitMemberVo) session.getAttribute(Session.USER);
		String email = loginRecruitMember.getEmail();
		recruitBoardVo.setRecruitMemberVo(loginRecruitMember);
		recruitBoardVo.setEmail(email);
		
		boolean isSuccess = this.recruitBoardService.updateOneRecruitBoardService(recruitBoardVo);
		
		return view;
	}
	
	@RequestMapping("/recruitBoard/recruitBoardDelete.do/{boardId}")
	public String doRecruitBoardDeleteAction(
			@PathVariable int boardId
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}		
		
		boolean isSuccess = this.recruitBoardService.deleteOneRecruitBoardByBoardIdService(boardId);
		
		return MasterCodeConstants.REDIRECT_RECRUIT_BOARD_LIST;
	}
	
	@GetMapping("/recruitBoard/recruitAgreement.do/{boardId}")
	public String viewRecruitAgreementPage(
			@PathVariable int boardId
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitBoard/recruitAgreement.do/{boardId}")
	public ModelAndView doRecruitAgreementAction(
			@PathVariable int boardId
			, @RequestParam(value="agree", defaultValue="false") Boolean agree 
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo) {
		
		BasicInfoVo basicInfo = new BasicInfoVo();
		String email = recruitMemberVo.getEmail();
		basicInfo.setEmail(email);
		basicInfo.setRecruitMemberVo(recruitMemberVo);
		basicInfo.setBoardId(boardId);
		
		boolean isSuccess = this.basicInfoService.createOneResumeInfoService(basicInfo, recruitMemberVo, boardId);
		
		int resumeId = this.basicInfoService.readOneBasicInfoByEmailService(email);
		
		ModelAndView view = new ModelAndView(MasterCodeConstants.REDIRECT_RESUME_BASIC_INFO + "/" + resumeId);
		
		if ( !agree ) {
			logger.info("agree의 값 : " + agree);
			view = new ModelAndView(HttpRequestHelper.getJspPath());
			return view;
		}
		
		return view;
		
	}
}
