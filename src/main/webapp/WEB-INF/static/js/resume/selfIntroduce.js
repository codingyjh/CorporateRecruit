/**
 * 
 */
var controller = $.extend(new $.CommonObj(), {
	
	eventInit:function() {
		
	},
	onCreate:function() {
		
		$("#selfItdtContent1").keyup(function (e) {
			var selfItdtContent1 = $(this).val();
			$("#counter1").html("(" + selfItdtContent1.length + "/700자)");
		});
		
		$("#selfItdtContent2").keyup(function (e) {
			var selfItdtContent2 = $(this).val();
			$("#counter2").html("(" + selfItdtContent2.length + "/700자)");
		});
		
		$("#selfItdtContent3").keyup(function (e) {
			var selfItdtContent3 = $(this).val();
			$("#counter3").html("(" + selfItdtContent3.length + "/700자)");
		});
		
		$("#tempSaveBtn").click(function() {
			
			if ( controller.selfIntroduceValidationCheckFunc() ) {
				
				return;
				
			} else {
				$.post("/resume/selfIntroduceTempSave.do"
						,$("#selfIntroduceForm").serialize()
						, function(response) {
					
					 if ( response == "fail" ) {
						$("#errorAlertMessage").html("자기소개 수정처리가 실패되었습니다.");
						$("#errorMessageModal").modal("show");
					}
					else {
						$("#successAlertMessage").html("자기소개 정보가 수정되었습니다.");
						$("#successMessageModal").modal("show");
					} 

				});
			}
		});
		
		$("#finalSubmitBtn").click(function() {
			
			if ( controller.selfIntroduceValidationCheckFunc() ) {
				
				return;
				
			} else {
				
				var resumeId = $("#resumeId").val();
				
				controller.autoClosingAlert("#successMessage", 2000);
				$("#selfIntroduceForm").attr({
					method:"post",
					action:"/resume/finalSubmitCheck.do/" + resumeId
				}).submit();
			}
		});		
		
	}, selfIntroduceValidationCheckFunc : function() {
		
		if ( $("#selfItdtContent1").val() == "" ) {
			$("#errorAlertMessage").html("성장과정 항목을 입력해주세요.");
			$("#errorMessageModal").modal("show");
		
			return true;
			
		} else {
			
			if ( $("#selfItdtContent1").val().length < 100 ) {
				$("#errorAlertMessage").html("성장과정 항목 최소 100글자 이상을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				
				return true;
			}	
		}
		
		if ( $("#selfItdtContent2").val() == "" ) {
			$("#errorAlertMessage").html("지원동기 항목을 입력해주세요.");
			$("#errorMessageModal").modal("show");
			
			return true;
			
		} else {
			
			if ( $("#selfItdtContent2").val().length < 100 ) {
				$("#errorAlertMessage").html("지원동기 항목 최소 100글자 이상을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				
				return true;
			}	
		}
		
		if ( $("#selfItdtContent3").val() == "" ) {
			$("#errorAlertMessage").html("입사 후 포부 항목을 입력해주세요.");
			$("#errorMessageModal").modal("show");
			
			return true;
			
		} else {
			
			if ( $("#selfItdtContent3").val().length < 100 ) {
				$("#errorAlertMessage").html("입사 후 포부 항목 최소 100글자 이상을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				
				return true;
			}	
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