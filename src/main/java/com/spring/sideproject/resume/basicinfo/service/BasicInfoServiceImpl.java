package com.spring.sideproject.resume.basicinfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.academicbacground.biz.AcademicBackgroundBiz;
import com.spring.sideproject.resume.academicbacground.vo.AcademicBackgroundVo;
import com.spring.sideproject.resume.basicinfo.biz.BasicInfoBiz;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;
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
import com.spring.sideproject.resume.selfintroduce.biz.SelfIntroduceBiz;
import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

@Service
public class BasicInfoServiceImpl implements BasicInfoService {

	private Logger logger = LoggerFactory.getLogger(BasicInfoServiceImpl.class);
	
	@Autowired
	private BasicInfoBiz basicInfoBiz;
	
	@Autowired
	private AcademicBackgroundBiz academicBackgroundBiz;
	
	@Autowired
	private ActivityBiz activityBiz;
	
	@Autowired
	private AwardBiz awardBiz;
	
	@Autowired
	private EducationBiz educationBiz;
	
	@Autowired
	private LicenseBiz licenseBiz;
	
	@Autowired
	private OfficialExamBiz officialExamBiz;
	
	@Autowired
	private SelfIntroduceBiz selfIntroduceBiz;

	@Override
	public boolean createOneResumeInfoService(BasicInfoVo basicInfoVo, RecruitMemberVo recruitMemberVo, int boardId) {
		
		// 기본사항 등록
		boolean isSuccessBasicInfo = this.basicInfoBiz.createOneBasicInfoBiz(basicInfoVo);
		
		String email = recruitMemberVo.getEmail();
		int resumeId = this.basicInfoBiz.readOneBasicInfoByEmailBiz(email);
		
		// 학력 등록
		AcademicBackgroundVo academicBackground = new AcademicBackgroundVo();
		academicBackground.setEmail(email);
		academicBackground.setRecruitMemberVo(recruitMemberVo);
		academicBackground.setResumeId(resumeId);
		boolean isSuccessAcademicBackGround = this.academicBackgroundBiz.createOneAcademicBackgroundBiz(academicBackground);
		
		// 교육 등록
		EducationVo education = new EducationVo();
		education.setEmail(email);
		education.setRecruitMemberVo(recruitMemberVo);
		education.setResumeId(resumeId);
		boolean isEducation = this.educationBiz.createOneEducationBiz(education);
		
		// 학내외 활동 등록
		ActivityVo activity = new ActivityVo();
		activity.setEmail(email);
		activity.setRecruitMemberVo(recruitMemberVo);
		activity.setResumeId(resumeId);
		boolean isSuccessActivity = this.activityBiz.createOneActivityBiz(activity);
		
		// 공인시험 등록
		OfficialExamVo officialExam = new OfficialExamVo();
		officialExam.setEmail(email);
		officialExam.setRecruitMemberVo(recruitMemberVo);
		officialExam.setResumeId(resumeId);
		boolean isSuccessOffcialExam = this.officialExamBiz.createOneOfficialExamBiz(officialExam);
		
		// 자격증 등록
		LicenseVo license = new LicenseVo();
		license.setEmail(email);
		license.setRecruitMemberVo(recruitMemberVo);
		license.setResumeId(resumeId);
		boolean isSuccessLicense = this.licenseBiz.createOneLicenseBiz(license);
		
		// 수상경록 등록
		AwardVo award = new AwardVo();
		award.setEmail(email);
		award.setRecruitMemberVo(recruitMemberVo);
		award.setResumeId(resumeId);
		boolean isSuccessAward = this.awardBiz.createOneAwardBiz(award);
		
		SelfIntroduceVo selfIntroduce = new SelfIntroduceVo();
		selfIntroduce.setEmail(email);
		selfIntroduce.setRecruitMemberVo(recruitMemberVo);
		selfIntroduce.setResumeId(resumeId);
		boolean isSuccessSelfIntroduce = this.selfIntroduceBiz.createOneSelfIntroduceBiz(selfIntroduce);
		
		if ( !isSuccessBasicInfo == true || !isSuccessAcademicBackGround == true || !isEducation == true 
				|| isSuccessActivity == true || !isSuccessOffcialExam == true || isSuccessLicense == true
				|| isSuccessAward == true || isSuccessSelfIntroduce == true ) {
			
			return false;
		}
		
		return false;
	}

	@Override
	public int readOneBasicInfoByEmailService(String email) {
		return this.basicInfoBiz.readOneBasicInfoByEmailBiz(email);
	}

	@Override
	public BasicInfoVo readOneBasicInfoByResumeIdService(int resumeId) {
		return this.basicInfoBiz.readOneBasicInfoByResumeIdBiz(resumeId);
	}

	@Override
	public boolean updateOneBasicInfoService(BasicInfoVo basicInfoVo) {
		return this.basicInfoBiz.updateOneBasicInfoBiz(basicInfoVo);
	}
	
}
