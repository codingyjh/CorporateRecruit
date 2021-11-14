/**
 * 
 */
var controller = $.extend(new $.CommonObj(), {
	eventInit:function() {
		
	},
	onCreate:function() {
		let getContent;
		let contentTxt;
		
		ClassicEditor
			.create(document.querySelector("#content"), {
				ckfinder: {
							uploadUrl: 'http://localhost:8080/recruitBoard/recruitBoardImageFileUpload'
				},
				alignment: {
					options: ['left', 'center', 'right']
				}
			})
			.then(content => {
				getContent = content;
			})
			.catch( error => {
				console.error(error);
			});
		
		$("#fileSearchBtn").click(function() {
			var file = $(this).parent().parent().parent().find('.file');
			file.trigger('click');
		});
		
		$("#createBtn").click(function() {
			if ( $("#recruitDt").val() == "") {
				
				$("#checkMessage").html("채용마감을 입력해주세요.");
				$("#messageModal").modal("show");
				return false;
			}
			
			if ( $("#title").val() == "") {
				
				$("#checkMessage").html("글 제목을 입력해주세요.");
				$("#messageModal").modal("show");
				return false;
			}
			
			contentTxt = getContent.getData();
			
			if( contentTxt == null || contentTxt == '' ) {
				$("#checkMessage").html("글 내용을 입력해주세요.");
				$("#messageModal").modal("show");
				return false;				
			}
			
			controller.autoClosingAlert("#successMessage", 2000);
			$("#boardWriteForm").attr({
				method:"post", 
		     	action:"/recruitBoard/recruitBoardWrite",
		     	//enctype:"multipart/form-data"
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