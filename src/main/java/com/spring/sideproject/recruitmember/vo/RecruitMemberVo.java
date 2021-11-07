package com.spring.sideproject.recruitmember.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.spring.sideproject.common.dao.support.Types;
import com.spring.sideproject.common.validator.RecruitMemberValidator;

public class RecruitMemberVo {

	@Types(alias = "M_EMAIL")
	@NotEmpty(message = "이메일은 필수 입력 값입니다.", groups = { RecruitMemberValidator.Regist.class, RecruitMemberValidator.Login.class })
	@Email(message = "이메일 형식으로 작성해주세요.", groups = { RecruitMemberValidator.Regist.class, RecruitMemberValidator.Login.class })	
	private String email;

	@Types
	@NotEmpty(message = "이름은 필수 입력 값입니다.", groups = { RecruitMemberValidator.Regist.class })	
	private String name;

	@Types
	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.", groups = { RecruitMemberValidator.Regist.class, RecruitMemberValidator.Login.class, RecruitMemberValidator.Update.class })
	@Length(min = 8, max = 20, message = "비밀번호는 8~20글자 사이로 입력해주세요.", groups = {RecruitMemberValidator.Regist.class, RecruitMemberValidator.Update.class })
	@Pattern(regexp = "((?=.*[a-zA-z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20})", message = "대/소문자, 특수문자를 조합하여 비밀번호 8자리 이상 입력해주세요.")	
	private String password;

	@Types
	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.", groups = { RecruitMemberValidator.Regist.class, RecruitMemberValidator.Login.class, RecruitMemberValidator.Update.class })
	@Length(min = 8, max = 20, message = "비밀번호는 8~20글자 사이로 입력해주세요.", groups = {RecruitMemberValidator.Regist.class, RecruitMemberValidator.Update.class })
	@Pattern(regexp = "((?=.*[a-zA-z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20})", message = "대/소문자, 특수문자를 조합하여 비밀번호 8자리 이상 입력해주세요.")	
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
