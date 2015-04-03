<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>

<%
	String str ="Hello";

%>

<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	<%= str %><br>
	<%= abs(-5) %>
	<%! //선언문
		String str = "Hello";
	
		public int abs(int n){
			if(n<0){
				n= -n;
				
			}
			return n;
		}
	%>
	
	</body>
</html>