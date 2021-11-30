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
			$("#passwordMessage").hide();				
		});
		
		$("#loginBtn").click(function() {
			
			if ( controller.validationCheckFunc() ) {
				return;
				
			} else {
				controller.LoadingWithMaskFunc();
				setTimeout("controller.closeLoadingWithMaskFunc()", 10000);
				//controller.autoClosingAlert("#successMessage", 2000);
				$("#loginForm").attr({
					method:"post", 				     	
			     	action:"/recruitMemberLogin.do"
				}).submit();	
			}
		});
		
		$("passwordFindPopup").click(function() {
			window.open("http://localhost:8080/recruitMember/passwordFindPopup.do")
		});
		
	}, emailCheckFunc : function() {
		
		var email = $("#email").val();
		var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		
		if ( reg.test(email) ) {
			$("#emailMessage").hide();
			controller.successState("#email");
			return false;
			
		} else {
			$("#emailMessage").text("올바른 이메일 형식이 아닙니다. 다시 입력해 주세요.").show();
			controller.errorState("#email");
			return true;
		}
		
	}, successState : function(sel) {
	
		$(sel).closest(".form-group")
  	   	  .removeClass("has-error")
  	   	  .find(".form-control-feedback")
  	   	  .removeClass("glyphicon-ok")
  	   	  .removeClass("glyphicon-remove")
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
		
	}, validationCheckFunc : function() {
		
		controller.emptyCheckFunc();
		
		if ( emailEmpty || passwordEmpty ) {
			
			if ( emailEmpty ) {
				$("#emailMessage").text("이메일을 입력해주세요.").show();
				controller.errorState("#email");
			}
			
			if ( passwordEmpty ) {
				$("#passwordMessage").text("비밀번호를 입력해주세요.").show();
				controller.errorState("#password");
			}
			
			return true;
			
		} else {
			
			if ( controller.emailCheckFunc() == true ) {
				return true;
			}
			
			return false;
		}
		
	}, emptyCheckFunc : function() {
		
		emailEmpty = false;
		passwordEmpty = false;
		
		if ( $("#email").val() == "" ) {
			emailEmpty = true;
		}
		
		if ( $("#password").val() == "" ) {
			passwordEmpty = true;
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