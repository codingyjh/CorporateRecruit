<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>    

	<link rel="stylesheet" href="<c:url value='/css/resume/finalSubmissionAgreement.css' />">

	<title>최종제출 동의 서약서</title>

	<script src="<c:url value='/js/resume/finalSubmissionAgreement.js' />"></script>

	<input type="hidden" name="resumeId" id="resumeId" value="${basicInfoVo.resumeId}"/>
	<div class="container">
		<div class="tabDiv">
			<ul class="nav nav-pills nav-justified">			 
			  <li><a href="<c:url value='/resume/basicInfo.do/${basicInfoVo.resumeId}'/>">1.기본정보</a></li>
			  <li><a href="<c:url value='/resume/academicBackground.do/${basicInfoVo.resumeId}'/>">2.학력사항</a></li>
			  <li><a href="<c:url value='/resume/qualificationExperience.do/${basicInfoVo.resumeId}'/>">3.자격 및 경험</a></li>
			  <li><a href="<c:url value='/resume/selfIntroduce.do/${basicInfoVo.resumeId}'/>">4.자기소개서</a></li>
			  <li class="active"><a href="<c:url value='/resume/finalSubmit.do/${basicInfoVo.resumeId}'/>">5.최종제출</a></li>
			</ul>
		</div>
		<br />
		<br />
		<h1>최종제출 동의 서약서</h1>
		<hr>
		<br />
		<div class="row">
	    	<div class="col-lg-12">
	    		<div class="panel-body" style="border: 1px solid #ccc">
	    			<h2 style="text-align: center;">지원서 동의 서약서</h2>		
	    			<br/>	
					<h4>1. 본인은 OO 기업 2018년 하반기 신입사원 채용에 지원함에 있어 인상청탁 등 불명예스러운 일을 하지 않을 것이며
					, 이를 어길 시 어떠한 불이익도 감수할 것을 서약합니다.</h4>
					<h4>2. 지원서 상에 모든 기재 사항은 사실과 다름이 없음을 증명하며, 차후 지원서 상의 내용이 허위로 판명되어 
					합격 도는 입사가 취소되더라도 이의를 제기하지 않을 것을 서약합니다.</h4>
					<br/>
					<br/>
					<h4 style="text-align: right;">제출일 : ${basicInfoVo.finalDt} </h4>
					<h4 style="text-align: right;">지원자 : ${sessionScope._USER_.name} </h4>						
				</div>
				<br />
				<form:form id="finalSubmissionAgreeForm"
						   role="form"
						   action="/Recruit/main/agreement"
						   method="post">
					<div class="form-group" id="checkBox" style="text-align:center;">
						<label class="checkbox-inline">
							<input type="checkbox" id="agree" name="agree" value="true">동의합니다.
						</label>
					</div>
					<div id="agreeBtnDiv" style="text-align:center;" >
						<input type="button" id="finalSubmissionAgreeBtn" class="btn btn-primary" value="최종제출">
					</div>
				</form:form>										
	    	</div>
	    </div>
	    <br />		
	    <br />
	</div>
	<div class="modal fade" id="errorMessageModal" tabindex="-1" role="dialog" aria-hidden="true">
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
					<div id="errorAlertMessage" class="modal-body">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>		
	<br />
	<br />
	<div class="alert alert-success" id="successMessage">
		<strong>글 작성이 성공적으로 처리되었습니다.</strong>
	</div>