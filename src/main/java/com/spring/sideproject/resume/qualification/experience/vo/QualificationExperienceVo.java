package com.spring.sideproject.resume.qualification.experience.vo;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public class QualificationExperienceVo {

	// 교육 이수
	private String eduId;
	private String eduName;
	private String eduInst;
	private String eduStartDt;
	private String eduEndDt;
	private String eduTime;
	private String eduContent;

	// 학내외 활동
	private String actId;
	private String actDiv;
	private String actInst;
	private String actStartDt;
	private String actEndDt;
	private String actRole;
	private String actContent;

	// 공인시험
	private String ofclEmId;
	private String ofclEmType;
	private String ofclEmDt;
	private String ofclEmScore;
	private String ofclEmRegistNum;

	// 자격증
	private String licenseId;
	private String licenseType;
	private String licenseRegistNum;
	private String licenseAcqDt;

	// 수상경력
	private String awardId;
	private String awardName;
	private String awardInst;
	private String awardDt;
	private String awardContent;

	// 공통(외래키)
	private String email;
	private int resumeId;
	private RecruitMemberVo recruitMemberVo;
	private BasicInfoVo basicInfoVo;

	public String getEduId() {
		return eduId;
	}

	public void setEduId(String eduId) {
		this.eduId = eduId;
	}

	public String getEduName() {
		return eduName;
	}

	public void setEduName(String eduName) {
		this.eduName = eduName;
	}

	public String getEduInst() {
		return eduInst;
	}

	public void setEduInst(String eduInst) {
		this.eduInst = eduInst;
	}

	public String getEduStartDt() {
		return eduStartDt;
	}

	public void setEduStartDt(String eduStartDt) {
		this.eduStartDt = eduStartDt;
	}

	public String getEduEndDt() {
		return eduEndDt;
	}

	public void setEduEndDt(String eduEndDt) {
		this.eduEndDt = eduEndDt;
	}

	public String getEduTime() {
		return eduTime;
	}

	public void setEduTime(String eduTime) {
		this.eduTime = eduTime;
	}

	public String getEduContent() {
		return eduContent;
	}

	public void setEduContent(String eduContent) {
		this.eduContent = eduContent;
	}

	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getActDiv() {
		return actDiv;
	}

	public void setActDiv(String actDiv) {
		this.actDiv = actDiv;
	}

	public String getActInst() {
		return actInst;
	}

	public void setActInst(String actInst) {
		this.actInst = actInst;
	}

	public String getActStartDt() {
		return actStartDt;
	}

	public void setActStartDt(String actStartDt) {
		this.actStartDt = actStartDt;
	}

	public String getActEndDt() {
		return actEndDt;
	}

	public void setActEndDt(String actEndDt) {
		this.actEndDt = actEndDt;
	}

	public String getActRole() {
		return actRole;
	}

	public void setActRole(String actRole) {
		this.actRole = actRole;
	}

	public String getActContent() {
		return actContent;
	}

	public void setActContent(String actContent) {
		this.actContent = actContent;
	}

	public String getOfclEmId() {
		return ofclEmId;
	}

	public void setOfclEmId(String ofclEmId) {
		this.ofclEmId = ofclEmId;
	}

	public String getOfclEmType() {
		return ofclEmType;
	}

	public void setOfclEmType(String ofclEmType) {
		this.ofclEmType = ofclEmType;
	}

	public String getOfclEmDt() {
		return ofclEmDt;
	}

	public void setOfclEmDt(String ofclEmDt) {
		this.ofclEmDt = ofclEmDt;
	}

	public String getOfclEmScore() {
		return ofclEmScore;
	}

	public void setOfclEmScore(String ofclEmScore) {
		this.ofclEmScore = ofclEmScore;
	}

	public String getOfclEmRegistNum() {
		return ofclEmRegistNum;
	}

	public void setOfclEmRegistNum(String ofclEmRegistNum) {
		this.ofclEmRegistNum = ofclEmRegistNum;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getLicenseRegistNum() {
		return licenseRegistNum;
	}

	public void setLicenseRegistNum(String licenseRegistNum) {
		this.licenseRegistNum = licenseRegistNum;
	}

	public String getLicenseAcqDt() {
		return licenseAcqDt;
	}

	public void setLicenseAcqDt(String licenseAcqDt) {
		this.licenseAcqDt = licenseAcqDt;
	}

	public String getAwardId() {
		return awardId;
	}

	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardInst() {
		return awardInst;
	}

	public void setAwardInst(String awardInst) {
		this.awardInst = awardInst;
	}

	public String getAwardDt() {
		return awardDt;
	}

	public void setAwardDt(String awardDt) {
		this.awardDt = awardDt;
	}

	public String getAwardContent() {
		return awardContent;
	}

	public void setAwardContent(String awardContent) {
		this.awardContent = awardContent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public RecruitMemberVo getRecruitMemberVo() {
		return recruitMemberVo;
	}

	public void setRecruitMemberVo(RecruitMemberVo recruitMemberVo) {
		this.recruitMemberVo = recruitMemberVo;
	}

	public BasicInfoVo getBasicInfoVo() {
		return basicInfoVo;
	}

	public void setBasicInfoVo(BasicInfoVo basicInfoVo) {
		this.basicInfoVo = basicInfoVo;
	}
}
