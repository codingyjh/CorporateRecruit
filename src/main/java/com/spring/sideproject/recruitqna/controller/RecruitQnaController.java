package com.spring.sideproject.recruitqna.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.lucy.security.xss.XssFilter;
import com.spring.sideproject.common.constant.MasterCodeConstants;
import com.spring.sideproject.common.session.Session;
import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.recruitqna.vo.RecruitQnaVo;

@Controller
public class RecruitQnaController {

	@GetMapping("/recruitmentQuestion/recruitmentQuestion.do")
	public String viewRecruitQuestionPage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitmentQuestion/recruitmentQuestion.do")
	public ModelAndView recruitQuestionMailSending(
			@Valid @ModelAttribute RecruitQnaVo recruitQnaVo
			, Errors errors
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo) {
		
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		recruitQnaVo.setTitle(filter.doFilter(recruitQnaVo.getTitle()));
		recruitQnaVo.setContent(filter.doFilter(recruitQnaVo.getContent()));
		
		
		ModelAndView view = new ModelAndView(MasterCodeConstants.REDIRECT_RECRUITMENT_QUESTION);
		
		if ( errors.hasErrors() ) {
			view.setViewName(MasterCodeConstants.VIEW_RECRUITMENT_QUESTION);
			view.addObject("recruitQnaVo", recruitQnaVo);
			return view;
		}
	
		return view;
	}	
}
