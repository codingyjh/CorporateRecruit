package com.spring.sideproject.recruitmember.dao;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitMemberDao {
	
	// 회원가입
	public int insertOneRecruitMember(RecruitMemberVo recruitMemberVo);
	
	// 로그인
	public RecruitMemberVo selectOneRecruitMember(RecruitMemberVo recruitMemberVo);
	public String getSaltByEmail(String email);
}
