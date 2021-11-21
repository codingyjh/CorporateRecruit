package com.spring.sideproject.resume.academicbacground.vo;

import com.spring.sideproject.common.dao.support.Types;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public class AcademicBackgroundVo {

	private String admBgId;
	private String highSDiv;
	private String highSName;
	private String highSRegion;
	private String highSDayNight;
	private String highSEndDt;
	private String univDiv;
	private String univStartDt;
	private String univEndDt;
	private String univName;
	private String univRegion;
	private String univDayNight;
	private String univMainBranch;
	private String univTypeName;
	private String univMajor;
	private String univScore;
	private String univPScore;
	private String univGraDiv;
	private String graUnivDegree;
	private String graUnivGraDiv;
	private String graUnivStartDt;
	private String graUnivEndDt;
	private String graUnivName;
	private String graUnivRegion;
	private String graUnivDayNight;
	private String graUnivMainBranch;
	private String graUnivTypeName;
	private String graUnivMajor;
	private String graUnivScore;
	private String graUnivPScore;

	@Types(alias = "ADM_EMAIL")
	private String email;

	@Types(alias = "ADM_RESUME_ID")
	private int resumeId;

	private RecruitMemberVo recruitMemberVo;
	private BasicInfoVo basicInfoVo;

	public String getAdmBgId() {
		return admBgId;
	}

	public void setAdmBgId(String admBgId) {
		this.admBgId = admBgId;
	}

	public String getHighSDiv() {
		return highSDiv;
	}

	public void setHighSDiv(String highSDiv) {
		this.highSDiv = highSDiv;
	}

	public String getHighSName() {
		return highSName;
	}

	public void setHighSName(String highSName) {
		this.highSName = highSName;
	}

	public String getHighSRegion() {
		return highSRegion;
	}

	public void setHighSRegion(String highSRegion) {
		this.highSRegion = highSRegion;
	}

	public String getHighSDayNight() {
		return highSDayNight;
	}

	public void setHighSDayNight(String highSDayNight) {
		this.highSDayNight = highSDayNight;
	}

	public String getHighSEndDt() {
		return highSEndDt;
	}

	public void setHighSEndDt(String highSEndDt) {
		this.highSEndDt = highSEndDt;
	}

	public String getUnivDiv() {
		return univDiv;
	}

	public void setUnivDiv(String univDiv) {
		this.univDiv = univDiv;
	}

	public String getUnivStartDt() {
		return univStartDt;
	}

	public void setUnivStartDt(String univStartDt) {
		this.univStartDt = univStartDt;
	}

	public String getUnivEndDt() {
		return univEndDt;
	}

	public void setUnivEndDt(String univEndDt) {
		this.univEndDt = univEndDt;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public String getUnivRegion() {
		return univRegion;
	}

	public void setUnivRegion(String univRegion) {
		this.univRegion = univRegion;
	}

	public String getUnivDayNight() {
		return univDayNight;
	}

	public void setUnivDayNight(String univDayNight) {
		this.univDayNight = univDayNight;
	}

	public String getUnivMainBranch() {
		return univMainBranch;
	}

	public void setUnivMainBranch(String univMainBranch) {
		this.univMainBranch = univMainBranch;
	}

	public String getUnivTypeName() {
		return univTypeName;
	}

	public void setUnivTypeName(String univTypeName) {
		this.univTypeName = univTypeName;
	}

	public String getUnivMajor() {
		return univMajor;
	}

	public void setUnivMajor(String univMajor) {
		this.univMajor = univMajor;
	}

	public String getUnivScore() {
		return univScore;
	}

	public void setUnivScore(String univScore) {
		this.univScore = univScore;
	}

	public String getUnivPScore() {
		return univPScore;
	}

	public void setUnivPScore(String univPScore) {
		this.univPScore = univPScore;
	}

	public String getUnivGraDiv() {
		return univGraDiv;
	}

	public void setUnivGraDiv(String univGraDiv) {
		this.univGraDiv = univGraDiv;
	}

	public String getGraUnivDegree() {
		return graUnivDegree;
	}

	public void setGraUnivDegree(String graUnivDegree) {
		this.graUnivDegree = graUnivDegree;
	}

	public String getGraUnivGraDiv() {
		return graUnivGraDiv;
	}

	public void setGraUnivGraDiv(String graUnivGraDiv) {
		this.graUnivGraDiv = graUnivGraDiv;
	}

	public String getGraUnivStartDt() {
		return graUnivStartDt;
	}

	public void setGraUnivStartDt(String graUnivStartDt) {
		this.graUnivStartDt = graUnivStartDt;
	}

	public String getGraUnivEndDt() {
		return graUnivEndDt;
	}

	public void setGraUnivEndDt(String graUnivEndDt) {
		this.graUnivEndDt = graUnivEndDt;
	}

	public String getGraUnivName() {
		return graUnivName;
	}

	public void setGraUnivName(String graUnivName) {
		this.graUnivName = graUnivName;
	}

	public String getGraUnivRegion() {
		return graUnivRegion;
	}

	public void setGraUnivRegion(String graUnivRegion) {
		this.graUnivRegion = graUnivRegion;
	}

	public String getGraUnivDayNight() {
		return graUnivDayNight;
	}

	public void setGraUnivDayNight(String graUnivDayNight) {
		this.graUnivDayNight = graUnivDayNight;
	}

	public String getGraUnivMainBranch() {
		return graUnivMainBranch;
	}

	public void setGraUnivMainBranch(String graUnivMainBranch) {
		this.graUnivMainBranch = graUnivMainBranch;
	}

	public String getGraUnivTypeName() {
		return graUnivTypeName;
	}

	public void setGraUnivTypeName(String graUnivTypeName) {
		this.graUnivTypeName = graUnivTypeName;
	}

	public String getGraUnivMajor() {
		return graUnivMajor;
	}

	public void setGraUnivMajor(String graUnivMajor) {
		this.graUnivMajor = graUnivMajor;
	}

	public String getGraUnivScore() {
		return graUnivScore;
	}

	public void setGraUnivScore(String graUnivScore) {
		this.graUnivScore = graUnivScore;
	}

	public String getGraUnivPScore() {
		return graUnivPScore;
	}

	public void setGraUnivPScore(String graUnivPScore) {
		this.graUnivPScore = graUnivPScore;
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
