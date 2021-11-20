package com.spring.sideproject.recruitmember.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

@Repository
public class RecruitMemberDaoImplMyBatis extends SqlSessionDaoSupport implements RecruitMemberDao {

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public int insertOneRecruitMemberDao(RecruitMemberVo recruitMemberVo) {
		return getSqlSession().insert("RecruitMemberDao.insertOneRecruitMemberDao", recruitMemberVo);
	}

	@Override
	public RecruitMemberVo selectOneRecruitMemberDao(RecruitMemberVo recruitMemberVo) {
		return getSqlSession().selectOne("RecruitMemberDao.selectOneRecruitMemberDao", recruitMemberVo);
	}

	@Override
	public RecruitMemberVo selectOneRecruitMembersGetByEmailDao(String email) {
		return getSqlSession().selectOne("RecruitMemberDao.selectOneRecruitMembersGetByEmailDao", email);
	}
	
	@Override
	public int duplicateCheckByEmailDao(String email) {
		return getSqlSession().selectOne("RecruitMemberDao.duplicateCheckByEmailDao", email);
	}
	
	@Override
	public String getSaltByEmailDao(String email) {
		return getSqlSession().selectOne("RecruitMemberDao.getSaltByEmailDao", email);
	}

	@Override
	public int updateOneRecruitMemberInfoDao(RecruitMemberVo recruitMemberVo) {
		return getSqlSession().update("RecruitMemberDao.updateOneRecruitMemberInfoDao", recruitMemberVo);
	}

	@Override
	public int isBlockUserDao(String email) {
		return getSqlSession().selectOne("RecruitMemberDao.isBlockUserDao", email);
	}

	@Override
	public int unBlockUserDao(String email) {
		return getSqlSession().update("RecruitMemberDao.unBlockUserDao", email);
	}

	@Override
	public boolean blockUserDao(String email) {
		return false;
	}

	@Override
	public int increaseLoginFailCountDao(String email) {
		return getSqlSession().update("RecruitMemberDao.increaseLoginFailCountDao", email);
	}

	@Override
	public String selectOneEmailExistCheckDao(String email) {
		return getSqlSession().selectOne("RecruitMemberDao.selectOneEmailExistCheckDao", email);
	}

}
