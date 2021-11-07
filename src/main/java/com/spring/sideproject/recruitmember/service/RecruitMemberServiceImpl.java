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
	public boolean registOneRecruitMember(RecruitMemberVo recruitMemberVo) {
		return this.recruitMemberBiz.registOneRecruitMember(recruitMemberVo);
	}

	@Override
	public RecruitMemberVo readOneRecruitMember(RecruitMemberVo recruitMemberVo) {
		return this.recruitMemberBiz.readOneRecruitMember(recruitMemberVo);
	}

}
