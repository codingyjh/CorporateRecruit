package com.spring.sideproject.resume.qualification.experience.common.award.dao;

import com.spring.sideproject.resume.qualification.experience.common.award.vo.AwardVo;

public interface AwardDao {

	public int insertOneAwardDao(AwardVo awardVo);
	public AwardVo selectOneAwardByResumeIdDao(int resumeId);
	public int updateOneAwardDao(AwardVo awardVo);
}
