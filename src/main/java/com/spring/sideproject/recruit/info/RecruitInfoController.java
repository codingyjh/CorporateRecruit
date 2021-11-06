package com.spring.sideproject.recruit.info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.sideproject.common.utils.HttpRequestHelper;

@Controller
public class RecruitInfoController {

	@GetMapping("/recruitInfo/recruitmentGuide")
	public String viewRecruitmentGuidePage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@GetMapping("/recruitInfo/talentedHRModel")
	public String viewTalentedHRModelPage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@GetMapping("/recruitInfo/jobIntroduce")
	public String viewJobIntroducePage() {				
		return HttpRequestHelper.getJspPath();
	}
}
