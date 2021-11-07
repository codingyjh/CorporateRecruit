package com.spring.sideproject.recruitmember.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.recruitmember.service.RecruitMemberService;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

@Controller
public class RecruitMemberController {

	@Autowired
	private RecruitMemberService recruitMemberService;
	
	@GetMapping("/recruitMember/recruitMemberRegist")
	public String viewRecruitMemberRegistPage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitMember/recruitMemberRegist")
	public ModelAndView doRecruitMemberRegistAction(
			@ModelAttribute RecruitMemberVo recruitMemberVo
			, HttpServletRequest request
			, HttpServletResponse response) {
		
		ModelAndView view = new ModelAndView("redirect:/recruitMember/recruitMemberLogin");
		
		boolean isSuccess = this.recruitMemberService.registOneRecruitMembers(recruitMemberVo);
		
		return view;
	}
	
	@GetMapping("/recruitMember/recruitMemberLogin")
	public String viewRecruitMemberLoginPage() {
		return HttpRequestHelper.getJspPath();
	}
}
