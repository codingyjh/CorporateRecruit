<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     

<link rel="stylesheet" href="<c:url value='/css/recruitInfo/jobIntroduce.css' />">	

<title>직무 소개</title>

<div class="container">
	<div class="jumbotron">
		<h1 class="text-center">직무소개</h1>
		<p class="text-center">다양한 직무와 함께 성장하는 OO 기업인 입니다.</p>
	</div>
	<h1 class="page-header">직무 소개</h1>
	<div class="row">
		<div class="col-sm-2">
			<h3>개발/운영</h3>
		</div>
		<div class="col-sm-7" style="margin-top: 15px;">
			<a class="btn btn-default" data-target="#bizModal" data-toggle="modal">비즈니스분석</a>
			<a class="btn btn-default" data-target="#designModal" data-toggle="modal">설계</a>
			<a class="btn btn-default" data-target="#developModel" data-toggle="modal">개발</a>
			<a class="btn btn-default" data-target="#testModel" data-toggle="modal">테스트</a>
			<a class="btn btn-default" data-target="#appModal" data-toggle="modal">어플리케이션운영</a>
			<a class="btn btn-default" data-target="#uiUxModal" data-toggle="modal">UI/UX</a>
			<a class="btn btn-default" data-target="#dataAnalysisModal" data-toggle="modal">데이터분석</a>
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-sm-2">
			<h3>인프라</h3>
		</div>
		<div class="col-sm-6" style="margin-top: 15px;">
			<a class="btn btn-default" data-target="#serverModal" data-toggle="modal">서버관리</a>
			<a class="btn btn-default" data-target="#infraModal" data-toggle="modal">인프라지원</a>
			<a class="btn btn-default" data-target="#middlewareModal" data-toggle="modal">미들웨어관리</a>
			<a class="btn btn-default" data-target="#networkModal" data-toggle="modal">네트워크관리</a>
			<a class="btn btn-default" data-target="#sercurityModal" data-toggle="modal">보안관리</a>
			<a class="btn btn-default" data-target="#dbaModal" data-toggle="modal">DBA</a>
		</div>		
	</div>	
	<hr />
	<div class="row">
		<div class="col-sm-2">
			<h3>IT관리</h3>
		</div>
		<div class="col-sm-4" style="margin-top: 15px;">
			<a class="btn btn-default" data-target="#itServiceModal" data-toggle="modal">IT서비스관리</a>
			<a class="btn btn-default" data-target="#qualityModal" data-toggle="modal">품질관리</a>
			<a class="btn btn-default" data-target="#informationProtectModal" data-toggle="modal">정보보호</a>
			<a class="btn btn-default" data-target="#pmModal" data-toggle="modal">PM</a>
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-sm-2">
			<h3>아키텍처</h3>
		</div>
		<div class="col-sm-7" style="margin-top: 15px;">
			<a class="btn btn-default" data-target="#aaModal" data-toggle="modal">AA(Application Architecture)</a>
			<a class="btn btn-default" data-target="#daModal" data-toggle="modal">DA(Data Architecture)</a>
			<a class="btn btn-default" data-target="#taModal" data-toggle="modal">TA(Technical Architecture)</a>
		</div>	
	</div>
</div>

<div class="row">
	<div class="modal fade" id="bizModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>비즈니스 분석 | 개발/운영</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;고객의 비즈니스 요구를 정확히 이해하고, 이를 기반으로 고객 비즈니스 니즈와 시스템의 목표에 맞는 합리적인 기능 요구사항을 분석하고 명세화하며, 요구명세의 완전성, 정확성, 일관성 등을 유지하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>요구사항 도출-요구개발 프로세스 정의, 요구사항 도출 범위 정의, 고객 및 이해관계자 분석 업무를 수행합니다.</p> 
							<p>요구사항 분석-실현 가능성 분석, 요구사항 우선순위 부여 업무를 수행합니다.</p> 
							<p>요구사항 명세 작성-요구사항 명세서 템플릿 정의, 요구사항 식별번호 부여 업무를 수행합니다.</p> 
							<p>타당성 확인- 요구사항 명세서 인스펙션, 요구사항 테스트 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-고객사 니즈 분석 및 대안제시 능력이 필요합니다.</p>
							<p>-고객요구사항 분석능력</p>
							<p>-기술 요구사항/제약사항 검토 능력</p>
							<p>-요구사항 정의 및 변경관리 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="designModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>설계 | 개발/운영</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;비즈니스 요구사항에 부합하도록 최적의 프로세스를 정의하고, 요구되는 성능을 구현하기 위해 관련된 DB, 인터페이스, UI 등을 설계하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>-요구사항 관리 -비즈니스 요구사항을 기능 요구사항으로 변환, 기능 요구사항 상세 분석 및 최종 구현기능 확정 업무를 수행합니다.</p> 
							<p>논리/물리 DB설계-기존 형상 및 구조를 고려하여 비즈니스 요구사항 구현을 위한 논리 / 물리 ERD설계 업무를 수행합니다.</p> 
							<p>시스템 분석/설계-시스템 구조 분석 업무를 수행합니다. 프로세스 설계-기존 시스템 내 영향도 분석, 프로세스 정의 및 설계 업무를 수행합니다.</p> 
							<p>인터페이스 설계-연관 시스템 영향도 분석, 인터페이스 대상 정의 및 연동방식 정의 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-논리/물리 모델링 능력</p>
							<p>-기술 요구사항/제약사항 검토 능력</p>
							<p>-요구사항 변경관리 능력</p>
							<p>-기술표준사양 설계능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="developModel" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>개발 | 개발/운영</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;프로그램 요구사항정의서 및 화면설계서에 정의된 Spec에 따라, 코딩 / 단위테스트/소스리뷰 / 동료검토를 진행하고 소스코드의 형상관리 수행하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>테스트 시나리오 작성-테스트 케이스 라이브러리 활용, 추가 기능에 대한 테스트 케이스 작성 업무를 수행합니다.</p> 
							<p>코딩(구현)-소스코드 작성, 회사 코딩 표준 준수, 공통 사용 모듈에 대한 라이브러리화 업무를 수행합니다.</p> 
							<p>단위 테스트-소스 코드 빌드. 테스트 시나리오에 의한 요구사항 검증 업무를 수행합니다.</p> 
							<p>코드리뷰-소스코드 체크리스트에 의한 코드 리뷰, 발견된 결함의 수정 이력 관리 업무를 수행합니다.</p> 
							<p>형상관리-요구사항 별 검증된 소스코드와 산출물에 대한 baseline 설정, 리스크에 대한 backup 계획 수립 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-시스템 개발/Delivery 능력</p>
							<p>-DB 최적화 및 액세스 개발 능력</p>
							<p>-개발환경에 대한 이해 및 활용 능력</p>
							<p>-Software Verification/Validation 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="testModel" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>테스트 | 개발/운영</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;테스트와 관련한 실행 전략 및 상세 수행 계획을 수립하고, 가이드라인을 제시하며, 테스트 요구사항 분석 및 테스트 케이스를 설계하여, 이를 바탕으로 테스트를 수행하고 결과 확인 및 분석/보고하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>Master 테스트 Plan 수립-테스트 관리 프로세스 설계 및 지원 도구 선정, 각종 템플릿 및 테스트 케이스 설계 가이드라인 정의 업무를 수행합니다.</p> 
							<p>테스트 요구사항 분석 및 테스트 설계-개발 분서/설계 산출물 Review, 테스트 요구사항 도출 및 누락 요구사항 도출 업무를 수행합니다.</p> 
							<p>테스트 수행 및 측정 지표 관리-테스트 케이스 선후관계를 고려한 테스트 수행 업무를 수행합니다.</p> 
							<p>테스트 결과 분석 및 보고-테스트 수행율, Pass율 등 측정 지표 분석, 결함 발생 현황 및 유형 상세 분석 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-테스트 항목 설계 능력</p>
							<p>-테스트 Tool 사용 능력</p>
							<p>-Software Verification/Validation 능력</p>
							<p>-품질표준절차 이해 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="appModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>어플리케이션운영 | 개발/운영</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;고객의 비즈니스 요구사항을 정확히 파악하고 비즈니스 수행을 위한 안정적인 시스템 운영을 관리하며, 고객의 요구사항에 대한 신속한 대응을 책임지는 역할(서비스 운영, 모니터링, VOC, SR 응대 등)을 수행하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>AP운영-시스템별 특화된 고유 업무 수행, VOC 대응/ 문제점 및 개선안 도출 업무를 수행합니다.</p>
							<p>운영형상관리-인수테스트 계획 수립 및 인수시험, 인수테스트 결과 분석, AP 배포 계획 수립 및 배포 업무를 수행합니다.</p> 
							<p>장애 관리-정보보호 및 내부 통제 관련 업무, SLA 관리, 장애 예방 / 복구 활동 업무를 수행합니다.</p> 
							<p>데이터 관리-데이터 정합성 관리, DB 및 DISK 용량 관리 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-Database 이해 능력</p> 
							<p>-ITSM프로세스 이해 능력</p> 
							<p>-Package 개발 및 활용 능력</p> 
							<p>-Trouble Shooting 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="uiUxModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>UI/UX | 개발/운영</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;시스템의 사용자 인터페이스와 관련하여 사용자 경험을 바탕으로 화면 UI에 대한 분석, 기획, 설계 등의 시각적 디자인 결과물 및 가이드를 제공하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>사용자 분석-기 시스템의 산업 특성과 프로세스, 사용자들의 업무 환경등의 이해 및 분석 업무를 수행합니다.</p> 
							<p>UI/UX 기획/설계-도출 된 UX Concept 기반의 정보 설계(Information Architecture) 구체적 작성 업무를 수행합니다.</p> 
							<p>UI/UX Design-브랜드 아이덴티티 이해를 통한 유지관리 및 개선, 도출 된 UX Concept 기반의 Web Design Style Guide 도출 업무를 수행합니다.</p> 
							<p>웹표준 및 웹접근성-UI/UX Design을 바탕으로 다양한 사용자 환경(웹브라우저, OS등)을 고려한 UI개발 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-요구사항 변경관리 능력</p> 
							<p>-UX전략 수립 능력</p>
							<p>-웹/모바일 UI기획 능력</p> 
							<p>-브랜드 디자인 진단 및개선 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="dataAnalysisModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>데이터분석 | 개발/운영</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;전사 데이터를 수집/통합/가공 작업을 적기에 수행하여 관련 부서에 제공 및 안정적으로 데이터를 관리 고객의 니즈를 이해하고 정형/비정형 형태의 정보 제공하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>데이터 수집-데이터 I/F 관리, 데이터 수집 및 JOB 관리 업무를 수행합니다.</p> 
							<p>데이터 통합-통합 DW 모델링 및 설계. 통합 DW 개발 및 구축 업무를 수행합니다.</p> 
							<p>데이터 분석-정형/비정형 데이터 셋 모델링 및 설계, 유관 시스템 정보 제공 업무를 수행합니다.</p> 
							<p>데이터 관리-DB 용량/성능 관리. 데이터 품질 측정 기준 정의 업무를 수행합니다.</p> 
							<p>Big Data 처리-Big Data 분석 환경 구축, Big Data 처리 프로세스 (정보검색,추출,요약) 개발 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-Big Data 처리/운영 능력</p> 
							<p>-통합/다차원 모델링 능력</p> 
							<p>-데이터 전환/처리 능력</p> 
							<p>-데이터 분석기법 활용능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="serverModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>서버관리 | 인프라</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;서비스의 안정성 및 효율성 향상을 위해 Legacy 및 Cloud 시스템의 설비에 대한 구성 설계, 도입, 구축, 운영 , 폐기 활동을 수행함에 있어 ITIL기반의 관리프로세스 (이벤트관리, 인시던트관리, 변경관리, 문제관리, 구성관리, 용량관리)를 준수하고 시스템의 성능튜닝과 더불어 구성취약점, 보안취약점 등을 해소하여 안정 운영 토록 관리하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>시스템 운용정책 수립/추진-시스템에 대한 기본적인 이해 , 운영환경 전반의 운용정책 수립 업무를 수행합니다.</p>
							<p> 시스템도입 및 검수-시스템 구성 지원 및 검사계획서 작성 및 수행, 시스템운영업무 인수인계 시 시스템 인수인계 항목 점검 업무를 수행합니다.</p>
							<p>시스템 자산 및 가용량 관리-시스템 가용량 관리기준 수립 및 수행, 시스템에 대한 자산 및 현행화 관리 수행합니다.</p> 
							<p>변경관리 및 성능개선-시스템 정기 점검 및 성능모니터링,재구성 및 HA 테스트 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-시스템 백업/복구 능력</p> 
							<p>-성능분석 및 모니터링 능력</p> 
							<p>-시스템 구축계획 수립 능력</p>
							<p>-시스템 장애예방 및 조치능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="infraModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>인프라지원 | 인프라</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;인프라(일반/Cloud) 도입 및 구축을 통해서 서비스 제공을 위한 인프라(WEB, AP, DB)의 도입/구축, 유지보수 관련 계약, 위탁 IT자산의 관리를 수행하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>시스템 도입/구축-시스템 규모 적정성 검토 및 구매요구서 작성, 시스템 검사 및 준공처리 업무를 수행합니다.</p> 
							<p>행정처리- ds1 프로젝트 관리, 기업 ERP 처리,바코드 등 자산등록 업무를 수행합니다.</p> 
							<p>시스템평가-평가계획서,BMT 세부 시나리오 작성,평가결과서 업무를 수행합니다.</p> 
							<p>년간 도입계획 수립- Capacity Plan 에 의한 년간 사업 계획 수립,시스템 구축 용량 산정 근거 작성,문제점 및 개선방안 수립 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-시스템구성 설계 능력</p>
							<p>-인프라 아키텍처 설계 능력</p> 
							<p>-기술적 이슈도출 및 해결방안 제시능력</p> 
							<p>-선진기술 분석능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="middlewareModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>미들웨어관리 | 인프라</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;미들웨어의 안정성 및 효율성 향상을 위해 서비스 제공을 위한 시스템(Web, WAS, EAI) 구성 설계, 도입, 구축, 운영 및 개선을 위한 전략과 계획 수립 및 시행 (원활한 서비스 제공을 위한 인프라 미들웨어의 구성 설계, 설치, 운영 최적화, 모니터링, 성능 튜닝, 아키텍처 설계 등)하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>MW 운용정책 수립/추진-고객사 시스템의 서비스에 대한 기본적인 이해, 신규 시스템에 대한 운용 및 개선방안 도출 업무를 수행합니다.</p> 
							<p>운용계획 및 용량산정-비즈니스 요구사항에 대한 가용성 관리기준 수립 및 수행. 용량관리 실사 계획 수립 및 실사, 결과 분석 업무를 수행합니다.</p> 
							<p>형상 관리-형상 관리의 목적,범위,목표설정,적용대상의 우선 순위 결정, 형상 관리 개선 대책 및 계획 수립 업무를 수행합니다.</p>
							<p>시스템 장애/ 변경관리 및 성능개선-잠재위험에 대한 재해복구계획 수행, 인시던트에 해결방안 적용 및 기술적 문제 해결 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-서비스플랫폼 활용능력</p> 
							<p>-기술요소 구현 검토 및 Tuning 능력</p> 
							<p>-통합 웹 서비스 아키텍처 설계 능력</p> 
							<p>-Java/C 기반 웹 서비스 개발/활용 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="networkModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>네트워크관리 | 인프라</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;NW관리에 필요한 실무기술, NW 보안기술, Design, Traffic 분산기술 등 네트워크 전문지식을 토대로 사용자 요구에 따라 Network을 설계/구축하며, NW 부문별 기술에 대한 자문/감리를 지원하고 Network 운영 및 유지보수 전략 수립/적용 (대내, 대외 네트워크 설계, 운영, 장애 조치, 성능 개선)하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>NW 프로젝트 참여 및 구축 설계-고객사 시스템 요구사항에 따른 NW 설계 및 검토 업무를 수행합니다.</p>
							<p>NW 시스템 성능 분석 및 개선 능력-트래픽 분석을 통한 네트워크 및 시스템 문제진단 및 해결방안 도출 업무를 수행합니다.</p> 
							<p>NW 설비 장애 / 형상관리-잠재위험에 대한 재해복구계획 수행, 인시던트에 대한 해결방안 적용 및 기술적 문제 해결 업무를 수행합니다.</p> 
							<p>운용계획 및 용량산정-신규 시스템에 대한 가용성 관리기준 수립 및 수행, NW 시스템에 대한 전체 NW 용량 요건 확정 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-NW 시스템 설계/구축 계획 수립 능력</p> 
							<p>-NW 시스템 분석 및 개선 능력</p> 
							<p>-NW 시스템 장애관리 능력</p> 
							<p>-NW 시스템 형상(구성)관리 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="sercurityModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>보안관리 | 인프라</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;정보시스템의 안정운영과 연속성 확보를 위해 보안시스템을 구성 설계, 도입, 구축, 운영하며, 시스템개선을 위한 전략과 계획을 수립하여 시스템의 안정성과 효율성을 향상시키는 역할을 수행하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>보안설비 운영기획-보안설비의 안정적 운영을 위한 운영계획 수립, 보안설비의 표준운영절차수립 및 현행화 업무를 수행합니다.</p> 
							<p>보안설비 아키텍처 설계/구축-최신보안기술동향 파악 및 신기술 적용, 비즈니스 요구사항에 따른 보안 아키텍처 설계 및 검토 업무를 수행합니다.</p> 
							<p>장애/형상관리-보안설비의 사전 장애예방 활동 및 문제개선활동, 보안설비의 인시던트/문제/장애관리 업무를 수행합니다.</p> 
							<p>변경/성능관리-신규 시스템의 성능시험 및 개선사항 도출, 기본 시스템의 변경이력관리 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-Client/Server 보안기술 활용 능력</p> 
							<p>-NW 보안기술 이해/활용 능력</p> 
							<p>-어플리케이션 보안기술 활용능력</p> 
							<p>-데이터보안기술 활용능력<p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="dbaModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>DBA | 인프라</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;DBMS의 운용 안정성 확보 및 효율성 향상을 위해 서비스별 시스템의 구조 설계 및 구축, 운영, 백업/복구, 마이그레이션, 장애 분석, 해결방안 제시, 성능 개선활동 등을 통한 장애 예방활동과 지속적 점검/분석 활동을 기반으로 안정적 운용 활동을 수행하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>프로젝트 데이터 아키텍처 설계-비즈니스 요구 사항에 대한 아키텍처 설계 및 검토, 시스템에 대한 테스트 및 성능개선 업무를 수행합니다.</p> 
							<p>시스템 장애관리-잠재위험에 대한 재해복구 계획 수행, 시스템 성능/장애/백업/보안 시스템 구축 및 운영 업무를 수행합니다.</p> 
							<p>형상관리-형상 관리의 목적, 범위, 목표설정, 적용대상의 우선순위 결정, 형상 관리 개선 대책 및 계획 수립 업무를 수행합니다.</p> 
							<p>기술지원/유지보수-AP팀 프로젝트 진행 및 개발관련 DBMS 기술지원 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-Trouble Shooting 능력</p> 
							<p>-DBMS관리 능력</p> 
							<p>-성능분석/ Tuning 능력</p> 
							<p>-백업 및 복구 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="itServiceModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>IT서비스관리 | IT관리</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;경영방침, 기술전략과 IT Trend를 기반으로 중장기 기술확보 전략을 수립하고, ITO 부문의 계약구조 설계, 계약 근거가 되는 각종 Data 정의, 축적, 대가체계 구성, 관련된 서비스 수준 정의, 측정 모니터링, 서비스 운영 성과평가 및 전사 장애 현황을 관리/개선하는 역할을 수행하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>본부 경영방침 및 목표 수립-경영방향에 정렬한 경영방침 수립, 전략방향에 따른 목표 설정 업무를 수행합니다.</p> 
							<p>ITO 대가산정 및 계약관리-위탁 서비스 라인별 견적 및 대가 결정 업무를 수행합니다.</p> 
							<p>서비스 수준 관리 (SLM) 체계 정립 및 개선-SLA 지표 및 목표수준 설정, SLA 성과에 따른 보상체계 규정 업무를 수행합니다.</p> 
							<p>서비스 수준 분석 및 보고-취약 영역별 원인분석 및 개선방향 도출업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-경영전략 수립능력</p> 
							<p>-프로젝트 손익/원가관리 능력</p> 
							<p>-SLA성과 관리능력</p> 
							<p>-Price Planning 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="qualityModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>품질관리 | IT관리</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;고품질의 IT 서비스 제공을 위한 관리 체계(조직 표준프로세스, 개발 방법론, BP, 템플릿) , 수행조직, 프로세스 등의 관리 모델 및 기준을 제시하고 관리 하는 역할로서 국제 품질 인증의 신규/유지/갱신 심사를 위한 내부 심사 및 조직 내재화를 리딩할 수 있으며, 아울러 제품의 품질 보증을 위한 테스트 및 Code Inspection 등을 지원하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>프로세스 체계 기획/구축/시행-신규 서비스의 수행조직, 프로세스, 관리체계에 대한 현황 분석 업무를 수행합니다.</p> 
							<p>품질보증 활동계획 수립-고객의 품질 요구사항 수집, 품질 목표 달성을 위한 프로젝트 품질 활동 계획 수립/협의/확정 업무를 수행합니다.</p> 
							<p>Product 품질보증활동 수행/보고-품질보증활동 계획에 의거한 단계별 산출물 검토 업무를 수행합니다.</p> 
							<p>품질 인증 사후 관리-인증 심사 후 부적합/개선 사항 식별, 개선 방안 이행 관리 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-표준 개발프로세스 이해 능력</p> 
							<p>-조직 표준 프로세스 개발/적용 능력</p> 
							<p>-글로벌 표준 프로세스 이해 능력</p>
							<p>-어플리케이션 품질검증 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="informationProtectModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>정보보호관리 | IT관리</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;회사의 보안정책/보안체계를 기획, 유지, 개선하고 보안수준진단, 법 Compliance 준수 및 침해 위험 모니터링, 침해대응, 사고분석업무를 수행하여 회사내 정보보호 Risk를 최소화하는 역할을 수행하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>보안기획/감사-전사 보안업무처리규정 제정 및 개정, 보안인프라환경 전반의 보안운용정책 수립 업무를 수행합니다.</p> 
							<p>보안진단-정보시스템 보안수준 진단활동, 정보시스템 취약점조치 권고 및 개선활동 업무를 수행합니다.</p> 
							<p>모의해킹-정보시스템 대상 모의해킹수행, 주요취약점 선정 및 조치가이드 배포 업무를 수행합니다.</p> 
							<p>침해대응-최신보안기술동향 파악 및 신기술 적용, 신속하고 정확한 침해사고분석 업무를 수행합니다.</p> 
							<p>보안성 검토-신규 시스템에 보안수준 적합성 평가, 신규 보안시스템에 대한 운용 및 개선방안 도출 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-보안 Master Plan 수립 능력</p> 
							<p>-보안정책/지침 구성 능력</p> 
							<p>-시스템 취약점 분석/모의해킹 능력</p> 
							<p>-침해 위협 사전 정보수집 및 대응능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="pmModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>정보보호관리 | IT관리</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;프로젝트와 관련된 이해관계자의 요구와 기대를 충족시키기 위하여 인력, 범위, 시간, 비용, 품질 등에 대한 수행계획을 수립하고, 이에 따라 적시,적임의 내/외부 자원을 조달하고 프로젝트 진행을 통제하여 목표한 제품/서비스를 제공하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>사전제안-고객사 신규 요구사항 분석 및 신기술 동향 분석, 고객사 내부 보고를 위한 프로젝트 계획서 작성 및 지원 업무를 수행합니다.</p> 
							<p>사업 심의-사업에 대한 수행 예산 작성, 예산 계획 수립, 단계별 VRB작성 및 심의 업무를 수행합니다.</p> 
							<p>프로젝트 추진계획 작성-개발방법론 선정/조정/확정 및 고객 협의, 업무전환 일정/방법 선정 및 고객 협의 업무를 수행합니다.</p> 
							<p>하도급 관리-하도급 처리를 위한 과업내역서 작성, 하도급 보안관리 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-프로젝트 일정관리 능력</p> 
							<p>-프로젝트 리스크/이슈 관리 능력</p> 
							<p>-프로젝트 손익/원가관리 능력</p> 
							<p>-프로젝트 통합/성과 관리 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="aaModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>AA(Applicaion Architecture) | 아키텍처</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;최적의 소프트웨어 개발 전략을 수립하고, 구축 대상 시스템의 주요한 소프트웨어 구성요소와 각 요소간의 관계를 설계하여 공통된 비전으로 어플리케이션을 구축할 수 있도록 시스템의 청사진을 제시하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>아키텍처 절차와 방법론 수립-방법론 이해를 바탕으로 아키텍처 절차와 방법정의, 테일러링 및 응용 업무를 수행합니다.</p>
							<p>아키텍처 기반 프로젝트 계획수립- WBS 상황 별 아키텍처 우선순위 결정 등 아키텍처 전략수립 업무를 수행합니다.</p> 
							<p>아키텍처 요구사항관리-요구공학 적용, 요구사항 도출/정제화, 문서화, 우선순위결정 업무를 수행합니다.</p> 
							<p>아키텍처 구현 및 가이드-아키텍처 대안설계, 대안 의견제시, 공통 기능 도출 및 개발방법 리딩 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-아키텍처 프로세스 정의 및 활용 능력</p> 
							<p>-아키텍처 핵심기술 활용 능력</p> 
							<p>-아키텍처 관련 View 정의 및 문서화 능력</p> 
							<p>-아키텍처 컨설팅 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="daModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>DA(Data Architecture) | 아키텍처</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;기업의 업무 수행에 필요한 데이터의 구조를 체계적으로 정의하여 데이터 기획, 구조, 표준, 구축, 관리 체계, 품질 보증을 포함하는 데이터 아키텍처 영역을 관리하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>데이터 표준화-데이터 표준화 원칙과 지침 수립, 표준화 구성요소 정의, 데이터 표준준수도 측정 및 관리 업무를 수행합니다.</p> 
							<p>데이터 요구사항 분석-정보 요구 사항 의 생명주기 및 업무 흐름 프로세스 도출 업무를 수행합니다.</p> 
							<p>데이터 모델링-개념 데이터모델링, 논리 데이터모델링, 물리 데이터모델링, 현행 데이터아키텍처 진단/개선 업무를 수행합니다.</p> 
							<p>데이터 품질관리-도메인/업무기반 데이터 품질 관리, Infra 관리 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-데이터 아키텍처 모델링 능력</p> 
							<p>-데이터 아키텍처 원칙수립 능력</p> 
							<p>-데이터베이스 디자인 능력</p> 
							<p>-데이터 표준화 능력 -데이터 품질관리 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="taModal" tabindex="-1">
		<div class="modal-dialog" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<h2>TA(Technical Architecture) | 아키텍처</h2>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="row">
						<p>&nbsp;시스템설계, 서버최적화, 데이터베이스 최적화, Network분석설계, Security 등 IT Infrastructure를 설계하고 시스템 안정화를 위한 기술을 지원하는 업무</p>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>task</h2></div>
						<div class="col-sm-8">
							<p>요구사항 이해 및 아키텍처 제시-As-Is 시스템 구성 및 실태 파악, To-Be 정의를 위한 분석, 비즈니스 요구사항 분석 업무를 수행합니다.</p> 
							<p>아키텍처 분석/설계-아키텍처 구현방안 수립, 아키텍처 설계 업무를 수행합니다.</p> 
							<p>Prototyping 수행-프로토타입 실행 및 검증 결과 작성 업무를 수행합니다.</p> 
							<p>기술 표준 정의 및 관리-표준 아키텍처 수립 및 관리, 기술 표준 수립 및 유지관리 / 현행화 업무를 수행합니다.</p>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-sm-4"><h2>Qualification</h2></div>
						<div class="col-sm-8">
							<p>-IT 인프라 분석/설계 능력</p> 
							<p>-표준 운영 지침 수립/개선 능력</p> 
							<p>-개발 S/W 활용 능력</p> 
							<p>-인프라 아키텍처 설계 능력</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br />