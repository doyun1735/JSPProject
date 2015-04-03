<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ page import ="java.io.*" %>
<%@ page errorPage="error.jsp" %><!--에러가 발생시 이쪽 페이지로 넘어간다.  -->
<% 
	out.print("Hello");
 
	int num1=10,num2=20;
	int num3= num1 +num2;
	out.print(num3);
	
	out.print(2/0);
 %>
<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	
	</body>
</html>