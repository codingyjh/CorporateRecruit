package com.spring.sideproject.resume.academicbacground.biz;

import com.spring.sideproject.resume.academicbacground.vo.AcademicBackgroundVo;

public interface AcademicBackgroundBiz {

	public boolean createOneAcademicBackgroundBiz(AcademicBackgroundVo academicBackgroundVo);
	public AcademicBackgroundVo readOneAcademicBackgroundByResumeIdBiz(int resumeId);
	public boolean updateOneAcademicBackgroundBiz(AcademicBackgroundVo academicBackgroundVo);
}
