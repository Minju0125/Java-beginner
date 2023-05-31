package chapter11.sec02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//데이터베이스와 상호 작용하여 데이터를 조회하는 역할
//쿼리를 작성.
//테이블 하나면 다오클래스 하나만. + 서비스(다오가 기능이 커지면 분배.)
//VO클래스 안쓸 때는 MAP 사용할 수 있음.

public class TempDao {
	//final 상수 -> 대문자
	//URL, USER, PASSWD
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "pc13";
	private final String PASSWD = "java";
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	//rs.는 쿼리실행 결과 컬럼명까지 다 포함해서 resultset -> rs에서 가장첫번째 데이터 꺼내야함
	//get empNo 하면 -> 7369 ~ 해서 empno 에 set empNO 에 저장 (VO 클래스의)
	//
	
	//싱글톤 패턴
	private static TempDao instance = null;
	private TempDao() {}
	
	public static TempDao getInstance () {
		if(instance == null) instance = new TempDao();
		return instance;
	}
	
	//인터페이스 타입 변수의 리스트. 
	// 부모타입의 인터페이스에 넣어줌 *다형성 (upcast)
	List<TempVO> list = new ArrayList <TempVO> (); // 리스트 인터페이스에서 정의해놓은 메소드만 사용하겠다.
	// ArrayList 안에 list 가 가지고 있는 모든 추상메소드를 재정의해줬다.
	
	//부모인터페이스가 리스트
	// list 라는 변수로 호출할 수 있는건 부모 인터페이스에서 정의해놓은 것만 참조하겠다.
	
	public List<TempVO> selectList(String sql) { //select~ 어쩌구를 sql 로 받아서 쿼리 실행. 반환 타입은 lsit 타입 // 여러개를 조회할때 selectlist
		try {
			conn = DriverManager.getConnection(URL,USER, PASSWD); //DB 연결객체 만들어짐.
			stmt = conn.createStatement(); // 정적명령어 객체가 만들어져서 stmt -> conn 객체의 저 메소드를 호출
			rs = stmt.executeQuery(sql); // execute는 쿼리는 select 일때만 (이미 알려진 데이터를 통해 쿼리를 실행할 경우) stmt 객체  // insert, delete, -> executeupdate
			// prestmt 써야함 
			
			while(rs.next()) { //꺼내올 자료가 있으면 true, 없으면 false -> 처음부터 끝까지 차례로 하나씩 가져옴.
				TempVO tempVO = new TempVO(); //객체 생성
				
				tempVO.setEmpNo(rs.getString("EMPNO")); //getter 메소드. 테이블 컬럼 EMPNO 에 들어있는 문자열 데잍어 꺼내서 tmepVO 에 setEmpNO. 위에 있는 private 멤버 변수에 저장 !
				tempVO.seteName(rs.getString("EMPNO"));
				tempVO.setJob(rs.getString("JOB"));
				tempVO.setDeptNo(rs.getInt("DEPTNO"));
				
				//한줄단위로 저장. VO 클래스의 set 메소드 실행!!@@@!
				//가져올 데이터 없으면 반환해줌 (호출한쪽으로 -> example 에서)
				
				list.add(tempVO); //클래스 변수만 사용되면 뒤에, .toString 메소드 생략된 것
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e) {}
			if(stmt != null) try {stmt.close();} catch (Exception e) {}
			if(conn != null) try {conn.close();} catch (Exception e) {}
		} 
		return list;
	}
	
}
