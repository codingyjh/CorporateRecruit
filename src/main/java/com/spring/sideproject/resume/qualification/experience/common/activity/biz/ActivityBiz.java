package com.spring.sideproject.resume.qualification.experience.common.activity.biz;

import com.spring.sideproject.resume.qualification.experience.common.activity.vo.ActivityVo;

public interface ActivityBiz {

	public boolean createOneActivityBiz(ActivityVo activityVo);
	public ActivityVo readOneActivityBiz(int resumeId);
	public boolean updateOneActivityBiz(ActivityVo activityVo);
}
