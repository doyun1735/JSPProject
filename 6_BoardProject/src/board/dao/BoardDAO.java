package board.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.dto.Board;

public class BoardDAO {
	
	Board board = new Board();
	private Connection  con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public  BoardDAO(){
		// 1. JDBC 드라이버 로드
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. 데이터 베이스 연결			
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jspuserd", "jsp1234");
				}
				 catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				catch (SQLException e){
					e.printStackTrace();
				} finally//그러던지 말던지 무조건 실행
				{
					
				}
			
	}
	
	
	// 글 쓰기
	public int insertBoard(Board board){
		String sql = "insert into board values (board_seq.nextval,?,?,?,default,default,?)";
		//글순서,네임 타이틀,컨텐츠,시간,조회수,파일
		
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4,board.getAttachment());
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
		
	}
	
	public List<Board> selectALLBoards() {
		
		String sql = "select * from board order by num desc";
		List<Board> list = new ArrayList<Board>();												//가장 큰값이 가장 먼저 나오게 정렬.
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setRegDate(rs.getDate("wdate"));
				board.setContent(rs.getString("content"));
				board.setHits(rs.getInt("hits"));
				
				
				list.add(board);
				
				
				
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return list;
		
	}
	//상세보기
	public Board selectOneBoardByNum(int num){
		String sql = "select * from board where num=?";
		Board board = new Board();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setRegDate(rs.getDate("wdate"));
				board.setContent(rs.getString("content"));
				board.setHits(rs.getInt("hits"));
				board.setAttachment(rs.getString("attachment"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return board;
	}
	
	//조회수 증가
	
	public void updateHits(int num){
		String sql = "update board set hits=hits+1 where num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
				
	}
	public int upadteBoard(Board board){
		return 0;
	}
	public int deleteBoard(int num){
		return num;
	}
}
