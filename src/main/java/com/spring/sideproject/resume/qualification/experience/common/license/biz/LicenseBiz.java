package com.spring.sideproject.resume.qualification.experience.common.license.biz;

import com.spring.sideproject.resume.qualification.experience.common.license.vo.LicenseVo;

public interface LicenseBiz {

	public boolean createOneLicenseBiz(LicenseVo licenseVo);
	public LicenseVo readOneLicenseByResumeIdBiz(int resumeId);
}
