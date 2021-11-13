package com.spring.sideproject.recruitboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.common.session.Session;
import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.recruitboard.service.RecruitBoardService;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;

@Controller
public class RecruitBoardController {
	
	@Autowired
	private RecruitBoardService recruitBoardService;
	
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
}
