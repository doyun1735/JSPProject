<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>


<%
	String id =request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	if(id.equals("test") && pwd.equals("1234")){
		//out.print("로그인 성공");
		
		session.setAttribute("loginID", id);
		//이름을 loginID라는 이름으로 id =test값을 저장을 한다. 세션에 저장하므로 main으로 가도 유지가 된다.
		response.sendRedirect("main.jsp");
	}
		
	else{
		//out.print("로그인 실패");
		response.sendRedirect("loginForm.jsp");
	}
		


%>


<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	
	</body>
</html>