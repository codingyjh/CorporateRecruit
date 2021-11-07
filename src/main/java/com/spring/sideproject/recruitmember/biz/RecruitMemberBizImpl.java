package com.spring.sideproject.recruitmember.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.common.utils.SHA256Util;
import com.spring.sideproject.recruitmember.dao.RecruitMemberDao;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

@Component
public class RecruitMemberBizImpl implements RecruitMemberBiz {

	@Autowired
	private RecruitMemberDao recruitMemberDao;
	
	@Override
	public boolean registOneRecruitMember(RecruitMemberVo recruitMemberVo) {
		

		recruitMemberVo.setPassword(recruitMemberVo.getPassword());
		return this.recruitMemberDao.insertOneRecruitMember(recruitMemberVo) > 0;
	}
	
	public String getHashedPassword(String salt, String password) {
		return SHA256Util.getEncrypt(password, salt);
	}

	@Override
	public RecruitMemberVo readOneRecruitMember(RecruitMemberVo recruitMemberVo) {
		return this.recruitMemberDao.selectOneRecruitMember(recruitMemberVo);
	}

}
