package com.spring.sideproject.resume.qualification.experience.common.award.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.resume.qualification.experience.common.award.dao.AwardDao;
import com.spring.sideproject.resume.qualification.experience.common.award.vo.AwardVo;

@Component
public class AwardBizImpl implements AwardBiz {

	@Autowired
	private AwardDao awardDao;

	@Override
	public boolean createOneAwardBiz(AwardVo awardVo) {
		return this.awardDao.insertOneAwardDao(awardVo) > 0;
	}

	@Override
	public AwardVo readOneAwardByResumeIdBiz(int resumeId) {
		return this.awardDao.selectOneAwardByResumeIdDao(resumeId);
	}

	@Override
	public boolean updateOneAwardBiz(AwardVo awardVo) {
		return this.awardDao.updateOneAwardDao(awardVo) > 0;
	}
	
}
