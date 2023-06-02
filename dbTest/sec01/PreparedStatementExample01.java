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

/*���� query ��ɾ� ��ü
-> �ڹ��� ����ð��� �ʿ��� �����͸� �Է¹޾� ���� ����
1) ������ �Ҵ�� �� ��� ?�� ����Ͽ� ���� ����
	 ex) tbl_member�� �ű�ȸ�� ����Ϸ���,
	 sql = "insert into tbl_member values (?,?,?,?,?)"
2)	query�� ?�� �ش�Ǵ� ���� ���ν��Ѿ���.
	query�� ?�� �����ϴ� ������ mapping (setter �޼ҵ� : set������Ÿ��)
	��ɾü����.set������Ÿ�� (?����, ��)
	ex) PreparedStatement ps = conn PreparedStatement(sql);
	 	ps.setString(1,"a002") -> mem_id //String : ���̺� �÷��� ������ Ÿ��
	 	ps.setString(2, "09876") -> mem_pass
	 	ps.setString(3, "������") -> mem name
	 	ps.setString(4, "951230-1234567") -> mem_jumin
	 	ps.setInt(5,1000) -> mem_milege
	���εǸ� ���� �ϼ�(������ ����)
	������ 2���� ��� - > execute����(������ select���϶�), �������� executeUpdate �޼ҵ� ���
3) ���� ����
	* select �� : executeQuery()
	* �� �̿��� query :  executeUpdate()
4) ������
	* select ��: ResultSet ��ü�� ����
	ex) ResultSet rs = executeQuery(); // ResultSet�� �ϳ��� ��
	while(rs.next()) {
			String mid = rs.getString("MEM_ID");
					:
			int mileage = rs.getInt("MEM_MILEAGE");
	}
	* �� �̿��� query : Ŀ�� (������ ������� ��(row)�� ����)�� ���� �� (����) 
*/

public class PreparedStatementExample01 {
	static Scanner sc = new Scanner(System.in); // static �����ϸ� ��ĳ��Ŭ������ �� Ŭ���� �ȿ��� ��𼭳� ���� ����.

	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "pc13";
	private String passwd = "java";

	private Connection conn;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private int rowCount = 0;

	public static void main(String[] args) {

		String sql = "INSERT INTO tbl_member VALUES(?,?,?,?,?)"; // sql ���� ����
		PreparedStatementExample01 ps01 = new PreparedStatementExample01();
		int result = ps01.insert(sql);

		int result = new PreparedStatementExample01().insert(sql);
		if (result != 0) {
			System.out.println("�ڷᰡ ���������� ����Ǿ����ϴ�. ");
		} else {
			System.out.println("�ڷᰡ ������� �ʾҽ��ϴ�. ");

		}
		result = ps01.update();
	}

	public int insert(String sql) {

		String mid = "";
		// �Է¹��� ȸ�����̵��� �ߺ����θ� ���� �ľ��ϴ� while��
		while (true) {
			System.out.print("ȸ�� ���̵� : ");
			mid = sc.next();
//			param.add(mid);
			LoginService loginService = LoginService.getInstance();
			Map<String, Object> map = loginService.isDuplicate(mid); // �α��� ���񽺿� �ִ� �޼ҵ�
			if (map != null) {
				System.out.println("���̵� �ߺ��Ǿ����ϴ�...");
			} else {
				break;
			}
		}
		System.out.print("ȸ���� : ");
		String mname = sc.next();

		System.out.print("��й�ȣ : ");
		String pw = sc.next();

		System.out.print("�ֹε�Ϲ�ȣ : ");
		String jumin = sc.next();

		System.out.print("���ϸ��� : ");
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
		// ȸ�����̵� �޾Ƽ� �ߺ��� �Ǿ�� update �� �� ����
		// ������Ʈ ����� �̹� �����ؾ� ��������. -- �ڷ� ������ insert ��

		String mid = "";
		String flag = "";
		String pw = "";
		String jumin = "";
		int mileage = 0;
		List<Object> param = new ArrayList<Object>();

		// �Է¹��� ȸ�����̵��� �ߺ����θ� ���� �ľ��ϴ� while��
		while (true) {
			System.out.print("ȸ�� ���̵� : ");
			mid = sc.next();
//		param.add(mid);
			LoginService loginService = LoginService.getInstance();
			Map<String, Object> map = loginService.isDuplicate(mid); // �α��� ���񽺿� �ִ� �޼ҵ�
			if (map == null) {
				System.out.println("ȸ�������� �����ϴ�.");
			} else {
				param.add(mid); // **********************�̰� �� �ϴ���??
				break;
			}
		}

		System.out.print("��й�ȣ��  �����ϰڽ��ϱ�? (Y/N) : ");
		flag = sc.next();
		while (flag.equalsIgnoreCase("y")) {
			System.out.print("��й�ȣ : ");
			pw = sc.next(); // **********************nextLine�ƴϰ� next??
			param.add(pw);
		}
		System.out.println("�ֹι�ȣ�� �����ϰڽ��ϱ�? (Y/N) : ");
		flag = sc.next();
		while (flag.equalsIgnoreCase("y")) {
			System.out.println("�ֹε�Ϲ�ȣ : ");
			jumin = sc.next();
		}

		System.out.println("���ϸ����� �����ϰڽ��ϱ�? (Y/N) : ");
		flag = sc.next();
		while (flag.equalsIgnoreCase("y")) {
			System.out.println("���ϸ��� : ");
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
