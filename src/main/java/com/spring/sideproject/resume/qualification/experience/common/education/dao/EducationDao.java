package com.spring.sideproject.resume.qualification.experience.common.education.dao;

import com.spring.sideproject.resume.qualification.experience.common.education.vo.EducationVo;

public interface EducationDao {

	public int insertOneEducationDao(EducationVo educationVo);
	public EducationVo selectOneEducationByResumeIdDao(int resumeId);
	public int updateOneEducationDao(EducationVo educationVo);
}
