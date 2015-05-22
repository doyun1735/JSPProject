<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "exam.dao.*" %>
<%@ page import = "exam.dto.*" %>
<%@ page import = "java.util.*" %>

<!DOCTYPE html>
    
<html>
<head>
	<title>JSP/Servlet Example</title>
</head>

<body>
	<h1>회원리스트</h1>
	<hr>
	<table border="1">
	<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>나이</th>
	<th>성별</th>
	<th>주소</th>
	</tr>
<%
	MemberDAO dao = new MemberDAO();
	List<Member> list = dao.listMember();
	
	for(int i =0; i<list.size(); i++) {
		Member member = list.get(i);
	

%>
	<tr>
		<td><%= member.getId() %></td>
		<td><%= member.getName() %></td>
		<td><%= member.getAge() %></td>
		<td><%= member.getGender() %></td>
		<td><%= member.getAddr() %></td>
		
	</tr>
	<% } %>
	</table>
	

	

	</form>
</body>
</html>