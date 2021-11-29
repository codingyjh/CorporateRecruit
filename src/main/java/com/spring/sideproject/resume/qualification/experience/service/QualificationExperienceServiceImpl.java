package com.spring.sideproject.resume.qualification.experience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
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
	public QualificationExperienceVo readOneQualificationExperienceService(int resumeId) {
		
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

	@Override
	public boolean updateOneQualificationExperienceService(QualificationExperienceVo qualificationExperienceVo) {
		
		EducationVo education = new EducationVo();
		education.setEduName(qualificationExperienceVo.getEduName());
		education.setEduInst(qualificationExperienceVo.getEduInst());
		education.setEduStartDt(qualificationExperienceVo.getEduStartDt());
		education.setEduEndDt(qualificationExperienceVo.getEduEndDt());
		education.setEduTime(qualificationExperienceVo.getEduTime());
		education.setEduContent(qualificationExperienceVo.getEduContent());
		education.setEmail(qualificationExperienceVo.getEmail());
		
		ActivityVo activity = new ActivityVo();
		activity.setActDiv(qualificationExperienceVo.getActDiv());
		activity.setActInst(qualificationExperienceVo.getActInst());
		activity.setActStartDt(qualificationExperienceVo.getActStartDt());
		activity.setActEndDt(qualificationExperienceVo.getActEndDt());
		activity.setActRole(qualificationExperienceVo.getActRole());
		activity.setActContent(qualificationExperienceVo.getActContent());
		activity.setEmail(qualificationExperienceVo.getEmail());
		
		OfficialExamVo officialExam = new OfficialExamVo();
		officialExam.setOfclEmType(qualificationExperienceVo.getOfclEmType());
		officialExam.setOfclEmDt(qualificationExperienceVo.getOfclEmDt());
		officialExam.setOfclEmScore(qualificationExperienceVo.getOfclEmScore());
		officialExam.setOfclEmRegistNum(qualificationExperienceVo.getOfclEmRegistNum());
		officialExam.setEmail(qualificationExperienceVo.getEmail());
		
		LicenseVo license = new LicenseVo();
		license.setLicenseType(qualificationExperienceVo.getLicenseType());
		license.setLicenseRegistNum(qualificationExperienceVo.getLicenseRegistNum());
		license.setLicenseAcqDt(qualificationExperienceVo.getLicenseAcqDt());
		license.setEmail(qualificationExperienceVo.getEmail());
		
		AwardVo award = new AwardVo();
		award.setAwardName(qualificationExperienceVo.getAwardName());
		award.setAwardInst(qualificationExperienceVo.getAwardInst());
		award.setAwardDt(qualificationExperienceVo.getAwardDt());
		award.setAwardContent(qualificationExperienceVo.getAwardContent());
		award.setEmail(qualificationExperienceVo.getEmail());		
		
		boolean isSuccessEducation = this.educationBiz.updateOneEducationBiz(education);
		boolean isSuccessActivity = this.activityBiz.updateOneActivityBiz(activity);
		boolean isSuccessOfficialExam = this.officialExamBiz.updateOneOfficialExamBiz(officialExam);
		boolean isSuccessLicense = this.licenseBiz.updateOneLicenseBiz(license);
		boolean isSuccessAward = this.awardBiz.updateOneAwardBiz(award);
		
		if ( isSuccessEducation != true || isSuccessActivity != true || isSuccessOfficialExam != true 
				|| isSuccessLicense != true || isSuccessAward != true ) {
			return false;
		}
		
		return true;
	}
	
	
}
