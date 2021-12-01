<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<link rel="stylesheet" href="<c:url value='/css/resume/academicBackground.css' />">
	
	<title>교육 및 경험</title>

	<script src="<c:url value='/js/resume/academicBackground.js' />"></script>

	<input type="hidden" name="resumeId" id="resumeId" value="${academicBackgroundVo.resumeId}"/>
	<div class="container" style="width: 70%;">
		<div class="tabDiv">
			<ul class="nav nav-pills nav-justified">
			  <li><a href="<c:url value='/resume/basicInfo.do/${academicBackgroundVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">1.기본정보</a></li>
			  <li class="active"><a href="<c:url value='/resume/qualificationExperience.do/${academicBackgroundVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">2.학력사항</a></li>
			  <li><a href="<c:url value='/resume/qualificationExperience.do/${academicBackgroundVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">3.자격 및 경험</a></li>
			  <li><a href="<c:url value='/resume/selfIntroduce.do/${academicBackgroundVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">4.자기소개서</a></li>
			  <li><a href="<c:url value='/resume/finalSubmissionAgreement.do/${academicBackgroundVo.resumeId}?token=${sessionScope._CSRF_TOKEN_}'/>">5.최종제출</a></li>
			</ul>
		</div>
		<br />
		<br />
		<form:form	id="academicBackgroundForm"
					modelAttribute="academicBackgroundVo"
					autocomplete="off">
			<h1>고등학교</h1>
			<hr>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>졸업구분</h4>
					<select name="highSDiv" id="highSDiv" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.highSDiv eq ''}">selected="selected"</c:if>>
					  	선택 
					  </option>
					  <option value="졸업" <c:if test="${academicBackgroundVo.highSDiv eq '졸업'}">selected="selected"</c:if>>
					  	졸업 
					  </option>
					  <option value="중퇴" <c:if test="${academicBackgroundVo.highSDiv eq '중퇴'}">selected="selected"</c:if>>
					  	중퇴 
					  </option>
					  <option value="검정고시" <c:if test="${academicBackgroundVo.highSDiv eq '검정고시'}">selected="selected"</c:if>>
					  	검정고시 
					  </option>
					</select>
				</div>
				<div class="col-sm-3">
					<h4>학교명</h4> 
					<input type="text" id="highSName" name="highSName" class="form-control" placeholder="학교명을 입력하세요." value="${academicBackgroundVo.highSName}"/>
				</div>
				<div class="col-sm-3">
					<h4>소재지</h4> 
					<select name="highSRegion" id="highSRegion" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.highSRegion eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="서울" <c:if test="${academicBackgroundVo.highSRegion eq '서울'}">selected="selected"</c:if>>서울</option>
					  <option value="부산" <c:if test="${academicBackgroundVo.highSRegion eq '부산'}">selected="selected"</c:if>>부산</option>
					  <option value="대구" <c:if test="${academicBackgroundVo.highSRegion eq '대구'}">selected="selected"</c:if>>대구</option>
					  <option value="인천" <c:if test="${academicBackgroundVo.highSRegion eq '인천'}">selected="selected"</c:if>>인천</option>
					  <option value="광주" <c:if test="${academicBackgroundVo.highSRegion eq '광주'}">selected="selected"</c:if>>광주</option>
					  <option value="대전" <c:if test="${academicBackgroundVo.highSRegion eq '대전'}">selected="selected"</c:if>>대전</option>
					  <option value="울산" <c:if test="${academicBackgroundVo.highSRegion eq '울산'}">selected="selected"</c:if>>울산</option>
					  <option value="세종" <c:if test="${academicBackgroundVo.highSRegion eq '세종'}">selected="selected"</c:if>>세종</option>
					  <option value="경기" <c:if test="${academicBackgroundVo.highSRegion eq '경기'}">selected="selected"</c:if>>경기</option>
					  <option value="강원" <c:if test="${academicBackgroundVo.highSRegion eq '강원'}">selected="selected"</c:if>>강원</option>
					  <option value="충북" <c:if test="${academicBackgroundVo.highSRegion eq '충북'}">selected="selected"</c:if>>충북</option>
					  <option value="충남" <c:if test="${academicBackgroundVo.highSRegion eq '충남'}">selected="selected"</c:if>>충남</option>
					  <option value="전북" <c:if test="${academicBackgroundVo.highSRegion eq '전북'}">selected="selected"</c:if>>전북</option>
					  <option value="전남" <c:if test="${academicBackgroundVo.highSRegion eq '전남'}">selected="selected"</c:if>>전남</option>
					  <option value="경북" <c:if test="${academicBackgroundVo.highSRegion eq '경북'}">selected="selected"</c:if>>경북</option>
					  <option value="경남" <c:if test="${academicBackgroundVo.highSRegion eq '경남'}">selected="selected"</c:if>>경남</option>
					  <option value="제주" <c:if test="${academicBackgroundVo.highSRegion eq '제주'}">selected="selected"</c:if>>제주</option>
					</select>
				</div>
			</div>		
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>주/야간</h4> 
					<select name="highSDayNight" id="highSDayNight" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.highSDayNight eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="주간" <c:if test="${academicBackgroundVo.highSDayNight eq '주간'}">selected="selected"</c:if>>주간</option>
					  <option value="야간" <c:if test="${academicBackgroundVo.highSDayNight eq '야간'}">selected="selected"</c:if>>야간</option>
					</select>
				</div>
				<div class="col-sm-3">
					<h4>졸업일</h4> 
					<input type="date" id="highSEndDt" name="highSEndDt" class="form-control" placeholder="졸업일을 입력하세요." value="${academicBackgroundVo.highSEndDt}"/>
				</div>
			</div>
			<h1>대학교</h1>
			<hr>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<h4>전문학사/학사</h4> 
					<select name="univDiv" id="univDiv" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.univDiv eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="전문학사" <c:if test="${academicBackgroundVo.univDiv eq '전문학사'}">selected="selected"</c:if>>전문학사</option>
					  <option value="학사" <c:if test="${academicBackgroundVo.univDiv eq '학사'}">selected="selected"</c:if>>학사</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>졸업구분</h4> 
					<select name="univGraDiv" id="univGraDiv" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.univGraDiv eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="졸업" <c:if test="${academicBackgroundVo.univGraDiv eq '졸업'}">selected="selected"</c:if>>졸업</option>
					  <option value="휴학" <c:if test="${academicBackgroundVo.univGraDiv eq '휴학'}">selected="selected"</c:if>>휴학</option>
					  <option value="중퇴" <c:if test="${academicBackgroundVo.univGraDiv eq '중퇴'}">selected="selected"</c:if>>중퇴</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>주/야간</h4> 
					<select name="univDayNight" id="univDayNight" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.univDayNight eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="주간" <c:if test="${academicBackgroundVo.univDayNight eq '주간'}">selected="selected"</c:if>>주간</option>
					  <option value="야간" <c:if test="${academicBackgroundVo.univDayNight eq '야간'}">selected="selected"</c:if>>야간</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>본교/분교</h4> 
					<select name="univMainBranch" id="univMainBranch" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.univMainBranch eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="본교" <c:if test="${academicBackgroundVo.univMainBranch eq '본교'}">selected="selected"</c:if>>본교</option>
					  <option value="분교" <c:if test="${academicBackgroundVo.univMainBranch eq '분교'}">selected="selected"</c:if>>분교</option>
					</select>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>학교명</h4> 
					<input type="text" id="univName" name="univName" class="form-control" placeholder="대학교명을 입력하세요." value="${academicBackgroundVo.univName}"/>
				</div>
				<div class="col-sm-3">
					<h4>학과명</h4> 
					<input type="text" id="univTypeName" name="univTypeName" class="form-control" placeholder="학과명을 입력하세요." value="${academicBackgroundVo.univTypeName} "/>
				</div>
				<div class="col-sm-3">
					<h4>전공</h4> 
					<input type="text" id="univMajor" name="univMajor" class="form-control" placeholder="전공을 입력하세요." value="${academicBackgroundVo.univMajor}"/>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>입학일</h4> 
					<input type="date" id="univStartDt" name="univStartDt" class="form-control" placeholder="입학일을 입력하세요." value="${academicBackgroundVo.univStartDt}"/>
				</div>
				<div class="col-sm-3">
					<h4>졸업일</h4> 
					<input type="date" id="univEndDt" name="univEndDt" class="form-control" placeholder="졸업일을 입력하세요." value="${academicBackgroundVo.univEndDt}" />
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>학점</h4> 
					<input type="text" id="univScore" name="univScore" style="width: 30%" value="${academicBackgroundVo.univScore}"/>
					<select name="univPScore" id="univPScore" style="width: 30%">
					  <option value="" <c:if test="${academicBackgroundVo.univPScore eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="4.5" <c:if test="${academicBackgroundVo.univPScore eq '4.5'}">selected="selected"</c:if>>4.5</option>
					  <option value="4.3" <c:if test="${academicBackgroundVo.univPScore eq '4.3'}">selected="selected"</c:if>>4.3</option>
					  <option value="4.0" <c:if test="${academicBackgroundVo.univPScore eq '4.0'}">selected="selected"</c:if>>4.0</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>소재지</h4> 
					<select name="univRegion" id="univRegion" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.univRegion eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="서울" <c:if test="${academicBackgroundVo.univRegion eq '서울'}">selected="selected"</c:if>>서울</option>
					  <option value="부산" <c:if test="${academicBackgroundVo.univRegion eq '부산'}">selected="selected"</c:if>>부산</option>
					  <option value="대구" <c:if test="${academicBackgroundVo.univRegion eq '대구'}">selected="selected"</c:if>>대구</option>
					  <option value="인천" <c:if test="${academicBackgroundVo.univRegion eq '인천'}">selected="selected"</c:if>>인천</option>
					  <option value="광주" <c:if test="${academicBackgroundVo.univRegion eq '광주'}">selected="selected"</c:if>>광주</option>
					  <option value="대전" <c:if test="${academicBackgroundVo.univRegion eq '대전'}">selected="selected"</c:if>>대전</option>
					  <option value="울산" <c:if test="${academicBackgroundVo.univRegion eq '울산'}">selected="selected"</c:if>>울산</option>
					  <option value="세종" <c:if test="${academicBackgroundVo.univRegion eq '세종'}">selected="selected"</c:if>>세종</option>
					  <option value="경기" <c:if test="${academicBackgroundVo.univRegion eq '경기'}">selected="selected"</c:if>>경기</option>
					  <option value="강원" <c:if test="${academicBackgroundVo.univRegion eq '강원'}">selected="selected"</c:if>>강원</option>
					  <option value="충북" <c:if test="${academicBackgroundVo.univRegion eq '충북'}">selected="selected"</c:if>>충북</option>
					  <option value="충남" <c:if test="${academicBackgroundVo.univRegion eq '충남'}">selected="selected"</c:if>>충남</option>
					  <option value="전북" <c:if test="${academicBackgroundVo.univRegion eq '전북'}">selected="selected"</c:if>>전북</option>
					  <option value="전남" <c:if test="${academicBackgroundVo.univRegion eq '전남'}">selected="selected"</c:if>>전남</option>
					  <option value="경북" <c:if test="${academicBackgroundVo.univRegion eq '경북'}">selected="selected"</c:if>>경북</option>
					  <option value="경남" <c:if test="${academicBackgroundVo.univRegion eq '경남'}">selected="selected"</c:if>>경남</option>
					  <option value="제주" <c:if test="${academicBackgroundVo.univRegion eq '제주'}">selected="selected"</c:if>>제주</option>
					</select>
				</div>
			</div>
			<h1>대학원</h1>
			<hr>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<h4>대학원 학위</h4> 
					<select name="graUnivDegree" id="graUnivDegree" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.graUnivDegree eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="석사" <c:if test="${academicBackgroundVo.graUnivDegree eq '석사'}">selected="selected"</c:if>>석사</option>
					  <option value="박사" <c:if test="${academicBackgroundVo.graUnivDegree eq '박사'}">selected="selected"</c:if>>박사</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>졸업구분</h4> 
					<select name="graUnivGraDiv" id="graUnivGraDiv" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.graUnivGraDiv eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="졸업" <c:if test="${academicBackgroundVo.graUnivGraDiv eq '졸업'}">selected="selected"</c:if>>졸업</option>
					  <option value="휴학" <c:if test="${academicBackgroundVo.graUnivGraDiv eq '휴학'}">selected="selected"</c:if>>휴학</option>
					  <option value="중퇴" <c:if test="${academicBackgroundVo.graUnivGraDiv eq '중퇴'}">selected="selected"</c:if>>중퇴</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>주/야간</h4> 
					<select name="graUnivDayNight" id="graUnivDayNight" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.graUnivDayNight eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="1" <c:if test="${academicBackgroundVo.graUnivDayNight eq '1'}">selected="selected"</c:if>>주간</option>
					  <option value="2" <c:if test="${academicBackgroundVo.graUnivDayNight eq '2'}">selected="selected"</c:if>>야간</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>본교/분교</h4> 
					<select name="graUnivMainBranch" id="graUnivMainBranch" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.graUnivMainBranch eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="본교" <c:if test="${academicBackgroundVo.graUnivMainBranch eq '본교'}">selected="selected"</c:if>>본교</option>
					  <option value="분교" <c:if test="${academicBackgroundVo.graUnivMainBranch eq '분교'}">selected="selected"</c:if>>분교</option>
					</select>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>학교명</h4> 
					<input type="text" id="graUnivName" name="graUnivName" class="form-control" placeholder="대학교명을 입력하세요." value="${academicBackgroundVo.graUnivName}"/>
				</div>
				<div class="col-sm-3">
					<h4>학과명</h4> 
					<input type="text" id="graUnivTypeName" name="graUnivTypeName" class="form-control" placeholder="학과명을 입력하세요." value="${academicBackgroundVo.graUnivTypeName}"/>
				</div>
				<div class="col-sm-3">
					<h4>전공</h4> 
					<input type="text" id="graUnivMajor" name="graUnivMajor" class="form-control" placeholder="전공을 입력하세요." value="${academicBackgroundVo.graUnivMajor}" />
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>입학일</h4> 
					<input type="date" id="graUnivStartDt" name="graUnivStartDt" class="form-control" placeholder="입학일을 입력하세요." value="${academicBackgroundVo.graUnivStartDt}"/>
				</div>
				<div class="col-sm-3">
					<h4>졸업일</h4> 
					<input type="date" id="graUnivEndDt" name="graUnivEndDt" class="form-control" placeholder="졸업일을 입력하세요." value="${academicBackgroundVo.graUnivEndDt}" />
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h4>학점</h4> 
					<input type="text" id="graUnivScore" name="graUnivScore" style="width: 30%" value="${academicBackgroundVo.graUnivScore}" />
					<select name="graUnivPScore" id="graUnivPScore" style="width: 30%">
					  <option value="" <c:if test="${academicBackgroundVo.graUnivPScore eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="4.5" <c:if test="${academicBackgroundVo.graUnivPScore eq '4.5'}">selected="selected"</c:if>>4.5</option>
					  <option value="4.3" <c:if test="${academicBackgroundVo.graUnivPScore eq '4.3'}">selected="selected"</c:if>>4.3</option>
					  <option value="4.0" <c:if test="${academicBackgroundVo.graUnivPScore eq '4.0'}">selected="selected"</c:if>>4.0</option>
					</select>
				</div>
				<div class="col-sm-2">
					<h4>소재지</h4> 
					<select name="graUnivRegion" id="graUnivRegion" class="form-control">
					  <option value="" <c:if test="${academicBackgroundVo.graUnivRegion eq ''}">selected="selected"</c:if>>선택</option>
					  <option value="서울" <c:if test="${academicBackgroundVo.graUnivRegion eq '서울'}">selected="selected"</c:if>>서울</option>
					  <option value="부산" <c:if test="${academicBackgroundVo.graUnivRegion eq '부산'}">selected="selected"</c:if>>부산</option>
					  <option value="대구" <c:if test="${academicBackgroundVo.graUnivRegion eq '대구'}">selected="selected"</c:if>>대구</option>
					  <option value="인천" <c:if test="${academicBackgroundVo.graUnivRegion eq '인천'}">selected="selected"</c:if>>인천</option>
					  <option value="광주" <c:if test="${academicBackgroundVo.graUnivRegion eq '광주'}">selected="selected"</c:if>>광주</option>
					  <option value="대전" <c:if test="${academicBackgroundVo.graUnivRegion eq '대전'}">selected="selected"</c:if>>대전</option>
					  <option value="울산" <c:if test="${academicBackgroundVo.graUnivRegion eq '울산'}">selected="selected"</c:if>>울산</option>
					  <option value="세종" <c:if test="${academicBackgroundVo.graUnivRegion eq '세종'}">selected="selected"</c:if>>세종</option>
					  <option value="경기" <c:if test="${academicBackgroundVo.graUnivRegion eq '경기'}">selected="selected"</c:if>>경기</option>
					  <option value="강원" <c:if test="${academicBackgroundVo.graUnivRegion eq '강원'}">selected="selected"</c:if>>강원</option>
					  <option value="충북" <c:if test="${academicBackgroundVo.graUnivRegion eq '충북'}">selected="selected"</c:if>>충북</option>
					  <option value="충남" <c:if test="${academicBackgroundVo.graUnivRegion eq '충남'}">selected="selected"</c:if>>충남</option>
					  <option value="전북" <c:if test="${academicBackgroundVo.graUnivRegion eq '전북'}">selected="selected"</c:if>>전북</option>
					  <option value="전남" <c:if test="${academicBackgroundVo.graUnivRegion eq '전남'}">selected="selected"</c:if>>전남</option>
					  <option value="경북" <c:if test="${academicBackgroundVo.graUnivRegion eq '경북'}">selected="selected"</c:if>>경북</option>
					  <option value="경남" <c:if test="${academicBackgroundVo.graUnivRegion eq '경남'}">selected="selected"</c:if>>경남</option>
					  <option value="제주" <c:if test="${academicBackgroundVo.graUnivRegion eq '제주'}">selected="selected"</c:if>>제주</option>
					</select>
				</div>
			</div>
			<br />
			<br />
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<input type="button" id="tempSaveBtn" class="btn btn-primary" value="임시저장" />
				<input type="button" id="nextStepBtn" class="btn btn-primary btn-warning" value="다음단계" />
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
		<strong>로그인이 정상적으로 처리되었습니다.</strong>
	</div>