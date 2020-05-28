<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.net.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<% request.setCharacterEncoding("utf-8"); %>

<%
	String[] original = request.getParameterValues("original");
	String[] fileSystemNames = request.getParameterValues("fileSystemName");
	int cnt = original.length;
%>	

<c:set var="original" value="${paramValues.original }"/>
<c:set var="fileSystemNames" value="${paramValues.fileSystemName }"/>
<c:set var="cnt" value="${fn:length(original)}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>파일 확인 & 다운로드 링크</title>
<style>
form p{text-decoration: underline;}
form p:hover{cursor: pointer; color: blue;}
</style>
</head>
<body>
<h3><%= cnt %>개의 파일 확인</h3>
<ul>
<%
	for(int i =0; i<cnt; i++){
		out.println("<li>파일: " + (i+1) + "</li>");
		out.println("<ul>");
		out.println("<li>원본이름: " + original[i] + "</li>");
		out.println("<li>파일시스템: " + fileSystemNames[i] + "</li>");
		out.println("</ul>");
	}
%>
</ul>

<!-- jstl 버전 -->
<h3>${cnt } 개의 파일 확인</h3>
<ul>
<c:forEach var="element" items="${original }" varStatus="status">
		<li>파일: ${status.count}</li>
		<ul>
		<li>원본이름 : ${element }</li>
		<li>파일시스템 : ${fileSystemNames[status.index] }</li>
		</ul>
	</c:forEach>
</ul>

<hr>
<%-- GET방식 request시 url 에  한글이나 띄어쓰기 등이 들어가선 안되기 때문에 반드시 URLEncoder 로 처리 해야 한다
X ] http://localhost:8080/JSP18_FileUpload/FileDownload.jsp?fileSystemName=8퍼센트.ipynb
O ] http://localhost:8080/JSP18_FileUpload/FileDownload.jsp?fileSystemName=8%ED%8D%BC%EC%84%BC%ED%8A%B8.ipynb
java.net.URLEncoder  임포트!
--%>
<h3>다운로드 링크 1: get + Java</h3>
<%for(int i =0; i<original.length; i++){ %>
	<!-- 화면에는 원본이름으로, 실제 링크는 업로드 저장된 이름으로 -->
	<%
		String fname = URLEncoder.encode(fileSystemNames[i], "utf-8");
		String oname = URLEncoder.encode(original[i], "utf-8");
	%>
	
	<a href="FileDownload.jsp?fileSystemName=<%=fname%>&original=<%=oname%>">
		<%=original[i] %>
	</a>
	<br>
<%} %>

<h3>다운로드 링크2: post + java	</h3>
<%for(int i =0; i<original.length; i++){ %>
<form name="frm<%=i%>" action="FileDownload.jsp" method="post">
	<input type="hidden" name="fileSystemName" value="<%= fileSystemNames[i]%>"/>
	<input type="hidden" name="originalFileName" value="<%= original[i]%>"/>
	<p onclick="document.forms['frm<%=i%>'].submit()"><%= original[i]%></p>
</form>
<%} %>

<h3>다운로드 링크3: post + JSTL	</h3>
<c:forEach var="i" begin="0" end="${cnt-1 }">
<form name="ifrm${i }" action="FileDownload.jsp" method="post">
	<input type="hidden" name="fileSystemName" value="${fileSystemNames[i] }"/>
	<input type="hidden" name="originalFileName" value="${original[i] }"/>
	<p onclick="document.forms['ifrm${i}'].submit()">${original[i] }</p>
</form>

</c:forEach>

<hr>
<!-- 웹 경로에 이미지 저장한 경우 -->
<h3>이미지 보기</h3>
<%for(int i =0; i<original.length; i++){ %>
<div style="width: 300px">
	<img style="width: 100%; height:auto" src="upload/<%=fileSystemNames[i]%>"/>
</div>
<%} %>


</body>
</html>























