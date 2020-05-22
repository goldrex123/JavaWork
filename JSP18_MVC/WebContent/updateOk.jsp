<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="com.lec.beans.*" %>

<%
	int uid = Integer.parseInt(request.getParameter("uid"));
%>

<% 
	int cnt = (Integer)request.getAttribute("seleok");
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
		location.href = "view.do?uid=<%= uid%>";
	</script>
<% } %>











