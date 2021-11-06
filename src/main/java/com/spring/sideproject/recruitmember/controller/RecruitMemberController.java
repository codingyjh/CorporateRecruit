package com.spring.sideproject.recruitmember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.sideproject.common.utils.HttpRequestHelper;

@Controller
public class RecruitMemberController {

	@GetMapping("/recruitMember/recruitMemberRegist")
	public String viewRecruitMemberRegistPage() {
		return HttpRequestHelper.getJspPath();
	}
}
