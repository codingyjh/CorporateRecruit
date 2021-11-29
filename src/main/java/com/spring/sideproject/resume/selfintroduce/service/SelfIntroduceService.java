package com.spring.sideproject.resume.selfintroduce.service;

import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

public interface SelfIntroduceService {

	public SelfIntroduceVo readOneSelfIntroduceByResumeIdService(int resumeId);
	public boolean updateOneSelfIntroduceService(SelfIntroduceVo selfIntroduceVo);
}
