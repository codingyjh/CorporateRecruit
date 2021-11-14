package com.spring.sideproject.recruitmember.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.session.Session;
import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.common.validator.RecruitMemberValidator;
import com.spring.sideproject.recruitmember.service.RecruitMemberService;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

@Controller
public class RecruitMemberController {

	private Logger log = LoggerFactory.getLogger("list.Statistics");
	
	@Autowired
	private RecruitMemberService recruitMemberService;
	
	@GetMapping("/recruitMember/recruitMemberRegist.do")
	public String viewRecruitMemberRegistPage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitMember/recruitMemberRegist.do")
	public ModelAndView doRecruitMemberRegistAction(
			@Validated(value = {RecruitMemberValidator.Regist.class}) @ModelAttribute RecruitMemberVo recruitMemberVo
			, Errors errors
			, HttpServletRequest request
			, HttpServletResponse response) {
		
		ModelAndView view = new ModelAndView("redirect:/recruitMember/recruitMemberLogin.do");
		
		if ( errors.hasErrors() ) {
			view.setViewName("recruitMember/recruitMemberRegist.do");
			view.addObject("recruitMemberVo", recruitMemberVo);
			return view;
		}
		
		boolean isSuccess = this.recruitMemberService.registOneRecruitMemberService(recruitMemberVo);
		
		return view;
	}
	
	@GetMapping("/recruitMember/recruitMemberLogin.do")
	public String viewRecruitMemberLoginPage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitMember/recruitMemberLogin.do")	
	public ModelAndView doRecruitMemberLoginAction(
			@Validated(value= {RecruitMemberValidator.Login.class}) @ModelAttribute RecruitMemberVo recruitMemberVo
			, Errors errors
			, HttpSession session) {
		
		ModelAndView view = new ModelAndView("redirect:/companyMain/main.do");
		
//		if ( errors.hasErrors() ) {
//			view.setViewName("recruitMember/recruitMemberLogin");
//			view.addObject("recruitMemberVo", recruitMemberVo);
//			return view;
//		}
		
		RecruitMemberVo loginMember = this.recruitMemberService.readOneRecruitMemberService(recruitMemberVo);
		loginMember.setEmail(recruitMemberVo.getEmail());
		loginMember.setPassword(recruitMemberVo.getPassword());
		
		session.setAttribute(Session.USER, loginMember);
		
		return view;
	}
	
	@RequestMapping("/recruitMember/emailDuplicate.do")
	@ResponseBody
	public Map<Object, Object> doDulicateCheckOfEmail(
			@RequestParam String email) {
		
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		count = this.recruitMemberService.duplicateCheckByEmailService(email);
		log.info("count : " + count);
		map.put("cnt", count);
		return map;
	}
	
	@GetMapping("/recruitMember/recruitMemberLogout.do")
	public String doRecruitMemberLogoutAction(HttpSession session) {
		
		session.invalidate();
		return "redirect:/companyMain/main.do";
	}
	
	@GetMapping("/recruitMember/recruitMemberUpdate.do")
	public String viewRecruitMemberInfoUpdatePage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitMember/recruitMemberUpdate.do")
	public ModelAndView doRecruitMemberInfoUpdateAction(
			@Validated(value = {RecruitMemberValidator.Update.class})
			@SessionAttribute(Session.USER) @ModelAttribute RecruitMemberVo recruitMemberVo
			, Errors errors) {
		
		ModelAndView view = new ModelAndView("redirect:/companyMain/main.do");
		
		if ( errors.hasErrors() ) {
			view.setViewName("recruitMember/recruitMemberUpdate.do");
			view.addObject("recruitMemberVo", recruitMemberVo);
			return view;
		}
		
		boolean isSuccess = this.recruitMemberService.updateOneRecruitMemberInfoService(recruitMemberVo);
		
		return view;
		
	}
}
