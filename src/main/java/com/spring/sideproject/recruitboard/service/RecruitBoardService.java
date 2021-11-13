package com.spring.sideproject.recruitboard.service;

import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;

public interface RecruitBoardService {

	public PageExplorer readAllRecruitBoardsService(RecruitBoardSearchVo recruitBoardSearchVo);
	
	public boolean createOneRecruitBoardService(RecruitBoardVo recruitBoardVo);
}
