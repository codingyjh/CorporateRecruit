package com.spring.sideproject.resume.qualification.experience.common.officialexam.dao;

import com.spring.sideproject.resume.qualification.experience.common.officialexam.vo.OfficialExamVo;

public interface OffcialExamDao {

	public int insertOneOfficialExamDao(OfficialExamVo officialExamVo);
	public OfficialExamVo selectOneOfficialExamByResumeIdDao(int resumeId);
	public int updateOneOfficialExamDao(OfficialExamVo officialExamVo);
}
