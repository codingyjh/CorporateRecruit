package com.spring.sideproject.resume.qualification.experience.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.sideproject.resume.qualification.experience.common.activity.biz.ActivityBiz;
import com.spring.sideproject.resume.qualification.experience.common.activity.vo.ActivityVo;
import com.spring.sideproject.resume.qualification.experience.common.award.biz.AwardBiz;
import com.spring.sideproject.resume.qualification.experience.common.award.vo.AwardVo;
import com.spring.sideproject.resume.qualification.experience.common.education.biz.EducationBiz;
import com.spring.sideproject.resume.qualification.experience.common.education.vo.EducationVo;
import com.spring.sideproject.resume.qualification.experience.common.license.biz.LicenseBiz;
import com.spring.sideproject.resume.qualification.experience.common.license.vo.LicenseVo;
import com.spring.sideproject.resume.qualification.experience.common.officialexam.biz.OfficialExamBiz;
import com.spring.sideproject.resume.qualification.experience.common.officialexam.vo.OfficialExamVo;
import com.spring.sideproject.resume.qualification.experience.vo.QualificationExperienceVo;

public class QualificationExperienceServiceImpl implements QualificationExperienceService {

	@Autowired
	private EducationBiz educationBiz;
	
	@Autowired
	private ActivityBiz activityBiz;
	
	@Autowired
	private OfficialExamBiz officialExamBiz;
	
	@Autowired
	private LicenseBiz licenseBiz;
	
	@Autowired
	private AwardBiz awardBiz;

	@Override
	public QualificationExperienceVo readOneQualificationExperience(int resumeId) {
		
		QualificationExperienceVo qualificationExperience = new QualificationExperienceVo();
		
		EducationVo education = new EducationVo();
		education = this.educationBiz.readOneEducationByResumeIdBiz(resumeId);
		
		qualificationExperience.setResumeId(education.getResumeId());
		qualificationExperience.setEduId(education.getEduId());
		qualificationExperience.setEduName(education.getEduName());
		qualificationExperience.setEduInst(education.getEduInst());
		qualificationExperience.setEduStartDt(education.getEduStartDt());
		qualificationExperience.setEduEndDt(education.getEduEndDt());
		qualificationExperience.setEduTime(education.getEduTime());
		qualificationExperience.setEduContent(education.getEduContent());
		
		ActivityVo activity = new ActivityVo();
		activity = this.activityBiz.readOneActivityBiz(resumeId);
		
		qualificationExperience.setResumeId(activity.getResumeId());
		qualificationExperience.setActId(activity.getActId());
		qualificationExperience.setActDiv(activity.getActDiv());
		qualificationExperience.setActStartDt(activity.getActStartDt());
		qualificationExperience.setActEndDt(activity.getActEndDt());
		qualificationExperience.setActRole(activity.getActRole());
		qualificationExperience.setActContent(activity.getActContent());
		
		OfficialExamVo officialExam = new OfficialExamVo();
		officialExam = this.officialExamBiz.readOndOfficialExamByResumeIdBiz(resumeId);
		
		qualificationExperience.setResumeId(officialExam.getResumeId());
		qualificationExperience.setOfclEmId(officialExam.getOfclEmId());
		qualificationExperience.setOfclEmType(officialExam.getOfclEmType());
		qualificationExperience.setOfclEmDt(officialExam.getOfclEmDt());
		qualificationExperience.setOfclEmScore(officialExam.getOfclEmScore());
		qualificationExperience.setOfclEmRegistNum(officialExam.getOfclEmRegistNum());		
		
		LicenseVo license = new LicenseVo();
		license = this.licenseBiz.readOneLicenseByResumeIdBiz(resumeId);
		
		qualificationExperience.setResumeId(license.getResumeId());
		qualificationExperience.setLicenseId(license.getLicenseId());
		qualificationExperience.setLicenseType(license.getLicenseType());
		qualificationExperience.setLicenseRegistNum(license.getLicenseRegistNum());
		qualificationExperience.setLicenseAcqDt(license.getLicenseAcqDt());		
		
		AwardVo award = new AwardVo();
		award = this.awardBiz.readOneAwardByResumeIdBiz(resumeId);
		
		qualificationExperience.setResumeId(award.getResumeId());
		qualificationExperience.setAwardId(award.getAwardId());
		qualificationExperience.setAwardName(award.getAwardName());
		qualificationExperience.setAwardInst(award.getAwardInst());
		qualificationExperience.setAwardDt(award.getAwardDt());
		qualificationExperience.setAwardContent(award.getAwardContent());
		
		return qualificationExperience;
	}
	
	
}
