<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

	<link rel="stylesheet" href="<c:url value='/css/resume/qualificationExperience.css' />">
	
	<title>자격 및 경험</title>
	
	<script src="<c:url value='/js/resume/qualificationExperience.js' />"></script>	

	<input type="hidden" name="resumeId" id="resumeId" value="${qualificationExperienceVo.resumeId}"/>
	<div class="container" style="width: 70%;">
		<div class="tabDiv">
			<ul class="nav nav-pills nav-justified">
			  <li><a href="<c:url value='/resume/basicInfo.do/${qualificationExperienceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">1.기본정보</a></li>
			  <li><a href="<c:url value='/resume/academicBackground.do/${qualificationExperienceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">2.학력사항</a></li>
			  <li class="active"><a href="<c:url value='/resume/qualificationExperience.do/${qualificationExperienceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">3.자격 및 경험</a></li>
			  <li><a href="<c:url value='/resume/selfIntroduce.do/${qualificationExperienceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">4.자기소개서</a></li>
			  <li><a href="<c:url value='/resume/finalSubmit.do/${qualificationExperienceVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">5.최종제출</a></li>
			</ul>
		</div>
		<br />
		<br />
		<form:form	id="qualificationExperienceForm"
					modelAttribute="qualificationExperienceVo">
				<h1>교육이수</h1>
				<hr>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-3">
						<h4>교육과정</h4>
						<input type="text" id="eduName" name="eduName" class="form-control" placeholder="교육과정명을 입력하세요." value="${qualificationExperienceVo.eduName}" />
					</div>
					<div class="col-sm-3">
						<h4>교육기관</h4>
						<input type="text" id="eduInst" name="eduInst" class="form-control" placeholder="교육기관을 입력하세요." value="${qualificationExperienceVo.eduInst}" />
					</div>
					<div class="col-sm-2">
						<h4>교육시간</h4>
						<input type="text" id="eduTime" name="eduTime" class="form-control" placeholder="교육시간을 입력하세요."  value="${qualificationExperienceVo.eduTime}" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-3">
						<h4>교육시작일</h4>
						<input type="date" id="eduStartDt" name="eduStartDt" class="form-control" value="${qualificationExperienceVo.eduStartDt}" />
					</div>
					<div class="col-sm-3">
						<h4>교육종료일</h4>
						<input type="date" id="eduEndDt" name="eduEndDt" class="form-control" value="${qualificationExperienceVo.eduEndDt}" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-9">
						<h4>교육내용</h4>
						<textarea id="eduContent" name="eduContent" class="form-control" cols="120" rows="12" placeholder="교육내용을 입력해주세요." >${qualificationExperienceVo.eduContent}</textarea>
					</div>
				</div>
				<h1>학내외 활동</h1>
				<hr>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-3">
						<h4>행동구분</h4>
						<select name="actDiv" id="actDiv" class="form-control">
						  <option value="" <c:if test="${qualificationExperienceVo.actDiv eq ''}">selected="selected"</c:if>>선택</option>
						  <option value="동아리" <c:if test="${qualificationExperienceVo.actDiv eq '동아리'}">selected="selected"</c:if>>동아리</option>
						  <option value="인턴" <c:if test="${qualificationExperienceVo.actDiv eq '인턴'}">selected="selected"</c:if>>인턴</option>
						</select>
					</div>
					<div class="col-sm-3">
						<h4>기관 및 조직명</h4>
						<input type="text" id="actInst" name="actInst" class="form-control" placeholder="기관 및 조직명을 입력하세요." value="${qualificationExperienceVo.actInst}" />
					</div>
					<div class="col-sm-3">
						<h4>역할</h4>
						<input type="text" id="actRole" name="actRole" class="form-control" placeholder="기관 및 조직명을 입력하세요." value="${qualificationExperienceVo.actRole}" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-3">
						<h4>활동시작일</h4>
						<input type="date" id="actStartDt" name="actStartDt" class="form-control" value="${qualificationExperienceVo.actStartDt}" />
					</div>
					<div class="col-sm-3">
						<h4>활동종료일</h4>
						<input type="date" id="actEndDt" name="actEndDt" class="form-control" value="${qualificationExperienceVo.actEndDt}" />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-9">
						<h4>활동내용</h4>
						<textarea id="actContent" name="actContent" class="form-control" cols="120" rows="12" placeholder="교육내용을 입력해주세요." >${qualificationExperienceVo.actContent}</textarea>
					</div>
				</div>
				<h1>공인시험</h1>
				<hr />
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-3">
						<h4>시험종류</h4>
						<input type="text" id="ofclEmType" name="ofclEmType" class="form-control" placeholder="공인시험 종류을 입력하세요." value="${qualificationExperienceVo.ofclEmType}" />
					</div>
					<div class="col-sm-3">
						<h4>등록번호</h4>
						<input type="text" id="ofclEmRegistNum" name="ofclEmRegistNum" class="form-control" placeholder="공인시험 종류을 입력하세요." value="${qualificationExperienceVo.ofclEmRegistNum}" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-3">
						<h4>응시일</h4>
						<input type="date" id="ofclEmDt" name="ofclEmDt" class="form-control" value="${qualificationExperienceVo.ofclEmDt}" />
					</div>
					<div class="col-sm-3">
						<h4>취득점수</h4>
						<input type="text" id="ofclEmScore" name="ofclEmScore" class="form-control" placeholder="공인시험 종류을 입력하세요." value="${qualificationExperienceVo.ofclEmScore}" />
					</div>
				</div>
				<h1>자격증</h1>
				<hr>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-3">
						<h4>자격증 종류</h4>
						<input type="text" id="licenseType" name="licenseType" class="form-control" placeholder="공인시험 종류을 입력하세요." value="${qualificationExperienceVo.licenseType}" />
					</div>
					<div class="col-sm-3">
						<h4>등록번호</h4>
						<input type="text" id="licenseRegistNum" name="licenseRegistNum" class="form-control" placeholder="공인시험 종류을 입력하세요." value="${qualificationExperienceVo.licenseRegistNum}" />
					</div>
					<div class="col-sm-3">
						<h4>취득일</h4>
						<input type="date" id="licenseAcqDt" name="licenseAcqDt" class="form-control" value="${qualificationExperienceVo.licenseAcqDt}" />
					</div>
				</div>
				<h1>수상경력</h1>
				<hr>
				<div class="row">
					<div class="col-sm-2"></div>
						<div class="col-sm-3">
						<h4>상훈명</h4>
						<input type="text" id="awardName" name="awardName" class="form-control" placeholder="공인시험 종류을 입력하세요." value="${qualificationExperienceVo.awardName}" />
					</div>
					<div class="col-sm-3">
						<h4>수여기관</h4>
						<input type="text" id="awardInst" name="awardInst" class="form-control" placeholder="공인시험 종류을 입력하세요." value="${qualificationExperienceVo.awardInst}" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-2"></div>
						<div class="col-sm-3">
						<h4>수상일자</h4>
						<input type="date" id="awardDt" name="awardDt" class="form-control" placeholder="공인시험 종류을 입력하세요." value="${qualificationExperienceVo.awardDt}" />
					</div>
					<div class="col-sm-3">
						<h4>수상내역</h4>
						<input type="text" id="awardContent" name="awardContent" class="form-control" placeholder="공인시험 종류을 입력하세요." value="${qualificationExperienceVo.awardContent}" />
					</div>
				</div>	
			
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<input type="button" id="tempSaveBtn" class="btn btn-primary" value="임시저장" />
				<input type="button" id="nextStepBtn" class="btn btn-primary btn-warning" value="다음단계" />
			</div>
			<input type="hidden" name="token" id="token" value="${sessionScope._CSRF_TOKEN_}"/>
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
		<strong>로그인이 정상적으로 처리되었습니다.</strong>
	</div>