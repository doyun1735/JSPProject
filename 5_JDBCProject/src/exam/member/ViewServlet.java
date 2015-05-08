package exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out =response.getWriter();
		out.print("<h1>회원 상세페이지</h1><hr>");
		//0.요청
		
		String id = request.getParameter("id");
		
		
		//1.JDBC 드라이버 로드
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//2.데이터 베이스 연결
				Connection con =null;
				try {
					con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserd","jsp1234");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//3.sql문 실행
				
				String sql ="select * from member where id=?";
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,id);
					rs = pstmt.executeQuery();
					if(rs.next()){
						out.print("<h1>"+id+"님의 정보"+"</h1>");
						out.print("<table border =1>");	
						out.print("<tr><th>아이디</th><th>이름</th><th>나이</th><th>성별</th><th>주소</th></tr>");
							
							out.print("<tr>");
							out.print("<td><a href ='view?id="+ rs.getString("id")+"'>"+ rs.getString("id")+"</a></td>"); //a태그 링크거는것.
							out.print("<td>"+rs.getString("name")+"</td>");
							out.print("<td>"+rs.getInt("age")+"</td>");
							out.print("<td>"+rs.getString("gender")+"</td>");
							out.print("<td>"+rs.getString("addr")+"</td>");
							
							out.print("</tr>");
						
						out.print("</table>");
						out.print("<a href='delete.jsp?id="+rs.getString("id")+"'>삭제</a>");
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//4. 데이터 출력
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
