<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	<%
		session.removeAttribute("loginID"); //로그인ID라는 이름의 세션값을 지워버린다.
		session.invalidate(); //여러개 저장 했을시 사용하는 방법 --- 세션에 들어있는 값 모두 지워버림
		response.sendRedirect("main.jsp");
	%>
	</body>
</html>