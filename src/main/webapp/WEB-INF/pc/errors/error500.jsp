<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width initial-scale=1">			
	<link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />">		
	<link rel="stylesheet" href="<c:url value='/css/errors/error500.css' />">
	<link href='https://fonts.googleapis.com/css?family=Anton|Passion+One|PT+Sans+Caption' rel='stylesheet' type='text/css'>
	<title>500 페이지</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="<c:url value='/bootstrap/js/bootstrap.js' />"></script>
	<script src="<c:url value='/js/errors/error500.js' />"></script>
	
	<!-- Error Page -->
	<div class="error">
	    <div class="container-floud">
	        <div class="col-xs-12 ground-color text-center">
	            <div class="container-error-404">
	                <div class="clip"><div class="shadow"><span class="digit thirdDigit"></span></div></div>
	                <div class="clip"><div class="shadow"><span class="digit secondDigit"></span></div></div>
	                <div class="clip"><div class="shadow"><span class="digit firstDigit"></span></div></div>
	                <div class="msg">OH!<span class="triangle"></span></div>
	            </div>
	            <h2 class="h1">일시적인 오류로 인해 페이지를 표시할 수 없습니다.</h2>
				<h4>잠시 후 다시 시도해 주세요.</h4>
				<h4>이 페이지가 계속 보인다면, 사이트 관리자에게 문의해 주세요.</h4>
	            <a href="<c:url value='/companyMain/main.do' />" class="btn btn-primary" type="button" >홈으로 돌아가기</a>
	        </div>
	    </div>
	</div>
	<!-- Error Page -->