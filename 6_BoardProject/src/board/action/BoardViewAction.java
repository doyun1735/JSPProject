package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String num = request.getParameter("num");
		BoardDAO dao = new BoardDAO();
		
		Board board = dao.selectOneBoardByNum(Integer.parseInt(num));
		
		dao.updateHits(Integer.parseInt(num));
		
		request.setAttribute("board", board); //리퀘스트 영역에 저장시키는 라인.
		
		String url = "./board/view.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
