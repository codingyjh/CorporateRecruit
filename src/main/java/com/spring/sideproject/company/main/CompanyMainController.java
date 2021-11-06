package com.spring.sideproject.company.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyMainController {

	@GetMapping("/companyMain/main")
	public String viewRecruitMainPage() {
		return "companyMain/main";
	}
}
