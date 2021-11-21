package com.spring.sideproject.resume.qualification.experience.common.officialexam.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.resume.qualification.experience.common.officialexam.vo.OfficialExamVo;

@Repository
public class OffcialExamImplMyBatis extends SqlSessionDaoSupport implements OffcialExamDao {

	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertOneOfficialExamDao(OfficialExamVo officialExamVo) {
		return getSqlSession().insert("OffcialExamDao.insertOneOfficialExamDao", officialExamVo);
	}
	
}
