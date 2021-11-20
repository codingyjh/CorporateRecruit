/**/
var controller = $.extend(new $.CommonObj(), {
	eventInit:function() {
		
	},
	onCreate:function() {
		let getContent;
		let contentTxt;
		
		ClassicEditor
			.create(document.querySelector("#content"), {
				ckfinder: {
					uploadUrl: 'https://localhost:8080/recruitBoard/recruitBoardImageFileUpload.do'
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
		
		$("#updateBtn").click(function() {
			
			var boardId = $("#boardId").val();
			
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
			$("#boardUpdateForm").attr({
				method:"post", 
		     	action:"/recruitBoard/recruitBoardUpdate.do/" + boardId,
		     	enctype:"multipart/form-data"
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