package com.spring.sideproject.recruitmember.biz;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public interface RecruitMemberBiz {
	
	// 회원가입
	public boolean registOneRecruitMemberBiz(RecruitMemberVo recruitMemberVo);
	
	// 로그인
	public RecruitMemberVo readOneRecruitMemberBiz(RecruitMemberVo recruitMemberVo);
	public RecruitMemberVo readOneRecruitMembersGetByEmailBiz(String email);
	
	// 중복체크
	public int duplicateCheckByEmailBiz(String email);
	
	// 비밀번호 변경
	public boolean updateOneRecruitMemberInfoBiz(RecruitMemberVo recruitMemberVo);
	
	// 로그인 시도 제한 횟수 Interface
	public boolean isBlockUserBiz(String email);
	public boolean unBlockUserBiz(String email);
	public boolean blockUserBiz(String email);
	public boolean increaseLoginFailCountBiz(String email);	
	
	// 이메일 존재 체크
	public String readOneEmailExistCheckBiz(String email);
}
