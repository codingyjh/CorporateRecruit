package com.spring.sideproject.resume.qualification.experience.common.education.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.resume.qualification.experience.common.education.vo.EducationVo;

@Repository
public class EducationDaoImplMyBatis extends SqlSessionDaoSupport implements EducationDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertOneEducationDao(EducationVo educationVo) {
		return getSqlSession().insert("EducationDao.insertOneEducationDao", educationVo);
	}

	@Override
	public EducationVo selectOneEducationByResumeIdDao(int resumeId) {
		return getSqlSession().selectOne("EducationDao.selectOneEducationByResumeIdDao", resumeId);
	}

	@Override
	public int updateOneEducationDao(EducationVo educationVo) {
		return getSqlSession().update("EducationDao.updateOneEducationDao", educationVo);
	}
	
	
}
