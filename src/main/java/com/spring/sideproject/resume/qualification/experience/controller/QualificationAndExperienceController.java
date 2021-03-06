package com.spring.sideproject.resume.qualification.experience.controller;

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
import com.spring.sideproject.resume.qualification.experience.service.QualificationExperienceService;
import com.spring.sideproject.resume.qualification.experience.vo.QualificationExperienceVo;

@Controller
public class QualificationAndExperienceController {

	@Autowired
	private QualificationExperienceService qualificationExperienceService;
	
	@GetMapping("/resume/qualificationExperience.do/{resumeId}")
	public ModelAndView viewQualificationExperiencePage(
			@PathVariable int resumeId
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		QualificationExperienceVo qualificationExperience = this.qualificationExperienceService.readOneQualificationExperienceService(resumeId);
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("qualificationExperienceVo", qualificationExperience);
		
		return view;
	}
	
	@PostMapping("/resume/qualificationExperienceTempSave.do")
	@ResponseBody
	public Map<Object, Object> doQualificationExperienceTempSaveAction(
			@ModelAttribute QualificationExperienceVo qualificationExperienceVo
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {

		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		String email = recruitMemberVo.getEmail();
		qualificationExperienceVo.setEmail(email);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean isTempSaveCheck = this.qualificationExperienceService.updateOneQualificationExperienceService(qualificationExperienceVo);
		
		if ( !isTempSaveCheck == true ) {
			map.put("fail", isTempSaveCheck);
			return map;
		}
		map.put("success", isTempSaveCheck);
		return map;
	}
	
	@PostMapping("/resume/qualificationExperienceNextStep.do/{resumeId}")
	public ModelAndView doQualificationAndEducationAction(
			@ModelAttribute QualificationExperienceVo qualificationExperienceVo
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		int resumeId = qualificationExperienceVo.getResumeId();
		ModelAndView view =  new ModelAndView(MasterCodeConstants.REDIRECT_RESUME_SELF_INTRODUCE + "/" + resumeId + "?token=" + sessionToken);
		
		String email = recruitMemberVo.getEmail();
		qualificationExperienceVo.setEmail(email);
		qualificationExperienceVo.setRecruitMemberVo(recruitMemberVo);
		
		boolean isSuccess = this.qualificationExperienceService.updateOneQualificationExperienceService(qualificationExperienceVo);
		
		return view;
	}
	
}
