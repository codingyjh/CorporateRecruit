<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

	<link rel="stylesheet" href="<c:url value='/css/recruitBoard/recruitAgreement.css' />">
	
	<title>이용약관 및 개인정보</title>
	
	<script src="<c:url value='/js/recruitBoard/recruitAgreement.js' />"></script>
		
	<div class="container">
		<div class="panel panel-default">
		  <div class="panel-heading">이용약관 및 개인정보</div>
		  <div class="panel-body">
		    <div class="row">
		    	<div class="col-lg-12">
		    		<h4>이용약관</h4>
					<div class="panel-body" style="border: 1px solid #ccc">
						<p>본 채용홈페이지를 통해 제출하는 지원서는 귀하께서 지원서를 제출하는 회사(이하 채용회사)가 직접 접수하고 관리하며, 향후 지원서 관리책임은 채용회사에 있습니다.</p>
						<p>지원자는 아래 개인정보 제공 등에 관해 동의하지 않을 권리가 있습니다.</p>
						<p>다만, 지원서를 통해 제공받은 정보는 채용회사의 채용 및 선발에 필수적인 항목으로 해당 정보를 제공받지 못할 경우 회사는 공정한 선발전형을 진행할 수 없습니다. 따라서 아래 개인정보 제공에 대해 동의하지 않는 경우 채용 및 선발전형에 지원이 제한될 수 있습니다. 지원자의 동의 거부 권리 및 동의 거부에 따른 불이익은 아래에 제시되는 모든 동의사항에 해당됩니다.</p>
					</div>
					<br />
					<h4>개인정보</h4>
					<div class="panel-body" style="border: 1px solid #ccc">
						<p>1. 수집하는 개인정보 항목</p>
						<p>성명, 국적, 주소, 보훈 및 장애인 대상여부, 전화번호, 휴대전화번호, 학력, 성적, 병역, 경력, 해외 체류경험 및 연수활동, 사회활동, 어학 및 기타자격, 수상경력, 취미, 특기, 자기소개</p>
						<p>2. 수집 및 이용 목적</p>
						<p>채용전형의 진행, 진행단계별 결과 등 채용정보 안내 및 인재풀 구성</p>
						<p>3. 개인정보의 보유 및 이용 기간</p>
						<p>지원서상에 작성하신 개인정보는 회사의 인재채용을 위한 인재풀로 활용될 예정으로 채용전형 결과 통보일로부터 1개월까지 보관됩니다. 지원자께서 삭제를 요청하실 경우 해당 개인정보는 삭제됩니다.</p>
					</div>
					<br />
					<form:form id="agreeForm"
							   role="form"
							   action="/Recruit/main/agreement"
							   method="post">
						<div class="form-group">
							<label class="checkbox-inline">
								<input type="checkbox" id="agree" name="agree" value="true">동의합니다.
							</label>
						</div>
						<input type="button" id="agreeBtn" class="btn btn-primary" value="다음단계">
						<input type="hidden" name="boardId" id="boardId" value="${boardId}"/>
						<input type="hidden" name="token" id="token" value="${sessionScope._CSRF_TOKEN_}"/>
					</form:form>
		    	</div>
		    </div>
		  </div>
		</div>
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
	<br />
	<br />
	<div class="alert alert-success" id="successMessage">
		<strong>글 작성이 성공적으로 처리되었습니다.</strong>
	</div>