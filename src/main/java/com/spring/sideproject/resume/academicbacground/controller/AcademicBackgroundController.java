package com.spring.sideproject.resume.academicbacground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.resume.academicbacground.service.AcademicBackgroundService;
import com.spring.sideproject.resume.academicbacground.vo.AcademicBackgroundVo;

@Controller
public class AcademicBackgroundController {

	@Autowired
	private AcademicBackgroundService academicBackgroundService;
	
	@GetMapping("/resume/academicBackground.do/{resumeId}")
	public ModelAndView viewAcademicBackgroundPage(
			@PathVariable int resumeId) {
		
		AcademicBackgroundVo academicBackground = this.academicBackgroundService.readOneAcademicBackgroundByResumeIdService(resumeId);
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("academicBackgroundVo", academicBackground);
		
		return view;		
	}
}
