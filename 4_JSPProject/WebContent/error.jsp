<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@page isErrorPage="true" %>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
Error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!<br>
<%= exception.getMessage() %>
	</body>
</html>