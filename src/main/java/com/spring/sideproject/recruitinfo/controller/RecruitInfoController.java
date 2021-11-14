package com.spring.sideproject.recruitinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.sideproject.common.utils.HttpRequestHelper;

@Controller
public class RecruitInfoController {

	@GetMapping("/recruitInfo/recruitmentGuide.do")
	public String viewRecruitmentGuidePage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@GetMapping("/recruitInfo/talentedHRModel.do")
	public String viewTalentedHRModelPage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@GetMapping("/recruitInfo/jobIntroduce.do")
	public String viewJobIntroducePage() {				
		return HttpRequestHelper.getJspPath();
	}
}
