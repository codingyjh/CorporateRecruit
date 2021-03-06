package com.spring.sideproject.resume.academicbacground.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.constant.MasterCodeConstants;
import com.spring.sideproject.common.session.Session;
import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.academicbacground.service.AcademicBackgroundService;
import com.spring.sideproject.resume.academicbacground.vo.AcademicBackgroundVo;

@Controller
public class AcademicBackgroundController {

	@Autowired
	private AcademicBackgroundService academicBackgroundService;
	
	@GetMapping("/resume/academicBackground.do/{resumeId}")
	public ModelAndView viewAcademicBackgroundPage(
			@PathVariable int resumeId
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		AcademicBackgroundVo academicBackground = this.academicBackgroundService.readOneAcademicBackgroundByResumeIdService(resumeId);
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("academicBackgroundVo", academicBackground);
		
		return view;		
	}
	
	@PostMapping("/resume/academicBackgroundTempSave.do")
	@ResponseBody
	public Map<Object, Object> doAcademicBackgroundTempSaveAction(
			@ModelAttribute AcademicBackgroundVo academicBackgroundVo
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		String email = recruitMemberVo.getEmail();
		academicBackgroundVo.setEmail(email);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		boolean isTempSaveCheck = this.academicBackgroundService.updateOneAcademicBackgroundService(academicBackgroundVo);
		
		if ( isTempSaveCheck != true ) {
			map.put("fail", isTempSaveCheck);
			return map;
		}
		
		map.put("success", isTempSaveCheck);
		return map;	
	}
	
	@PostMapping("/resume/academicBackgroundNextStep.do/{resumeId}")
	public ModelAndView doAcademicBackgroundAction(
			@ModelAttribute AcademicBackgroundVo academicBackgroundVo			
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		int resumeId = academicBackgroundVo.getResumeId();
		ModelAndView view = new ModelAndView(MasterCodeConstants.REDIRECT_RESUME_QUALIFICATION_EXPERIENCE + "/" + resumeId + "?token=" + sessionToken);
		
		String email = recruitMemberVo.getEmail();
		academicBackgroundVo.setEmail(email);
		academicBackgroundVo.setRecruitMemberVo(recruitMemberVo);
		
		boolean isSuccess = this.academicBackgroundService.updateOneAcademicBackgroundService(academicBackgroundVo);
		
		return view;
	}
}
