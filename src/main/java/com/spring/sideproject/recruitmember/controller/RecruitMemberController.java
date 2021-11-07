package com.spring.sideproject.recruitmember.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.session.Session;
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
		
		boolean isSuccess = this.recruitMemberService.registOneRecruitMember(recruitMemberVo);
		
		return view;
	}
	
	@GetMapping("/recruitMember/recruitMemberLogin")
	public String viewRecruitMemberLoginPage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitMember/recruitMemberLogin")	
	public ModelAndView doRecruitMemberLoginAction(
			@ModelAttribute RecruitMemberVo recruitMemberVo
			,HttpSession session) {
		
		ModelAndView view = new ModelAndView("redirect:/companyMain/main");
		
		RecruitMemberVo loginMember = this.recruitMemberService.readOneRecruitMember(recruitMemberVo);
		loginMember.setEmail(recruitMemberVo.getEmail());
		loginMember.setPassword(recruitMemberVo.getPassword());
		
		session.setAttribute(Session.USER, loginMember);
		
		return view;
	}
}
