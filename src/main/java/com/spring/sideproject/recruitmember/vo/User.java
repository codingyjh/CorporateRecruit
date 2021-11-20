package com.spring.sideproject.recruitmember.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private String userEmail;
	private String userPassword;
	private String grade;
	private boolean isBlockAccount;
	private String token;

	public User(String userEmail, String userPassword, String grade, boolean isBlockAccount, String token) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.grade = grade;
		this.isBlockAccount = isBlockAccount;
		this.token = token;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public boolean isBlockAccount() {
		return isBlockAccount;
	}

	public void setBlockAccount(boolean isBlockAccount) {
		this.isBlockAccount = isBlockAccount;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(grade));
		
		if ( grade.equals("ROLE_ADMIN")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return authorities;
	}

	@Override
	public String getPassword() {		
		return this.userPassword;
	}
	
	@Override
	public String getUsername() {		
		return this.userEmail;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return !isBlockAccount;
	}

	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}

	@Override
	public boolean isEnabled() {		
		return true;
	}

}
