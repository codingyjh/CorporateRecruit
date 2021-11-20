package com.spring.sideproject.recruitmember.dao;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitMemberDao {
	
	// 회원가입
	public int insertOneRecruitMemberDao(RecruitMemberVo recruitMemberVo);
	
	// 로그인
	public RecruitMemberVo selectOneRecruitMemberDao(RecruitMemberVo recruitMemberVo);
	public RecruitMemberVo selectOneRecruitMembersGetByEmailDao(String email);
	
	// 중복체크
	public int duplicateCheckByEmailDao(String email);
	public String getSaltByEmailDao(String email);
	
	// 비밀번호 변경
	public int updateOneRecruitMemberInfoDao(RecruitMemberVo recruitMemberVo);
	
	// 로그인 시도 제한 횟수 Interface
	public int isBlockUserDao(String email);
	public int unBlockUserDao(String email);
	public boolean blockUserDao(String email);
	public int increaseLoginFailCountDao(String email);
}
