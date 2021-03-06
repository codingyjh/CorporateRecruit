package com.spring.sideproject.recruitboard.dao;

import java.util.List;

import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitBoardDao {
	
	// 채용공고 Count 조회
	public int selectAllRecruitBoardsCountDao(RecruitBoardSearchVo recruitBoardSearchVo);
	
	// 채용공고  게시물 조회
	List<RecruitMemberVo> selectAllRecruitBoardsDao(RecruitBoardSearchVo recruitBoardSearchVo);
	
	// 채용공고 게시물 등록
	public int insertOneRecruitBoardDao(RecruitBoardVo recruitBoardVo);
	
	// 채용공고 게시물 조회
	public RecruitBoardVo selectOneRecruitBoardDao(int boardId);
	
	// 채용공고 게시물 조회 수 업데이트 
	public int updateHitOneRecruitBoardDao(int boardId);
	
	// 채용공고 게시물 수정
	public int updateOneRecruitBoardDao(RecruitBoardVo recruitBoardVo);
	
	// 채용공고 게시물 삭제
	public int deleteOneRecruitBoardByBoardIdDao(int boardId);

}
