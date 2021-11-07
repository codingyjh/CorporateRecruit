package com.spring.sideproject.recruitmember.vo;

import com.spring.sideproject.common.dao.support.Types;

public class RecruitMemberVo {

	@Types(alias = "M_EMAIL")
	private String email;

	@Types
	private String name;

	@Types
	private String password;

	@Types
	private String passwordConfirm;

	@Types
	private String crtDt;

	@Types
	private String latestLogin;

	@Types
	private String salt;

	@Types
	private int loginFailCount;

	@Types
	private String isAdminYn;

	@Types
	private String mdfyDt;

	private String token;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getLatestLogin() {
		return latestLogin;
	}

	public void setLatestLogin(String latestLogin) {
		this.latestLogin = latestLogin;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getLoginFailCount() {
		return loginFailCount;
	}

	public void setLoginFailCount(int loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	public String getIsAdminYn() {
		return isAdminYn;
	}

	public void setIsAdminYn(String isAdminYn) {
		this.isAdminYn = isAdminYn;
	}

	public String getMdfyDt() {
		return mdfyDt;
	}

	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
