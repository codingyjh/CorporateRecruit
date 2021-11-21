package com.spring.sideproject.resume.academicbacground.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.resume.academicbacground.dao.AcademicBackgroundDao;
import com.spring.sideproject.resume.academicbacground.vo.AcademicBackgroundVo;

@Component
public class AcademicBackgroundBizImpl implements AcademicBackgroundBiz {

	@Autowired
	private AcademicBackgroundDao academicBackgroundDao;
	
	@Override
	public boolean createOneAcademicBackgroundBiz(AcademicBackgroundVo academicBackgroundVo) {
		return this.academicBackgroundDao.insertOneAcademicBackgroundDao(academicBackgroundVo) > 0;
	}

}
