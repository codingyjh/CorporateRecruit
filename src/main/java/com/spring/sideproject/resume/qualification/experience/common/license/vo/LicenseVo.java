package com.spring.sideproject.resume.qualification.experience.common.license.vo;

import com.spring.sideproject.common.dao.support.Types;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public class LicenseVo {

	private String licenseId;
	private String licenseType;
	private String licenseRegistNum;
	private String licenseAcqDt;

	@Types(alias = "LC_EMAIL")
	private String email;

	@Types(alias = "LC_RESUME_ID")
	private int resumeId;

	private RecruitMemberVo recruitMemberVo;
	private BasicInfoVo basicInfoVo;

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
