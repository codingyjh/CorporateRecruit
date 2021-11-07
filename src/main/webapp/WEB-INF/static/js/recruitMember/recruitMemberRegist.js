/**
 * 
 */


var controller = $.extend(new $.CommonObj(), {
	eventInit:function() {
		
	},
	onCreate:function() {
		
		$("#registBtn").click(function() {
			
			 $("#registForm").attr({
					method:"post", 					     				     	
			     	action:"/recruitMember/recruitMemberRegist"
			 }).submit();
			
		});
		
	}	
});


$(document).ready(function() {
	controller.init();
});