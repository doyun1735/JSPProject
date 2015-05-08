<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ page import="exam.dao.*, exam.dto.*" %>
<%
	
	//0. 요청 처리
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pass = request.getParameter("pwd");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String addr = request.getParameter("addr");
	
	//1. JDBC 드라이버 로드
	//2. DB 연결 
	MemberDAO dao = new MemberDAO();
	
	//3. SQL문 실행
	Member member = new Member();
	member.setId(id);
	member.setPassword(pass);
	member.setName(name);
	member.setAge(age);
	member.setGender(gender);
	member.setAddr(addr);
	
	dao.insertMember(member);
	
	

%>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	
	</body>
</html>