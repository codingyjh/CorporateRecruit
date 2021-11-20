package com.spring.sideproject.recruitmember.service;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitMemberService {
	
	// 회원가입
	public boolean registOneRecruitMemberService(RecruitMemberVo recruitMemberVo);
	
	// 로그인
	public RecruitMemberVo readOneRecruitMemberService(RecruitMemberVo recruitMemberVo);
	public RecruitMemberVo readOneRecruitMembersGetByEmailService(String email);
	
	// 중복체크
	public int duplicateCheckByEmailService(String email);
	
	// 비밀번호 변경
	public boolean updateOneRecruitMemberInfoService(RecruitMemberVo recruitMemberVo);
	
	// 로그인 시도 제한 횟수 Interface
	public boolean isBlockUserService(String email);
	public boolean unBlockUserService(String email);
	public boolean blockUserService(String email);
	public boolean increaseLoginFailCountService(String email);	

}
