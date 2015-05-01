<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>


<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	<h1>두 번째 페이지</h1>
	<hr>
	page 영역 : <%=pageContext.getAttribute("page") %><br> <!--리턴타입이 오브젝트 이므로 나중에 형변환 사용할지도.  -->
	request 영역: <%=request.getAttribute("request") %><br>
	session 영역: <%=session.getAttribute("session") %><br>
	application 영역: <%=application.getAttribute("application") %><br>
	
	</body>
</html>