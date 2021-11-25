package com.spring.sideproject.resume.qualification.experience.common.officialexam.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.resume.qualification.experience.common.officialexam.vo.OfficialExamVo;

@Repository
public class OffcialExamImplMyBatis extends SqlSessionDaoSupport implements OffcialExamDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertOneOfficialExamDao(OfficialExamVo officialExamVo) {
		return getSqlSession().insert("OffcialExamDao.insertOneOfficialExamDao", officialExamVo);
	}

	@Override
	public OfficialExamVo selectOneOfficialExamByResumeIdDao(int resumeId) {
		return getSqlSession().selectOne("OffcialExamDao.selectOneOfficialExamByResumeIdDao", resumeId);
	}
	
}
