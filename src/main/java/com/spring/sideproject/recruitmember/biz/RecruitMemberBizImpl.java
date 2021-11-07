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
		
		String salt = SHA256Util.generateSalt();
		String password = this.getHashedPassword(salt, recruitMemberVo.getPassword()); 
		
		recruitMemberVo.setPassword(password);
		recruitMemberVo.setSalt(salt);
		
		return this.recruitMemberDao.insertOneRecruitMember(recruitMemberVo) > 0;
	}
	
	public String getHashedPassword(String salt, String password) {
		return SHA256Util.getEncrypt(password, salt);
	}

	@Override
	public RecruitMemberVo readOneRecruitMember(RecruitMemberVo recruitMemberVo) {
		
		String salt = this.recruitMemberDao.getSaltByEmail(recruitMemberVo.getEmail());
		
		if ( salt != null ) {
			String password = this.getHashedPassword(salt, recruitMemberVo.getPassword());
			recruitMemberVo.setPassword(password);
		}
		
		return this.recruitMemberDao.selectOneRecruitMember(recruitMemberVo);
	}

}
