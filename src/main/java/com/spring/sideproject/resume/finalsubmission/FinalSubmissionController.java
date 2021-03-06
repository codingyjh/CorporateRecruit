package com.spring.sideproject.resume.finalsubmission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.constant.MasterCodeConstants;
import com.spring.sideproject.common.session.Session;
import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.resume.basicinfo.service.BasicInfoService;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

@Controller
public class FinalSubmissionController {

	@Autowired
	private BasicInfoService basicInfoService;
	
	@GetMapping("/resume/finalSubmissionAgreement.do/{resumeId}")
	public ModelAndView viewFinalSubmissionPage(
			@PathVariable int resumeId
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		BasicInfoVo basicInfo = this.basicInfoService.readOneBasicInfoByResumeIdService(resumeId);
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("basicInfoVo", basicInfo);
		
		return view;
	}
	
	@PostMapping("/resume/finalSubmissionAgreement.do/{resumeId}")
	public ModelAndView doFinalSubmitssionAgreeAction(
			@PathVariable int resumeId
			, @RequestParam(value="agree", defaultValue="false") Boolean agree 
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		ModelAndView view = new ModelAndView(MasterCodeConstants.REDIRECT_RESUME_FINISH_RESUME + "/" + resumeId + "?token=" + sessionToken);
		
		if ( !agree ) {			
			view = new ModelAndView(HttpRequestHelper.getJspPath());
			return view;
		}
		
		return view;
	}
	
	@GetMapping("/resume/finishResume.do/{resumeId}")
	public ModelAndView viewfinalResumePage(
			@PathVariable int resumeId
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		return view;
	}
}
