package com.spring.sideproject.resume.qualification.experience.common.activity.vo;

import com.spring.sideproject.common.dao.support.Types;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public class ActivityVo {

	private String actId;
	private String actDiv;
	private String actInst;
	private String actStartDt;
	private String actEndDt;
	private String actRole;
	private String actContent;

	@Types(alias = "ACT_EMAIL")
	private String email;

	@Types(alias = "ACT_RESUME_ID")
	private int resumeId;

	private RecruitMemberVo recruitMemberVo;
	private BasicInfoVo basicInfoVo;

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
