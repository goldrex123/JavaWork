<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<%
	// 사용자 컴퓨터 안의 쿠키 정보는 request 시에 서버로 전달된다
	// request.getCookies() 로 받아 온다
	Cookie[] cookies = request.getCookies(); //cookie[] 배열 리턴
	
	if(cookies != null){ // 만약 쿠기가 하나도 없다면  null 리턴
		for(int i = 0 ; i < cookies.length; i++){
			String name = cookies[i].getName(); // 쿠키 이름
			String value = cookies[i].getValue();
			
			out.println((i+1) + "]" + name + " : " + value + "<br>");
		}
		
	} else {
		out.println("쿠키가 없습니다<br>");
	}
%>

<hr>
<form action="cookieCreate.jsp">
	<input type="submit" value ="쿠키생성&갱신">
</form>
<br>
<form action="cookieDelete.jsp">
	<input type="submit" value ="쿠키삭제">
</form>

</body>
</html>