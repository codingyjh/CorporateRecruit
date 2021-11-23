package com.spring.sideproject.resume.qualification.experience.common.activity.dao;

import com.spring.sideproject.resume.qualification.experience.common.activity.vo.ActivityVo;

public interface ActivityDao {

	public int insertOneActivityDao(ActivityVo activityVo);
	public ActivityVo selectOneActivityByResumeIdDao(int resumeId);
}
