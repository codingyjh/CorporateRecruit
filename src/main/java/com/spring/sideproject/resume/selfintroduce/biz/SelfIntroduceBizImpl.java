package com.spring.sideproject.resume.selfintroduce.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.resume.selfintroduce.dao.SelfIntroduceDao;
import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

@Component
public class SelfIntroduceBizImpl implements SelfIntroduceBiz {

	@Autowired
	private SelfIntroduceDao selfIntroduceDao;

	@Override
	public boolean createOneSelfIntroduceBiz(SelfIntroduceVo selfIntroduceVo) {
		return this.selfIntroduceDao.insertOneSelfIntroduceDao(selfIntroduceVo) > 0;
	}

	@Override
	public SelfIntroduceVo readOneSelfIntroduceByResumeIdBiz(int resumeId) {
		return this.selfIntroduceDao.selectOneSelfIntroduceByResumeIdDao(resumeId);
	}

	@Override
	public boolean updateOneSelfIntroduceBiz(SelfIntroduceVo selfIntroduceVo) {
		return this.selfIntroduceDao.updateOneSelfIntroduceDao(selfIntroduceVo) > 0;
	}
	
	
}
