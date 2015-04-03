package exam.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet") //어노테이션 XML로 설정해주는것을 간단하게 설정  뒤에 /hello가 URL맵핑이다.
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super(); //상위 계층에 있는 생성자를 호출 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub //클래스이름은 대문자!
	
		response.setContentType("text/html;charset=UTF-8"); //반응 할때 html형식으로 지원하고 UTF-8코드를 사용 대분류/소분류
		request.setCharacterEncoding("UTF-8"); //요청인코딩 타입을 설정한다. 
		/*get방식에서 한글 지원 할려면

		server.xml 65번째 라인에 URIEncodiong="UTF-8"이라는 것을 추가 시켜준다.*/
		PrintWriter out =response.getWriter();
		//.은 소속을 나타낸다.
		String name = request.getParameter("name");
		String i =request.getParameter("id"); //요청받는 값을 i변수에 저장
		String p = request.getParameter("pwd");
		out.print("Hello - GET <br>");
		out.print(name+"<br>");
		out.print(i+"<br>");
		out.print(p+"<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); //포스트 타입일때는 이것만 해주어도 된다!
		PrintWriter out =response.getWriter();
		//.은 소속을 나타낸다.
		
		String n = request.getParameter("name");
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		out.println("Hello - POST <br>");
	
		out.print(n+"<br>");
		out.println(id+"<br>");
		out.println(pwd+"<br>");
	
	}

}
