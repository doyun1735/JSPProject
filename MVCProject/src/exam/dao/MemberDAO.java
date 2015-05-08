package exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exam.dto.Member;

public class MemberDAO {
	Member member = new Member();
	//생성자.
	public MemberDAO(){
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
	}
	
	//회원 가입
	public void insertMember(Member member){
		System.out.println("회원 가입 성공");
		String sql ="insert into member values(? , ?, ?, ?, ?, ?, default)";
	}
	
	//회원 삭제
	public void deleteMember(){
		
	}
	
	//회원 리스트 보는것
	public void listMember(){
		
	}
	//회원 상제 페이지
	public void viewMember(){
		
	}
	
	
}
