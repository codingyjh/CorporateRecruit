package com.spring.sideproject.companymain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.sideproject.common.utils.HttpRequestHelper;

@Controller
public class CompanyMainController {

	@GetMapping("/companyMain/main")
	public String viewRecruitMainPage() {
		return HttpRequestHelper.getJspPath();
	}
}
