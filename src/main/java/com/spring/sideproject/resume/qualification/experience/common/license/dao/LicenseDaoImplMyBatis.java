package com.spring.sideproject.resume.qualification.experience.common.license.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.resume.qualification.experience.common.license.vo.LicenseVo;

@Repository
public class LicenseDaoImplMyBatis extends SqlSessionDaoSupport implements LicenseDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertOneLicenseDao(LicenseVo licenseVo) {
		return getSqlSession().insert("LicenseDao.insertOneLicenseDao", licenseVo);
	}
	
	

}
