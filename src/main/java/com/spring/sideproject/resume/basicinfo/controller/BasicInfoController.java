package com.spring.sideproject.resume.basicinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.resume.basicinfo.service.BasicInfoService;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

@Controller
public class BasicInfoController {

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
}
