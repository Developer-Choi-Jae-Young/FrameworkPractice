<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
	.login-area > *{
		float: right;
	}

	.login-area a {
		text-decoration: none;
		color: black;
		font-size: 12px;
	}

	.nav-area{
		background-color: lightblue;
	}

	.menu {
		display: table-cell;
		width: 150px;
		height: 50px;
	}

	.menu a {
		text-decoration: none;
		color: white;
		font-size: 20px;
		font-weight: 900;
		display: inline-block;
		width: 100%;
		height: 100%;
		line-height: 50px;
	}

	.menu a:hover {
		background-color: pink;
	}
</style>
</head>
<body>
<%
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
	<% if(alertMsg != null) { %>
	<script>
		alert("<%= alertMsg %>");
	</script>		
	<% session.removeAttribute("alertMsg"); %>
	<% } %>
	
	<h1 align="center">Hello My World!</h1>

	<div class="login-area">	
		<c:choose>
			<c:when test="${ empty loginUser }">
				<!-- 로그인 전 -->
				<form action="<%= contextPath %>/login.me" method="post">
					<table>
						<tr>
							<th>아이디</th>
							<td>
								<input type="text" name="userId" required>
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>
								<input type="password" name="userPwd" required>
							</td>
						</tr>
						<tr>
							<th colspan="2">
								<button type="submit">로그인</button>
								<button type="button" onclick="enrollPage();">회원가입</button>
							</th>
						</tr>
					</table>
					<script>
						// 회원가입 페이지 요청
						function enrollPage() {							
							// 서블릿을 사용하여 페이지 요청
							location.href = "<%= contextPath %>/enrollForm.me"
						}
					</script>
				</form>
			</c:when>
			<c:otherwise>
				<!-- 로그인 후 -->
				<div>
					<b>${ loginUser.userName }</b>님의 방문을 환영합니다 ^^ <br><br>
		
					<div align="center">
						<a href="<%= contextPath %>/myPage.me">마이페이지</a>
						<a href="<%= contextPath %>/logout.me">로그아웃</a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		
	</div>

	<br clear="both">
	<br>

	<div class="nav-area" align="center">
		<div class="menu"><a href="<%= contextPath %>">HOME</a></div>
		<div class="menu"><a href="#">공지사항</a></div>
		<div class="menu"><a href="#">일반게시판</a></div>
		<div class="menu"><a href="#">사진게시판</a></div>
	</div>
	
	<script>
		document.title = "MyBatis";
	</script>
</body>
</html>