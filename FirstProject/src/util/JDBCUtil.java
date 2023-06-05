package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//JDBC를 사용하여 CRUD를 효율적으로 사용할 수 있는 메서드를 포함한 class
public class JDBCUtil {
//싱글톤패턴 적용
	private static JDBCUtil instance = null;

	private JDBCUtil() {
	}

	public static JDBCUtil getInstance() {
		if (instance == null)
			instance = new JDBCUtil();
		return instance;
	}

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "pc13";
	private String passwd = "java";

	private Connection conn;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public List<Map<String, Object>> selectList(String sql) {
		// 맵으로부터 매개변수를 받지 않고 하나의 데이터만 있는 경우
		// 매개변수 없이 이미 완성된 채로 들어오는 경우
		// SELECT * FROM tbl_member -> 이런 경우 처리해주는 것 (WHERE 절 X)
		// LIST 를 사용하는 경우는 ?를 사용하여 키보드로 입력받아야할때.
		// DELETE FROM TBL_MEMBER 이럴 때 사용할 수 있는 SQL 명령

		// 사용하려면 try-catch블록 써야함.

		// 한사람의 데이터 저장 -> map 에 저장해서 보냄

		// 값을 보관할 장소 선정 . 아직 값이 들어오지 않았기 때문에 null 처리함.
		List<Map<String, Object>> list = null;

		try {
			conn = DriverManager.getConnection(url, user, passwd);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 컬럼의 수, 컬럼명
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				if (list == null)
					list = new ArrayList<>();

				// 해시맵을 생성해서 집어넣음
				Map<String, Object> row = new HashMap<>();
				for (int i = 0; i < columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					// or String key=rsmd.getColumnName(i);
					Object value = rs.getObject(i);
					row.put(key, value);

				}
				list.add(row);
			}
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
		return list;

	}

	public Map<String, Object> selectOne(String sql, List<Object> param) {
		// sql="SELECT * FROM tbl_member WHERE mem_id = ? and
		// mem_pass = ? "
		Map<String, Object> row = null;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			pstmt = conn.prepareStatement(sql);
			// sql에 존재하는 ?에 대응되는 데이터 mapping=>
			// pstmt.set타입명(?순번,데이터)
			for (int i = 0; i < param.size(); i++) {
				pstmt.setObject(i + 1, param.get(i)); //?와 실제 데이터를 맵핑시켜라
			}
			rs = pstmt.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				row = new HashMap<>();
				for (int i = 0; i < columnCount; i++) {
					String key = rsmd.getColumnLabel(i + 1);
					Object value = rs.getObject(i + 1);
					row.put(key, value); // 첫번째사람의 컬럼별 자료 5개 ~ 마지막 사람까지.
				}
			}
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
			// 한맵이 반환됨
		return row;
	}

	public int update(String sql) {
		// update tbl_member set mem_mileage=1000 where mem_id='a00'
		// insert into tbl_member(mem_id,mem_pass,mem_name)
		// values('a003','789012','이순신');
		// delete from tbl_member where mem_id='s001'
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
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
		return result;
	}
}
