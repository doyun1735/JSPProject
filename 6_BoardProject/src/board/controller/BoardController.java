package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.*;



/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.board") //URI Mapping!
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); //한글 지원!
		doProcess(request, response);
	}
	
	//기능별 분기
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String command = uri.substring(contextPath.length());
		
	/*	System.out.println(contextPath);
		System.out.println("uri = : "+ uri);
		System.out.println("command = " + command );
		*/
		Action action =null;
		//리스트 
		if(command.equals("/list.board")){
			action = new BoardListAction();
			action.execute(request, response);
		}
		//글쓰기 Form
		else if(command.equals("/writeForm.board")){
			action =new BoardWriteFormAction();
			action.execute(request,response);
		}
		//글쓰기 insert
		else if(command.equals("/write.board")){
			action = new BoardWriteAction();
			action.execute(request, response);
		}
		
		
		
	}

}
