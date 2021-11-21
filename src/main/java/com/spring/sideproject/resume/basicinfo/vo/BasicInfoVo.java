package com.spring.sideproject.resume.basicinfo.vo;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.spring.sideproject.common.dao.support.Types;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public class BasicInfoVo {

	@Types(alias = "BASICINFO_RESUME_ID")
	private int resumeId;
	private String korName;
	@NotEmpty(message = "영어 이름은 필수 입력 값입니다.")
	private String engName;
	@NotEmpty(message = "생년월일은 필수 입력 값입니다.")
	private String birth;

	@NotEmpty(message = "경력구분은 필수 입력 값입니다.")
	private String careerDiv;
	@NotEmpty(message = "모집분야은 필수 입력 값입니다.")
	private String recruitField;
	@NotEmpty(message = "해당직무는 필수 입력 값입니다.")
	private String recruitJob;
	@NotEmpty(message = "연락처은 필수 입력 값입니다.")
	private String phone;
	@NotEmpty(message = "우편번호는 필수 입력 값입니다.")
	private String zipCode;
	@NotEmpty(message = "주소는 필수 입력 값입니다.")
	private String address;
	@NotEmpty(message = "상세주소는 필수 입력 값입니다.")
	private String dAddress;
	@NotEmpty(message = "장애여부는 필수 체크 값입니다.")
	private String handicapYn;
	private String handicapGrade;
	private String handicapReason;
	@NotEmpty(message = "보훈여부는 필수 체크 값입니다.")
	private String bohoonYn;
	private String bohoonNum;
	private String bohoonRltn;
	private String bohoonCost;
	private String milDiv;
	private String milType;
	private String milWork;
	private String milLevel;
	private String milStartDt;
	private String milEndDt;
	private String milDischangeDiv;
	@NotEmpty(message = "한자 이름은 필수 입력 값입니다.")
	private String chName;
	private String imgFileName;
	private String imgOriginFileName;
	private String email;
	private int boardId;
	private String finalDt;
	private MultipartFile file;
	private String resumeStartYn;
	private String resumeFinishYn;
	private RecruitMemberVo recruitMemberVo;
	private RecruitBoardVo recruitBoardVo;

	public BasicInfoVo() {
		this.imgFileName = "";
		this.imgOriginFileName = "";
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getKorName() {
		return korName;
	}

	public void setKorName(String korName) {
		this.korName = korName;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getCareerDiv() {
		return careerDiv;
	}

	public void setCareerDiv(String careerDiv) {
		this.careerDiv = careerDiv;
	}

	public String getRecruitField() {
		return recruitField;
	}

	public void setRecruitField(String recruitField) {
		this.recruitField = recruitField;
	}

	public String getRecruitJob() {
		return recruitJob;
	}

	public void setRecruitJob(String recruitJob) {
		this.recruitJob = recruitJob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	public String getHandicapYn() {
		return handicapYn;
	}

	public void setHandicapYn(String handicapYn) {
		this.handicapYn = handicapYn;
	}

	public String getHandicapGrade() {
		return handicapGrade;
	}

	public void setHandicapGrade(String handicapGrade) {
		this.handicapGrade = handicapGrade;
	}

	public String getHandicapReason() {
		return handicapReason;
	}

	public void setHandicapReason(String handicapReason) {
		this.handicapReason = handicapReason;
	}

	public String getBohoonYn() {
		return bohoonYn;
	}

	public void setBohoonYn(String bohoonYn) {
		this.bohoonYn = bohoonYn;
	}

	public String getBohoonNum() {
		return bohoonNum;
	}

	public void setBohoonNum(String bohoonNum) {
		this.bohoonNum = bohoonNum;
	}

	public String getBohoonRltn() {
		return bohoonRltn;
	}

	public void setBohoonRltn(String bohoonRltn) {
		this.bohoonRltn = bohoonRltn;
	}

	public String getBohoonCost() {
		return bohoonCost;
	}

	public void setBohoonCost(String bohoonCost) {
		this.bohoonCost = bohoonCost;
	}

	public String getMilDiv() {
		return milDiv;
	}

	public void setMilDiv(String milDiv) {
		this.milDiv = milDiv;
	}

	public String getMilType() {
		return milType;
	}

	public void setMilType(String milType) {
		this.milType = milType;
	}

	public String getMilWork() {
		return milWork;
	}

	public void setMilWork(String milWork) {
		this.milWork = milWork;
	}

	public String getMilLevel() {
		return milLevel;
	}

	public void setMilLevel(String milLevel) {
		this.milLevel = milLevel;
	}

	public String getMilStartDt() {
		return milStartDt;
	}

	public void setMilStartDt(String milStartDt) {
		this.milStartDt = milStartDt;
	}

	public String getMilEndDt() {
		return milEndDt;
	}

	public void setMilEndDt(String milEndDt) {
		this.milEndDt = milEndDt;
	}

	public String getMilDischangeDiv() {
		return milDischangeDiv;
	}

	public void setMilDischangeDiv(String milDischangeDiv) {
		this.milDischangeDiv = milDischangeDiv;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgOriginFileName() {
		return imgOriginFileName;
	}

	public void setImgOriginFileName(String imgOriginFileName) {
		this.imgOriginFileName = imgOriginFileName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getFinalDt() {
		return finalDt;
	}

	public void setFinalDt(String finalDt) {
		this.finalDt = finalDt;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getResumeStartYn() {
		return resumeStartYn;
	}

	public void setResumeStartYn(String resumeStartYn) {
		this.resumeStartYn = resumeStartYn;
	}

	public String getResumeFinishYn() {
		return resumeFinishYn;
	}

	public void setResumeFinishYn(String resumeFinishYn) {
		this.resumeFinishYn = resumeFinishYn;
	}

	public RecruitMemberVo getRecruitMemberVo() {
		return recruitMemberVo;
	}

	public void setRecruitMemberVo(RecruitMemberVo recruitMemberVo) {
		this.recruitMemberVo = recruitMemberVo;
	}

	public RecruitBoardVo getRecruitBoardVo() {
		return recruitBoardVo;
	}

	public void setRecruitBoardVo(RecruitBoardVo recruitBoardVo) {
		this.recruitBoardVo = recruitBoardVo;
	}

}
