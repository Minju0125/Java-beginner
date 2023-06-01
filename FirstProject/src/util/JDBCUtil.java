package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//JDBC를 효율적으로 사용할 수 있는 메서드를 포함한 class
//프로젝트 파일에서 우클릭 properties -> jar5 파일을 통해 연동
//connection, 데이터베이스 연동, 연동된 데이터 베이스에서 SELECT, INSERT, UPDATE, 딜리트, 커밋, 롤백 실행할 수 있는 코드로 구성
//singleton 패턴 적용
// 	해당데이터타입과 같은 변수가 나와야함

public class JDBCUtil {
	private static JDBCUtil instance = null; //자기 자신의 클래스 타입 기술, 변수명 instance (객체참조변수, 대부분 인스턴스라고 씀)
	private JDBCUtil() {} //생성자메소드를 private으로 선언 // 이클립스 밖에서는 불러다 쓸 수 없음 -> 객체 생성 안됨
	public static JDBCUtil getInstance() {//반환 타입이 클래스 타입
		if(instance == null) instance = new JDBCUtil();
		return instance;
				
	}
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; //독립된 파일 지원 받아서 할 때는 thin을 안씀 //xe : express 버전
	private String user = "pc13";
	private String passwd = "java"; // connection을 하기 위한 멤버변수
	
	/*명령어 객체 - > 
	statement 객체(정적쿼리 | 정적명령어-where절이 없거나 where절에서 사용되는 조건을 미리 알고 있을 때 사용. 실행시간 동안 입력받은 데이터를 where 절에 사용할 땐 못씀)
	prepareStatement 객체 (동적쿼리 |
	--------------------------
	function : 반환값이 있는 메소드 (select 절에 사용)
	프로시저 : 반환값이 없는 메소드 (execute명령 또는 익명 프로시저 또는 함수에서 불러야함_ callerablStatement : 프로시저를 불러서 사용할 때 사용)
	*/
	private Connection conn; //객체 선언
	private PreparedStatement pstmt = null;
	private Statement smtm = null;
	private ResultSet rs = null;
	
	//한개 검색하는 메소드- 주어진 SQL 쿼리를 실행하고, 그 결과를 List<Map<String, Object>> 형태로 반환하는 역할
	//. 반환된 리스트는 각각의 레코드를 Map으로 표현하고 있으며, 각 레코드의 열(Column)은 문자열 키로 매핑되어 해당 열의 값을 저장
	
	public Map<String, Object> selectOne(String sql) { //return O
		// 정적쿼리 사용한 경우
		// sql = "SELECT SUM(CART_QTY * PROD_PRICE) FROM CART, PROD 
		//			WHERE CART_MEMBER = (SELECT A.MEM_ID 
		//									FROM SELECT MEM_ID
		//											FROM MEMBER
		//									ORDER BY MEM_MILEAGE DESC
		//											WHERE ROWNUM = 1);		
	
		// 정적쿼리 사용한 경우 
		
		//한사람의 데이터가 저장될 기억장소 map // where 절이 없거나, where 절에 사용될 데이터가 고정된 상태일떄
		Map<String, Object> row = null; // key는 string 이고, value는 Object
		try {
			conn = DriverManager.getConnection(url, user, passwd); 
			//conn 객체 생성 -> DB(오라클)과 자바 연결
			//위에서 정의해놓은 url = "jdbc:oracle:thin:@localhost:1521:xe", 사용자계정과 암호를 매개변수로 해서 오라클, 자바 연동 -> getConnection
			pstmt = conn.prepareStatement(sql); // 사용되는 쿼리 문장 크게 세가지 있는데(정적, 동적, 프로시저) -> 실제 쿼리 명령을 가지고 생성됨.
			rs = pstmt.executeQuery(); // 실행시킨 쿼리의 결과는 행 한줄-> rs에 들어감 
			
			
			// 컬럼명, 컬럼의 갯수 얻을 수 있음(메타데이터를 통해) // ResultSetMetaData는 api에서 제공하는 클래스 . 대상은 rs -> 메타데이터 만들어져서 rsmd 에 들어감.
			ResultSetMetaData rsmd = rs.getMetaData();// 메타데이터는 데이터of데이터 -> 기본키, 컬럼, 외래키~~~ , 제약사항들을 보관하고 있는 데이터 -> 자바에서 클래스로 제공
														// 대상은 rs. import 시켜야함 // 컬럼의 갯수와 컬럼명을 얻기 위함. -> 메타데이터 객체 생성
			int columnCount = rsmd.getColumnCount(); //컬럼의 수 반환 -> tbl_member을 사용한다면, 결과는 5
			while(rs.next()) { //iterator 에서는 hasnext 썼었는데, 여기서는 next -> 가지고 올 자료 있 //rs 는 한사람의 데이터 //sql 실행되어서 
				row = new HashMap<>(); // row는 아까 만들어놓은 map 타입의 변수. 아직 map 객체는 생성 안됨	(이 말이 이해 안됨!)				
				for(int i=0; i<columnCount; i++) {
					String key = rsmd.getColumnLabel(i); // ***************여기서 i의 의미?, i번째 컬럼의 컬럼명을 가져오시오. ex)i가 1일때는 mem_id 가져옴
					//or String key = rsmd.getColumnName(i);
					Object value = rs.getObject(i); //rs resultSet 에서 값을 꺼내올때 . object 는 value니까 // value값을 가져와서 저장
					row.put(key, value); // 이 결과는 문자열, 객체 타입이니까 object 타입으로 받아서 row 에 저장함.-> 각 컬럼에  들어올 데이터 타입이 
														 
			}
			}
			
				/*tbl_member의 구조
				column name(원본테이블의 컬럼명) -> |mem_id| mem_name| mem_pass| mem_jumin| mem_age|
											  |		  |		    |	 	  |	 	 	 |		  |
				column Label은 별칭을 의미. as 다음에 쓴 별칭이 있으면 별칭을 가져오고, 별칭이 없으면 columnName(원본컬럼명)
				
			*/
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (Exception e) {} //(try catch 잘 모르겠음 !!!)
			if(pstmt!=null) try {pstmt.close();} catch (Exception e) {}
			if(conn!=null) try {conn.close();} catch (Exception e) {}
		}
		//row에 있는 한 사람의 데이터를 반환해줌
		return row; 
		
	}

	
												//매개변수가 달라짐 -> sql 이긴 한데,// sql = "SELECT * FROM tbl_meber where mem_id=? and mem_pass=?" ?을 썼다는건 컴파일 할때가지 뭔지 모름
	//키보드로 입력받아 전달할떄 사용되는 쿼리																														//실행후 입력받은 자료를 ?에 각각 매핑 . ?에 해당되는 자료가 param 을 통해 list로 들어옴
		public Map<String, Object> selectOne(String sql, List<Object>param) { //키보드로부터 입력받은 자료들이 와야함 (List 타입으로) List 에 입력받은 것들은. 몇개가 될지 모르니까 배열 형태로 받은 것( 데이터 타입도 object로 받음, ?에 대응 되는 매개변수가 어떤 타입이 될지 모르기때문에, 이 타입들을 다 사용할 수 있는 object 타입으로 ->나중에 list 를 불러서 이 값을 넘겨줄 것임)
			Map<String, Object> row = null; //맵 객체 생성
			try {
				conn = DriverManager.getConnection(url, user, passwd);
				pstmt = conn.prepareStatement(sql); //conn 객체를 이용 //sql 매개변수를 이용 //  사용되는 물음표와 대응되는 데이터를 맵핑
				// 자바는 0번부터 카운팅이지만, 오라클은 0이 없기 때문에 i+1
				//데이터를 알고 있다면 for 문 안써도됨.
			
				for(int i=0; i<param.size(); i++) { 
					pstmt.setObject(i+1, param.get(i)); // 여기서 param 부터 잘 모르겠움 // 오라클이리기 때문에 i+1 
				}
				
				// 위에서 맵핑 시켜줬으니까 쿼리를 실행
				rs=pstmt.executeQuery();
				
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				while(rs.next()) { // 저장하면 맵에 저장해서 반환할 것임 
					row = new HashMap<>(); // <> 안에 생략하면 자동으로 <String, Object> 타입 적용
					for(int i=0; i<columnCount; i++) {
					String key = rsmd.getColumnLabel(i); //i번째의 컬럼레이블을 key로 놓고
					Object value = rs.getObject(i); 
					//이렇게 만들어 놓은 것을 row에 저장해야함  (아래)
					row.put(key,value);
					}
			
				
				
				
				
				
				
				
				// ? 물음표가 두개 -> 맵핑시켜줘야함.
				//pstmt의 setter 메소드 이용 				
				//sql에 존재하는 ?에 대응되는 데이터 mapping => pstmt.set타입명(?순번, 데이터) . pstmt는 명령어 객체이름
				//id,pass 가 varchar2이기 떄문에 -> String
				//" " 안은 sql 쿼리이기 때문에 (오라클엔 0번이 없음) pass 는 2번째 물음표와 대응함.
				// "SELECT * FROM tbl_meber where mem_id=? and mem_pass=?" -> 1번 물음표(id), 2번 물음표 (pass) 
//				String id = sc.nextLine(); -> pstmt.setObject(1,id) // id라는 변수에 가져다 놓고, 첫번째 물음표 대신에 id 값을 집어 넣어라 (맵핑시키는 명령문)
//				String pw = sc.nextLine(); -> pstmt.setObject(1,pw) // pw라는 변수에 가져다 놓고, 첫번째 물음표 대신에 id 값을 집어 넣어라 -> 이 후에 실행시켜야 함.
				// 데이터가 Object 로 선언되어있기 때문에 setString 이 아닌 setObject .
				
				
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if(rs!=null) try {rs.close();} catch (Exception e) {}
				if(pstmt!=null) try {pstmt.close();} catch (Exception e) {}
				if(conn!=null) try {conn.close();} catch (Exception e) {}
			}
			
			return row;
			
	
	
	
	
	
	}
	
}



/* 동적쿼리 
 * 		Select * from member
 * 		멤버테이블로부터 전체를 가져옴
 * 		member 테이블에는 19개의 컬럼 존재하는데, 그 컬럼을 가져오겠다.
 * 		SELECT (조회할 컬럼) FROM
 * 		WHERE에서는 (조회할 행 정의)
 * 			SELECT절, FROM절은 생략할 수 없음
 * 		
 * 		WHERE MEM_ID=? AND MEM_PASS = ? // 아이디와 PASSWD를 입력받아얌
 *		id가 들어갈 자리를 미리 물음표를 씀
 *		passwd 도 물음표 씀
 *		_는 한글자 대응
 * 
 * 		String id = sc.nextLine(); -> pstmt.setString(1,id) // id라는 변수에 가져다 놓고, 첫번째 물음표 대신에 id 값을 집어 넣어라
 * 		String pw = sc.nextLine(); -> pstmt.setString(1,pw) // pw라는 변수에 가져다 놓고, 첫번째 물음표 대신에 id 값을 집어 넣어라 -> 이 후에 실행시켜야 함.
 * 		키보드로 입력받은 아이디를 첫번째 물음표에 대응, 암호를 두번째 물음표에 대응
 * 
 * 위의 예제에서는 물음표를 안써도됨 -> statement 객체
 * 이미 고정된 값이 들어옴
 *  
 *  
 *  19개의 데이터가 map 에 저장 (key, value)로? ? ?
 *  	-> 복잡하기 때문에 이걸 간략화시킨 테이블을 생성해서 프로그램에 사용할 수 있도록 ? ? ? ? 
 
 * view 도 테이블 명 처럼 쓸 수 잇음
 * create  어쩌구 view~
 * 
 *------------------------------------------------
 *preparedStatements 는 
 *프로그램 실행 시에
 *쿼리 안에 전달
 *for문 사용. 전달되는 데이터가 한개일지 두개일지,, 모름
 *
 *
 *
 */

 