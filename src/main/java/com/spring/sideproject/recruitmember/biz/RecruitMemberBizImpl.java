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
	public boolean registOneRecruitMemberBiz(RecruitMemberVo recruitMemberVo) {
		
		String salt = SHA256Util.generateSalt();
		String password = this.getHashedPassword(salt, recruitMemberVo.getPassword()); 
		
		recruitMemberVo.setPassword(password);
		recruitMemberVo.setSalt(salt);
		
		return this.recruitMemberDao.insertOneRecruitMemberDao(recruitMemberVo) > 0;
	}
	
	public String getHashedPassword(String salt, String password) {
		return SHA256Util.getEncrypt(password, salt);
	}

	@Override
	public RecruitMemberVo readOneRecruitMemberBiz(RecruitMemberVo recruitMemberVo) {
		
		String salt = this.recruitMemberDao.getSaltByEmailDao(recruitMemberVo.getEmail());
		
		if ( salt != null ) {
			String password = this.getHashedPassword(salt, recruitMemberVo.getPassword());
			recruitMemberVo.setPassword(password);
		}
		
		return this.recruitMemberDao.selectOneRecruitMemberDao(recruitMemberVo);
	}
	
	@Override
	public RecruitMemberVo readOneRecruitMembersGetByEmailBiz(String email) {
		return this.recruitMemberDao.selectOneRecruitMembersGetByEmailDao(email);
	}

	@Override
	public int duplicateCheckByEmailBiz(String email) {
		return this.recruitMemberDao.duplicateCheckByEmailDao(email);
	}

	@Override
	public boolean updateOneRecruitMemberInfoBiz(RecruitMemberVo recruitMemberVo) {
		
		String salt = SHA256Util.generateSalt();
		String password = this.getHashedPassword(salt, recruitMemberVo.getPassword());
		
		recruitMemberVo.setPassword(password);
		recruitMemberVo.setSalt(salt);
		
		return this.recruitMemberDao.updateOneRecruitMemberInfoDao(recruitMemberVo) > 0;
	}

	@Override
	public boolean isBlockUserBiz(String email) {
		return this.recruitMemberDao.isBlockUserDao(email) > 0;
	}

	@Override
	public boolean unBlockUserBiz(String email) {
		return this.recruitMemberDao.unBlockUserDao(email) > 0;
	}

	@Override
	public boolean blockUserBiz(String email) {
		return false;
	}

	@Override
	public boolean increaseLoginFailCountBiz(String email) {
		return this.recruitMemberDao.increaseLoginFailCountDao(email) > 0;
	}

	@Override
	public String readOneEmailExistCheckBiz(String email) {
		return this.recruitMemberDao.selectOneEmailExistCheckDao(email);
	}

}
