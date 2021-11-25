package com.spring.sideproject.resume.qualification.experience.common.license.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.resume.qualification.experience.common.license.dao.LicenseDao;
import com.spring.sideproject.resume.qualification.experience.common.license.vo.LicenseVo;

@Component
public class LicenseBizImpl implements LicenseBiz {

	@Autowired
	private LicenseDao licenseDao;

	@Override
	public boolean createOneLicenseBiz(LicenseVo licenseVo) {
		return this.licenseDao.insertOneLicenseDao(licenseVo) > 0;
	}

	@Override
	public LicenseVo readOneLicenseByResumeIdBiz(int resumeId) {
		return this.licenseDao.selectOneLicenseByResumeIdDao(resumeId);
	}
	
	
}
