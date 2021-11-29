package com.spring.sideproject.resume.qualification.experience.service;

import com.spring.sideproject.resume.qualification.experience.vo.QualificationExperienceVo;

public interface QualificationExperienceService {

	public QualificationExperienceVo readOneQualificationExperienceService(int resumeId);
	public boolean updateOneQualificationExperienceService(QualificationExperienceVo qualificationExperienceVo);
}
