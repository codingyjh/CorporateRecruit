<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>    

	<link rel="stylesheet" href="<c:url value='/css/resume/finishResume.css' />">
	
	<title>최종제출</title>
	
	<div class="container">				
		<h1>최종제출</h1>
		<hr>
		<br />
		<div class="row">
			<div class="finalDiv">
				<h2><span style="color: orange;">${sessionScope._USER_.name}</span>님 최종 제출하셨습니다.</h2>
				<h2>좋은 결과 있기를 응원합니다.</h2>
				<h3>OOO 기업 인사팀</h3>				
			</div>
			<div class="mainBtnDiv">
				<a href="<c:url value='/companyMain/main.do' />" class="btn btn-primary" type="button" >홈으로 돌아가기</a>
			</div>
		</div>		
	</div>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />