<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Session List</title>
</head>
<body>
<%
	if(request.isRequestedSessionIdValid()){
		out.println("유효한 세션이 있습니다<hr>");
	} else {
		out.println("유효한 세션이 없습니다<hr>");
	}

	String sessionName, sessionValue;
	
	// 현재 세션의 모든 name 들 가져오기
	Enumeration<String> enumer = session.getAttributeNames(); // Enumeration<String> 리턴
	
	int i = 0;
	while(enumer.hasMoreElements()){
		
		sessionName = enumer.nextElement();
		
		//session.getAttribute(sessionName) <-- 특정 name의 세션값 추출, name 없으면 null 리턴
		sessionValue = session.getAttribute(sessionName).toString();
		out.println((i+1) + "] " + sessionName + " : " + sessionValue + "<br>");
	
		i++;
	}
	
	if(i==0){
		out.println("세션이 없습니다<br>");
	}
%>

<hr>
<form action="sessionCreate.jsp">
	<input type="submit" value="세션생성">
</form>

<br>
<form action="sessionDelete.jsp">
	<input type="submit" value="세션삭제">
</form>

<hr>
<%
	String sessionId = session.getId();
	int sessionInteval = session.getMaxInactiveInterval();
	
	out.println("세션ID : " + sessionId + "<br>");
	out.println("세션 유효시간 : " + sessionInteval + "<br>");
%>

<%
	out.println("----- session.invalidate() 후 -----<br>");
	// 세션 무효화 invalidate
	// 기존 세션테이블 삭제 (session id 무효화)
	//	- 그 안의 모든 attribute(이름)도 삭제됨 
	// 새로운 세션테이블 생성
	
	//session.invalidate();
	
	sessionId = session.getId();
	sessionInteval = session.getMaxInactiveInterval();
	out.println("세션ID : " + sessionId + "<br>");
	out.println("세션 유효시간 : " + sessionInteval + "<br>");
%>
</body>
</html>
















