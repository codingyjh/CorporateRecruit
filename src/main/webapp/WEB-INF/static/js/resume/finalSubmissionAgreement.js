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
			
			controller.LoadingWithMaskFunc();
			setTimeout("controller.closeLoadingWithMaskFunc()", 10000);
			//controller.autoClosingAlert("#successMessage", 2000);
			$("#finalSubmissionAgreeForm").attr({
				method:"post", 
		     	action:"/resume/finalSubmissionAgreement.do/" + resumeId					
			}).submit();
		});
		
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