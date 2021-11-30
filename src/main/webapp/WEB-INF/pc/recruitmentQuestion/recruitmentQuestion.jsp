<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<link rel="stylesheet" href="<c:url value='/css/recruitmentQuestion/recruitmentQuestion.css' />">
<title>채용문의 페이지</title>
<script src="<c:url value='/js/recruitmentQuestion/recruitmentQuestion.js' />"></script>	

<div class="container">
	<div class="jumbotron">
		<h1 class="text-center">채용문의</h1>
		<p class="text-center">OO 기업 채용에 관한 문의사항을 메일로 보내주세요.</p>
	</div>
	<h1 class="page-header">채용문의</h1>
	<form:form id="recruitmentQuestionEmailForm"
		  	   modelAttribute="recruitQnaVo">
	
		<div>
			<form:errors id="errorsTitle" cssStyle="color: red;" path="title" />
		</div>
		<div>
			<form:errors id="errorsContent" cssStyle="color: red;" path="content" />
		</div>	
		
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th colspan="2"><h4>이메일</h4></th>
				</tr>
			</thead>
			<tbody>						
				<tr>
					<td class="tdStyle"><h5>메일제목</h5></td>
					<td>
						<input type="hidden" name="toEmail" class="form-control" value="yoojh0325@gmail.com" readonly />
						<input type="hidden" name="fromEmail" class="form-control" value="${sessionScope._USER_.email}" readonly />
						<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력해주세요" />
<%-- 						<input type="hidden" id="token" name="token" value="${sessionScope._CSRF_TOKEN_}"/> --%>
					</td>
				</tr>
				<tr>
					<td class="tdStyle"><h5>메일내용</h5></td>
					<td><textarea id="content" name="content" class="form-control" cols="120" rows="12" placeholder="내용을 입력해주세요." ></textarea></td>
				</tr>
				<tr>
					<td class="tdBtnStyle" colspan="4">
						<input type="button" id="recruitmentQuestionEmailBtn" class="btn btn-warning" value="메일 전송" />
					</td>
				</tr>
			</tbody>
		</table>	  	   
	</form:form>
</div>
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="vertical-alignment-helper">
		<div class="modal-dialog vertical-align-center">
			<div class="modal-content panel-warning">
				<div class="modal-header panel-heading">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times</span>
						<span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">
						오류 메시지
					</h4>
				</div>
				<div id="checkMessage" class="modal-body">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="alert alert-success" id="successMessage">
	<strong>메일 전송중입니다. 잠시만 기다려주세요.</strong>
</div>