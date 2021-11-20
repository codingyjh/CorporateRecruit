package com.spring.sideproject.recruitmember.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.nhncorp.lucy.security.xss.XssFilter;
import com.spring.sideproject.common.constant.MasterCodeConstants;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.recruitmember.vo.User;

public class UserService implements AuthenticationProvider {

	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private RecruitMemberService recruitMemberService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userEmail = authentication.getPrincipal().toString();
		String userPassword = authentication.getCredentials().toString();
		
		RecruitMemberVo recruitMember = new RecruitMemberVo();
		
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		
		recruitMember.setEmail(filter.doFilter(userEmail));
		recruitMember.setPassword(filter.doFilter(userPassword));
		
		RecruitMemberVo loginRecruitMember = null;
		
		System.out.println("----Email:" + recruitMember.getEmail());
		System.out.println("----Password:" + recruitMember.getPassword());
		
		if ( this.recruitMemberService == null ) {
			System.out.println("recruitMemberService is Null");
		}
		
		boolean isBlockUser = this.recruitMemberService.isBlockUserService(recruitMember.getEmail());
		
		if ( !isBlockUser ) {			
			loginRecruitMember = this.recruitMemberService.readOneRecruitMemberService(recruitMember);
			
			if ( loginRecruitMember == null ) {
				this.recruitMemberService.increaseLoginFailCountService(recruitMember.getEmail());
			}			
			else {
				this.recruitMemberService.unBlockUserService(recruitMember.getEmail());
			}
		}
		
		UsernamePasswordAuthenticationToken result = null;
		
		if ( loginRecruitMember != null ) {
			String token = UUID.randomUUID().toString();
			String grade = MasterCodeConstants.ROLE_USER;
			
			System.out.println("memberVO password : " + recruitMember.getPassword());
			System.out.println("loginMemberVO password : " + loginRecruitMember.getPassword());
			
			recruitMember.setPassword(userPassword);
			
			boolean isAdmin = this.recruitMemberService.readOneRecruitMemberService(recruitMember).getIsAdminYn().equals("Y");					
			
			if ( isAdmin == true ) {
				 grade = MasterCodeConstants.ROLE_ADMIN;
			}
			else {
				grade = MasterCodeConstants.ROLE_USER;
			}
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority(grade));
			
			if ( grade.equals(MasterCodeConstants.ROLE_ADMIN) ) {
				roles.add(new SimpleGrantedAuthority(MasterCodeConstants.ROLE_USER));
			}
			
			result = new UsernamePasswordAuthenticationToken(userEmail, recruitMember.getPassword(), roles);
			
			User user = new User(userEmail, userPassword, grade, isBlockUser, token);
			result.setDetails(user);			
		}
		else {
			throw new BadCredentialsException("잘못된 인증");
		}
		return result;	
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class );
	}

}
