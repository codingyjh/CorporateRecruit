package com.spring.sideproject.resume.academicbacground.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.resume.academicbacground.vo.AcademicBackgroundVo;

@Repository
public class AcademicBackgroundDaoImplMyBatis extends SqlSessionDaoSupport implements AcademicBackgroundDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertOneAcademicBackgroundDao(AcademicBackgroundVo academicBackgroundVo) {
		return getSqlSession().insert("AcademicBackgroundDao.insertOneAcademicBackgroundDao", academicBackgroundVo);
	}

	@Override
	public AcademicBackgroundVo selectOneAcademicBackgroundByResumeIdDao(int resumeId) {
		return getSqlSession().selectOne("AcademicBackgroundDao.selectOneAcademicBackgroundByResumeIdDao", resumeId);
	}

	@Override
	public int updateOneAcademicBackgroundDao(AcademicBackgroundVo academicBackgroundVo) {
		return getSqlSession().update("AcademicBackgroundDao.updateOneAcademicBackgroundDao", academicBackgroundVo);
	}

}
