package com.spring.sideproject.resume.qualification.experience.common.award.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.resume.qualification.experience.common.award.vo.AwardVo;

@Repository
public class AwardDaoImplMyBatis extends SqlSessionDaoSupport implements AwardDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertOneAwardDao(AwardVo awardVo) {
		return getSqlSession().insert("AwardDao.insertOneAwardDao", awardVo);
	}
	
	
}
