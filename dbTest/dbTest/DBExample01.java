package dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBExample01 {

	String url = "jdbc:oracle:thin:@localhost:1521:xe";// <-이거 url 은 외워야함/ .jar 라는 파일 안에 들어있음
	// 이거대신 ip 쓰고 싶다.하면 127.0.0.1// oraclebase를 connect 하겠다
	String user = "pc13"; // 오라클에 접속할 때 사용한 계정
	String passwd = "java";

	// 데이터 베이스 연동하려면 최소한 이거 아래 네개는 임포트 시켜야함.
	Connection conn = null; // import 시켜야함
	Statement stmt = null; // sql 거를 import 시켜야함
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public static void main(String[] args) {
//		new DBExample01().dbConnection();// 메인메소드에서 static이 붙지 않은 자기 자신을 부르는 방법
		// 자기자신 클래스를 생성시키고 나면, static 을 붙이지 않아도 가져다 쓸수있음

		int res = new DBExample01().dbInsert();
		if (res > 0) {
			System.out.println("자료 입력 성공");
		}
	}

	public void dbConnection() {
		try {
			conn = DriverManager.getConnection(url, user, passwd); // conn 객체 생성
			System.out.println("DB 연결 성공"); // db 연결은 성공한 것
			stmt = conn.createStatement();
			String sql = "select EMPNO, ENAME, JOB from TEMP"; // 오라클 코드 이게 문자열 sql 에 저장됨// 여기서 오류 발생할 수 있음.
																// 예를들어 여기세 String sql = "select EMPNO, ENAME, JOB from
																// EMPLOYEES" 라고 썼을 떄,
																// -> table or view does not exist 신택스 오류 -> 이 오류가 나면 여기
																// 구문 살펴보기
			rs = stmt.executeQuery(sql); // executeQuery 사용 (insert 할때?) -> 결과가 행, 열로 나오고 그걸 보관하는게 rs (rs에 들어있는 값을
											// while명령으로 처리. 아래에서)
			while (rs.next()) { // next 메소드는 결과집합에서 첫번째 행에 데이터가 있으면 true, 데이터(덩어리로. rs)를 가지고옴 / 없으면 false
				String eid = rs.getString("EMPNO"); // rs에 들어있는 "EMPNO"를 문자열로 가지고 오세요. 오라클에 있는 컬럼명 //오라클 뷰 인덱스는 첫번째가 1
				String eName = rs.getString("ENAME");// 오라클에 있는 컬럼명을 기술하던지 아래같이
				String job = rs.getString(3); //

				// char, varchar 상관없이 자바에서는 모두다 문자열로 -> String

				System.out.printf("%5s %7s %10s\n", eid, eName, job);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) // rs가 널이 아니다라는 것은 값이 할당되었다 ! 사용되었다,
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (Exception e) {
				}

		}

	}

	public int dbInsert() { // insert, delete, update 된 행의 수 -> 정수데이터를 반한하도록 int
		Scanner sc = new Scanner(System.in);

		System.out.println("[사원정보 입력]");
		System.out.println("사원번호 : ");
		String eid = sc.nextLine();

		System.out.println("사원이름 : ");
		String name = sc.nextLine();

		System.out.println("직무코드 : ");
		String jid = sc.nextLine();

		System.out.println("부서번호 : ");
		int deptid = Integer.parseInt(sc.nextLine());
		int res = 0; //

		try {
			conn = DriverManager.getConnection(url, user, passwd);
			String sql = "insert into TEMP values(?,?,?,?) "; // (?,?,?,?)는 각열에 해당

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eid); // ? 하나에 데이터 하나씩 맵핑
			pstmt.setString(2, name);
			pstmt.setString(3, jid);
			pstmt.setInt(4, deptid);

			res = pstmt.executeUpdate(); // update 명령 실행하면 insert 됨 // insert 된 행의수를 아래 res 로 리턴
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
		}
		return res;

	}

}

/*
 * 1521번 포트로 들어오는건 오라클 실행 url 절대 바꿔서 쓰면 안됨 제공되는 jdbc driver를 이용해서 오라클과 자바를 커넥팅한다
 * -> thin 오라클 express 버전 깔았다 -> xe 정식버전은 -> orcl
 */