<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %> --%>
<%@ page session="true" %>    

<nav class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="<c:url value='/companyMain/main' />">기업 입사지원 사이트</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
					aria-haspopup="true" aria-expanded="false">기업정보<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="<c:url value='/companyInfo/introduce' />">회사개요 및 연혁</a></li>
					<li><a href="<c:url value='/companyInfo/vision' />">비전</a></li>
					<li><a href="<c:url value='/companyInfo/ceoMessage' />">CEO 인사말</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
					aria-haspopup="true" aria-expanded="false">채용 정보<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="<c:url value='/recruitInfo/recruitmentGuide' />">채용 안내</a></li>
					<li><a href="<c:url value='/recruitInfo/talentedHRModel' />">인재상</a></li>
					<li><a href="<c:url value='/recruitInfo/jobIntroduce' />">직무 소개</a></li>	
				</ul>
			</li>				
<%-- 			<li><a href="<c:url value='/recruitBoard/recruitBoardList?token=${sessionScope._CSRF_TOKEN_}' />">채용공고</a></li>				 --%>
<%-- 			<li><a href="<c:url value='/recruitmentQuestion/recruitmentQuestion?token=${sessionScope._CSRF_TOKEN_}' />">채용문의</a></li> --%>
		</ul>
		<c:choose>
			<c:when test="${not empty sessionScope._USER_}">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">${sessionScope._USER_.name}님</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
							aria-haspopup="true" aria-expanded="false">접속중<span class="caret"></span></a>
<!-- 						<ul class="dropdown-menu">						 -->
<%-- 							<li><a href="<c:url value='/recruitMember/recruitMemberUpdate?token=${sessionScope._CSRF_TOKEN_}' />">비밀번호 변경</a></li>						 --%>
<!-- 							<li><a href="#">이력서 정보</a></li> -->
<!-- 							<s:authorize access="hasRole('ROLE_ADMIN')" > -->
<%-- 								<li><a href="<c:url value='/recruitMember/recruitMemberList?token=${sessionScope._CSRF_TOKEN_}' />">회원정보</a></li> --%>
<!-- 							</s:authorize>						 -->
<%-- 							<li><a href="<c:url value='/recruitMember/recruitMemberLogout?token=${sessionScope._CSRF_TOKEN_}' />">로그아웃</a></li> --%>
<!-- 						</ul> -->
					</li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
							aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/recruitMember/recruitMemberLogin' />">로그인</a></li>						
							<li><a href="<c:url value='/recruitMember/recruitMemberRegist' />">회원가입</a></li>												
						</ul>
					</li>
				</ul>
			</c:otherwise>
		</c:choose>				
	</div>
</nav>