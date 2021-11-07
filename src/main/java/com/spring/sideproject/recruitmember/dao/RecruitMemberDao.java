package com.spring.sideproject.recruitmember.dao;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitMemberDao {
	
	// 회원가입
	public int insertOneRecruitMemberDao(RecruitMemberVo recruitMemberVo);
	
	// 로그인
	public RecruitMemberVo selectOneRecruitMemberDao(RecruitMemberVo recruitMemberVo);
	public String getSaltByEmailDao(String email);
	
	// 중복체크
	public int duplicateCheckByEmailDao(String email);
}
