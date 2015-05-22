package exam.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import exam.dto.Member;

public class MemberDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// 생성자.
	public MemberDAO() {
		// 1. JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. 데이터 베이스 연결 
		
		
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jspuserd", "jsp1234");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	// 회원가입
	public void insertMember(Member member) {
		String sql = "insert into member values(?,?,?,?,?,?,default)";
		
		String id = member.getId();
		String pwd = member.getPassword();
		String name = member.getName();
		int age = member.getAge();
		String gender = member.getGender();
		String addr = member.getAddr();
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setInt(4, age);
			pstmt.setString(5, gender);
			pstmt.setString(6, addr);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 회원리스트
	public List<Member> listMember() {
		String sql = "select * from member order by id desc"; 
		
		List<Member> list = new ArrayList<Member>();
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setAddr(rs.getString("addr"));
				
				list.add(member);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	// 회원 상제 페이지
	public void viewMember() {
			
	}
	
	// 회원삭제
	public void deleteMember() {
		
	}
	
	// 로그인, DTO사용,  오버로딩 - 멤버
	public int loginMember(Member member) {
		String sql  = "select * from member where id=? and password=?";
		
		// 오버로딩은 리턴 값이 같아야함.
		return 0;
	}
	// 로그인, DTO미사용, 오버로딩 - 아이디, 비밀번호
	public int loginMember(String id, String pwd) {
		String sql  = "select * from member where id=? and password=?";
		int result = 0;
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			// 데이터가 존재한다면
			if(rs.next()) 
				result = 1; // 성공	
			else 
				result = 0; // 실패
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// result의 1 또는 0 값을 가지고 LoginServlet으로 이동.
		return result;
	}
}
