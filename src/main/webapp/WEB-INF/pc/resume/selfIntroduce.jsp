<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>    

	<link rel="stylesheet" href="<c:url value='/css/resume/selfIntroduce.css' />">
	
	<title>자기소개서</title>
	
	<script src="<c:url value='/js/resume/selfIntroduce.js' />"></script>

	<input type="hidden" name="resumeId" id="resumeId" value="${selfIntroduceVo.resumeId}"/>
	<div class="container" style="width: 70%;">
		<div class="tabDiv">
			<ul class="nav nav-pills nav-justified">			  
			 <li><a href="<c:url value='/resume/basicInfo.do/${selfIntroduceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">1.기본정보</a></li>
			  <li><a href="<c:url value='/resume/academicBackground.do/${selfIntroduceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">2.학력사항</a></li>
			  <li><a href="<c:url value='/resume/qualificationExperience.do/${selfIntroduceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">3.자격 및 경험</a></li>
			  <li class="active"><a href="<c:url value='/resume/selfIntroduce.do/${selfIntroduceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">4.자기소개서</a></li>
			  <li><a href="<c:url value='/resume/finalSubmissionAgreement.do/${selfIntroduceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">5.최종제출</a></li>
			</ul>
		</div>
		<br />
		<br />
		<form:form	id="selfIntroduceForm"
					modelAttribute="selfIntroduceVo">
			<h1>자기소개서</h1>
			<hr>	
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-9">
					<h4>1.성장과정(최대 700자)</h4>
					<textarea id="selfItdtContent1" name="selfItdtContent1" class="form-control" maxlength="700" cols="120" rows="12" placeholder="성장과정을 입력해주세요." >${selfIntroduceVo.selfItdtContent1}</textarea>
					<div style="text-align: right;">
						<span id="counter1">(0/700자)</span>
					</div>
					<div>
						<form:errors id="errorsSelfItdtContent1" cssStyle="color: red;" path="selfItdtContent1" />
					</div>
				</div>
				
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-9">
					<h4>2.지원동기(최대 700자)</h4>
					<textarea id="selfItdtContent2" name="selfItdtContent2" class="form-control" maxlength="700" cols="120" rows="12" placeholder="지원동기 내용을 입력해주세요." >${selfIntroduceVo.selfItdtContent2}</textarea>
					<div style="text-align: right;">
						<span id="counter2">(0/700자)</span>
					</div>
					<div>
						<form:errors id="errorsSelfItdtContent2" cssStyle="color: red;" path="selfItdtContent2" />
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-9">
					<h4>3.입사후 포부(최대 700자)</h4>
					<textarea id="selfItdtContent3" name="selfItdtContent3" class="form-control" maxlength="700" cols="120" rows="12" placeholder="입사후 포부 내용을 입력해주세요." >${selfIntroduceVo.selfItdtContent3}</textarea>
					<div style="text-align: right;">
						<span id="counter3">(0/700자)</span>
					</div>
					<div>
						<form:errors id="errorsSelfItdtContent3" cssStyle="color: red;" path="selfItdtContent3" />
					</div>
				</div>
			</div>			
			<br />
			<br />
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<input type="button" id="tempSaveBtn" class="btn btn-primary" value="임시저장" />
				<input type="button" id="finalSubmitBtn" class="btn btn-primary btn-warning" value="최종제출" />
			</div>
		</form:form>
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
	<div class="modal fade" id="successMessageModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="vertical-alignment-helper">
			<div class="modal-dialog vertical-align-center">
				<div class="modal-content panel-success">
					<div class="modal-header panel-heading">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">
							성공 메시지
						</h4>
					</div>
					<div id="successAlertMessage" class="modal-body">
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