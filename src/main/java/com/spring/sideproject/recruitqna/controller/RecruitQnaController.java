package com.spring.sideproject.recruitqna.controller;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/recruitmentQuestion/recruitmentQuestion.do")
	public String viewRecruitQuestionPage(
			@RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		if ( !token.equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitmentQuestion/recruitmentQuestion.do")
	public ModelAndView recruitQuestionMailSending(
			@Valid @ModelAttribute RecruitQnaVo recruitQnaVo
			, Errors errors
			, @SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo
			, @RequestParam String token
			, @SessionAttribute(Session.CSRF_TOKEN) String sessionToken) {
		
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		recruitQnaVo.setTitle(filter.doFilter(recruitQnaVo.getTitle()));
		recruitQnaVo.setContent(filter.doFilter(recruitQnaVo.getContent()));
		
		if ( !recruitQnaVo.getToken().equals(sessionToken) ) {
			throw new RuntimeException("잘못된 인증");
		}
		
		ModelAndView view = new ModelAndView(MasterCodeConstants.REDIRECT_RECRUITMENT_QUESTION + "?token=" + sessionToken);
		
		if ( errors.hasErrors() ) {
			view.setViewName(MasterCodeConstants.VIEW_RECRUITMENT_QUESTION);
			view.addObject("recruitQnaVo", recruitQnaVo);
			return view;
		}
	
		String setFrom = "QnA [from : " + recruitQnaVo.getFromEmail() + "] ";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setTo(recruitQnaVo.getToEmail());
			messageHelper.setSubject(setFrom + recruitQnaVo.getTitle());
			messageHelper.setText(recruitQnaVo.getContent());
			mailSender.send(message);
	
		} catch ( Exception e) {
			e.printStackTrace();
		}		
		return view;
	}	
}
