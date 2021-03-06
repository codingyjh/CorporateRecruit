package com.spring.sideproject.recruitboard.service;

import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitBoardService {

	public PageExplorer readAllRecruitBoardsService(RecruitBoardSearchVo recruitBoardSearchVo);
	
	public boolean createOneRecruitBoardService(RecruitBoardVo recruitBoardVo, RecruitMemberVo recruitMemberVo);
	
	public RecruitBoardVo readOneRecruitBoardService(int boardId);
	public RecruitBoardVo readOneRecruitBoardService(int boardId, RecruitMemberVo recruitMemberVo);
	
	public boolean updateOneRecruitBoardService(RecruitBoardVo recruitBoardVo);
	
	public boolean deleteOneRecruitBoardByBoardIdService(int boardId);
	
}
