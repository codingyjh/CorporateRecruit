/**
 * 
 */

$(document).ready(function() {
			
	$("#loginBtn").click(function() {
		
		$("#loginForm").attr({
			method:"post", 				     	
	     	action:"/recruitMember/recruitMemberLogin"
		}).submit();
	});

}); 