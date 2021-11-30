package com.spring.sideproject.recruitqna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.spring.sideproject.common.utils.HttpRequestHelper;

@Controller
public class RecruitQnaController {

	@GetMapping("/recruitmentQuestion/recruitmentQuestion.do")
	public String viewRecruitQuestionPage() {
		return HttpRequestHelper.getJspPath();
	}
}
