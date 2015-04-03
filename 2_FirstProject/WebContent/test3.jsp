<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    
	out.print("JSP <br>");/*내장객체  */ 
	String name = request.getParameter("name");/*request도 내장객체  */
    
	
	out.print("이름:"+name+"<br>");
    
    
    
    
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:<font color="blue"><%=name %></font>
</body>
</html>