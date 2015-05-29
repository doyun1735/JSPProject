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
				}
			
	}
	
	
	// 글 쓰기
	public int insertBoard(Board board){
		String sql = "insert into board values (board_seq.nextval,?,?,?,default,default,'file')";
		//글순서,네임 타이틀,컨텐츠,시간,조회수,파일
		
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			
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
		
		String sql = "select * from board order by num decs";
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
				
				board.setContent("content");
				
				list.add(board);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return list;
		
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
