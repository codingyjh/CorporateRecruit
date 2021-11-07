package com.spring.sideproject.recruitmember.service;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitMemberService {
	
	// 회원가입
	public boolean registOneRecruitMemberService(RecruitMemberVo recruitMemberVo);
	
	// 로그인
	public RecruitMemberVo readOneRecruitMemberService(RecruitMemberVo recruitMemberVo);
	
	// 중복체크
	public int duplicateCheckByEmailService(String email);
}
