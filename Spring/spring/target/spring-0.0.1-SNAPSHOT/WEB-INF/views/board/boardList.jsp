<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
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

#boardList {
	text-align: center;
}

#boardList>tbody>tr:hover {
	cursor: pointer;
}

#pagingArea {
	width: fit-content;
	margin: auto;
}

#searchForm {
	width: 80%;
	margin: auto;
}

#searchForm>* {
	float: left;
	margin: 5px;
}

.select {
	width: 25%;
}

.text {
	width: 48%;
}

.searchBtn {
	width: 20%;
}
</style>
</head>
<body>
	<%@include file="../common/header.jsp"%>

	<div class="outer">
		<br>
		<br>
		<div class="innerOuter" style="padding: 5% 10%">
			<h2>게시판</h2>
			<br>

			<%-- 로그인 시에만 글쓰기 버튼 표시 --%>
			<c:if test="${ not empty loginUser }">
				<a href="enrollForm" class="btn btn-secondary" style="float: right">글쓰기</a>
			</c:if>
			<br> <br>
			<table id="boardList" class="table table-hover" align="center">
				<thead>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
					<th>첨부파일</th>
				</thead>

				<tbody>
					<c:forEach var="b" items="${ list }">
						<tr>
							<td class="bno">${ b.boardNo }</td>
							<td>${ b.boardTitle }</td>
							<td>${ b.boardWriter }</td>
							<td>${ b.count }</td>
							<td>${ b.createDate }</td>
							<td><c:if test="${ not empty b.originName }">■</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>

			<div id="pagingArea">
				<ul class="pagination">
					<c:choose>
						<c:when test="${ pi.currentPage == 1 }">
							<li class="page-item disabled"><a href="#" class="page-link">Prev</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a
								href="list?cpage=${ pi.currentPage - 1 }" class="page-link">Prev</a></li>
						</c:otherwise>
					</c:choose>


					<c:forEach var="i" begin="${ pi.startPage }" end="${ pi.endPage }">
						<li class="page-item"><a href="list?cpage=${i}"
							class="page-link">${ i }</a></li>
					</c:forEach>

					<c:choose>
						<c:when test="${ pi.currentPage >= pi.endPage }">
							<li class="page-item disabled"><a href="#" class="page-link">Next</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a
								href="list?cpage=${pi.currentPage + 1}" class="page-link">Next</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>

			<br clear="both">

			<form action="" id="searchForm">
				<div class="select">
					<select name="condition" id="" class="custom-select form-select">
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
				</div>
				<div class="text">
					<input type="text" class="form-control" name="keyword">
				</div>
				<button class="searchBtn btn btn-secondary">검색</button>
			</form>
			<br>
			<br>
		</div>
		<br>
		<br>
	</div>
	<script>
		$(function() {
		<!-- 게시글 목록의 행을 클릭했을 때 detail 요청을 하도록 -->
			$("#boardList>tbody>tr").click(function() {
				location.href = 'detail?bno='+$(this).children(".bno").text();
			});
		});
	</script>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>