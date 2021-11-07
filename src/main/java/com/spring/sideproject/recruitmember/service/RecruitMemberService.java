package com.spring.sideproject.recruitmember.service;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitMemberService {
	
	// 회원가입
	public boolean registOneRecruitMember(RecruitMemberVo recruitMemberVo);
	
	// 로그인
	public RecruitMemberVo readOneRecruitMember(RecruitMemberVo recruitMemberVo);
}
