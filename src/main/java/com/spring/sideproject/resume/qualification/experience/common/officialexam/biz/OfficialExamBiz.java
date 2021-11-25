package com.spring.sideproject.resume.qualification.experience.common.officialexam.biz;

import com.spring.sideproject.resume.qualification.experience.common.officialexam.vo.OfficialExamVo;

public interface OfficialExamBiz {

	public boolean createOneOfficialExamBiz(OfficialExamVo officialExamVo);
	public OfficialExamVo readOndOfficialExamByResumeIdBiz(int resumeId);
}
