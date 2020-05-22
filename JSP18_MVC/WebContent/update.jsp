<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="com.lec.beans.*" %>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/>



<% //DAO 사용한 트랜잭션
	WriteDTO[] arr = (WriteDTO [])request.getAttribute("selec");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정 <%= arr[0].getSubject() %></title>
</head>
<script>
function chkSubmit(){
	frm = document.forms['frm'];
	var subject = frm['subject'].value.trim();
	
	if(subject==""){
		alert("제목은 반드시 작성하셔야 합니다");
		frm['subject'].focus();
		return false;
	}
		return true;
}
</script>
<body>
<h2>수정</h2>
<form name = "frm" action="updateOk.do" method="post" onsubmit="return chkSubmit()">
<input type="hidden" name ="uid" value="<%= arr[0].getUid() %>">
작성자 : <%= arr[0].getName() %><br> <%-- 작성자 이름 변경 불가 --%>
제목 : 
<input type="text" name="subject" value="<%= arr[0].getSubject() %>"><br>
내용 : <br>
<textarea name="content"><%= arr[0].getContent() %></textarea>
<br>
<input type="submit" value="수정"/>
</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.jsp'">목록보기</button>


</body>
</html>