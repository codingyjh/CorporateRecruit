package com.spring.sideproject.recruitboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.recruitboard.biz.RecruitBoardBiz;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;

@Service
public class RecruitBoardServiceImpl implements RecruitBoardService {

	@Autowired
	private RecruitBoardBiz recruitBoardBiz;
	
	@Override
	public PageExplorer readAllRecruitBoardsService(RecruitBoardSearchVo recruitBoardSearchVo) {
		return this.recruitBoardBiz.readAllRecruitBoardsBiz(recruitBoardSearchVo);
	}

}
