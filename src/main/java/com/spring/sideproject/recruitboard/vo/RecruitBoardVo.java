package com.spring.sideproject.recruitboard.vo;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.spring.sideproject.common.dao.support.Types;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public class RecruitBoardVo {

	@Types
	private int boardId;

	@Types
	@NotEmpty(message = "글 제목은 필수 잆력 값입니다.")
	private String title;

	@Types
	@NotEmpty(message = "글 내용은 필수 잆력 값입니다.")
	private String content;

	@Types(alias = "R_EMAIL")
	private String email;

	@Types
	private int hit;

	@Types
	private String wrtDt;

	@Types
	private String mdfyDt;

	@Types
	private String fileName;

	@Types
	private String originFileName;

	@Types
	@NotEmpty(message = "채용마감은 필수 입력 값입니다.")
	private String recruitDt;

	private MultipartFile file;

	private RecruitMemberVo recruitMemberVo;

	private String token;

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getWrtDt() {
		return wrtDt;
	}

	public void setWrtDt(String wrtDt) {
		this.wrtDt = wrtDt;
	}

	public String getMdfyDt() {
		return mdfyDt;
	}

	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}

	public String getRecruitDt() {
		return recruitDt;
	}

	public void setRecruitDt(String recruitDt) {
		this.recruitDt = recruitDt;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public RecruitMemberVo getRecruitMemberVo() {
		return recruitMemberVo;
	}

	public void setRecruitMemberVo(RecruitMemberVo recruitMemberVo) {
		this.recruitMemberVo = recruitMemberVo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
