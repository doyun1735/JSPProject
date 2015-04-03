<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	<h1> 어플리케이션 내장객체</h1>
	<table border="1">
	<tr>
		<td>ServerInfo()</td>
		<td><%= application.getServerInfo() %></td>
	</tr>
	<tr>
		<td>Contextpath()</td>
		<td><%= application.getContextPath() %>
	</tr>
	<tr>
	<td>RealPath()</td>
	<td><%= application.getRealPath(".") %> <!-- .이 현재 폴더를 얘기한다. -->
	</tr>
	
	</body>
</html>