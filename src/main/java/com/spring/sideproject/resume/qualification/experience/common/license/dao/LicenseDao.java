package com.spring.sideproject.resume.qualification.experience.common.license.dao;

import com.spring.sideproject.resume.qualification.experience.common.license.vo.LicenseVo;

public interface LicenseDao {

	public int insertOneLicenseDao(LicenseVo licenseVo);
	public LicenseVo selectOneLicenseByResumeIdDao(int resumeId);
	public int updateOneLicenseDao(LicenseVo licenseVo);
}
