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
						
					} else {
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
				
				controller.LoadingWithMaskFunc();
				setTimeout("controller.closeLoadingWithMaskFunc()", 10000);
				//controller.autoClosingAlert("#successMessage", 2000);
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