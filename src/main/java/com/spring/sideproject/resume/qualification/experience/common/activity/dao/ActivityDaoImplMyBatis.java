package com.spring.sideproject.resume.qualification.experience.common.activity.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.resume.qualification.experience.common.activity.vo.ActivityVo;

@Repository
public class ActivityDaoImplMyBatis extends SqlSessionDaoSupport implements ActivityDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertOneActivityDao(ActivityVo activityVo) {
		return getSqlSession().insert("ActivityDao.insertOneActivityDao", activityVo);
	}

	@Override
	public ActivityVo selectOneActivityByResumeIdDao(int resumeId) {
		return getSqlSession().selectOne("ActivityDao.selectOneActivityByResumeIdDao", resumeId);
	}
	
	
}
