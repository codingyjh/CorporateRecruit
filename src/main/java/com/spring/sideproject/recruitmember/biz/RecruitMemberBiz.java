package com.spring.sideproject.recruitmember.biz;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitMemberBiz {
	
	// 회원가입
	public boolean registOneRecruitMemberBiz(RecruitMemberVo recruitMemberVo);
	
	// 로그인
	public RecruitMemberVo readOneRecruitMemberBiz(RecruitMemberVo recruitMemberVo);
	
	// 중복체크
	public int duplicateCheckByEmailBiz(String email);
	
	// 비밀번호 변경
	public boolean updateOneRecruitMemberInfoBiz(RecruitMemberVo recruitMemberVo);
}
