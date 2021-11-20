package com.spring.sideproject.recruitmember.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sideproject.common.constant.MasterCodeConstants;
import com.spring.sideproject.recruitmember.service.RecruitMemberService;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	@Autowired
	private RecruitMemberService recruitMemberService;

	@RequestMapping("/recruitMember/recruitLoginFail.do")
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter(MasterCodeConstants.EMAIL);
		String password = request.getParameter(MasterCodeConstants.PASSWORD);
		
		String emailExistYn = this.recruitMemberService.readOneEmailExistCheckService(email);
		
		if ( emailExistYn.equals(MasterCodeConstants.YN_N) ) {
			out.println("<script>alert('등록되지 않은 이메일입니다. 다시 확인해주세요.'); location.href='/recruitMember/recruitMemberLogin.do';</script>");
			out.close();
		}
		
		RecruitMemberVo recruitMember = new RecruitMemberVo();
		recruitMember.setEmail(email);
		recruitMember.setPassword(password);
						
		RecruitMemberVo loginRecruitMember = this.recruitMemberService.readOneRecruitMemberService(recruitMember);
		
		boolean isBlockAccount = this.recruitMemberService.isBlockUserService(email);
		boolean isLoginSuccess = loginRecruitMember != null;		
		
		int loginFailCount =  this.recruitMemberService.readOneRecruitMembersGetByEmailService(recruitMember.getEmail()).getLoginFailCount();
		
		
		if ( !isBlockAccount ) {
			
			if ( !isLoginSuccess ) {
				
				if ( loginFailCount > 4 ) {
					out.println("<script>alert('로그인 시도 제한 마지막 횟수입니다.'); location.href='/recruitMember/recruitMemberLogin.do';</script>");
					out.close();
				} else {
					out.println("<script>alert('로그인 시도에 실패하였습니다.(시도횟수 : " + loginFailCount + "회 / 제한 5회)'); location.href='/recruitMember/recruitMemberLogin.do';</script>");
					out.close();
				}
			}
			
		} else {		
			out.println("<script>alert('계정이 잠겼습니다. 1시간 후에 다시 시도해주세요.'); location.href='/recruitMember/recruitMemberLogin.do';</script>");
			out.close();
		}
		
	}
}