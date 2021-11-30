/**
 * 
 */
var controller = $.extend(new $.CommonObj(), {
	eventInit:function() {
		
	},
	onCreate:function() {
		
		 $("#recruitmentQuestionEmailBtn").click(function() {
			 
				if ( $("#title").val() == "" ) {
					$("#checkMessage").html("메일제목을 작성해주세요.");
					$("#messageModal").modal("show");
					return false;
				}
				
				if ( $("#content").val() == "" ) {
					$("#checkMessage").html("메일내용을 작성해주세요.");
					$("#messageModal").modal("show");
					return false;
				}
					
				controller.autoClosingAlert("#successMessage", 10000);
				$("#recruitmentQuestionEmailForm").attr({
					method:"post", 
			     	action:"/recruitmentQuestion/recruitmentQuestion.do"					
				}).submit();
				
		 });
	}
});

$(document).ready(function() {
	controller.init();
});
