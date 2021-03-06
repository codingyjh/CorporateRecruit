package com.spring.sideproject.resume.academicbacground.dao;

import com.spring.sideproject.resume.academicbacground.vo.AcademicBackgroundVo;

public interface AcademicBackgroundDao {

	public int insertOneAcademicBackgroundDao(AcademicBackgroundVo academicBackgroundVo);
	public AcademicBackgroundVo selectOneAcademicBackgroundByResumeIdDao(int resumeId);
	public int updateOneAcademicBackgroundDao(AcademicBackgroundVo academicBackgroundVo);
}
