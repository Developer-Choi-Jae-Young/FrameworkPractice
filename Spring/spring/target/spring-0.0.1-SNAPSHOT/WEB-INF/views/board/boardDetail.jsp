<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<style>
.outer {
	background-color: #e7e7e7;
	width: 80%;
	margin: auto;
}

.inner-area {
	border: 1px solid #000025;
	width: 80%;
	margin: auto;
	padding: 5% 15%;
	background: #e7ecf7;
}

table {
	width: 100%;
}

table * {
	margin: 5px;
}
</style>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="outer">
		<br> <br>
		<div class="inner-area">
			<h2>게시글 상세보기</h2>
			<br> <a href="list" class="btn btn-secondary"
				style="float: right;">목록보기</a> <br> <br>

			<table align="center" class="table">
				<tr>
					<th width="100">제목</th>
					<td colspan="3">${ board.boardTitle }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${ board.boardWriter }</td>
					<th>작성일</th>
					<td>${ board.createDate }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"><c:choose>
							<c:when test="${ not empty board.originName }">
								<a href="<%= contextPath %>/${board.changeName}"
									download="${board.originName}">${ board.originName }</a>
							</c:when>
							<c:otherwise>
                    			첨부파일 없음
                    		</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4">
						<p style="height: 150px;">${ board.boardContent }</p>
					</td>
				</tr>
			</table>
			<br>

			<div align="center">
				<!-- 작성자와 로그인한 계정이 동일한 경우만 표시 -->
				<c:if test="${loginUser.userId eq board.boardWriter}">
					<a class="btn btn-primary" onclick="postSubmit('update');">수정</a>
					<a class="btn btn-danger" onclick="postSubmit('delete');">삭제</a>
				</c:if>
			</div>
			<br> <br>
			<form action="" method="post" id="postForm">
				<input type="hidden" name="bno" value="${ board.boardNo }">
			</form>

			<script>
				function postSubmit(type){
					const postForm = document.getElementById("postForm");
					
					if(type == 'update') {
						// 게시글 수정 페이지로 요청
						postForm.action = 'updateForm';					
					} else if(type == 'delete'){
						// 게시글 삭제 요청
						postForm.action = 'delete';
					}
					
					postForm.submit();
				}
			</script>

			<table id="replyArea" class="table" align="center">
				<thead>
					<%-- 
							* 로그인한 사용자만 댓글을 작성할 수 있도록
								=> 만약, 로그인을 하지 않았다면 
													입력창 부분에 '로그인 후 이용가능합니다.' 메시지를 표시하고 입력하지 못하도록
													[등록] 버튼을 비활성화  
					--%>
					<c:choose>
						<c:when test="${ not empty loginUser }">
							<tr>
								<th colspan="2"><textarea name="" id="content" cols="55"
										rows="2" class="form-control" style="resize: none;"></textarea>
								</th>
								<th style="vertical-align: middle;">
									<button class="btn btn-secondary" onclick="addReply();">등록</button>
								</th>
							</tr>
							<tr>
								<td colspan="3">댓글 (<span id="rcount">0</span>)
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<th colspan="2"><textarea name="" id="content" cols="55"
										rows="2" class="form-control" style="resize: none;" readonly placeholder="로그인 후 이용가능합니다."></textarea>
								</th>
								<th style="vertical-align: middle;">
									<button class="btn btn-secondary" disabled>등록</button>
								</th>
							</tr>
							<tr>
								<td colspan="3">댓글 (<span id="rcount">0</span>)
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</thead>
				<tbody></tbody>
			</table>
			<br> <br>
		</div>
	</div>

	<script>
    	$(function() {
    		// 해당 게시글의 댓글 목록 조회(ajax)
    		selectReplyList();
    	});
    	
    	function selectReplyList() {
    		$.ajax({
    			url: "rlist",
    			data: {
    				bno: ${board.boardNo}	
    			},
    			success: function(result) {
    				console.log(result);
    				
    				// 댓글 목록이 있을 경우 화면에 표시
    				// => 댓글 목록 없을 경우 : 빈 배열
    				// => 댓글 목록 있는 경우 : 배열에 데이터 담겨져있음
    				if(result != null && result.length) {
    					let replyValue = "";
    					
    					for(let r of result) {
    						replyValue += "<tr>"
    									 +"<th>" + r.replyWriter +"</th>"
    									 +"<td>" + r.replyContent +"</td>"
    									 +"<td>" + r.createDate +"</td>"
    									 +"</tr>";
    									 
    					$("#replyArea tbody").html(replyValue);
    					$("#rcount").text(result.length);
    					}
    				}
    			},
    			error: function(err) {
    				console.log("댓글 조회 실패!");
    				console.log(err);
    			}
    		});
    	}
    	
    	function addReply() {
			// 댓글 추가 요청 (ajax)
			// => /spring/board/rinsert?replyContent=입력된내용&refBno=게시글번호&replyWriter=작성자
					
			if($('#replyArea #content').val().trim().length > 0) {
				$.ajax({
					url: "rinsert",
					data: {
						replyContent: $('#replyArea #content').val(),
						refBno: ${board.boardNo},
						replyWriter: "${ board.boardWriter }"
					},
					success: function(result) {
						console.log(result);
						if(result == 'success') {
						// 댓글 추가 성공 시, 입력창 부분을 초기화 댓글 목록 다시 조회
							$('#replyArea #content').val('');
							selectReplyList();
						} else {
						// 댓글 추가 실패 시, '댓글 추가에 실패했습니다.' 메시지를 출력(alert)
							alert('댓글 추가에 실패했습니다.');
						}
					},
					error: function(err) {
						console.log(err);
					}
				});	
			} else {
				alert("내용 입력 후 추가 가능합니다.");
			}
		}	
    </script>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>