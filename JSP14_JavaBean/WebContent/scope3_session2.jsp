<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="session"/>

<h3>session2<br>cnt와 getCount 호출</h3>
<jsp:getProperty property="count" name="cnt"/>

<a href="scope3_session1.jsp">session1로....</a>