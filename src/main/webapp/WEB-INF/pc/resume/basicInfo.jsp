<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

	<link rel="stylesheet" href="<c:url value='/css/resume/basicInfo.css' />">
	
	<title>기본 정보</title>
	
	<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>	
	<script src="<c:url value='/js/common/jquery-form.js' />"></script>
	<script src="<c:url value='/js/resume/basicInfo.js' />"></script>		

	<input type="hidden" name="resumeId" id="resumeId" value="${basicInfoVo.resumeId}"/>
	<div class="container" style="width: 70%;">	
		<div class="tabDiv">
			<ul class="nav nav-pills nav-justified">				  		  
			  <li class="active"><a href="<c:url value='/resume/basicInfo.do/${basicInfoVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">1.기본정보</a></li>
			  <li><a href="<c:url value='/resume/academicBackground.do/${basicInfoVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">2.학력사항</a></li>
			  <li><a href="<c:url value='/resume/qualificationExperience.do/${basicInfoVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">3.자격 및 경험</a></li>
			  <li><a href="<c:url value='/resume/selfIntroduce.do/${basicInfoVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">4.자기소개서</a></li>
			  <li><a href="<c:url value='/resume/finalSubmissionAgreement.do/${basicInfoVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">5.최종제출</a></li>			  	
			</ul>
		</div>
		<br />
		<br />
		<form:form id="basicInfoForm"
				   modelAttribute="basicInfoVo"
				   autocomplete="off"
				   enctype="multipart/form-data">
			<h1>기본정보</h1>
			<hr>
			<div class="row">
				<div class="col-sm-3">
				    <div class="text-center">
				    	<c:choose>
				    		<c:when test="${not empty basicInfoVo.imgOriginFileName}">				    			
				    			<img src="<c:url value='/resume/basicInfoImageDownload.do/${basicInfoVo.resumeId}' />" class="avatar img-thumbnail" alt="avatar" id="profile">
				    		</c:when>
				    		<c:otherwise>
				    			<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-thumbnail" alt="avatar" id="profile">
				    		</c:otherwise>
				    	</c:choose>
				        <h6>이력서 사진 업로드</h6>
				        <input type="file" id="file" name="file" class="text-center center-block file-upload" value="${basicInfoVo.imgOriginFileName}"/>
			      	</div>
				</div>
				<div class="col-sm-3">
				    <h4>한글 이름</h4><input type="text" id="korName" name="korName" class="form-control" value="${sessionScope._USER_.name}" readOnly />
				    <br />
				    <h4>한자 이름</h4><input type="text" id="chName" name="chName" class="form-control" placeholder="한자 이름 입력" value="${basicInfoVo.chName}" />
				    <form:errors id="errorsChName" cssStyle="color: red;" path="chName" />
				</div>
				<div class="col-sm-3">
				    <h4>영어 이름</h4><input type="text" id="engName" name="engName" class="form-control"placeholder="영어 이름 입력" value="${basicInfoVo.engName}" />
				    <form:errors id="errorsEngName" cssStyle="color: red;" path="engName" />
				    <br />
				    <h4>생년월일</h4><input type="date" id="birth" name="birth" class="form-control" placeholder="생년월일 입력" value="${basicInfoVo.birth}" />
				    <form:errors id="errorsBirth" cssStyle="color: red;" path="birth" />
				</div>
			</div>
			<h1>인적사항</h1>
			<hr>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">				
					<h4>이메일</h4><input type="text" id="email" name="email" class="form-control" value="${sessionScope._USER_.email}" readOnly />
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>연락처</h4>
					<input type="text" id="phone" name="phone" class="form-control" placeholder="연락처 입력" value="${basicInfoVo.phone}" />
					<form:errors id="errorsPhone" cssStyle="color: red;" path="phone" />
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-6">
					<h4>주소</h4>
					<input type="text" id="zipCode" name="zipCode" placeholder="우편번호" value="${basicInfoVo.zipCode}" />
					<form:errors id="errorsZipCode" cssStyle="color: red;" path="zipCode" />
					<input type="button" id="addressBtn" name="addressBtn" class="btn btn-primary" value="우편번호 찾기" />
					<input type="text" id="address" name="address" class="form-control" placeholder="주소" value="${basicInfoVo.address}" />
					<form:errors id="errorsAddress" cssStyle="color: red;" path="address" />
					<input type="text" id="dAddress" name="dAddress" class="form-control" placeholder="상세주소" value="${basicInfoVo.dAddress}" />
					<form:errors id="errorsDAddress" cssStyle="color: red;" path="dAddress" />
				</div>
			</div>
			<h1>지원분야</h1>
			<hr>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<h4>경력구분</h4> 
					<select name="careerDiv" id="careerDiv" class="form-control">
					  <option value="" <c:if test="${basicInfoVo.careerDiv eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="신입" <c:if test="${basicInfoVo.careerDiv eq '신입'}">selected="selected"</c:if>>신입</option>
					  <option value="경력" <c:if test="${basicInfoVo.careerDiv eq '경력'}">selected="selected"</c:if>>경력</option>
					</select>
					<form:errors id="errorsCareerDiv" cssStyle="color: red;" path="careerDiv" />
				</div>
				<div class="col-sm-5">
					<h4>모집분야</h4> 
					<select name="recruitField" id="recruitField" class="form-control" >
					  <option value="" <c:if test="${basicInfoVo.recruitField eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="2018 하반기 OO 기업 신입/경력 공채" <c:if test="${basicInfoVo.recruitField eq '2018 하반기 OO 기업 신입/경력 공채'}">selected="selected"</c:if>>2018 하반기 OO 기업 신입/경력 공채 </option>
					</select>
					<form:errors id="errorsRecruitField" cssStyle="color: red;" path="recruitField" />
				</div>
				<div class="col-sm-3">
					<h4>해당직무</h4> 
					<select name="recruitJob" id="recruitJob" class="form-control">
					  <option value="" <c:if test="${basicInfoVo.recruitJob eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="웹 디자인" <c:if test="${basicInfoVo.recruitJob eq '웹 디자인'}">selected="selected"</c:if>>웹 디자인</option>
					  <option value="웹 개발자" <c:if test="${basicInfoVo.recruitJob eq '웹 개발자'}">selected="selected"</c:if>>웹 개발자</option>
					  <option value="시스템 엔지니어" <c:if test="${basicInfoVo.recruitJob eq '시스템 엔지니어'}">selected="selected"</c:if>>시스템 엔지니어</option>
					  <option value="보안" <c:if test="${basicInfoVo.recruitJob eq '보안'}">selected="selected"</c:if>>보안</option>
					</select>
					<form:errors id="errorsRecruitJob" cssStyle="color: red;" path="recruitJob" />
				</div>
			</div>
			<br />
			<br />
			<h1>장애여부</h1>
			<hr>
			<div class="row">
				<form:errors id="errorsHandicapYn" cssStyle="color: red;" path="handicapYn" />
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<div class="radio">
					  <label>
					    <input type="radio" name="handicapYn" id="handicapRadioY" value="handicapRadioY" <c:if test="${basicInfoVo.handicapYn eq 'handicapRadioY'}">checked="checked"</c:if>>
					    	<span style="font-size: 18px;">대상</span>
					  </label>				 	
					</div>
				</div>
				<div class="col-sm-2">
					<div class="radio">
					  <label>
					    <input type="radio" name="handicapYn" id="handicapRadioN" value="handicapRadioN" <c:if test="${basicInfoVo.handicapYn eq 'handicapRadioN'}">checked="checked"</c:if>>
					    	<span style="font-size: 18px;">비대상</span>
					  </label>				 	
					</div>
				</div>
				<div id="handicapGradeDiv" class="col-sm-3">
					<select name="handicapGrade" id="handicapGrade" class="form-control">
					  	<option value="" <c:if test="${basicInfoVo.handicapGrade eq ''}">selected="selected"</c:if>>등급</option>
						<option value="1급" <c:if test="${basicInfoVo.handicapGrade eq '1급'}">selected="selected"</c:if>>1급</option>
						<option value="2급" <c:if test="${basicInfoVo.handicapGrade eq '2급'}">selected="selected"</c:if>>2급</option>
						<option value="3급" <c:if test="${basicInfoVo.handicapGrade eq '3급'}">selected="selected"</c:if>>3급</option>
						<option value="4급" <c:if test="${basicInfoVo.handicapGrade eq '4급'}">selected="selected"</c:if>>4급</option>
						<option value="5급" <c:if test="${basicInfoVo.handicapGrade eq '5급'}">selected="selected"</c:if>>5급</option>
						<option value="6급" <c:if test="${basicInfoVo.handicapGrade eq '6급'}">selected="selected"</c:if>>6급</option>
						<option value="7급" <c:if test="${basicInfoVo.handicapGrade eq '7급'}">selected="selected"</c:if>>7급</option>
						<option value="8급" <c:if test="${basicInfoVo.handicapGrade eq '8급'}">selected="selected"</c:if>>8급</option>
						<option value="9급" <c:if test="${basicInfoVo.handicapGrade eq '9급'}">selected="selected"</c:if>>9급</option>
						<option value="10급" <c:if test="${basicInfoVo.handicapGrade eq '10급'}">selected="selected"</c:if>>10급</option>
						<option value="11급" <c:if test="${basicInfoVo.handicapGrade eq '11급'}">selected="selected"</c:if>>11급</option>
						<option value="12급" <c:if test="${basicInfoVo.handicapGrade eq '12급'}">selected="selected"</c:if>>12급</option>
						<option value="13급" <c:if test="${basicInfoVo.handicapGrade eq '13급'}">selected="selected"</c:if>>13급</option>
						<option value="14급" <c:if test="${basicInfoVo.handicapGrade eq '14급'}">selected="selected"</c:if>>14급</option>
					</select>
				</div>
				<div id="handicapReasonDiv" class="col-sm-3">
					<select name="handicapReason" id="handicapReason" class="form-control">
					  	<option value="" <c:if test="${basicInfoVo.handicapReason eq ''}">selected="selected"</c:if>>내용</option>
						<option value="지체장애" <c:if test="${basicInfoVo.handicapReason eq '지체장애'}">selected="selected"</c:if>>지체장애</option>
	                    <option value="뇌병변장애" <c:if test="${basicInfoVo.handicapReason eq '뇌병변장애'}">selected="selected"</c:if>>뇌병변장애</option>
	                    <option value="시각장애" <c:if test="${basicInfoVo.handicapReason eq '시각장애'}">selected="selected"</c:if>>시각장애</option>
	                    <option value="청각장애" <c:if test="${basicInfoVo.handicapReason eq '청각장애'}">selected="selected"</c:if>>청각장애</option>
	                    <option value="언어장애" <c:if test="${basicInfoVo.handicapReason eq '언어장애'}">selected="selected"</c:if>>언어장애</option>
	                    <option value="정신지체" <c:if test="${basicInfoVo.handicapReason eq '정신지체'}">selected="selected"</c:if>>정신지체</option>
	                    <option value="발달장애" <c:if test="${basicInfoVo.handicapReason eq '발달장애'}">selected="selected"</c:if>>발달장애</option>
	                    <option value="정신장애" <c:if test="${basicInfoVo.handicapReason eq '정신장애'}">selected="selected"</c:if>>정신장애</option>
	                    <option value="신장장애" <c:if test="${basicInfoVo.handicapReason eq '신장장애'}">selected="selected"</c:if>>신장장애</option>
	                    <option value="심장장애" <c:if test="${basicInfoVo.handicapReason eq '심장장애'}">selected="selected"</c:if>>심장장애</option>
	                    <option value="안면변형장애" <c:if test="${basicInfoVo.handicapReason eq '안면변형장애'}">selected="selected"</c:if>>안면변형장애</option>
	                    <option value="호흡기장애" <c:if test="${basicInfoVo.handicapReason eq '호흡기장애'}">selected="selected"</c:if>>호흡기장애</option>
	                    <option value="간장애" <c:if test="${basicInfoVo.handicapReason eq '간장애'}">selected="selected"</c:if>>간장애</option>
	                    <option value="장루요루장애" <c:if test="${basicInfoVo.handicapReason eq '장루요루장애'}">selected="selected"</c:if>>장루요루장애</option>
	                    <option value="간질장애" <c:if test="${basicInfoVo.handicapReason eq '간질장애'}">selected="selected"</c:if>>간질장애</option>
	                    <option value="산재장애" <c:if test="${basicInfoVo.handicapReason eq '산재장애'}">selected="selected"</c:if>>산재장애</option>
					</select>
				</div>
			</div>
			<h1>보훈여부</h1>
			<hr>
			<div class="row">
				<form:errors id="errorsBohoonYn" cssStyle="color: red;" path="bohoonYn" />
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<div class="radio">
					  <label>
					    <input type="radio" name="bohoonYn" id="bohoonRadioY" value="bohoonRadioY" <c:if test="${basicInfoVo.bohoonYn eq 'bohoonRadioY'}">checked="checked"</c:if>>
					    	<span style="font-size: 18px;">대상</span>
					  </label>				 	
					</div>
				</div>
				<div class="col-sm-2">
					<div class="radio">
					  <label>
					    <input type="radio" name="bohoonYn" id="bohoonRadioN" value="bohoonRadioN" <c:if test="${basicInfoVo.bohoonYn eq 'bohoonRadioN'}">checked="checked"</c:if>>
					    	<span style="font-size: 18px;">비대상</span>
					  </label>				 	
					</div>
				</div>
			</div>
			<br />
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div id="bohoonNumDiv" class="col-sm-3">
					<h4>보훈번호</h4>
					<input type="text" id="bohoonNum" name="bohoonNum" class="form-control" placeholder="보훈 번호를 입력하세요." value="${basicInfoVo.bohoonNum}" />
					<form:errors id="errorsBohoonNum" cssStyle="color: red;" path="bohoonNum" />
				</div>
				<div id="bohoonRLTNDiv" class="col-sm-3">
					<h4>관계</h4>
					<input type="text" id="bohoonRltn" name="bohoonRltn" class="form-control" placeholder="관계를 입력하세요." value="${basicInfoVo.bohoonRltn}" />
					<form:errors id="errorsBohoonRltn" cssStyle="color: red;" path="bohoonRltn" />
				</div>
				<div id="bohoonCostDiv" class="col-sm-3">
					<h4>비용</h4>
					<input type="text" id="bohoonCost" name="bohoonCost" class="form-control" placeholder="비용을 입력하세요." value="${basicInfoVo.bohoonCost}" />
					<form:errors id="errorsBohoonCost" cssStyle="color: red;" path="bohoonCost" />
				</div>
			</div>
			<h1>병역사항</h1>
			<hr>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<h4>병역구분</h4> 
					<select name="milDiv" id="milDiv" class="form-control">
					  <option value="" <c:if test="${basicInfoVo.milDiv eq ''}">selected="selected"</c:if>>선택</option>
						<option value="군필" <c:if test="${basicInfoVo.milDiv eq '군필'}">selected="selected"</c:if>>군필</option>
						<option value="면제" <c:if test="${basicInfoVo.milDiv eq '면제'}">selected="selected"</c:if>>면제</option>
						<option value="미필" <c:if test="${basicInfoVo.milDiv eq '미필'}">selected="selected"</c:if>>미필</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>군별</h4> 
					<select name="milType" id="milType" class="form-control">
					  	<option value="" <c:if test="${basicInfoVo.milType eq ''}">selected="selected"</c:if>>선택</option>
						<option value="육군" <c:if test="${basicInfoVo.milType eq '육군'}">selected="selected"</c:if>>육군</option>
						<option value="해군" <c:if test="${basicInfoVo.milType eq '해군'}">selected="selected"</c:if>>해군</option>
						<option value="공군" <c:if test="${basicInfoVo.milType eq '공군'}">selected="selected"</c:if>>공군</option>
						<option value="해병" <c:if test="${basicInfoVo.milType eq '해병'}">selected="selected"</c:if>>해병</option>
						<option value="전경" <c:if test="${basicInfoVo.milType eq '전경'}">selected="selected"</c:if>>전경</option>
						<option value="의경" <c:if test="${basicInfoVo.milType eq '의경'}">selected="selected"</c:if>>의경</option>
						<option value="공익" <c:if test="${basicInfoVo.milType eq '공익'}">selected="selected"</c:if>>공익</option>
						<option value="병특" <c:if test="${basicInfoVo.milType eq '병특'}">selected="selected"</c:if>>병특</option>
						<option value="기타" <c:if test="${basicInfoVo.milType eq '기타'}">selected="selected"</c:if>>기타</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>병과</h4> 
					<select name="milWork" id="milWork" class="form-control">
					  	<option value="" <c:if test="${basicInfoVo.milWork eq ''}">selected="selected"</c:if>>선택</option>
						<option value="보병" <c:if test="${basicInfoVo.milWork eq '보병'}">selected="selected"</c:if>>보병</option>
	                    <option value="행정" <c:if test="${basicInfoVo.milWork eq '행정'}">selected="selected"</c:if>>행정</option>
	                    <option value="수송" <c:if test="${basicInfoVo.milWork eq '수송'}">selected="selected"</c:if>>수송</option>
	                    <option value="의무" <c:if test="${basicInfoVo.milWork eq '의무'}">selected="selected"</c:if>>의무</option>
	                    <option value="작전" <c:if test="${basicInfoVo.milWork eq '작전'}">selected="selected"</c:if>>작전</option>
	                    <option value="보급" <c:if test="${basicInfoVo.milWork eq '보급'}">selected="selected"</c:if>>보급</option>
	                    <option value="통신" <c:if test="${basicInfoVo.milWork eq '통신'}">selected="selected"</c:if>>통신</option>
	                    <option value="포병" <c:if test="${basicInfoVo.milWork eq '포병'}">selected="selected"</c:if>>포병</option>
	                    <option value="기갑" <c:if test="${basicInfoVo.milWork eq '기갑'}">selected="selected"</c:if>>기갑</option>
	                    <option value="공병" <c:if test="${basicInfoVo.milWork eq '공병'}">selected="selected"</c:if>>공병</option>
	                    <option value="화학" <c:if test="${basicInfoVo.milWork eq '화학'}">selected="selected"</c:if>>화학</option>
	                    <option value="기타" <c:if test="${basicInfoVo.milWork eq '기타'}">selected="selected"</c:if>>기타</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>계급</h4> 
					<select name="milLevel" id="milLevel" class="form-control">
					  	<option value="" <c:if test="${basicInfoVo.milLevel eq ''}">selected="selected"</c:if>>선택</option>
						<option value="이병" <c:if test="${basicInfoVo.milLevel eq '이병'}">selected="selected"</c:if>>이병</option>
	                    <option value="일병" <c:if test="${basicInfoVo.milLevel eq '일병'}">selected="selected"</c:if>>일병</option>
	                    <option value="상병" <c:if test="${basicInfoVo.milLevel eq '상병'}">selected="selected"</c:if>>상병</option>
	                    <option value="병장" <c:if test="${basicInfoVo.milLevel eq '병장'}">selected="selected"</c:if>>병장</option>
	                    <option value="하사" <c:if test="${basicInfoVo.milLevel eq '하사'}">selected="selected"</c:if>>하사</option>
	                    <option value="중사" <c:if test="${basicInfoVo.milLevel eq '중사'}">selected="selected"</c:if>>중사</option>
	                    <option value="상사" <c:if test="${basicInfoVo.milLevel eq '상사'}">selected="selected"</c:if>>상사</option>
	                    <option value="원사" <c:if test="${basicInfoVo.milLevel eq '원사'}">selected="selected"</c:if>>원사</option>
	                    <option value="준위" <c:if test="${basicInfoVo.milLevel eq '준위'}">selected="selected"</c:if>>준위</option>
	                    <option value="소위" <c:if test="${basicInfoVo.milLevel eq '소위'}">selected="selected"</c:if>>소위</option>
	                    <option value="중위" <c:if test="${basicInfoVo.milLevel eq '중위'}">selected="selected"</c:if>>중위</option>
	                    <option value="대위" <c:if test="${basicInfoVo.milLevel eq '대위'}">selected="selected"</c:if>>대위</option>
	                    <option value="소령" <c:if test="${basicInfoVo.milLevel eq '소령'}">selected="selected"</c:if>>소령</option>
	                    <option value="중령" <c:if test="${basicInfoVo.milLevel eq '중령'}">selected="selected"</c:if>>중령</option>
	                    <option value="대령" <c:if test="${basicInfoVo.milLevel eq '대령'}">selected="selected"</c:if>>대령</option>
	                    <option value="준장" <c:if test="${basicInfoVo.milLevel eq '준장'}">selected="selected"</c:if>>준장</option>
	                    <option value="소장" <c:if test="${basicInfoVo.milLevel eq '소장'}">selected="selected"</c:if>>소장</option>
	                    <option value="중장" <c:if test="${basicInfoVo.milLevel eq '중장'}">selected="selected"</c:if>>중장</option>
	                    <option value="대장" <c:if test="${basicInfoVo.milLevel eq '대장'}">selected="selected"</c:if>>대장</option>
					</select>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>제대구분</h4> 
					<input type="text" id="milDischangeDiv" name="milDischangeDiv" class="form-control" placeholder="제대 구분을 입력하세요." value="${basicInfoVo.milDischangeDiv}" />
					<form:errors id="errorsMilDischangeDiv" cssStyle="color: red;" path="milDischangeDiv" />
				</div>
				<div class="col-sm-3">
					<h4>입대일</h4> 
					<input type="date" id="milStartDt" name="milStartDt" class="form-control" value="${basicInfoVo.milStartDt}" />
					<form:errors id="errorsMilStartDt" cssStyle="color: red;" path="milStartDt" />
				</div>
				<div class="col-sm-3">
					<h4>제대일</h4> 
					<input type="date" id="milEndDt" name="milEndDt" class="form-control" value="${basicInfoVo.milEndDt}" />
					<form:errors id="errorsMilEndDt" cssStyle="color: red;" path="milEndDt" />
				</div>
			</div>
		
			<br />
			<br />
			<div class="row" id="btnRow">
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