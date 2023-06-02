package sec01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import service.LoginService;

/*동적 query 명령어 객체
-> 자바의 실행시간에 필요한 데이터를 입력받아 쿼리 실행
1) 변수에 할당될 값 대신 ?를 기술하여 쿼리 구성
	 ex) tbl_member에 신규회원 등록하려면,
	 sql = "insert into tbl_member values (?,?,?,?,?)"
2)	query의 ?에 해당되는 값을 맵핑시켜야함.
	query의 ?에 대응하는 데이터 mapping (setter 메소드 : set데이터타입)
	명령어객체변수.set데이터타입 (?순번, 값)
	ex) PreparedStatement ps = conn PreparedStatement(sql);
	 	ps.setString(1,"a002") -> mem_id //String : 테이블 컬럼의 데이터 타입
	 	ps.setString(2, "09876") -> mem_pass
	 	ps.setString(3, "정몽주") -> mem name
	 	ps.setString(4, "951230-1234567") -> mem_jumin
	 	ps.setInt(5,1000) -> mem_milege
	맵핑되면 쿼리 완성(실행은 아직)
	실행은 2가지 명령 - > execute쿼리(쿼리가 select문일때), 나머지는 executeUpdate 메소드 사용
3) 쿼리 실행
	* select 문 : executeQuery()
	* 그 이외의 query :  executeUpdate()
4) 실행결과
	* select 문: ResultSet 객체에 저장
	ex) ResultSet rs = executeQuery(); // ResultSet은 하나의 행
	while(rs.next()) {
			String mid = rs.getString("MEM_ID");
					:
			int mileage = rs.getInt("MEM_MILEAGE");
	}
	* 그 이외의 query : 커서 (쿼리로 영향받은 행(row)의 집합)의 행의 수 (정수) 
*/

public class PreparedStatementExample01 {
	static Scanner sc = new Scanner(System.in); // static 선언하면 스캐너클래스를 이 클래스 안에서 어디서나 쓸수 있음.

	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "pc13";
	private String passwd = "java";

	private Connection conn;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private int rowCount = 0;

	public static void main(String[] args) {

		String sql = "INSERT INTO tbl_member VALUES(?,?,?,?,?)"; // sql 쿼리 제시
		PreparedStatementExample01 ps01 = new PreparedStatementExample01();
		int result = ps01.insert(sql);

		int result = new PreparedStatementExample01().insert(sql);
		if (result != 0) {
			System.out.println("자료가 성공적으로 저장되었습니다. ");
		} else {
			System.out.println("자료가 저장되지 않았습니다. ");

		}
		result = ps01.update();
	}

	public int insert(String sql) {

		String mid = "";
		// 입력받은 회원아이디의 중복여부를 먼저 파악하는 while문
		while (true) {
			System.out.print("회원 아이디 : ");
			mid = sc.next();
//			param.add(mid);
			LoginService loginService = LoginService.getInstance();
			Map<String, Object> map = loginService.isDuplicate(mid); // 로그인 서비스에 있는 메소드
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

	public int update(String sql) {
		// 회원아이디 받아서 중복이 되어야 update 될 수 있음
		// 업데이트 대상이 이미 존재해야 수정가능. -- 자료 없으면 insert 임

		String mid = "";
		String flag = "";
		String pw = "";
		String jumin = "";
		int mileage = 0;
		List<Object> param = new ArrayList<Object>();

		// 입력받은 회원아이디의 중복여부를 먼저 파악하는 while문
		while (true) {
			System.out.print("회원 아이디 : ");
			mid = sc.next();
//		param.add(mid);
			LoginService loginService = LoginService.getInstance();
			Map<String, Object> map = loginService.isDuplicate(mid); // 로그인 서비스에 있는 메소드
			if (map == null) {
				System.out.println("회원정보가 없습니다.");
			} else {
				param.add(mid); // **********************이걸 왜 하는지??
				break;
			}
		}

		System.out.print("비밀번호를  변경하겠습니까? (Y/N) : ");
		flag = sc.next();
		while (flag.equalsIgnoreCase("y")) {
			System.out.print("비밀번호 : ");
			pw = sc.next(); // **********************nextLine아니고 next??
			param.add(pw);
		}
		System.out.println("주민번호를 변경하겠습니까? (Y/N) : ");
		flag = sc.next();
		while (flag.equalsIgnoreCase("y")) {
			System.out.println("주민등록번호 : ");
			jumin = sc.next();
		}

		System.out.println("마일리지를 변경하겠습니까? (Y/N) : ");
		flag = sc.next();
		while (flag.equalsIgnoreCase("y")) {
			System.out.println("마일리지 : ");
			mileage = sc.nextInt();
		}
		
		int len = updateSql.length();
		update

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

}
