<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
	//---------------------------------------
	//회원가입
	//---------------------------------------
	
	
	
	
	
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pwd");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String addr = request.getParameter("addr");
	//out.print(id);
	//1.JDBC 드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	
	//2.데이터 베이스 연결
	Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserd","jsp1234");
											//주소													//아이디		//비밀번호
	
	//3. SQL문 실행
	//1)Statement 객체 이용
	
	/* String sql ="insert into MEMBER values('"+id+ "','"+pass+"','"+name+ "','"+age+"','"+gender+"','"+addr+"',default)";
	Statement stmt =con.createStatement(); //이게  SQL문장이다 라는 중간 매개체 역할을 해준다.
	
	int result = stmt.executeUpdate(sql); // 이게 sql에서 Alt+x 역할을 해준다. */
	
	//2)PreparedStatement 객체 이용
	
	String sql ="insert into member values(? , ?, ?, ?, ?, ?, default)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	//바인딩 해야함.
	pstmt.setString(1, id);
	pstmt.setString(2, pass);
	pstmt.setString(3, name);
	pstmt.setInt(4, Integer.parseInt(age));
	pstmt.setString(5, gender);
	pstmt.setString(6, addr);
	
	
	int result = pstmt.executeUpdate();  //insert,update,delete 사용시 옆에 .executeUpdate사용.
	
	if(result == 0)
		out.print("회원가입 실패");
	else
		out.print("회원 가입 성공");
	
	//4. 데이터 베이스와 연결 끊음
	//stmt.close();
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