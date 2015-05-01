<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%
	pageContext.setAttribute("page", "PageScope");  //page 영역
								//이름  //값  설정하는것.
	//request영역
	request.setAttribute("request", "RequestScope");
	
	//session 영역
	session.setAttribute("session", "SessionScope");
	//새 창을 열어서 하면 유지가 안된다.
	
	//application 영역
	application.setAttribute("application", "ApllicationScope");
	//서버 재시작시 유지가 안된다.
	
	
	//페이지 이동
	//1.리다이렉트 방식
	response.sendRedirect("secondPage.jsp"); //기존 리퀘스트가 유지가 안되는 방식이다.
	
	//2.포워드 방식
	 /* RequestDispatcher requestDispatcher = request.getRequestDispatcher("secondPage.jsp");
	requestDispatcher.forward(request,response); */  
	//기존 리퀘스트가 유지가 되는 방식// 주소도 유지 //bcz,서버상에서 페이지를 이동시키기 때문이다.
%>


<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	<h1>첫 번째 페이지</h1>
	<hr>
	page 영역 : <%=pageContext.getAttribute("page") %><br> <!--리턴타입이 오브젝트 이므로 나중에 형변환 사용할지도.  -->
	request 영역: <%=request.getAttribute("request") %><br>
	session 영역: <%=session.getAttribute("session") %><br>
	application 영역: <%=application.getAttribute("application") %><br>
	
	</body>
</html>