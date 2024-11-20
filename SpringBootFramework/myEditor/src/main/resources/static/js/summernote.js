/**
 * 
 */
 $(document).ready(function () {
            $('#summernote').summernote({
                placeholder: 'Hello stand alone ui',
                tabsize: 2,
                height: 120,
                toolbar: [
                    ['style', ['style']],
                    ['font', ['bold', 'underline', 'clear']],
                    ['color', ['color']],
                    ['para', ['ul', 'ol', 'paragraph']],
                    ['table', ['table']],
                    ['insert', ['link', 'picture', 'video']],
                    ['view', ['fullscreen', 'codeview', 'help']]
                ],
                callbacks: {
                	onImageUpload: imageUpload
                }
            });

            
              $("#btn-reset").click(function() {
        	initBoard();
        });
        
        $("#btn-write").click(function() {
        	$.ajax({
        		url: "/board",
        		method: "post",
        		data: {
        			title: $('#title').val(),
        			content: $('#summernote').summernote('code')
        		},
        		success: function(result) {
        			console.log(result);
        			initBoard();
        		},
        		error: function(err) {
        			console.log(err);
        		}
        	});
        });
        });
        
        function initBoard() {
        	$('#title').val("");
        	$('#summernote').summernote('code', "");
        }
        
        function imageUpload(imgList) {
        	const formData = new FormData();
        	for(let file of imgList) {
        		formData.append("imgList", file);
        	}
        	
        	$.ajax({
        		url: 'upload',
        		type: 'post',
        		data: formData,
        		processData: false,
        		contentType: false,	//application/x-www-form-... (default) -> multipart/form-data
        		//dataType: "json",
        		success: (result) => {
        			console.log(result);
        			for(let imgSrc of result) {
        				$("#summernote").summernote("editor.insertImage", imgSrc);
        			}
        		},
        		error: (err) => {
        			console.log(err);
        			alert('문제가 발생했습니다.');
        		}
        	})
        }