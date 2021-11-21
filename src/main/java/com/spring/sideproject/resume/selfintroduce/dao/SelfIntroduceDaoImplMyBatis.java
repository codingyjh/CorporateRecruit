package com.spring.sideproject.resume.selfintroduce.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

@Repository
public class SelfIntroduceDaoImplMyBatis extends SqlSessionDaoSupport implements SelfIntroduceDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertOneSelfIntroduceDao(SelfIntroduceVo selfIntroduceVo) {
		return getSqlSession().insert("SelfIntroduceDao.insertOneSelfIntroduceDao", selfIntroduceVo);
	}
	
}
