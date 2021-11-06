package com.spring.sideproject.company.info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.sideproject.common.utils.HttpRequestHelper;

@Controller
public class CompanyInfoController {

	@GetMapping("/companyInfo/introduce")
	public String viewCompanyIntroducePage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@GetMapping("/companyInfo/vision")
	public String viewCompanyVisionPage() {
		return HttpRequestHelper.getJspPath();
	}
}
