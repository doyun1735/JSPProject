<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet</title>
		<style type="text/css">
			
		</style>
	</head>
	
	<body>
	<h2>설문 조사</h2>
	<form action="02_research.jsp">
	<font color ="red"><table border="1" ></font>
	<tr>
		<td> 이름 : </td>
		<td> 
			<input type="text" name="name" size 15>
		</td>
	</tr>
	<tr>
		<td> 성별: </td>
		<td>
			<input type="radio" name="gender"	value="남자">남자
			<input type="radio" name="gender"	value="여자">여자
		</td>	
	</tr>		
	<tr>
		<td> 좋아하는 계절 : </td>
		<td>
			<input type="checkbox" name ="season" value ="1">Spring
			<input type="checkbox" name ="season" value ="2">Summer
			<input type="checkbox" name ="season" value ="3">Fall
			<input type="checkbox" name ="season" value ="4">Winter
		</td>
	</tr>
	<tr >
		<td colspan="2" align ="center"> 
			<input type="submit" value="전송">
			<input type="reset" value ="취소"> 
		</td>
	</tr>
			
	</table>
	
	
	
	</form>
	
	</body>
</html>