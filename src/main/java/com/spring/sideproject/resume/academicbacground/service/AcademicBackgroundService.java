package com.spring.sideproject.resume.academicbacground.service;

import com.spring.sideproject.resume.academicbacground.vo.AcademicBackgroundVo;

public interface AcademicBackgroundService {

	public AcademicBackgroundVo readOneAcademicBackgroundByResumeIdService(int resumeId);
	public boolean updateOneAcademicBackgroundService(AcademicBackgroundVo academicBackgroundVo);
}
