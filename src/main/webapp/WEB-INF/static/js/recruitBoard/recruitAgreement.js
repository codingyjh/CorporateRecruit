/**
 * 
 */
var controller = $.extend(new $.CommonObj(), {
	eventInit:function() {
		
	},
	onCreate:function() {
		
		$("#agreeBtn").click(function() {
			
			var boardId = $("#boardId").val();
			
			var agreementCheck = $("#agree").prop("checked");
			if ( !agreementCheck ) {
				$("#checkMessage").html("동의합니다. 체크를 해주셔야 다음 진행을 하실 수 있습니다.");
				$("#messageModal").modal("show");
				return false;
			} 
			
			controller.autoClosingAlert("#successMessage", 2000);
			$("#agreeForm").attr({
				method:"post", 
		     	action:"/Recruit/recruitBoard/recruitAgreement.do/" + boardId					
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