<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common/header.jsp" />
	<div class="outer">
		<div class="inner-area">
			<table id="toplist" class="table table-hover" align="center">
				<thead>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
					<th>첨부파일</th>
				</thead>
	
				<tbody></tbody>
			</table>
		</div>
		
		<script>
		$(function() {
			boardTopList();
		});
		
		function boardTopList() {
			let tableValue = "";
			let file = "";
			$.ajax({
				url: "board/top5",
				success: function(result) {
					if(result != null & result.length > 0) {
						for(let board of result) {
							if(board.originName != null) {
								file = "■";
							} else {
								file ="";
							}
							
							tableValue += "<tr>"
								+ "<td class='bno'>" + board.boardNo + "</td>"
								+ "<td>" + board.boardTitle + "</td>"
								+ "<td>" + board.boardWriter + "</td>"
								+ "<td>" + board.count + "</td>"
								+ "<td>" + board.createDate + "</td>"
								+ "<td>" + file + "</td>"
								+"</tr>";
						}
						
						$('#toplist tbody').html(tableValue);
					}
				},
				error: function(err) {
					
				}
			});
		}
		</script>
	</div>
	<jsp:include page="common/footer.jsp" />
</body>
</html>