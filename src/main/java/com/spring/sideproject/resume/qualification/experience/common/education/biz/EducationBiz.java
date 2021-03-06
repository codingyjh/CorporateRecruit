package com.spring.sideproject.resume.qualification.experience.common.education.biz;

import com.spring.sideproject.resume.qualification.experience.common.education.vo.EducationVo;

public interface EducationBiz {

	public boolean createOneEducationBiz(EducationVo educationVo);
	public EducationVo readOneEducationByResumeIdBiz(int resumeId);
	public boolean updateOneEducationBiz(EducationVo educationVo);
}
