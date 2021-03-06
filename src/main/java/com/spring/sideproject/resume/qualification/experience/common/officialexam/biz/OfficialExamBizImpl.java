package com.spring.sideproject.resume.qualification.experience.common.officialexam.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.resume.qualification.experience.common.officialexam.dao.OffcialExamDao;
import com.spring.sideproject.resume.qualification.experience.common.officialexam.vo.OfficialExamVo;

@Component
public class OfficialExamBizImpl implements OfficialExamBiz {
	
	@Autowired
	private OffcialExamDao offcialExamDao;

	@Override
	public boolean createOneOfficialExamBiz(OfficialExamVo officialExamVo) {
		return this.offcialExamDao.insertOneOfficialExamDao(officialExamVo) > 0;
	}

	@Override
	public OfficialExamVo readOndOfficialExamByResumeIdBiz(int resumeId) {
		return this.offcialExamDao.selectOneOfficialExamByResumeIdDao(resumeId);
	}

	@Override
	public boolean updateOneOfficialExamBiz(OfficialExamVo officialExamVo) {
		return this.offcialExamDao.updateOneOfficialExamDao(officialExamVo) > 0;
	}

}
