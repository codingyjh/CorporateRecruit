package com.spring.sideproject.recruitboard.dao;

import java.util.List;

import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitBoardDao {
	
	public int selectAllRecruitBoardsCountDao(RecruitBoardSearchVo recruitBoardSearchVo);
	List<RecruitMemberVo> selectAllRecruitBoardsDao(RecruitBoardSearchVo recruitBoardSearchVo);

}
