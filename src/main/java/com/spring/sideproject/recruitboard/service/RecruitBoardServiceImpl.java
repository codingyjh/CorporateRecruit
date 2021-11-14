package com.spring.sideproject.recruitboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.recruitboard.biz.RecruitBoardBiz;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

@Service
public class RecruitBoardServiceImpl implements RecruitBoardService {

	@Autowired
	private RecruitBoardBiz recruitBoardBiz;
	
	@Override
	public PageExplorer readAllRecruitBoardsService(RecruitBoardSearchVo recruitBoardSearchVo) {
		return this.recruitBoardBiz.readAllRecruitBoardsBiz(recruitBoardSearchVo);
	}

	@Override
	public boolean createOneRecruitBoardService(RecruitBoardVo recruitBoardVo, RecruitMemberVo recruitMemberVo) {
		return this.recruitBoardBiz.createOneRecruitBoardBiz(recruitBoardVo, recruitMemberVo);
	}

	@Override
	public RecruitBoardVo readOneRecruitBoardService(int boardId, RecruitMemberVo recruitMemberVo) {
		return this.recruitBoardBiz.readOneRecruitBoardBiz(boardId, recruitMemberVo);
	}

}
