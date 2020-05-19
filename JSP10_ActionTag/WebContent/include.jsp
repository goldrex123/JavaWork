<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.net.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>include</title>
</head>
<body>
<!-- action tag -->
<h3>지금의 페이지는 include 페이지 입니다.</h3>
<jsp:include page="sub.jsp"/>
<p>위라인의 내용은 sub 페이지의 내용입니다</p>

<hr>

<h3>지금의 페이지는 include 페이지 입니다.</h3>
<%@ include file="sub.jsp" %>
<p>위라인의 내용은 sub 페이지의 내용입니다</p>

<hr>

<%!
	//변수 선언
	String name ="홍길동";
	int age = 33;
%>
<%-- <%@ include file="sub2.jsp" %> 코드 변환시 합쳐지기 때문에  sub2가 오류여도 동작--%>
<%-- <jsp:include page="sub2.jsp"/> 코드 변환 하고 합쳐지는데 sub2가 컴파일이 안되서 오류남 --%>

<jsp:include page="sub3.jsp">
	<jsp:param value='<%= URLEncoder.encode(name, "utf-8") %>' name="name"/>
	<jsp:param value="<%= age %>" name="age"/>
</jsp:include>
</body>
</html>