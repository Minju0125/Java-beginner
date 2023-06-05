package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MemberDAO {
	private static MemberDAO instance = null;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	public int update(String sql) {
		return jdbc.update(sql);
	}

	public List<Map<String, Object>> searchAll() { // 서비스클래스에서 얘를 호출해야함
		String sql = "SELECT * FROM Tbl_member ";
		return jdbc.selectList(sql);
	}

	public Map<String, Object> searchOne(String id) {
		String sql = "SELECT * FROM tbl_member WHERE mem_id = ?";
		List<Object> param = new ArrayList<Object> ();
		param.add(id); //여기에 넘겨받은 id를 param에 add
		
		return jdbc.selectOne(sql, param); //sql을 가지고 jdbc의 selectOne을 호출하시오
		// SELECT * FROM TBL_MEMBER WHERE MEM_ID = ? 
		// ?의 순번은 1 (자바와 다르게 0이 아님)
		// id는 mid이기 때문에 이 mid값을 List에 넣어줌 --? 맞나
		// param을 가지고 arrayList의 0번째에 넣음
		
		
	}


}
