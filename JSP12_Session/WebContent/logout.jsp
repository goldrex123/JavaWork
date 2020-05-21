<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessionName = "userid";

	//세션 삭제
	session.removeAttribute(sessionName);

%>
<script>
alert("로그아웃되었습니다ㅎㅎ")
location.href="login.jsp";
</script>