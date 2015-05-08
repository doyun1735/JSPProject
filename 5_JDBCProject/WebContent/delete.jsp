<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
    String id = request.getParameter("id");
	out.print(id);
	//1.JDBC 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
	//2.데이터 베이스 연결
	Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserd","jsp1234");
		
	//3.sql문 실행	
	String sql="delete member where id=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	//바인딩 위에 물음표와 get과 매칭시켜주는것. 1은 첫번째 것.
	pstmt.setString(1,id);
	//익스큐트
	int result = pstmt.executeUpdate();

	if(result == 0)
		out.print("회원 삭제 실패");
	else{
		out.print("회원 삭제 성공");
		response.sendRedirect("list");
	}
	pstmt.close();
	con.close();
	
%>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
	</head>
	
	<body>
	
	</body>
</html>