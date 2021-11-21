/**
 * 
 */
var controller = $.extend(new $.CommonObj(), {
	eventInit:function() {
		
	},
	onCreate:function() {
		
		controller.hadicapDisabledCheckFunc();
		controller.handicapRadioCheckFunc();
		
		controller.boohoonDisabledCheckFunc();
		controller.bohoonRadioCheckFunc();
		
		controller.militaryCheckFunc();
		controller.militaryDivSelectBoxCheckFunc();
		
		$("#addressBtn").click(function(){
			controller.exeDaumPostcode();
		});
		
		$("#tempSaveBtn").click(function() {
			
			if ( basicInfoValidationCheckFunc() || humanInfoValidationCheckFunc() || recruitFieldValidaionCheckFunc() 
					|| handicapValidationCheckFunc() || bohoonValidationCheckFunc() || militaryValidationCheckFunc() ) {
	    		
				return;
				
			} else {
	    		
				controller.handicapDisabledRemoveAttrFunc();
				controller.bohoonDisabledRemoveAttrFunc();
				controller.militaryDisabledRemoveAttrFunc();
		    	
				var form = $("#basicInfoForm");
				form.ajaxSubmit({
					url:"/resume/basicInfoTempSave.do",
					data:form.serialize(),
					type:"POST",
					success: function(response) {
						if ( response == "fail" ) {
							$("#errorAlertMessage").html("기본정보 수정을 실패했습니다.");
							$("#errorMessageModal").modal("show");
							
						} else {
							$("#successAlertMessage").html("기본정보가 수정되었습니다.");
							$("#successMessageModal").modal("show");
								
							controller.hadicapDisabledCheckFunc();
							controller.boohoonDisabledCheckFunc();
							controller.militaryCheckFunc()
						} 
					}
				});
			}
		});		
		
	    $("#nextStepBtn").click(function() {
	    	
	    	if ( basicInfoValidationCheckFunc() || humanInfoValidationCheckFunc() || recruitFieldValidaionCheckFunc() 
	    			|| handicapValidationCheckFunc() || bohoonValidationCheckFunc() || militaryValidationCheckFunc() ) {
	    		
	    		return;
	    		
	    	} else {
	    		
	    		var resumeId = $("#resumeId").val();
	    		
	    		controller.handicapDisabledRemoveAttrFunc();
	    		controller.bohoonDisabledRemoveAttrFunc();
	    		controller.militaryDisabledRemoveAttrFunc();
		    	
	    		controller.autoClosingAlert("#successMessage", 2000);
		    	$("#basicInfoForm").attr({
		    		method:"post",
					action: "/resume/basicInfoNextStep.do/" + resumeId,
					enctype:"multipart/form-data"
				}).submit();
		    	
		    	controller.hadicapDisabledCheckFunc();
		    	controller.boohoonDisabledCheckFunc();
		    	controller.militaryCheckFunc();
	    	}
	    	/* handicapDisabledRemoveAttrFunc();
	    	bohoonDisabledRemoveAttrFunc();
	    	militaryDisabledRemoveAttrFunc();
	    	
	    	$("#basicInfoForm").attr({
				method:"post",
				action: "/Recruit/resume/nextStep/${basicInfoVO.resumeId}",
				enctype:"multipart/form-data"
			}).submit();
	    	
	    	hadicapDisabledCheck();
			boohoonDisabledCheck();
			militaryCheck();	 */		   

		});			
		
	}, exeDaumPostcode : function() {
		new daum.Postcode({
			oncomplete: function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { 
                	// 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { 
                	// 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                // $("zipCode").val() = data.zonecode;
                document.getElementById('zipCode').value = data.zonecode;
                
                //5자리 새우편번호 사용
                //$("address").val() = fullAddr;
                document.getElementById('address').value = fullAddr;
                
                // 커서를 상세주소 필드로 이동한다.
                //$("Daddress").focus();
                document.getElementById('dAddress').focus();
            }
        }).open();
		
	}, hadicapDisabledCheckFunc : function() {
		
		var handicapRadioCheck = $("input[type=radio][name=handicapYn]:checked").val();
		
		if ( handicapRadioCheck == "handicapRadioY") {
			$("#handicapGrade").attr("disabled", false);
			$("#handicapReason").attr("disabled", false);
		}
		else {
			
			$("#handicapGrade").attr("disabled", true);
			$("#handicapGrade").val("");
			$("#handicapReason").attr("disabled", true);
			$("#handicapReason").val("");
		}
		
	}, handicapRadioCheckFunc : function() {
		
		// 장애여부 Radio 버튼 변경 시
		$("input[type=radio][name=handicapYn]").bind("change", function() {
			controller.hadicapDisabledCheck();
		});
		
	}, boohoonDisabledCheckFunc : function() {
		
		var bohoonRadioCheck = $("input[type=radio][name=bohoonYn]:checked").val();
		
		if ( bohoonRadioCheck == "bohoonRadioY") {
			$("#bohoonNum").attr("disabled", false);
			$("#bohoonRltn").attr("disabled", false);
			$("#bohoonCost").attr("disabled", false);
		}
		else {					
			$("#bohoonNum").attr("disabled", true);
			$("#bohoonNum").val("");
			$("#bohoonRltn").attr("disabled", true);
			$("#bohoonRltn").val("");
			$("#bohoonCost").attr("disabled", true);
			$("#bohoonCost").val("");
		}
		
	}, bohoonRadioCheckFunc : function() {
		
		// 장애여부 Radio 버튼 변경 시
		$("input[type=radio][name=bohoonYn]").bind("change", function() {
			controller.boohoonDisabledCheck();
		});
		
	}, militaryCheckFunc : function() {
		
		var milDiv = $("#milDiv").val();
		
		if ( milDiv == "2" || milDiv == "3" ) {
			$("#milType").attr("disabled", true);
			$("#milType").val("");
			$("#milWork").attr("disabled", true);
			$("#milWork").val("");
			$("#milLevel").attr("disabled", true);
			$("#milLevel").val("");
			$("#milDischangeDiv").attr("disabled", true);
			$("#milDischangeDiv").val("");
			$("#milStartDt").attr("disabled", true);
			$("#milStartDt").val("");
			$("#milEndDt").attr("disabled", true);
			$("#milEndDt").val("");
			
		}
		else {
			$("#milType").attr("disabled", false);
			$("#milWork").attr("disabled", false);
			$("#milLevel").attr("disabled", false);
			$("#milDischangeDiv").attr("disabled", false);
			$("#milStartDt").attr("disabled", false);
			$("#milEndDt").attr("disabled", false);
		}
		
	}, militaryDivSelectBoxCheckFunc : function() {
	
		$("#milDiv").bind("change", function () {
			controller.militaryCheck();
		});
		
	}, basicInfoValidationCheckFunc : function() {
		
		controller.basicinfoEmptyCheckFunc();
		
		if ( fileEmpty || chNameEmpty || engNameEmpty || birthEmpty ) {
			
			if ( fileEmpty ) {
				$("#errorAlertMessage").html("기본정보 - 이력서 사진을 업로드해주세요.");
				$("#errorMessageModal").modal("show");
				$("#file").focus();
			}
			
			if ( chNameEmpty ) {
				$("#errorAlertMessage").html("기본정보 - 영어 이름을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#chName").focus();
			}
			
			if ( engNameEmpty ) {
				$("#errorAlertMessage").html("기본정보 - 한자 이름을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#engName").focus();
			}
			
			if ( birthEmpty ) {
				$("#errorAlertMessage").html("기본정보 - 생년월일을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#birth").focus();
			}
			
			return true;
			
		} else {
			return false;
		}
		
	}, basicinfoEmptyCheckFunc : function() {
		
		fileEmpty = false;
		chNameEmpty = false;
		engNameEmpty = false;
		birthEmpty = false;
		
		if ( $("#file").val() == "" ) {
    		fileEmpty = true;
    	} 
		
		if ( $("#chName").val() == "" ) {
			chNameEmpty = true;
		}
		
		if ( $("#engName").val() == "" ) {
			engNameEmpty = true;
		}
		
		if ( $("#birth").val() == "" ) {
			birthEmpty = true;
		}
		
	}, humanInfoValidationCheckFunc : function() {
		
		controller.humanInfoEmptyCheckFunc();
		
		if ( phoneEmpty || zipCodeEmpty || addressEmpty || dAddressEmpty ) {
			
			if ( phoneEmpty ) {
				$("#errorAlertMessage").html("인적사항 - 연락처를 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#phone").focus();
			}
			
			if ( zipCodeEmpty ) {
				$("#errorAlertMessage").html("인적사항 - 우편번호를 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#zipCode").focus();
			}
			
			if ( addressEmpty ) {
				$("#errorAlertMessage").html("인적사항 - 주소를 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#address").focus();
			}
			
			if ( dAddressEmpty ) {
				$("#errorAlertMessage").html("인적사항 - 상세주소를 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#dAddress").focus();
			}
			
			return true;
			
		} else {
			return false;
		}
		
	}, humanInfoEmptyCheckFunc : function() {
	
		phoneEmpty = false;
		zipCodeEmpty = false;
		addressEmpty = false;
		dAddressEmpty = false;
		
		if ( $("#phone").val() == "" ) {
			phoneEmpty = true;
    	} 
		
		if ( $("#zipCode").val() == "" ) {
			zipCodeEmpty = true;
		}
		
		if ( $("#address").val() == "" ) {
			addressEmpty = true;
		}
		
		if ( $("#dAddress").val() == "" ) {
			dAddressEmpty = true;
		}
		
	}, recruitFieldValidaionCheckFunc : function() {
		
		controller.recruitFieldEmptyCheckFunc();
		
		if ( careerDivEmpty || recruitFieldEmpty || recruitJobEmpty ) {
			
			if ( careerDivEmpty ) {
				$("#errorAlertMessage").html("지원분야 - 경력구분을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#careerDiv").focus();
			}
			
			if ( recruitFieldEmpty ) {
				$("#errorAlertMessage").html("지원분야 - 모집분야를 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#recruitField").focus();
			}
			if ( recruitJobEmpty ) {
				$("#errorAlertMessage").html("지원분야 - 해당직무를 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#recruitJob").focus();
			}
			
			return true;
			
		} else {
			return false;
		}
		
	}, recruitFieldEmptyCheckFunc : function() {
		
		careerDivEmpty = false;
		recruitFieldEmpty = false;
		recruitJobEmpty = false;
		
		if ( $("#careerDiv").val() == "" ) {
			careerDivEmpty = true;
    	} 
		
		if ( $("#recruitField").val() == "" ) {
			recruitFieldEmpty = true;
		}
		
		if ( $("#recruitJob").val() == "" ) {
			recruitJobEmpty = true;
		}
		
	}, handicapValidationCheckFunc : function() {
		
		controller.handicapEmptyCheckFunc();
		
		var handicapRadioCheck = $("input[type=radio][name=handicapYn]:checked").val();
		
		if ( handicapRadioCheck == undefined ) {
			$("#errorAlertMessage").html("장애여부 - 대상/비대상을 선택해주세요.");
			$("#errorMessageModal").modal("show");
			$("#handicapRadioN").focus();
			
			return true;
			
		} else if ( handicapRadioCheck == "handicapRadioY") {
			
			if ( handicapGradeEmpty ) {
				$("#errorAlertMessage").html("장애여부 - 등급을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#handicapGrade").focus();
				return true;
			}
			
			if ( handicapReasonEmpty ) {
				$("#errorAlertMessage").html("장애여부 - 내용을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#handicapReason").focus();
				return true;
			}										
		}
		
		return false;
		
	}, handicapEmptyCheckFunc : function() {
		
		handicapGradeEmpty = false;
		handicapReasonEmpty = false;
		
		if ( $("#handicapGrade").val() == "" ) {
			handicapGradeEmpty = true;
		}
		
		if ( $("#handicapReason").val() == "" ) {
			handicapReasonEmpty = true;
		}
		
	}, bohoonValidationCheckFunc : function() {
		
		controller.boohoonEmptyCheckFunc();
		
		var bohoonRadioCheck = $("input[type=radio][name=bohoonYn]:checked").val();
		
		if ( bohoonRadioCheck == undefined ) {
			$("#errorAlertMessage").html("보훈여부 - 대상/비대상을 선택해주세요.");
			$("#errorMessageModal").modal("show");
			$("#bohoonRadioN").focus();
			
			return true;
			
		} else if ( bohoonRadioCheck == "bohoonRadioY") {
			
			if ( bohoonNumEmpty ) {
				$("#errorAlertMessage").html("보훈여부 - 보훈번호를 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#bohoonNum").focus();
				return true;
			}
			
			if ( bohoonRltnEmpty ) {
				$("#errorAlertMessage").html("보훈여부 - 관계를 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#bohoonRltn").focus();
				return true;
			}
			
			if ( bohoonCostEmpty ) {
				$("#errorAlertMessage").html("보훈여부 - 비용을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#bohoonCost").focus();
				return true;
			}
			
		}
		
		return false;		
		
	}, boohoonEmptyCheckFunc : function() {
		
		bohoonNumEmpty = false;
		bohoonRltnEmpty = false;
		bohoonCostEmpty = false;
		
		if ( $("#bohoonNum").val() == "" ) {
			bohoonNumEmpty = true;
		}
		
		if ( $("#bohoonRltn").val() == "" ) {
			bohoonRltnEmpty = true;
		}
		
		if ( $("#bohoonCost").val() == "" ) {
			bohoonCostEmpty = true;
		}
		
	}, militaryValidationCheckFunc : function() {
		
		controller.militaryEmptyCheckFunc();
		
		if ( milDivEmpty ) {
			
			$("#errorAlertMessage").html("병역사항 - 병역구분을 선택해주세요.");
			$("#errorMessageModal").modal("show");
			$("#milDiv").focus();
			
			if ( milTypeEmpty || milWorkEmpty || milLevelEmpty
					|| milDischangeDivEmpty || milStartDtEmpty || milEndDtEmpty ) {
				
				if ( milTypeEmpty ) {
					$("#errorAlertMessage").html("병역사항 - 군별을 선택해주세요.");
					$("#errorMessageModal").modal("show");
					$("#milType").focus();
				}
				if ( milWorkEmpty ) {
					$("#errorAlertMessage").html("병역사항 - 병과를 선택해주세요.");
					$("#errorMessageModal").modal("show");
					$("#milWork").focus();
				}
				if ( milLevelEmpty ) {
					$("#errorAlertMessage").html("병역사항 - 계급을 선택해주세요.");
					$("#errorMessageModal").modal("show");
					$("#milLevel").focus();
				}
				if ( milDischangeDivEmpty ) {
					$("#errorAlertMessage").html("병역사항 - 제대구분을 입력해주세요.");
					$("#errorMessageModal").modal("show");
					$("#milDischangeDiv").focus();
				}
				if ( milStartDtEmpty ) {
					$("#errorAlertMessage").html("병역사항 - 입대일을 입력해주세요.");
					$("#errorMessageModal").modal("show");
					$("#milStartDt").focus();
				}
				if ( milEndDtEmpty ) {
					$("#errorAlertMessage").html("병역사항 - 제대일을 입력해주세요.");
					$("#errorMessageModal").modal("show");
					$("#milEndDt").focus();
				}
			}
			
			return true;
			
		} else if ( milDivEmpty == false) {
			
			var milDiv = $("#milDiv").val();
			
			if ( milDiv == "1" ) {
				
				if ( milTypeEmpty || milWorkEmpty || milLevelEmpty
						|| milDischangeDivEmpty || milStartDtEmpty || milEndDtEmpty ) {
				
					if ( milTypeEmpty ) {
						$("#errorAlertMessage").html("병역사항 - 군별을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#milType").focus();
					}
					
					if ( milWorkEmpty ) {
						$("#errorAlertMessage").html("병역사항 - 병과를 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#milWork").focus();
					}
					
					if ( milLevelEmpty ) {
						$("#errorAlertMessage").html("병역사항 - 계급을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#milLevel").focus();
					}
					
					if ( milDischangeDivEmpty ) {
						$("#errorAlertMessage").html("병역사항 - 제대구분을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#milDischangeDiv").focus();
					}
					
					if ( milStartDtEmpty ) {
						$("#errorAlertMessage").html("병역사항 - 입대일을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#milStartDt").focus();
					}
					
					if ( milEndDtEmpty ) {
						$("#errorAlertMessage").html("병역사항 - 제대일을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#milEndDt").focus();
					}
					
					return true;
					
				}
				
				return false;
			}					
		}
		
	}, militaryEmptyCheckFunc : function() {
		
		milDivEmpty = false;
		milTypeEmpty = false;
		milWorkEmpty = false;
		milLevelEmpty = false;
		milDischangeDivEmpty = false;
		milStartDtEmpty = false;
		milEndDtEmpty = false;
		
		if ( $("#milDiv").val() == "" ) {
			milDivEmpty = true;
		}
		
		if ( $("#milType").val() == "" ) {
			milTypeEmpty = true;
		}
		
		if ( $("#milWork").val() == "" ) {
			milWorkEmpty = true;
		}
		
		if ( $("#milLevel").val() == "" ) {
			milLevelEmpty = true;
		}
		
		if ( $("#milDischangeDiv").val() == "" ) {
			milDischangeDivEmpty = true;
		}
		
		if ( $("#milStartDt").val() == "" ) {
			milStartDtEmpty = true;
		}
		
		if ( $("#milEndDt").val() == "" ) {
			milEndDtEmpty = true;
		}
		
	}, handicapDisabledRemoveAttrFunc : function() {
		$("#handicapGrade").removeAttr("disabled");
    	$("#handicapReason").removeAttr("disabled");
    	
	}, bohoonDisabledRemoveAttrFunc : function() {
    	$("#bohoonNum").removeAttr("disabled");
		$("#bohoonRltn").removeAttr("disabled");
		$("#bohoonCost").removeAttr("disabled");
		
	}, militaryDisabledRemoveAttrFunc : function() {
    	$("#milType").removeAttr("disabled");
		$("#milWork").removeAttr("disabled");
		$("#milLevel").removeAttr("disabled");
		$("#milDischangeDiv").removeAttr("disabled");
		$("#milStartDt").removeAttr("disabled");
		$("#milEndDt").removeAttr("disabled");
		
	}, autoClosingAlert : function(selector, delay) {
		
		var alert = $(selector).alert();
		alert.show();
		window.setTimeout(function() { alert.hide() }, delay);		
	}
});


$(document).ready(function() {
	controller.init();			
});