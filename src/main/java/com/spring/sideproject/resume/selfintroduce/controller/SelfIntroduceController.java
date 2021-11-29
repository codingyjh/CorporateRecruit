package com.spring.sideproject.resume.selfintroduce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.resume.selfintroduce.service.SelfIntroduceService;
import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

@Controller
public class SelfIntroduceController {

	@Autowired
	private SelfIntroduceService selfIntroduceService;
	
	@GetMapping("/resume/selfIntroduce.do/{resumeId}")
	public ModelAndView viewSelfIntroducePage(
			@PathVariable int resumeId) {

		SelfIntroduceVo selfIntroduce = this.selfIntroduceService.readOneSelfIntroduceByResumeIdService(resumeId);
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("selfIntroduceVo", selfIntroduce);
		
		return view;
	}
}
