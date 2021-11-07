package com.spring.sideproject.recruitmember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

@Controller
public class RecruitMemberController {

	@GetMapping("/recruitMember/recruitMemberRegist")
	public String viewRecruitMemberRegistPage() {
		return HttpRequestHelper.getJspPath();
	}
	
//	@PostMapping("/recruitMember/recruitMemberRegist")
//	public ModelAndView doRecruitMemberRegistAction(
//			@ModelAttribute RecruitMemberVo recruitMemberVo
//			) {
//		
//	}
}
