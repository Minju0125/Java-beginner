package sec01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import service.LoginService;
import service.MemberService;

//동적 query명령어 객체
//  ->자바의 실행시간에 필요한 데이터를 입력받아 쿼리 실행
// 1)변수에 할당될 값 대신 ?를 기술하여 쿼리 구성
// ex) tbl_member에 신규회원등록
//   sql="insert into tbl_member values(?, ?, ?, ?, ?)"
// 2)query의 ?에 대응하는 데이터 mapping(setter메서드:
//   명령어객체변수.set데이터타입(?순번, 값) 
//  ex) PreparedStatement ps=conn.preparedStatement(sql);
//      ps.setString(1, "a002") ->mem_id
//      ps.setString(2, "09876") ->mem_pass
//      ps.setString(3, "정몽주") ->mem_name
//      ps.setString(4, "951230-1234567") ->mem_jumin
//      ps.setInt(5, 1000) ->mem_mileage
//  3)쿼리 실행
//    . select 문 : executeQuery()
//    . 그 이외의 query : executeUpdate() 
//  4)실행결과 
//    . select 문 : ResultSet 객체에 저장
//    ex) ResultSet rs=executeQuery();
//        while(rs.next()){
//              String mid=rs.getString("MEM_ID");
//                              :
//              int mileage=rs.getInt("MEM_MILEAGE");
//        }
//    . 그 이외의 query : 커서(쿼리로 영향받은 행(row)의 집합)의 행의 수(정수)
public class PreparedStatementExample01 {
	private static Scanner sc = new Scanner(System.in);

	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "pc13";
	private String passwd = "java";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int rowCount = 0;

	MemberService memberService = MemberService.getInstance();

	public static void main(String[] args) {
		PreparedStatementExample01 ps01 = new PreparedStatementExample01();
		/*
		 * String sql = " INSERT INTO tbl_member VALUES(?, ?, ?, ?, ?) ";
		 * PreparedStatmentExample01 ps01=new PreparedStatmentExample01(); int result =
		 * ps01.insert(sql); if (result != 0) {
		 * System.out.println("자료가 성공적으로 저장되었습니다. "); } else {
		 * System.out.println("자료가 저장되지 않았습니다. "); }
		 */
//		ps01.update();
		
		while (true) {
			
			System.out.println("[1. 전체조회]");
			System.out.println("[2. 개별조회]");
			System.out.println("-----------------");
			System.out.println("선택 -> : ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				searchAll();
				break;
			case 2:
				searchOne();
				break;
			default:
				System.out.println("선택번호를 잘못 입력 했습니다.");
			}
		}

	}

	public int insert(String sql) {
		String mid = "";
		while (true) {
			System.out.print("회원 아이디 : ");
			mid = sc.next();
			LoginService loginService = LoginService.getInstance();
			Map<String, Object> map = loginService.isDuplicate(mid);
			if (map != null) {
				System.out.println("아이디가 중복되었습니다...");
			} else {
				break;
			}
		}
		System.out.print("회원명 : ");
		String mname = sc.next();

		System.out.print("비밀번호 : ");
		String pw = sc.next();

		System.out.print("주민등록번호 : ");
		String jumin = sc.next();

		System.out.print("마일리지 : ");
		int mileage = sc.nextInt();

		try {
			conn = DriverManager.getConnection(url, user, passwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pw);
			pstmt.setString(3, mname);
			pstmt.setString(4, jumin);
			pstmt.setInt(5, mileage);

			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
		return rowCount;
	}

	public void update() {
		int res = memberService.update();
		if (res > 0) {
			System.out.println("자료가 정상적으로 갱신되었습니다");
		} else {
			System.out.println("자료 갱신에 실패했습니다");
		}
	}
	
	
	public static void searchAll() {
		List<Map<String, Object>> memberService.searchAll();
		
	}
	
	public void searchOne() {
		Map<String, Objcet> result = memberService.searchOne();
		//결과를 맵에 저장
		if(result != null) { // null이 아니라는 것은 결과가 들어왔다는 것
			System.out.println("				[[ 회원 LIST ]]");
//			System.out.println("[2. 개별조회]");
//			System.out.println("-----------------");
//			System.out.println("선택 -> : ");
//			여기 고쳐야함
			String mid = (String)result.get("MEM_ID");
//			String name = (String)result.get("MEM_name");
			String jumin = (String)result.get("MEM_jumin");
			int mileage = Integer.parseInt(String.copyValueOf(result.get("")) //?/?)
					
		}
		
	}
	
}
