<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>

<%
	WriteDTO[] arr = (WriteDTO [])request.getAttribute("read");
%>

<%-- 
<%	// dao 사용한 트랜잭션 
	WriteDTO [] arr = dao.readByUid(uid);
%>

<%
	if(arr==null || arr.length ==0){
%>
				<script>
					alert("해당 정보가 삭제되거나 없습니다");
					history.back();
				</script>
<%
		return; // 더 이상 JSP 프로세싱 하지 않고 종료
	}
%>
<%
	String name = arr[0].getName();
	String subject = arr[0].getSubject();
	String content = arr[0].getContent();
	String regDate = arr[0].getRegDate();
	int viewCnt = arr[0].getViewCnt();
%>
--%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>읽기 <%= arr[0].getSubject() %></title> <!--  타이틀에 글 제목 보기  -->
</head>
<script>
	function chkDelete(uid){
		// 삭제 여부, 다시 확인하고 진행하기
		var r = confirm("삭제 하시겠습니까??");
		if(r){
			location.href="deleteOk.do?uid=" + uid;
		}
	}
</script>
<body>
<h2>읽기 <%= arr[0].getSubject() %></h2>
<br>
UID : <%= arr[0].getUid() %><br>
작성자 : <%= arr[0].getName() %><br>
제목 : <%= arr[0].getSubject() %><br>
등록일 : <%= arr[0].getRegDate() %><br>
조회수 : <%= arr[0].getViewCnt() %><br>
내용 : <br>
<hr>
<div>
	<%= arr[0].getContent() %>
</div>
<hr>
<br>
<button onclick="location.href='update.do?uid=<%=arr[0].getUid()%>'">수정하기</button>
<button onclick="location.href='list.do'">목록보기</button>
<button onclick="chkDelete(<%=arr[0].getUid()%>)">삭제하기</button>
<button onclick="location.href = 'write.do'">신규등록</button>
</body>
</html>