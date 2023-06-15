package util;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JDBCUtil {

	DAOConnection daoConn = DAOConnection.getInstance();
	private static JDBCUtil instance = null;

	private JDBCUtil() {
	}

	public static JDBCUtil getInstance() {
		if (instance == null)
			instance = new JDBCUtil();
		return instance;
	}
	
	/*
	 * daoConn�� ���� ���� protected static Connection conn = null; protected Statement
	 * stmt = null; protected PreparedStatement pstmt = null; protected ResultSet rs
	 * = null; �� ���� ����..? daoConn. ���� �����ؼ� ���
	 */
	public static Map<String, Object> loginUser = null;

	public void connectConn() {
		daoConn.connectConn();

	}

	public void disconnectConn() {
		daoConn.disconectConn();
	}

	public void clearConsole() { // �ܼ�â�� ���� 80�� �Է��ؼ� ����ִ� �޼ҵ�
		for (int i = 0; i < 80; i++)
			System.out.println();
		
	}

	public List<Map<String, Object>> selectList(String sql, List<Object> param) {
		// ?�� ������ ����  List�� �޾Ƽ� ��� Ʃ���� ���� ��ҷ��ϴ� List�� ��ȯ���ִ� �޼ҵ�
		Map<String, Object> oneRow = null;
		List<Map<String, Object>> info = new ArrayList<>();
		try {
			daoConn.pstmt = daoConn.conn.prepareStatement(sql);

			for (int i = 0; i < param.size(); i++) {
				daoConn.pstmt.setObject(i + 1, param.get(i));
			}

			daoConn.rs = daoConn.pstmt.executeQuery();

			ResultSetMetaData rsmd = daoConn.rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			while (daoConn.rs.next()) {
				oneRow = new HashMap<>();
				for (int i = 0; i < columnCount; i++) {
					oneRow.put(rsmd.getColumnName(i + 1), daoConn.rs.getObject(i + 1));
				}
				info.add(oneRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	
	public List<Map<String, Object>> selectList(String sql, Object param) {
		// ?�� ������ ����  Object�� �ϳ��� �޾Ƽ� ��� Ʃ���� ���� ��ҷ��ϴ� List�� ��ȯ���ִ� �޼ҵ�
		Map<String, Object> oneRow = null;
		List<Map<String, Object>> info = new ArrayList<>();
		try {
			daoConn.pstmt = daoConn.conn.prepareStatement(sql);
			daoConn.pstmt.setObject(1, param);
			daoConn.rs = daoConn.pstmt.executeQuery();
			
			ResultSetMetaData rsmd = daoConn.rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while (daoConn.rs.next()) {
				oneRow = new HashMap<>();
				for (int i = 0; i < columnCount; i++) {
					oneRow.put(rsmd.getColumnName(i + 1), daoConn.rs.getObject(i + 1));
				}
				info.add(oneRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	public List<Map<String, Object>> selectList(String sql) {
		// sql���常 �޾Ƽ� ��ȸ�Ǵ� ��� Ʃ���� Map�� ��ҷ��ϴ� List�� ��ȯ���ִ� �޼ҵ�
		Map<String, Object> oneRow = null;
		List<Map<String, Object>> info = new ArrayList<>();
		try {
			daoConn.stmt = daoConn.conn.createStatement();
			daoConn.rs = daoConn.stmt.executeQuery(sql);
			
			ResultSetMetaData rsmd = daoConn.rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while (daoConn.rs.next()) {
				oneRow = new HashMap<>();
				for (int i = 0; i < columnCount; i++) {
					oneRow.put(rsmd.getColumnName(i + 1), daoConn.rs.getObject(i + 1));
				}
				info.add(oneRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	public Map<String, Object> selectOneRow(String sql, List<Object> param) {
		// Ʃ�� �ϳ��� �����ؼ� ��� �÷��� �������� �޼ҵ�
		Map<String, Object> info = null;
		try {
			daoConn.pstmt = daoConn.conn.prepareStatement(sql);

			for (int i = 0; i < param.size(); i++) {
				daoConn.pstmt.setObject(i + 1, param.get(i));
			}

			daoConn.rs = daoConn.pstmt.executeQuery();

			ResultSetMetaData rsmd = daoConn.rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			while (daoConn.rs.next()) {
				info = new HashMap<>();
				for (int i = 0; i < columnCount; i++) {
					info.put(rsmd.getColumnName(i + 1), daoConn.rs.getObject(i + 1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	public Map<String, Object> selectOneRow(String sql, Object param) {
		// Ʃ�� �ϳ��� �����ؼ� ��� �÷��� �������� �޼ҵ�
		Map<String, Object> info = null;
		try {
			daoConn.pstmt = daoConn.conn.prepareStatement(sql);
			daoConn.pstmt.setObject(1, param);
			daoConn.rs = daoConn.pstmt.executeQuery();
			
			ResultSetMetaData rsmd = daoConn.rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while (daoConn.rs.next()) {
				info = new HashMap<>();
				for (int i = 0; i < columnCount; i++) {
					info.put(rsmd.getColumnName(i + 1), daoConn.rs.getObject(i + 1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	public Object selectOneValue(String sql, Object param, String columnName) {
		// Ʃ���� �� �÷� ���� �������� �޼ҵ�, �÷��� ���� �ִ��� Ȯ���� �� ���(isDuplicate�� �Բ� ���)
		// where�� ���� �ϳ��� �� �� ����(pk �����ͼ� ���, ���� �� �ް������ param-List�� �����ؼ� �ٽø�������)
		Object result = null;
		try {
			daoConn.pstmt = daoConn.conn.prepareStatement(sql);
			daoConn.pstmt.setObject(1, param);
			daoConn.rs = daoConn.pstmt.executeQuery();

			while (daoConn.rs.next()) {
				result = daoConn.rs.getObject(columnName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Object selectOneValue(String sql, List<Object> param, String columnName) {
		// Ʃ���� �� �÷� ���� �������� �޼ҵ�, �÷��� ���� �ִ��� Ȯ���� �� ���(isDuplicate�� �Բ� ���)
		// where�� ���� �ϳ��� �� �� ����(pk �����ͼ� ���, ���� �� �ް������ param-List�� �����ؼ� �ٽø�������)
		Object result = null;
		try {
			daoConn.pstmt = daoConn.conn.prepareStatement(sql);
			for (int i = 0; i < param.size(); i++) {
				daoConn.pstmt.setObject(i + 1, param.get(i));
			}
			
			daoConn.rs = daoConn.pstmt.executeQuery();
			while (daoConn.rs.next()) {
				result = daoConn.rs.getObject(columnName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int update(String sql, List<Object> param) {
		// sql=" insert into emp(empno, ename, job, sal, deptno)
		// values (?, ?, ?, ?, ?) "
		// ����Ʈ param �ȿ� �ִ� ������ŭ ?���� ��������
		int ret = 0;
		try {

			daoConn.pstmt = daoConn.conn.prepareStatement(sql);
			for (int i = 0; i < param.size(); i++) {
				daoConn.pstmt.setObject(i + 1, param.get(i));
			}
			ret = daoConn.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	// SQL���� �޾Ƽ� �ٷ� ������Ʈ������ �����ϴ� �޼ҵ�
	public int update(String sql) {
		int ret = 0;
		try {
			daoConn.stmt = daoConn.conn.createStatement();
			ret = daoConn.stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public int procedureUpdate(String sql, List<Object> param) {
		// sql=" insert into emp(empno, ename, job, sal, deptno)
		// values (?, ?, ?, ?, ?) "
		// ����Ʈ param �ȿ� �ִ� ������ŭ ?���� ��������
		int ret = 0;
		try {

			daoConn.cstmt = daoConn.conn.prepareCall(sql);
			for (int i = 0; i < param.size(); i++) {
				daoConn.cstmt.setString(i + 1, (String) param.get(i));
			}
			ret = daoConn.cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public Object isDuplicateSTD(Object param, String columnName) {
		// STDENT���̺��� �Ű������� ���� ���� ���� �Ű������� �÷��� �ִ��� Ȯ���ϴ� �޼ҵ�
		// DAO ��Ű����-> ���� �����ؼ� ���(���̺�, where�� �÷��� ����)
		// ��ӹ޾� ���°ͺ��� ����� Ŭ���� �ȿ� �޼ҵ� �������� ���°� ��õ!
		String sql = "select * from STUDENT where STD_NO=? ";

		return selectOneValue(sql, param, columnName);

	}

	public Object isDuplicateBK(Object param, String columnName) {
		// STDENT���̺��� �Ű������� ���� ���� ���� �Ű������� �÷��� �ִ��� Ȯ���ϴ� �޼ҵ�
		// DAO ��Ű����-> ���� �����ؼ� ���(���̺�, where�� �÷��� ����)
		// ��ӹ޾� ���°ͺ��� ����� Ŭ���� �ȿ� �޼ҵ� �������� ���°� ��õ!
		String sql = "select * from BOOK where BK_NO=? ";

		return selectOneValue(sql, param, columnName);

	}
}
