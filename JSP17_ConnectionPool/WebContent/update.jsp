<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="com.lec.beans.*" %>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/>

<%
	//parameter 체크
	int uid = Integer.parseInt(request.getParameter("uid"));
	// 이 단계에서 parameter 검증 필요 but 생략 (없거나 값과 다르거나)
%>

<% //DAO 사용한 트랜잭션
	WriteDTO[] arr = dao.selectByUid(uid);
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

<%!
	//쿼리문 준비
	final String SQL_WRITE_SELECT_BY_UID =
			"SELECT * FROM test_write WHERE wr_uid = ?";
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정 <%= subject %></title>
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
<form name = "frm" action="updateOk.jsp" method="post" onsubmit="return chkSubmit()">
<input type="hidden" name ="uid" value="<%=uid %>">
작성자 : <%= name %><br> <%-- 작성자 이름 변경 불가 --%>
제목 : 
<input type="text" name="subject" value="<%= subject %>"><br>
내용 : <br>
<textarea name="content"><%= content %></textarea>
<br>
<input type="submit" value="수정"/>
</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.jsp'">목록보기</button>


</body>
</html>