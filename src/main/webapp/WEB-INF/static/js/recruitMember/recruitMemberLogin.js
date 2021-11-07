/**
 * 
 */

$(document).ready(function() {

	$("#email").keyup(function() {			
		emailCheck();
	});
	
	$("#password").keyup(function() {
		$("#passwordMessage").hide();				
	});
	
	function emailCheck() {
		var email = $("#email").val();
		var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		
		if ( reg.test(email) ) {
			$("#emailMessage").hide();
			successState("#email");
			return false;
		} else {
			$("#emailMessage").text("올바른 이메일 형식이 아닙니다. 다시 입력해 주세요.").show();
			errorState("#email");
			return true;
		}
	}
	
	function successState(sel) {
		
		$(sel).closest(".form-group")
  	  	   	  .removeClass("has-error")
  	  	   	  .find(".form-control-feedback")
  	  	   	  .removeClass("glyphicon-ok")
  	  	   	  .removeClass("glyphicon-remove")
  	  	   	  .show();
	}
	
	function errorState(sel) {
		
		$(sel).closest(".form-group")
			  .removeClass("has-success")
			  .addClass("has-error")
			  .find(".form-control-feedback")
			  .removeClass("glyphicon-ok")
			  .addClass("glyphicon-remove")
			  .show();
	}
	
	function autoClosingAlert(selector, delay) {
		var alert = $(selector).alert();
		alert.show();
		window.setTimeout(function() { alert.hide() }, delay);	
	}
	
	function emptyCheck() {
		
		emailEmpty = false;
		passwordEmpty = false;
		
		if ( $("#email").val() == "" ) {
			emailEmpty = true;
		}
		if ( $("#password").val() == "" ) {
			passwordEmpty = true;
		}
	}
	
	function validationCheck() {
		
		emptyCheck();
		
		if ( emailEmpty || passwordEmpty ) {
			if ( emailEmpty ) {
				$("#emailMessage").text("이메일을 입력해주세요.").show();
				errorState("#email");
			}
			if ( passwordEmpty ) {
				$("#passwordMessage").text("비밀번호를 입력해주세요.").show();
				errorState("#password");
			}
			return true;
		} else {
				if ( emailCheck() == true ) {
					return true;
				}
				
				return false;
		}
	}
	
	$("#loginBtn").click(function() {
		
		if ( validationCheck() ) {
			return;
		} else {
			autoClosingAlert("#successMessage", 2000);
			$("#loginForm").attr({
				method:"post", 				     	
		     	action:"/recruitMember/recruitMemberLogin"
			}).submit();	
		}
	});	

	$("passwordFindPopup").click(function() {
		window.open("https://localhost:8080/recruitMember/passwordFindPopup");
	});	
}); 