package com.spring.sideproject.recruitboard.biz;

import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;

public interface RecruitBoardBiz {

	public PageExplorer readAllRecruitBoardsBiz(RecruitBoardSearchVo recruitBoardSearchVo);
}
