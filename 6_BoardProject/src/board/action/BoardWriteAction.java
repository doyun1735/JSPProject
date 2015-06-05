package board.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

import com.oreilly.servlet.MultipartRequest;
//이름이 똑같을때 사용되는 정책
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//System.out.println("BoardWriteAction");
		
		/*String name =request.getParameter("name");
		String subject = request.getParameter("subject");
		String textArea = request.getParameter("textArea");*/
		
		ServletContext context = request.getServletContext();
		String uploadPath  =context.getRealPath("upload");
		
		/*System.out.println(uploadPath);*/
		
		MultipartRequest multi 
			= new MultipartRequest(request,uploadPath,10*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		String title = multi.getParameter("title");
		String content =multi.getParameter("content");
		String fileName = multi.getFilesystemName("file");
		
		Board board = new Board();
		
		board.setName(name);
		board.setTitle(title);
		board.setContent(content);
		board.setAttachment(fileName);
		
		BoardDAO dao = new  BoardDAO();
		
		int result =dao.insertBoard(board);
		if(result != 0){
			String url = "list.board";
			response.sendRedirect(url);
		
		
		}
		
		
		
		
	}

}
