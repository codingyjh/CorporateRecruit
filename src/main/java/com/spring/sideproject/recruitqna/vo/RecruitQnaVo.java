package com.spring.sideproject.recruitqna.vo;

import javax.validation.constraints.NotEmpty;

public class RecruitQnaVo {

	private String toEmail;
	private String fromEmail;

	@NotEmpty(message = "메일 제목은 필수 입력 값입니다.")
	private String title;

	@NotEmpty(message = "메일 내용은 필수 입력 값입니다.")
	private String content;
	private String token;

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
