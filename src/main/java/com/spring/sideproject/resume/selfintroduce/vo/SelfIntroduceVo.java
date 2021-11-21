package com.spring.sideproject.resume.selfintroduce.vo;

import org.hibernate.validator.constraints.NotEmpty;

import com.spring.sideproject.common.dao.support.Types;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public class SelfIntroduceVo {

	private String selfItdtId;

	@Types
	@NotEmpty(message = "자기소개서 항목1은 필수 입력 값입니다.")
	private String selfItdtContent1;

	@Types
	@NotEmpty(message = "자기소개서 항목2은 필수 입력 값입니다.")
	private String selfItdtContent2;

	@Types
	@NotEmpty(message = "자기소개서 항목3은 필수 입력 값입니다.")
	private String selfItdtContent3;

	@Types(alias = "SELF_EMAIL")
	private String email;

	@Types(alias = "SELF_RESUME_ID")
	private int resumeId;

	private RecruitMemberVo recruitMemberVo;
	private BasicInfoVo basicInfoVo;

	public String getSelfItdtId() {
		return selfItdtId;
	}

	public void setSelfItdtId(String selfItdtId) {
		this.selfItdtId = selfItdtId;
	}

	public String getSelfItdtContent1() {
		return selfItdtContent1;
	}

	public void setSelfItdtContent1(String selfItdtContent1) {
		this.selfItdtContent1 = selfItdtContent1;
	}

	public String getSelfItdtContent2() {
		return selfItdtContent2;
	}

	public void setSelfItdtContent2(String selfItdtContent2) {
		this.selfItdtContent2 = selfItdtContent2;
	}

	public String getSelfItdtContent3() {
		return selfItdtContent3;
	}

	public void setSelfItdtContent3(String selfItdtContent3) {
		this.selfItdtContent3 = selfItdtContent3;
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
