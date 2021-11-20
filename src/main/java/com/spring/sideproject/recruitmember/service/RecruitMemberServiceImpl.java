package com.spring.sideproject.recruitmember.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sideproject.recruitmember.biz.RecruitMemberBiz;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

@Service
public class RecruitMemberServiceImpl implements RecruitMemberService {

	@Autowired
	private RecruitMemberBiz recruitMemberBiz;
	
	@Override
	public boolean registOneRecruitMemberService(RecruitMemberVo recruitMemberVo) {
		return this.recruitMemberBiz.registOneRecruitMemberBiz(recruitMemberVo);
	}

	@Override
	public RecruitMemberVo readOneRecruitMemberService(RecruitMemberVo recruitMemberVo) {
		return this.recruitMemberBiz.readOneRecruitMemberBiz(recruitMemberVo);
	}

	@Override
	public RecruitMemberVo readOneRecruitMembersGetByEmailService(String email) {
		return this.recruitMemberBiz.readOneRecruitMembersGetByEmailBiz(email);
	}
	
	@Override
	public int duplicateCheckByEmailService(String email) {
		return this.recruitMemberBiz.duplicateCheckByEmailBiz(email);
	}

	@Override
	public boolean updateOneRecruitMemberInfoService(RecruitMemberVo recruitMemberVo) {
		return this.recruitMemberBiz.updateOneRecruitMemberInfoBiz(recruitMemberVo);
	}

	@Override
	public boolean isBlockUserService(String email) {
		return this.recruitMemberBiz.isBlockUserBiz(email);
	}

	@Override
	public boolean unBlockUserService(String email) {
		return this.recruitMemberBiz.unBlockUserBiz(email);
	}

	@Override
	public boolean blockUserService(String email) {
		return false;
	}

	@Override
	public boolean increaseLoginFailCountService(String email) {
		return this.recruitMemberBiz.increaseLoginFailCountBiz(email);
	}

	@Override
	public String readOneEmailExistCheckService(String email) {
		return this.recruitMemberBiz.readOneEmailExistCheckBiz(email);
	}
}
