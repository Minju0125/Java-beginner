package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import util.JDBCUtil;

//로그인만 처리
public class LoginDAO {
	private static LoginDAO instance = null;

	private LoginDAO() {
	}

	public static LoginDAO getInstance() {
		if (instance == null)
			instance = new LoginDAO();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance(); // class 객체 생성

	public Map<String, Object> login(String id, String pass) {
		String sql = "SELECT * FROM TBL_MEMBER WHERE MEM_ID = ? ";
		sql = sql + " AND MEM_PASS = ? ";
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pass);

		return jdbc.selectOne(sql, param); // LoginService 에서 호출 -> 다오에서 유틸을 호출, 서비스에서 다오 호출

	}
	
	//패스워드 불필요한 메소드 . 아이디 중복검사에 필요한 메소드
	public Map<String, Object> select(String id){
		String sql="SELECT * FROM TBL_MEMBER WHERE MEM_ID = ? "; // 출력하려고 하는 결과물에 적당한 쿼리 준비/
		//? 들어갈 자료(id)를  param 라고 하는  ArrayList 에 저장
		List<Object> param=new ArrayList<Object>();
		param.add(id);		
		return jdbc.selectOne(sql, param);
	}
}
