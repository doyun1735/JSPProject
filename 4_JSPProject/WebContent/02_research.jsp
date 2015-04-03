<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
		<style type ="text/css">
			b{
				font-size: 16pt;

			}
		</style>
	</head>
	
	<body>
	<h2>설문 조사 결과</h2>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("name");
		out.println("이름 :"+name+"<br>");
		
		String gender = request.getParameter("gender");
		out.println("성별 :"+gender+"<br>");
		if(gender.equals("남자")){
			response.sendRedirect("http://www.naver.com"); //리다이렉트 방식
		}
		else{
			response.sendRedirect("http://www.daum.net");
		}
		
		String[] season = request.getParameterValues("season");
		out.println("좋아하는 계절은 :");
		
		if(season ==null){
			out.print("선택하세요.");
		}
		else
		for(String str : season)
		{
			out.println(str);
			}
			
	
		
	%>
	<br>
	<b><a href='javascript:history.go(-1)'>다시</a></b>
	</body>
</html>