package com.spring.sideproject.resume.basicinfo.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

@Repository
public class BasicInfoDaoImplMyBatis extends SqlSessionDaoSupport implements BasicInfoDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertOneBasicInfoDao(BasicInfoVo basicInfoVo) {
		return getSqlSession().insert("BasicInfoDao.insertOneBasicInfoDao", basicInfoVo);
	}

	@Override
	public int selectOneBasicInfoByEmailDao(String email) {
		return getSqlSession().selectOne("BasicInfoDao.selectOneBasicInfoByEmailDao", email);
	}

	@Override
	public BasicInfoVo selectOneBasicInfoByResumeIdDao(int resumeId) {
		return getSqlSession().selectOne("BasicInfoDao.selectOneBasicInfoByResumeIdDao", resumeId);
	}

}
