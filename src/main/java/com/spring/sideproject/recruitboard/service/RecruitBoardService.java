package com.spring.sideproject.recruitboard.service;

import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;

public interface RecruitBoardService {

	public PageExplorer readAllRecruitBoardsService(RecruitBoardSearchVo recruitBoardSearchVo);
}
