<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<img src="<%= request.getContextPath() %>/myRes/apple.png"/><br>

<img src="/sts09_mvc/resources/img/apple.png"/><br>
<img src="<%= request.getContextPath() %>/resources/img/apple.png"/><br>
<img src="${pageContext.request.contextPath }/resources/img/apple.png"/><br>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
