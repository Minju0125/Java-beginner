package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import util.JDBCUtil;

//�α��θ� ó��
public class LoginDAO {
	private static LoginDAO instance = null;

	private LoginDAO() {
	}

	public static LoginDAO getInstance() {
		if (instance == null)
			instance = new LoginDAO();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance(); // class ��ü ����

	public Map<String, Object> login(String id, String pass) {
		String sql = "SELECT * FROM TBL_MEMBER WHERE MEM_ID = ? ";
		sql = sql + " AND MEM_PASS = ? ";
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pass);

		return jdbc.selectOne(sql, param); // LoginService ���� ȣ�� -> �ٿ����� ��ƿ�� ȣ��, ���񽺿��� �ٿ� ȣ��

	}
	
	//�н����� ���ʿ��� �޼ҵ� . ���̵� �ߺ��˻翡 �ʿ��� �޼ҵ�
	public Map<String, Object> select(String id){
		String sql="SELECT * FROM TBL_MEMBER WHERE MEM_ID = ? "; // ����Ϸ��� �ϴ� ������� ������ ���� �غ�/
		//? �� �ڷ�(id)��  param ��� �ϴ�  ArrayList �� ����
		List<Object> param=new ArrayList<Object>();
		param.add(id);		
		return jdbc.selectOne(sql, param);
	}
}
