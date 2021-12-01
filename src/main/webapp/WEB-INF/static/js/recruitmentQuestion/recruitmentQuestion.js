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
					
				controller.LoadingWithMaskFunc();
				setTimeout("controller.closeLoadingWithMaskFunc()", 20000);
				//controller.autoClosingAlert("#successMessage", 2000);
				$("#recruitmentQuestionEmailForm").attr({
					method:"post", 
			     	action:"/recruitmentQuestion/recruitmentQuestion.do"					
				}).submit();
				
		 });
		 
	}, autoClosingAlert : function(selector, delay) {
		
		var alert = $(selector).alert();
		alert.show();
		window.setTimeout(function() { alert.hide() }, delay);
		
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
