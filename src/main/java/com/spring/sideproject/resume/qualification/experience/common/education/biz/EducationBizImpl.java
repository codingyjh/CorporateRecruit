package com.spring.sideproject.resume.qualification.experience.common.education.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.resume.qualification.experience.common.education.dao.EducationDao;
import com.spring.sideproject.resume.qualification.experience.common.education.vo.EducationVo;

@Component
public class EducationBizImpl implements EducationBiz {

	@Autowired
	private EducationDao educationDao;

	@Override
	public boolean createOneEducationBiz(EducationVo educationVo) {
		return this.educationDao.insertOneEducationDao(educationVo) > 0;
	}

	@Override
	public EducationVo readOneEducationByResumeIdBiz(int resumeId) {
		return this.educationDao.selectOneEducationByResumeIdDao(resumeId);
	}

	@Override
	public boolean updateOneEducationBiz(EducationVo educationVo) {
		return this.educationDao.updateOneEducationDao(educationVo) > 0;
	}
	
}
