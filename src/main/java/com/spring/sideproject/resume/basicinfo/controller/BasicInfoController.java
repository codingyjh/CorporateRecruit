package com.spring.sideproject.resume.basicinfo.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.constant.MasterCodeConstants;
import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.resume.basicinfo.service.BasicInfoService;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

@Controller
public class BasicInfoController {

	@Autowired
	private String basicInfoImageUploadFilePath;
	
	@Autowired
	private BasicInfoService basicInfoService;
	
	@GetMapping("/resume/basicInfo.do/{resumeId}")
	public ModelAndView viewBasicInfoPage(
			@PathVariable int resumeId) {
		
		BasicInfoVo basicInfo = this.basicInfoService.readOneBasicInfoByResumeIdService(resumeId);
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("basicInfoVo", basicInfo);
		
		return view;
	}
	
	@PostMapping("/resume/basicInfoTempSave.do")
	@ResponseBody
	public Map<Object, Object> doBasicInfoTempSaveAction(
			MultipartRequest multipartRequest
			, @ModelAttribute BasicInfoVo basicInfoVo) {
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		MultipartFile uploadFile = multipartRequest.getFile(MasterCodeConstants.FILE);
		
		if ( !uploadFile.isEmpty() ) {
			
			// 실제 파일 이름
			String imgOriginFileName = uploadFile.getOriginalFilename();
			
			// 파일 시스템에 저장될 파일의 이름(난수)
			String imgFileName = UUID.randomUUID().toString();
			
			File uploadDir = new File(this.basicInfoImageUploadFilePath);
			
			// 폴더가 존재하지 않는다면 생성
			if ( !uploadDir.exists() ) {
				uploadDir.mkdirs();
			}
			
			// 파일이 업로드될 경로 지정
			File destFile = new File(this.basicInfoImageUploadFilePath,imgFileName);
			
			try {
				// 업로드
				uploadFile.transferTo(destFile);
				// DB에 File 정보 저장하기 위한 정보 셋팅
				basicInfoVo.setImgOriginFileName(imgOriginFileName);
				basicInfoVo.setImgFileName(imgFileName);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		boolean isTempSaveCheck = this.basicInfoService.updateOneBasicInfoService(basicInfoVo);
		
		if ( isTempSaveCheck != true ) {
			map.put("fail", isTempSaveCheck);
			return map;
		}
		
		map.put("success", isTempSaveCheck);
		return map;	
	}
}
