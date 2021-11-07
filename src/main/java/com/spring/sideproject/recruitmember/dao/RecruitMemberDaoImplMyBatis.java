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
	public int insertOneRecruitMember(RecruitMemberVo recruitMemberVo) {
		return getSqlSession().insert("RecruitMemberDao.insertOneRecruitMember", recruitMemberVo);
	}

	@Override
	public RecruitMemberVo selectOneRecruitMember(RecruitMemberVo recruitMemberVo) {
		return getSqlSession().selectOne("RecruitMemberDao.selectOneRecruitMember", recruitMemberVo);
	}

}
