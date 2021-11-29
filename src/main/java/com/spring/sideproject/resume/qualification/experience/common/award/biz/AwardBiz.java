package com.spring.sideproject.resume.qualification.experience.common.award.biz;

import com.spring.sideproject.resume.qualification.experience.common.award.vo.AwardVo;

public interface AwardBiz {
	
	public boolean createOneAwardBiz(AwardVo awardVo);
	public AwardVo readOneAwardByResumeIdBiz(int resumeId);
	public boolean updateOneAwardBiz(AwardVo awardVo);
}
