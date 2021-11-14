package com.spring.sideproject.companyinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.sideproject.common.utils.HttpRequestHelper;

@Controller
public class CompanyInfoController {

	@GetMapping("/companyInfo/introduce.do")
	public String viewCompanyIntroducePage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@GetMapping("/companyInfo/vision.do")
	public String viewCompanyVisionPage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@GetMapping("/companyInfo/ceoMessage.do")
	public String viewCompanyCeoMessagePage() {
		return HttpRequestHelper.getJspPath();
	}
}
