package com.spring.sideproject.recruitboard.biz;

import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;

public interface RecruitBoardBiz {

	public PageExplorer readAllRecruitBoardsBiz(RecruitBoardSearchVo recruitBoardSearchVo);
	
	public boolean createOneRecruitBoardBiz(RecruitBoardVo recruitBoardVo);
}
