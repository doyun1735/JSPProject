package board.dao;
import java.util.List;

import board.dto.Board;

public class BoardDAO {
	
	Board board = new Board();
	
	public  BoardDAO(){
		
	}
	
	public int insertBoard(Board board){
		return 0;
		
	}
	
	public List<Board> selectALLBoards(){
		return null;
		
	}
	public void selectOneBoardByNum(int num){
		
	}
	public int updateHits(Board board){
		return 0;
	}
	public int deleteBoard(int num){
		return num;
	}
}
