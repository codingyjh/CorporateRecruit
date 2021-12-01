/**
 * 
 */


var controller = $.extend(new $.CommonObj(), {
	eventInit:function() {
		
	},
	onCreate:function() {
		
		$("#email").keyup(function() {
			controller.emailCheckFunc();
		});
		
		$("#password").keyup(function() {
			controller.passwordRegCheckFunc();
			
		});
		
		$("#passwordConfirm").keyup(function() {
			controller.passwordConfirmCheckFunc();
		});
		
		$("#name").keyup(function() {
			controller.nameCheckFunc();
		});
		
		$("#registBtn").click(function() {
			
			if ( controller.validationCheckFunc() ) {
				return;
			} else {
				controller.LoadingWithMaskFunc();
				setTimeout("controller.closeLoadingWithMaskFunc()", 10000);
				//controller.autoClosingAlert("#successMessage", 2000);
				$("#registForm").attr({
					method:"post", 					     				     	
					action:"/recruitMember/recruitMemberRegist.do"
				}).submit();
			}	
			
		});
		
	}, emailCheckFunc : function() {
		
		var email = $("#email").val();
		var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

		$.post("/recruitMember/emailDuplicate.do"
				,  {									 
						"email": $("#email").val()
					} 
				, function(response) {
						
					if ( reg.test(email) ) {
						$("#emailMessage").hide();
						if ( response.count > 0 ) {					 
							$("#emailMessage").text("이미 존재하는 이메일입니다.").show();
							controller.errorState("#email");
							emailCheckFlag = true;
						} else {
							$("#emailMessage").text("사용가능한 이메일입니다.").show();
							controller.successState("#email");
							emailCheckFlag = false;
						}
					} else {
						$("#emailMessage").text("올바른 이메일 형식이 아닙니다. 다시 입력해 주세요.").show();
						controller.errorState("#email");
						emailCheckflag = true;
					}
				});
		return false;
		
	}, passwordRegCheckFunc : function() {
		
		var password = $("#password").val();
		var reg =  /^(?=.*[a-zA-z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}/;
		
		if (reg.test(password)) {
			$("#passwordMessage").hide();
			$("#passwordMessage").text("사용가능한 비밀번호입니다.").show();
			controller.successState("#password");
			passwordRegCheckFlag = false;
		} else {
			$("#passwordMessage").text("대/소문자, 특수문자 8글자 이상 입력하세요.").show();
			controller.errorState("#password");
			passwordRegCheckFlag = true;
		}
		
	}, passwordConfirmCheckFunc : function() {
		
		var password = $("#password").val();
		var passwordConfirm = $("#passwordConfirm").val();
						
		if ( password == passwordConfirm ) {
			$("#passwordConfirmMessage").hide();
			$("#passwordConfirmMessage").text("비밀번호가 일치합니다.").show();
			controller.successState("#passwordConfirm");
		} else {
			$("#passwordConfirmMessage").text("비밀번호와 일치하지 않습니다. 다시 입력해 주세요.").show();
			controller.errorState("#passwordConfirm");
		}
		
	}, nameCheckFunc : function() {
		
		var name = $("#name").val();
		
		if ( name != null) {
			$("#nameMessage").hide();
			controller.successState("#name");
		} 
		else {
			$("#nameMessage").text("이름을 입력해주세요.").show();
			controller.errorState("#name");
		}
		
	}, successState : function(sel) {
		
		$(sel).closest(".form-group")
		  .removeClass("has-error")
		  .addClass("has-success")
		  .find(".form-control-feedback")
		  .removeClass("glyphicon-remove")
		  .addClass("glyphicon-ok")
		  .show();
		
	}, errorState : function(sel) {
		
		$(sel).closest(".form-group")
		  .removeClass("has-success")
		  .addClass("has-error")
		  .find(".form-control-feedback")
		  .removeClass("glyphicon-ok")
		  .addClass("glyphicon-remove")
		  .show();
		
	}, autoClosingAlert : function(selector, delay) {
		
		var alert = $(selector).alert();
		alert.show();
		window.setTimeout(function() { alert.hide() }, delay);
		
	}, emptyCheckFunc : function() {
		
		emailEmpty = false;
		passwordEmpty = false;
		passwordConfirmEmpty = false;
		nameEmpty = false;
		
		if ( $("#email").val() == "" ) {
			emailEmpty = true;
		}
		if ( $("#password").val() == "" ) {
			passwordEmpty = true;
		}
		if ( $("#passwordConfirm").val() == "" ) {
			passwordConfirmEmpty = true;
		}
		if ( $("#name").val() == "" ) {
			nameEmpty = true;
		}
		
	}, validationCheckFunc : function() {
		
		controller.emptyCheckFunc();
		
		if ( emailEmpty || passwordEmpty || passwordConfirmEmpty || nameEmpty ) {
			
			if ( emailEmpty ) {
				$("#emailMessage").text("이메일을 입력해주세요.").show();
				controller.errorState("#email");
			}	
			if ( passwordEmpty ) {
				$("#passwordMessage").text("비밀번호를 입력해주세요.").show();
				controller.errorState("#password");
				
			}
			if ( passwordConfirmEmpty ) {
				$("#passwordConfirmMessage").text("비밀번호 확인을 입력해주세요.").show();
				controller.errorState("#passwordConfirm");
				
			}
			if ( nameEmpty ) {
				$("#nameMessage").text("이름을 입력해주세요.").show();
				controller.errorState("#name");
				
			}
			return true;
		} else {
				
				if ( emailCheckFlag == true) {
					return true;
				}
				if ( passwordRegCheckFlag == true ) {
					return true;
				}
				return false;
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
	}
	
});

$(document).ready(function() {
	controller.init();
});