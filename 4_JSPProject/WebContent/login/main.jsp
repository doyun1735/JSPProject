<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	<h1>환영 합니다.</h1>
	<hr>
	<%
		String id = (String) session.getAttribute("loginID");
	
	
	%>
	
	
	
	<%
		if(id != null){
			
		
		
			
	
	
	%>
	
	<font color="pink"><%=id  %></font>님 환영합니다.
	
	<form action="logout.jsp"> <!--로그아웃 jsp 파일로 들어가서 세션을 지워버리면 된다.  -->
		<input type ="submit" value="로그 아웃">
		
	</form>
<a href="logout.jsp">로그아웃</a>
	<%
		}
		else{
			response.sendRedirect("loginForm.jsp");
		}
	%>
	
	</body>
</html>