/**
 * 
 */
var controller = $.extend(new $.CommonObj(), {
	
	eventInit:function() {
		
	},
	onCreate:function() {
		
		$("#tempSaveBtn").click(function() {
			if ( controller.educationValidationCheckFunc() || controller.activityValidationCheckFunc() 
					|| controller.officialExamValidationCheckFunc() || controller.awardValidationCheckFunc() ) {
				return;
			}
			else {
				$.post("/resume/qualificationExperienceTempSave.do"
						,$("#qualificationExperienceForm").serialize()
						, function(response) {
					
					 if ( response == "fail" ) {
						$("#errorAlertMessage").html("자격 및 경험 정보 수정처리가 실패되었습니다.");
						$("#errorMessageModal").modal("show");
					}
					else {
						$("#successAlertMessage").html("자격 및 경험 수정이 완료되었습니다.");
						$("#successMessageModal").modal("show");
					} 

				});
			}
		});
		
		$("#nextStepBtn").click(function() {
			if ( controller.educationValidationCheckFunc() || controller.activityValidationCheckFunc() 
					|| controller.officialExamValidationCheckFunc() || controller.awardValidationCheckFunc() ) {
				return;
			}
			else {
				
				var resumeId = $("#resumeId").val();
				
				controller.autoClosingAlert("#successMessage", 2000);
				$("#qualificationExperienceForm").attr({
					method:"post",
					action: "/resume/qualificationExperienceNextStep.do/" + resumeId						
				}).submit();
			}				
		});
		
	}, educationValidationCheckFunc : function() {
		controller.educationEmptyCheckFunc();
		
		if ( eduNameEmpty == false || eduInstEmpty == false || eduTimeEmpty == false 
				|| eduStartDtEmpty == false || eduEndDtEmpty == false || eduContentEmpty == false ) {
			
			if ( eduNameEmpty ) {
				$("#errorAlertMessage").html("교육이수 - 교육과정을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#eduName").focus();
				return true;
			}
			if ( eduInstEmpty ) {
				$("#errorAlertMessage").html("교육이수 - 교육기관을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#eduInst").focus();
				return true;
			}
			if ( eduTimeEmpty ) {
				$("#errorAlertMessage").html("교육이수 - 교육시간을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#eduTime").focus();
				return true;
			}
			if ( eduStartDtEmpty ) {
				$("#errorAlertMessage").html("교육이수 - 교육시작일을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#eduStartDt").focus();
				return true;
			}
			if ( eduEndDtEmpty ) {
				$("#errorAlertMessage").html("교육이수 - 교육종료일을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#eduEndDt").focus();
				return true;
			}
			if ( eduContentEmpty ) {
				$("#errorAlertMessage").html("교육이수 - 교육내용을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#eduContent").focus();
				return true;
			}
			
		} else {
			return false;
		}
		
	}, educationEmptyCheckFunc : function() {
		
		eduNameEmpty = false;
		eduInstEmpty = false;
		eduTimeEmpty = false;
		eduStartDtEmpty = false;
		eduEndDtEmpty = false;
		eduContentEmpty = false;
			
		if ( $("#eduName").val() == "") {
			eduNameEmpty = true;
		}
		
		if ( $("#eduInst").val() == "") {
			eduInstEmpty = true;
		}
		
		if ( $("#eduTime").val() == "") {
			eduTimeEmpty = true;
		}
		
		if ( $("#eduStartDt").val() == "") {
			eduStartDtEmpty = true;
		}
		
		if ( $("#eduEndDt").val() == "") {
			eduEndDtEmpty = true;
		}
		
		if ( $("#eduContent").val() == "") {
			eduContentEmpty = true;
		}
		
	}, activityValidationCheckFunc : function() {
		
		controller.activityEmptyCheckFunc();
		
		if ( actDivEmpty == false || actInstEmpty == false || actRoleEmpty == false 
				|| actStartDtDtEmpty == false || actEndDtEmpty == false || actContentEmpty == false ) {
			
			if ( actDivEmpty ) {
				$("#errorAlertMessage").html("학내외 활동 - 행동구분을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#actDiv").focus();
				return true;
			}
			if ( actInstEmpty ) {
				$("#errorAlertMessage").html("학내외 활동 - 기관 및 조직명을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#actInst").focus();
				return true;
			}
			if ( actRoleEmpty ) {
				$("#errorAlertMessage").html("학내외 활동 - 역할을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#actRole").focus();
				return true;
			}
			if ( actStartDtDtEmpty ) {
				$("#errorAlertMessage").html("학내외 활동 - 활동시작일을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#actStartDt").focus();
				return true;
			}
			if ( actEndDtEmpty ) {
				$("#errorAlertMessage").html("학내외 활동 - 활동종료일을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#actEndDt").focus();
				return true;
			}
			if ( actContentEmpty ) {
				$("#errorAlertMessage").html("학내외 활동 - 활동내용을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#actContent").focus();
				return true;
			}
			
		} else {
			return false;
		}
		
	}, activityEmptyCheckFunc : function() {
		
		actDivEmpty = false;
		actInstEmpty = false;
		actRoleEmpty = false;
		actStartDtDtEmpty = false;
		actEndDtEmpty = false;
		actContentEmpty = false;
		
		if ( $("#actDiv").val() == "") {
			actDivEmpty = true;
		}
		if ( $("#actInst").val() == "") {
			actInstEmpty = true;
		}
		if ( $("#actRole").val() == "") {
			actRoleEmpty = true;
		}
		if ( $("#actStartDt").val() == "") {
			actStartDtDtEmpty = true;
		}
		if ( $("#actEndDt").val() == "") {
			actEndDtEmpty = true;
		}
		if ( $("#actContent").val() == "") {
			actContentEmpty = true;
		}		
		
	}, officialExamValidationCheckFunc : function() {
		
		controller.officialExamEmptyCheckFunc();
		
		if ( ofclEmTypeEmpty == false || ofclEmRegistNumEmpty == false  
				|| ofclEmDtEmpty == false || ofclEmScoreDtEmpty == false ) {
			
			if ( ofclEmTypeEmpty ) {
				$("#errorAlertMessage").html("공인시험 - 시험종류을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#ofclEmType").focus();
				return true;
			}
			if ( ofclEmRegistNumEmpty ) {
				$("#errorAlertMessage").html("공인시험 - 등록번호를 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#ofclEmRegistNum").focus();
				return true;
			}
			if ( ofclEmDtEmpty ) {
				$("#errorAlertMessage").html("공인시험 - 응시일을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#ofclEmDt").focus();
				return true;
			}
			if ( ofclEmScoreDtEmpty ) {
				$("#errorAlertMessage").html("공인시험 - 취득점수을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#ofclEmScore").focus();
				return true;
			}
			
		} else {
			return false;
		}
		
	}, officialExamEmptyCheckFunc : function() {
		
		ofclEmTypeEmpty = false;
		ofclEmRegistNumEmpty = false;
		ofclEmDtEmpty = false;
		ofclEmScoreDtEmpty = false;
		
		
		if ( $("#ofclEmType").val() == "") {
			ofclEmTypeEmpty = true;
		}
		
		if ( $("#ofclEmRegistNum").val() == "") {
			ofclEmRegistNumEmpty = true;
		}
		
		if ( $("#ofclEmDt").val() == "") {
			ofclEmDtEmpty = true;
		}
		
		if ( $("#ofclEmScore").val() == "") {
			ofclEmScoreDtEmpty = true;
		}		
		
	}, awardValidationCheckFunc : function() {
		
		controller.awardEmptyCheckFunc();
		
		if ( awardNameEmpty == false || awardInstEmpty == false  
				|| awardDtEmpty == false || awardContentEmpty == false ) {
			
			if ( awardNameEmpty ) {
				$("#errorAlertMessage").html("수상경력 - 상훈명을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#awardName").focus();
				return true;
			}
			if ( awardInstEmpty ) {
				$("#errorAlertMessage").html("수상경력 - 수여기관를 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#awardInst").focus();
				return true;
			}
			if ( awardDtEmpty ) {
				$("#errorAlertMessage").html("수상경력 - 수상일자을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#awardDt").focus();
				return true;
			}
			if ( awardContentEmpty ) {
				$("#errorAlertMessage").html("수상경력 - 수상내역을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#awardContent").focus();
				return true;
			}
		}
		else {
			return false;
		}		
		
	}, awardEmptyCheckFunc : function() {
		
		awardNameEmpty = false;
		awardInstEmpty = false;
		awardDtEmpty = false;
		awardContentEmpty = false;
		
		
		if ( $("#awardName").val() == "") {
			awardNameEmpty = true;
		}
		
		if ( $("#awardInst").val() == "") {
			awardInstEmpty = true;
		}
		
		if ( $("#awardDt").val() == "") {
			awardDtEmpty = true;
		}
		
		if ( $("#awardContent").val() == "") {
			awardContentEmpty = true;
		}		
		
	}, autoClosingAlert : function(selector, delay) {
		
		var alert = $(selector).alert();
		alert.show();
		window.setTimeout(function() { alert.hide() }, delay);			
		
	}
	
});

	


$(document).ready(function() {
	controller.init();			
});