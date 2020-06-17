<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/common.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/JS/category.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>다단계 카테고리 - select 하기</title>
</head>
<body>
<h2>다단계 카테고리 -select하기</h2>
<div class="cate" id="mycate">
<span>
	<select id='first' disabled></select>
</span>
<span>
	<select id='second' disabled></select>
</span>
<span>
	<select id='third' disabled></select>
</span>
</div>
</body>
</html>