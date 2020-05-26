<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public static final String ADMIN_ID = "admino";
	public static final String ADMIN_PW = "1234";
%>

<%
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	
	// userid / pw 일치하면 로그인 성공 + 쿠키 생성
	if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
		out.println("<script>");
		out.println("alert('로그인 성공ㅎㅎ')");
		out.println("</script>");
		
		String sessionName1 = "userid";
		String sessionValue1 = userid; // 이 경우 admino가 들어감.

		session.setAttribute(sessionName1, sessionValue1);
		
	} else {
		out.println("<script>");
		out.println("alert('로그인 실패ㅎㅎ')");
		out.println("</script>");
		
	} // end if
%>


<script>
location.href="login.jsp";
</script>
