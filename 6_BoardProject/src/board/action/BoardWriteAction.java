package board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//System.out.println("BoardWriteAction");
		String name =request.getParameter("name");
		String subject = request.getParameter("subject");
		String textArea = request.getParameter("textArea");
		
		
		Board board = new Board();
		
		board.setName(name);
		board.setTitle(subject);
		board.setContent(textArea);
		
		BoardDAO dao = new  BoardDAO();
		
		int result =dao.insertBoard(board);
		if(result != 0){
			String url = "list.board";
			response.sendRedirect(url);
		}
		
		
	}

}
