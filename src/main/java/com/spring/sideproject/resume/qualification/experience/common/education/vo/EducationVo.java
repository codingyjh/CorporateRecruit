package com.spring.sideproject.resume.qualification.experience.common.education.vo;

import com.spring.sideproject.common.dao.support.Types;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public class EducationVo {

	private String eduId;
	private String eduName;
	private String eduInst;
	private String eduStartDt;
	private String eduEndDt;
	private String eduTime;
	private String eduContent;

	@Types(alias = "EDU_EMAIL")
	private String email;

	@Types(alias = "EDU_RESUME_ID")
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
