<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="com.lec.beans.*" %>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/>
<%
	//parameter 받아오기
	request.setCharacterEncoding("utf-8");
	int uid = Integer.parseInt(request.getParameter("uid"));
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	// 파라매터 검증 필요 but 생략
%>

<% // DAO 사용한 트랜잭션
	int cnt = dao.update(uid, subject, content);
%>


<%-- 위 트랜잭션이 마무리되면 페이지 보여주기 --%>
<% if(cnt == 0) { %>
	<script>
		alert('수정 실패');
		history.back();
	</script>
<% } else { %>
	<script>
		alert("수정 성공");
		location.href = "view.jsp?uid=<%= uid%>";
	</script>
<% } %>











