package com.spring.sideproject.resume.selfintroduce.dao;

import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

public interface SelfIntroduceDao {

	public int insertOneSelfIntroduceDao(SelfIntroduceVo selfIntroduceVo);
	public SelfIntroduceVo selectOneSelfIntroduceByResumeIdDao(int resumeId);
	public int updateOneSelfIntroduceDao(SelfIntroduceVo selfIntroduceVo);
}
