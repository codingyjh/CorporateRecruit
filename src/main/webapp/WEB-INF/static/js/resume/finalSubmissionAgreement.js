/**
 * 
 */
var controller = $.extend(new $.CommonObj(), {
	
	eventInit:function() {
		
	},
	onCreate:function() {
		
		$("#finalSubmissionAgreeBtn").click(function() {
			
			var agreementCheck = $("#agree").prop("checked");
			
			if ( !agreementCheck ) {
				$("#errorAlertMessage").html("동의합니다. 체크를 해주셔야 최종제출을 하실 수 있습니다.");
				$("#errorMessageModal").modal("show");
				return false;
			} 
			
			var resumeId = $("#resumeId").val();
			
			controller.autoClosingAlert("#successMessage", 2000);
			$("#finalSubmissionAgreeForm").attr({
				method:"post", 
		     	action:"/resume/finalSubmissionAgreement.do/" + resumeId					
			}).submit();
		});
		
	}, autoClosingAlert : function(selector, delay) {
		
		var alert = $(selector).alert();
		alert.show();
		window.setTimeout(function() { alert.hide() }, delay);	
		
	}
});

$(document).ready(function() {
	controller.init();			
});