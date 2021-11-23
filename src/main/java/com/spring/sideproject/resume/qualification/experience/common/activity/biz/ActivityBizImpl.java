package com.spring.sideproject.resume.qualification.experience.common.activity.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.resume.qualification.experience.common.activity.dao.ActivityDao;
import com.spring.sideproject.resume.qualification.experience.common.activity.vo.ActivityVo;

@Component
public class ActivityBizImpl implements ActivityBiz {

	@Autowired
	private ActivityDao activityDao;

	@Override
	public boolean createOneActivityBiz(ActivityVo activityVo) {
		return this.activityDao.insertOneActivityDao(activityVo) > 0;
	}

	@Override
	public ActivityVo readOneActivity(int resumeId) {
		return this.activityDao.selectOneActivityByResumeIdDao(resumeId);
	}
	
	
}
