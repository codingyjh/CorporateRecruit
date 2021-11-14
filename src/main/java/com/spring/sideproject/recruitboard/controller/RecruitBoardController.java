package com.spring.sideproject.recruitboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.common.session.Session;
import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.recruitboard.service.RecruitBoardService;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

@Controller
public class RecruitBoardController {
	
	@Autowired
	private RecruitBoardService recruitBoardService;
	
	@RequestMapping("/recruitBoard/recruitBoardInit") 
	public String viewRecruitBoardListPageForInitiate(HttpSession session) {
		
		session.removeAttribute(Session.RECRUIT_BOARD_SEARCH);
		return "redirect:/recruitBoard/recruitBoardList";
	}
	
	
	@RequestMapping("/recruitBoard/recruitBoardList")
	public ModelAndView viewBoardListPaga(
			@ModelAttribute RecruitBoardSearchVo recruitBoardSearchVo
			,HttpSession session) {
		
		if( recruitBoardSearchVo.getSearchKeyword() == null ) {
			recruitBoardSearchVo = (RecruitBoardSearchVo) session.getAttribute(Session.RECRUIT_BOARD_SEARCH);
			
			if ( recruitBoardSearchVo == null ) {
				recruitBoardSearchVo = new RecruitBoardSearchVo();
				recruitBoardSearchVo.setPageNo(0);
			}
		}
		
		PageExplorer pageExplorer = this.recruitBoardService.readAllRecruitBoardsService(recruitBoardSearchVo);
		
		session.setAttribute(Session.RECRUIT_BOARD_SEARCH, recruitBoardSearchVo);
		
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("recruitBoardVoList", pageExplorer.getList());
		view.addObject("pagenation", pageExplorer.make());
		view.addObject("size", pageExplorer.getTotalCount());
		view.addObject("recruitBoardSearchVo", recruitBoardSearchVo);
		
		return view;
	}
	
	@GetMapping("/recruitBoard/recruitBoardWrite")
	public String viewRecruitBoardWritePage() {
		return HttpRequestHelper.getJspPath();
	}
	
	@PostMapping("/recruitBoard/recruitBoardWrite")
	public ModelAndView doRecruitBoardWriteAction(
			@ModelAttribute RecruitBoardVo recruitBoardVo
			, Errors errors
			, HttpSession session) {
		
		
		ModelAndView view = new ModelAndView("redirect:/recruitBoard/recruitBoardList");
		
//		if ( errors.hasErrors() ) {
//			view.setViewName("recruitBoard/recruitBoardWrite");
//			view.addObject("recruitBoardVo", recruitBoardVo);
//			return view;
//		}
		
		RecruitMemberVo loginRecruitMember = (RecruitMemberVo) session.getAttribute(Session.USER);
		String email = loginRecruitMember.getEmail();
		
		recruitBoardVo.setRecruitMemberVo(loginRecruitMember);
		recruitBoardVo.setEmail(email);
		
		boolean isSuccess = this.recruitBoardService.createOneRecruitBoardService(recruitBoardVo);
		
		return view;
	}
}
