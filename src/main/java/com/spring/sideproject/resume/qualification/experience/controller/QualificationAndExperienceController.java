package com.spring.sideproject.resume.qualification.experience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.resume.qualification.experience.service.QualificationExperienceService;
import com.spring.sideproject.resume.qualification.experience.vo.QualificationExperienceVo;

@Controller
public class QualificationAndExperienceController {

	@Autowired
	private QualificationExperienceService qualificationExperienceService;
	
	@GetMapping("/resume/qualificationAndEducation.do/{resumeId}")
	public ModelAndView viewQualificationAndEducationPage(
			@PathVariable int resumeId) {
		
		QualificationExperienceVo qualificationExperience = this.qualificationExperienceService.readOneQualificationExperience(resumeId);
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("qualificationExperienceVo", qualificationExperience);
		
		return view;
	}
}
