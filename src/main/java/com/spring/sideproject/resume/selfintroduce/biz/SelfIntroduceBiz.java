package com.spring.sideproject.resume.selfintroduce.biz;

import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

public interface SelfIntroduceBiz {

	public boolean createOneSelfIntroduceBiz(SelfIntroduceVo selfIntroduceVo);
	public SelfIntroduceVo readOneSelfIntroduceByResumeIdBiz(int resumeId);
	public boolean updateOneSelfIntroduceBiz(SelfIntroduceVo selfIntroduceVo);
}
