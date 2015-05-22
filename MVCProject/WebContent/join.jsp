<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "exam.dao.*" %>
<%@ page import = "exam.dto.*" %>

<%
	// 0. 요청처리
	request.setCharacterEncoding("UTF-8"); // POST 방식일 때 한글 지원
	
	String id = request.getParameter("id");
	String password = request.getParameter("pwd");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String addr = request.getParameter("addr");

	// 1.JDBC 드라이버 로드
	// 2.데이버베이스 연결
	MemberDAO dao = new MemberDAO(); 
	
	// 3.SQL 문 실행.
	Member member = new Member(); // DTO 객체 생성
	member.setId(id);
	member.setPassword(password);
	member.setName(name);
	member.setAge(Integer.parseInt(age));
	member.setGender(gender);
	member.setAddr(addr);
	
	dao.insertMember(member);
	
%>
<!DOCTYPE html>
    
<html>
<head>
	<title>JSP/Servlet Example</title>
</head>

<body>

</body>
</html>