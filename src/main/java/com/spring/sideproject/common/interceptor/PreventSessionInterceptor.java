package com.spring.sideproject.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.sideproject.common.constant.MasterCodeConstants;
import com.spring.sideproject.common.session.Session;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

public class PreventSessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		RecruitMemberVo recruitMemberVo = (RecruitMemberVo) session.getAttribute(Session.USER);
		
		if ( recruitMemberVo != null ) {
			response.sendRedirect(MasterCodeConstants.INTERCEPTOR_COMPANY_MAIN);
			return false;
		}
		return true;
	}
}
