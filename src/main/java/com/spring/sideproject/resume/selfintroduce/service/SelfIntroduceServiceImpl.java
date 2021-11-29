package com.spring.sideproject.resume.selfintroduce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sideproject.resume.selfintroduce.biz.SelfIntroduceBiz;
import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

@Service
public class SelfIntroduceServiceImpl implements SelfIntroduceService {

	@Autowired
	private SelfIntroduceBiz selfIntroduceBiz;

	@Override
	public SelfIntroduceVo readOneSelfIntroduceByResumeIdService(int resumeId) {
		return this.selfIntroduceBiz.readOneSelfIntroduceByResumeIdBiz(resumeId);
	}
	
	
}
