/**
 * 
 */
var controller = $.extend(new $.CommonObj(), {
	eventInit:function() {
		
	},
	onCreate:function() {

		controller.highSchoolDivCheckFunc();
		controller.highSchoolDivSelectBoxCheckFunc();
		
		controller.universityCheckFunc();
		controller.universitySelectBoxCheckFunc();
		
		controller.graduateSchoolCheckFunc();
		controller.graduateSchoolSelectBoxCheckFunc();
		
		$("#tempSaveBtn").click(function() {
			//|| graduateSchoolValidationCheckFunc()
			if ( controller.highSchoolValidationCheckFunc() || controller.universityValidationCheckFunc() || controller.graduateSchoolValidationCheckFunc() ) {
				return;
			}
			else {
				controller.highSchoolDisabledRemoveAttrFunc();
				controller.universityDisabledRemoveAttrFunc();
				controller.graduateSchoolDisabledRemoveAttrFunc();
				
				$.post("/resume/academicBackgroundTempSave.do"
						,$("#academicBackgroundForm").serialize()
						, function(response) {
					
					if ( response == "fail" ) {
						$("#errorAlertMessage").html("학력사항 수정처리가 실패되었습니다.");
						$("#errorMessageModal").modal("show");
					}
					else {
						$("#successAlertMessage").html("학력사항 정보가 수정되었습니다.");
						$("#successMessageModal").modal("show");
						
						controller.highSchoolDivCheckFunc();
						controller.universityCheckFunc();
						controller.graduateSchoolCheckFunc();
					}	
				});
			}				
		});
		
		$("#nextStepBtn").click(function() {
			if ( controller.highSchoolValidationCheckFunc() || controller.universityValidationCheckFunc() || controller.graduateSchoolValidationCheckFunc() ) {
				return;
			}
			else {
				
				var resumeId = $("#resumeId").val();
				
				controller.highSchoolDisabledRemoveAttrFunc();
				controller.universityDisabledRemoveAttrFunc();
				controller.graduateSchoolDisabledRemoveAttrFunc();
				
				controller.LoadingWithMaskFunc();
				setTimeout("controller.closeLoadingWithMaskFunc()", 10000);
				//controller.autoClosingAlert("#successMessage", 2000);
				$("#academicBackgroundForm").attr({
					method:"post",
					action: "/resume/academicBackgroundNextStep.do/" + resumeId						
				}).submit();
				
				controller.highSchoolDivCheckFunc();
				controller.universityCheckFunc();
				controller.graduateSchoolCheckFunc();
			}
		});
		
	}, highSchoolDivCheckFunc : function() {
		
		var highSDiv = $("#highSDiv").val();

		if ( highSDiv == "2" || highSDiv == "3" ) {
			$("#highSName").attr("disabled", true);
			$("#highSName").val("");
			$("#highSRegion").attr("disabled", true);
			$("#highSRegion").val("");
			$("#highSDayNight").attr("disabled", true);
			$("#highSDayNight").val("");
			$("#highSEndDt").attr("disabled", true); 
			$("#highSEndDt").val("");

		} else {
			$("#highSName").attr("disabled", false);
			$("#highSRegion").attr("disabled", false);
			$("#highSDayNight").attr("disabled", false);
			$("#highSEndDt").attr("disabled", false); 					
		}		
		
	}, highSchoolDivSelectBoxCheckFunc : function() {
		
		$("#highSDiv").bind("change", function () {
			controller.highSchoolDivCheckFunc();
		});
		
	}, universityCheckFunc : function() {
		
		var univGraDiv = $("#univGraDiv").val();
		
		if( univGraDiv == "2" || univGraDiv == "3" ) {
			$("#univDayNight").attr("disabled", true);
			$("#univDayNight").val("");
			$("#univMainBranch").attr("disabled", true);
			$("#univMainBranch").val("");
			$("#univName").attr("disabled", true);
			$("#univName").val("");
			$("#univTypeName").attr("disabled", true);
			$("#univTypeName").val("");
			$("#univMajor").attr("disabled", true);
			$("#univMajor").val("");
			$("#univStartDt").attr("disabled", true);
			$("#univStartDt").val("");
			$("#univEndDt").attr("disabled", true);
			$("#univEndDt").val("");
			$("#univScore").attr("disabled", true);
			$("#univScore").val("");
			$("#univPScore").attr("disabled", true);
			$("#univPScore").val("");
			$("#univRegion").attr("disabled", true);
			$("#univRegion").val("");
			
		} else {
			$("#univDayNight").attr("disabled", false);
			$("#univMainBranch").attr("disabled", false);
			$("#univName").attr("disabled", false);
			$("#univTypeName").attr("disabled", false);
			$("#univMajor").attr("disabled", false);
			$("#univStartDt").attr("disabled", false);
			$("#univEndDt").attr("disabled", false);
			$("#univScore").attr("disabled", false);
			$("#univPScore").attr("disabled", false);
			$("#univRegion").attr("disabled", false);					
		}		
		
	}, universitySelectBoxCheckFunc : function() {
		
		$("#univGraDiv").bind("change", function () {
			controller.universityCheckFunc();
		});
		
	}, graduateSchoolCheckFunc : function() {
		
		var graUnivGraDiv = $("#graUnivGraDiv").val();
		
		if( graUnivGraDiv == "2" || graUnivGraDiv == "3" ) {
			$("#graUnivDayNight").attr("disabled", true);
			$("#graUnivDayNight").val("");
			$("#graUnivMainBranch").attr("disabled", true);
			$("#graUnivMainBranch").val("");
			$("#graUnivName").attr("disabled", true);
			$("#graUnivName").val("");
			$("#graUnivTypeName").attr("disabled", true);
			$("#graUnivTypeName").val("");
			$("#graUnivMajor").attr("disabled", true);
			$("#graUnivMajor").val("");
			$("#graUnivStartDt").attr("disabled", true);
			$("#graUnivStartDt").val("");
			$("#graUnivEndDt").attr("disabled", true);
			$("#graUnivEndDt").val("");
			$("#graUnivScore").attr("disabled", true);
			$("#graUnivScore").val("");
			$("#graUnivPScore").attr("disabled", true);
			$("#graUnivPScore").val("");
			$("#graUnivRegion").attr("disabled", true);
			$("#graUnivRegion").val("");
			
		} else {
			$("#graUnivDayNight").attr("disabled", false);
			$("#graUnivMainBranch").attr("disabled", false);
			$("#graUnivName").attr("disabled", false);
			$("#graUnivTypeName").attr("disabled", false);
			$("#graUnivMajor").attr("disabled", false);
			$("#graUnivStartDt").attr("disabled", false);
			$("#graUnivEndDt").attr("disabled", false);
			$("#graUnivScore").attr("disabled", false);
			$("#graUnivPScore").attr("disabled", false);
			$("#graUnivRegion").attr("disabled", false);					
		}		
		
	}, graduateSchoolSelectBoxCheckFunc : function() {
		
		$("#graUnivGraDiv").bind("change", function () {
			controller.graduateSchoolCheckFunc();
		});
		
	}, highSchoolDisabledRemoveAttrFunc : function() {
		
		$("#highSName").removeAttr("disabled");
		$("#highSRegion").removeAttr("disabled");
		$("#highSDayNight").removeAttr("disabled");
		$("#highSEndDt").removeAttr("disabled");
		
	}, universityDisabledRemoveAttrFunc : function() {
		
		$("#univDayNight").removeAttr("disabled");
		$("#univMainBranch").removeAttr("disabled");
		$("#univName").removeAttr("disabled");
		$("#univTypeName").removeAttr("disabled");
		$("#univMajor").removeAttr("disabled");
		$("#univStartDt").removeAttr("disabled");
		$("#univEndDt").removeAttr("disabled");
		$("#univScore").removeAttr("disabled");
		$("#univPScore").removeAttr("disabled");
		$("#univRegion").removeAttr("disabled");
		
	}, graduateSchoolDisabledRemoveAttrFunc : function() {
		
		$("#graUnivDayNight").removeAttr("disabled");
		$("#graUnivMainBranch").removeAttr("disabled");
		$("#graUnivName").removeAttr("disabled");
		$("#graUnivTypeName").removeAttr("disabled");
		$("#graUnivMajor").removeAttr("disabled");
		$("#graUnivStartDt").removeAttr("disabled");
		$("#graUnivEndDt").removeAttr("disabled");
		$("#graUnivScore").removeAttr("disabled");
		$("#graUnivPScore").removeAttr("disabled");
		$("#graUnivRegion").removeAttr("disabled");		
		
	}, highSchoolValidationCheckFunc : function() {
		
		controller.highSchoolEmptyCheckFunc();
		
		if ( highSDivEmpty ) {
			$("#errorAlertMessage").html("고등학교 - 졸업구분을 선택해주세요.");
			$("#errorMessageModal").modal("show");
			$("#highSDiv").focus();
			
			if ( highSNameEmpty ) {
				$("#errorAlertMessage").html("고등학교 - 학교명을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#highSName").focus();
			}
			
			if ( highSRegionEmpty ) {
				$("#errorAlertMessage").html("고등학교 - 소재지를 입력해해주세요.");
				$("#errorMessageModal").modal("show");
				$("#highSRegion").focus();
			}
			
			if ( highSDayNightEmpty ) {
				$("#errorAlertMessage").html("고등학교 - 주/야간을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#highSDayNight").focus();
			}
			
			if ( highSEndDtEmpty ) {
				$("#errorAlertMessage").html("고등학교 - 졸업일을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#highSEndDt").focus();
			}
			
			return true;
			
		} else if ( highSDivEmpty == false ) {
			var highSDiv = $("#highSDiv").val();
			
			if ( highSDiv == "1") {
				if ( highSNameEmpty || highSRegionEmpty || highSDayNightEmpty || highSEndDtEmpty ) {
					if ( highSNameEmpty ) {
						$("#errorAlertMessage").html("고등학교 - 학교명을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#highSName").focus();
					}
					if ( highSRegionEmpty ) {
						$("#errorAlertMessage").html("고등학교 - 소재지를 입력해해주세요.");
						$("#errorMessageModal").modal("show");
						$("#highSRegion").focus();
					}
					if ( highSDayNightEmpty ) {
						$("#errorAlertMessage").html("고등학교 - 주/야간을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#highSDayNight").focus();
					}
					if ( highSEndDtEmpty ) {
						$("#errorAlertMessage").html("고등학교 - 졸업일을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#highSEndDt").focus();
					}
					return true;
					
				} else {
					return false;
				}
			}
		}
		
	}, highSchoolEmptyCheckFunc : function() {
		
		highSDivEmpty = false;
		highSNameEmpty = false;
		highSRegionEmpty = false;
		highSDayNightEmpty = false;
		highSEndDtEmpty = false;
			
		if ( $("#highSDiv").val() == "" ) {
			highSDivEmpty = true;
		}
		
		if ( $("#highSName").val() == "" ) {
			highSNameEmpty = true;
		}
		
		if ( $("#highSRegion").val() == "" ) {
			highSRegionEmpty = true;
		}
		
		if ( $("#highSDayNight").val() == "" ) {
			highSDayNightEmpty = true;
		}
		
		if ( $("#highSEndDt").val() == "" ) {
			highSEndDtEmpty = true;
		}		
		
	}, universityValidationCheckFunc : function() {
	
		controller.universityEmptyCheckFunc();
		
		if ( univDivEmpty ) {
			$("#errorAlertMessage").html("대학교 - 전문학사/학사를 선택해주세요.");
			$("#errorMessageModal").modal("show");
			$("#univDiv").focus();
			
			return true;
		}
		
		if ( univGraDivEmpty ) {
			$("#errorAlertMessage").html("대학교 - 졸업구분을 선택해주세요.");
			$("#errorMessageModal").modal("show");
			$("#univGraDiv").focus();
			
			if ( univDayNightEmpty ) {
				$("#errorAlertMessage").html("대학교 - 주/야간을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univDayNight").focus();
			}
			if ( univMainBranchEmpty ) {
				$("#errorAlertMessage").html("대학교 - 본교/분교을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univMainBranch").focus();
			}
			if ( univNameEmpty ) {
				$("#errorAlertMessage").html("대학교 - 학교명을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univName").focus();
			}
			if ( univTypeNameEmpty ) {
				$("#errorAlertMessage").html("대학교 - 학과명을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univTypeName").focus();
			}
			if ( univMajorEmpty ) {
				$("#errorAlertMessage").html("대학교 - 전공을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univMajor").focus();
			}
			if ( univStartDtEmpty ) {
				$("#errorAlertMessage").html("대학교 - 입학일을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univStartDt").focus();
			}
			if ( univEndDtEmpty ) {
				$("#errorAlertMessage").html("대학교 - 졸업일을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univEndDt").focus();
			}
			if ( univScoreEmpty ) {
				$("#errorAlertMessage").html("대학교 - 학점을 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univScore").focus();
			}
			if ( univPScoreEmpty ) {
				$("#errorAlertMessage").html("대학교 - 총 학점을 선택해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univPScore").focus();
			}
			if ( univRegionEmpty ) {
				$("#errorAlertMessage").html("대학교 - 소재지를 입력해주세요.");
				$("#errorMessageModal").modal("show");
				$("#univRegion").focus();
			}
			
			return true;
			
		} else if ( univGraDivEmpty == false ) {
			var univGraDiv = $("#univGraDiv").val();
			
			if( univGraDiv == "1" ) {
				if ( univDayNightEmpty || univMainBranchEmpty || univNameEmpty 
						|| univTypeNameEmpty || univMajorEmpty || univStartDtEmpty 
						|| univEndDtEmpty || univScoreEmpty || univPScoreEmpty || univRegionEmpty ) {
					
					if ( univDayNightEmpty ) {
						$("#errorAlertMessage").html("대학교 - 주/야간을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univDayNight").focus();
					}
					if ( univMainBranchEmpty ) {
						$("#errorAlertMessage").html("대학교 - 본교/분교을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univMainBranch").focus();
					}
					if ( univNameEmpty ) {
						$("#errorAlertMessage").html("대학교 - 학교명을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univName").focus();
					}
					if ( univTypeNameEmpty ) {
						$("#errorAlertMessage").html("대학교 - 학과명을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univTypeName").focus();
					}
					if ( univMajorEmpty ) {
						$("#errorAlertMessage").html("대학교 - 전공을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univMajor").focus();
					}
					if ( univStartDtEmpty ) {
						$("#errorAlertMessage").html("대학교 - 입학일을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univStartDt").focus();
					}
					if ( univEndDtEmpty ) {
						$("#errorAlertMessage").html("대학교 - 졸업일을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univEndDt").focus();
					}
					if ( univScoreEmpty ) {
						$("#errorAlertMessage").html("대학교 - 학점을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univScore").focus();
					}
					if ( univPScoreEmpty ) {
						$("#errorAlertMessage").html("대학교 - 총 학점을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univPScore").focus();
					}
					if ( univRegionEmpty ) {
						$("#errorAlertMessage").html("대학교 - 소재지를 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#univRegion").focus();
					}
					return true;
				}
				else {
					return false;
				}
			}					
		}		
		
	}, universityEmptyCheckFunc : function() {
		
		univDivEmpty = false;
		univGraDivEmpty = false;
		univDayNightEmpty = false;
		univMainBranchEmpty = false;
		univNameEmpty = false;
		univTypeNameEmpty = false;
		univMajorEmpty = false;
		univStartDtEmpty = false;
		univEndDtEmpty = false;
		univScoreEmpty = false;
		univPScoreEmpty = false;
		univRegionEmpty = false;
		
		if ( $("#univDiv").val() == "" ) {
			univDivEmpty = true;
		}
		
		if ( $("#univGraDiv").val() == "" ) {
			univGraDivEmpty = true;
		}
		
		if ( $("#univDayNight").val() == "" ) {
			univDayNightEmpty = true;
		}
		
		if ( $("#univMainBranch").val() == "" ) {
			univMainBranchEmpty = true;
		}
		
		if ( $("#univName").val() == "" ) {
			univNameEmpty = true;
		}
		
		if ( $("#univTypeName").val() == "" ) {
			univTypeNameEmpty = true;
		}
		
		if ( $("#univMajor").val() == "" ) {
			univMajorEmpty = true;
		}
		
		if ( $("#univStartDt").val() == "" ) {
			univStartDtEmpty = true;
		}
		
		if ( $("#univEndDt").val() == "" ) {
			univEndDtEmpty = true;
		}
		
		if ( $("#univScore").val() == "" ) {
			univScoreEmpty = true;
		}
		
		if ( $("#univPScore").val() == "" ) {
			univPScoreEmpty = true;
		}
		
		if ( $("#univRegion").val() == "" ) {
			univRegionEmpty = true;
		}		
		
	}, graduateSchoolValidationCheckFunc : function() {
		
		controller.graduateSchoolEmptyCheckFunc();
		
		if ( graUnivDegreeEmpty == false ) {
			if ( graUnivGraDivEmpty || graUnivDayNightEmpty || graUnivMainBranchEmpty 
					|| graUnivNameEmpty || graUnivTypeNameEmpty || graUnivMajorEmpty 
					|| graUnivStartDtEmpty || graUnivEndDtEmpty || graUnivScoreEmpty 
					|| graUnivPScoreEmpty || graUnivRegionEmpty ) {
				
				if ( graUnivGraDivEmpty ) {
					$("#errorAlertMessage").html("대학원 - 졸업구분을 선택해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivGraDiv").focus();
				}
				
				if ( graUnivDayNightEmpty ) {
					$("#errorAlertMessage").html("대학원 - 주/야간을 선택해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivDayNight").focus();
				}
				
				if ( graUnivMainBranchEmpty ) {
					$("#errorAlertMessage").html("대학원 - 본교/분교을 선택해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivMainBranch").focus();
				}
				
				if ( graUnivNameEmpty ) {
					$("#errorAlertMessage").html("대학원 - 학교명을 입력해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivName").focus();
				}
				
				if ( graUnivTypeNameEmpty ) {
					$("#errorAlertMessage").html("대학원 - 학과명을 입력해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivTypeName").focus();
				}
				
				if ( graUnivMajorEmpty ) {
					$("#errorAlertMessage").html("대학원 - 전공을 입력해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivMajor").focus();
				}
				
				if ( graUnivStartDtEmpty ) {
					$("#errorAlertMessage").html("대학원 - 입학일을 선택해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivStartDt").focus();
				}
				
				if ( graUnivEndDtEmpty ) {
					$("#errorAlertMessage").html("대학원 - 졸업일을 선택해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivEndDt").focus();
				}
				
				if ( graUnivScoreEmpty ) {
					$("#errorAlertMessage").html("대학원 - 학점을 입력해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivScore").focus();
				}
				
				if ( graUnivPScoreEmpty ) {
					$("#errorAlertMessage").html("대학원 - 총 학점을 선택해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivPScore").focus();
				}
				
				if ( graUnivRegionEmpty ) {
					$("#errorAlertMessage").html("대학원 - 소재지를 입력해주세요.");
					$("#errorMessageModal").modal("show");
					$("#graUnivRegion").focus();
				}
				
				return true;
			}
			
		} else if ( graUnivGraDivEmpty == false ) {
			var graUnivGraDiv = $("#graUnivGraDiv").val();
			
			if ( graUnivGraDiv == "1" ) {
				if ( graUnivDegreeEmpty || graUnivDayNightEmpty || graUnivMainBranchEmpty || graUnivNameEmpty 
						|| graUnivTypeNameEmpty || graUnivMajorEmpty || graUnivStartDtEmpty 
						|| graUnivEndDtEmpty || graUnivScoreEmpty || graUnivPScoreEmpty || graUnivRegionEmpty ) {
					
					if ( graUnivDegreeEmpty ) {
						$("#errorAlertMessage").html("대학원 - 대학원 학위를 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivRegion").focus();
					}
					
					if ( graUnivDayNightEmpty ) {
						$("#errorAlertMessage").html("대학원 - 주/야간을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivDayNight").focus();
					}
					
					if ( graUnivMainBranchEmpty ) {
						$("#errorAlertMessage").html("대학원 - 본교/분교을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivMainBranch").focus();
					}
					
					if ( graUnivNameEmpty ) {
						$("#errorAlertMessage").html("대학원 - 학교명을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivName").focus();
					}
					
					if ( graUnivTypeNameEmpty ) {
						$("#errorAlertMessage").html("대학원 - 학과명을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivTypeName").focus();
					}
					
					if ( graUnivMajorEmpty ) {
						$("#errorAlertMessage").html("대학원 - 전공을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivMajor").focus();
					}
					
					if ( graUnivStartDtEmpty ) {
						$("#errorAlertMessage").html("대학원 - 입학일을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivStartDt").focus();
					}
					
					if ( graUnivEndDtEmpty ) {
						$("#errorAlertMessage").html("대학원 - 졸업일을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivEndDt").focus();
					}
					
					if ( graUnivScoreEmpty ) {
						$("#errorAlertMessage").html("대학원 - 학점을 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivScore").focus();
					}
					
					if ( graUnivPScoreEmpty ) {
						$("#errorAlertMessage").html("대학원 - 총 학점을 선택해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivPScore").focus();
					}
					
					if ( graUnivRegionEmpty ) {
						$("#errorAlertMessage").html("대학원 - 소재지를 입력해주세요.");
						$("#errorMessageModal").modal("show");
						$("#graUnivRegion").focus();
					}
					
					return true;
				}						
			}
		}
		
		return false;
		
	}, graduateSchoolEmptyCheckFunc : function() {
		
		graUnivDegreeEmpty = false;
		graUnivGraDivEmpty = false;
		graUnivDayNightEmpty = false;
		graUnivMainBranchEmpty = false;
		graUnivNameEmpty = false;
		graUnivTypeNameEmpty = false;
		graUnivMajorEmpty = false;
		graUnivStartDtEmpty = false;
		graUnivEndDtEmpty = false;
		graUnivScoreEmpty = false;
		graUnivPScoreEmpty = false;
		graUnivRegionEmpty = false;
		
		if ( $("#graUnivDegree").val() == "" ) {
			graUnivDegreeEmpty = true;
		}
		
		if ( $("#graUnivGraDiv").val() == "" ) {
			graUnivGraDivEmpty = true;
		}
		
		if ( $("#graUnivDayNight").val() == "" ) {
			graUnivDayNightEmpty = true;
		}
		
		if ( $("#graUnivMainBranch").val() == "" ) {
			graUnivMainBranchEmpty = true;
		}
		
		if ( $("#graUnivName").val() == "" ) {
			graUnivNameEmpty = true;
		}
		
		if ( $("#graUnivTypeName").val() == "" ) {
			graUnivTypeNameEmpty = true;
		}
		
		if ( $("#graUnivMajor").val() == "" ) {
			graUnivMajorEmpty = true;
		}
		
		if ( $("#graUnivStartDt").val() == "" ) {
			graUnivStartDtEmpty = true;
		}
		
		if ( $("#graUnivEndDt").val() == "" ) {
			graUnivEndDtEmpty = true;
		}
		
		if ( $("#graUnivScore").val() == "" ) {
			graUnivScoreEmpty = true;
		}
		
		if ( $("#graUnivPScore").val() == "" ) {
			graUnivPScoreEmpty = true;
		}
		
		if ( $("#graUnivRegion").val() == "" ) {
			graUnivRegionEmpty = true;
		}		
		
	}, LoadingWithMaskFunc : function() {
		
	    //화면의 높이와 너비를 구합니다.
	    var maskHeight = $(document).height();
	    var maskWidth  = window.document.body.clientWidth;
	    
	    console.log('maskHeight : ' + maskHeight);
	    console.log('maskWidth : ' + maskWidth);
	    
	     
	    //화면에 출력할 마스크를 설정해줍니다.
	    var mask       = "<div id='mask' style='position:absolute; z-index:9000; background-color:#000000; display:none; left:0; top:0;'></div>";
	    var loadingImg = '';
	      
	    loadingImg += "<div id='loadingImg'>";
	    loadingImg += " <img src='/images/common/LoadingImg.gif' style='position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); display: block; '/>";
	    loadingImg += "</div>"; 
	  
	    //화면에 레이어 추가
	    $('body')
	        .append(mask)
	        .append(loadingImg)
	        
	    //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채웁니다.
	    $('#mask').css({
	            'width' : maskWidth
	            ,'height': maskHeight
	            ,'opacity' :'0.3'
	    });
	  
	    //마스크 표시
	    $('#mask').show();  
	  
	    //로딩중 이미지 표시
	    $('#loadingImg').show();
	    
	}, closeLoadingWithMaskFunc : function() {
	    $('#mask, #loadingImg').hide();
	    $('#mask, #loadingImg').remove(); 
	    
	}, autoClosingAlert : function(selector, delay) {
		
		var alert = $(selector).alert();
		alert.show();
		window.setTimeout(function() { alert.hide() }, delay);	
		
	}
});


$(document).ready(function() {
	controller.init();
});