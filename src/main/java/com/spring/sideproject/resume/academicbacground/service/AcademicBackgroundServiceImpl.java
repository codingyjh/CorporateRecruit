package com.spring.sideproject.resume.academicbacground.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sideproject.resume.academicbacground.biz.AcademicBackgroundBiz;
import com.spring.sideproject.resume.academicbacground.vo.AcademicBackgroundVo;

@Service
public class AcademicBackgroundServiceImpl implements AcademicBackgroundService {

	@Autowired
	private AcademicBackgroundBiz academicBackgroundBiz;

	@Override
	public AcademicBackgroundVo readOneAcademicBackgroundByResumeIdService(int resumeId) {
		return this.academicBackgroundBiz.readOneAcademicBackgroundByResumeIdBiz(resumeId);
	}
	
}
