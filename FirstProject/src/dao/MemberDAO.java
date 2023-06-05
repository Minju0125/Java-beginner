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

	public List<Map<String, Object>> searchAll() { // ����Ŭ�������� �긦 ȣ���ؾ���
		String sql = "SELECT * FROM Tbl_member ";
		return jdbc.selectList(sql);
	}

	public Map<String, Object> searchOne(String id) {
		String sql = "SELECT * FROM tbl_member WHERE mem_id = ?";
		List<Object> param = new ArrayList<Object> ();
		param.add(id); //���⿡ �Ѱܹ��� id�� param�� add
		
		return jdbc.selectOne(sql, param); //sql�� ������ jdbc�� selectOne�� ȣ���Ͻÿ�
		// SELECT * FROM TBL_MEMBER WHERE MEM_ID = ? 
		// ?�� ������ 1 (�ڹٿ� �ٸ��� 0�� �ƴ�)
		// id�� mid�̱� ������ �� mid���� List�� �־��� --? �³�
		// param�� ������ arrayList�� 0��°�� ����
		
		
	}


}
