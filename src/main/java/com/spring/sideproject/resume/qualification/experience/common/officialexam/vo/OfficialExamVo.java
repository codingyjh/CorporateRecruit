package com.spring.sideproject.resume.qualification.experience.common.officialexam.vo;

import com.spring.sideproject.common.dao.support.Types;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public class OfficialExamVo {

	private String ofclEmId;
	private String ofclEmType;
	private String ofclEmDt;
	private String ofclEmScore;
	private String ofclEmRegistNum;

	@Types(alias = "OFCL_EMAIL")
	private String email;

	@Types(alias = "OFCL_RESUME_ID")
	private int resumeId;

	private RecruitMemberVo recruitMemberVo;
	private BasicInfoVo basicInfoVo;

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
