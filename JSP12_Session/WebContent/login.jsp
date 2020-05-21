<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인 페이지</title>
</head>
<body>

<%! int i = 0; %>
<% if(session.getAttribute("userid") == null) {  %>
		<h2>로그인 상태가 아닙니다</h2>
		<form action="loginOk.jsp">
			id:<input type="text" name="userid"><br>
			pw:<input type="password" name="pw"><br>
			<input type="submit" value="로그인"><br>
		</form>
<% 	} else { %>
		<h2>로그인 상태 입니다.</h2>
		<form action="logout.jsp">
			<input type="submit" value="로그아웃"><br>
		</form>
<% 	} %>

</body>
</html>