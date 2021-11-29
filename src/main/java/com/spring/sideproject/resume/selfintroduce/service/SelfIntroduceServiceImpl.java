package com.spring.sideproject.resume.selfintroduce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sideproject.resume.basicinfo.biz.BasicInfoBiz;
import com.spring.sideproject.resume.selfintroduce.biz.SelfIntroduceBiz;
import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

@Service
public class SelfIntroduceServiceImpl implements SelfIntroduceService {

	@Autowired
	private BasicInfoBiz basicInfoBiz;
	
	@Autowired
	private SelfIntroduceBiz selfIntroduceBiz;

	@Override
	public SelfIntroduceVo readOneSelfIntroduceByResumeIdService(int resumeId) {
		return this.selfIntroduceBiz.readOneSelfIntroduceByResumeIdBiz(resumeId);
	}

	@Override
	public boolean updateOneSelfIntroduceService(SelfIntroduceVo selfIntroduceVo) {
		return this.selfIntroduceBiz.updateOneSelfIntroduceBiz(selfIntroduceVo);
	}

	@Override
	public boolean updateOneFinalSubmitService(SelfIntroduceVo selfIntroduceVo) {
		
		String email = selfIntroduceVo.getEmail();
		
		boolean isSuccessFinalSubmit = this.basicInfoBiz.updateOneFinalSubmitByEmailBiz(email);
		boolean isSuccessSelfIntroduce = this.selfIntroduceBiz.updateOneSelfIntroduceBiz(selfIntroduceVo);
		
		if ( isSuccessFinalSubmit != true || isSuccessSelfIntroduce != true ) {
			return false;
		}
		
		return true;
		
	}
	
}
