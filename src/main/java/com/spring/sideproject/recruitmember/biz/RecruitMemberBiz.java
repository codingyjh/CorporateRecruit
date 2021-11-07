package com.spring.sideproject.recruitmember.biz;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitMemberBiz {
	
	// 회원가입
	public boolean registOneRecruitMember(RecruitMemberVo recruitMemberVo);
	
	// 로그인
	public RecruitMemberVo readOneRecruitMember(RecruitMemberVo recruitMemberVo);
}
