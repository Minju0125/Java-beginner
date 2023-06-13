package teamProject01.sec01;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Loan {
	public Loan() {
	}

	public static void main(String[] args) throws SQLException {

		JDBCUtil jdbc = JDBCUtil.getInstance();
		LoginService login = new LoginService();

		jdbc.connectConn();
		login.loginService();

		LoanService loan = new LoanService();
//		loan.judgeStudent0();
		loan.judgeStudent1();
//		loan.loanManage();

	}
}

class LoanService {

	Scanner sc = new Scanner(System.in);
	JDBCUtil jdbc = JDBCUtil.getInstance();

// �α����� �л��� ���������� ������ �л����� �Ǵ��ϴ� �޼ҵ�

	public List<Map<String, Object>> selectList(String sql, List<Object> param) {
		// Ʃ�� �ϳ��� �����ؼ� ��� �÷��� �������� �޼ҵ�
		Map<String, Object> oneRow = null;
		List<Map<String, Object>> info = new ArrayList<>();
		try {
			jdbc.daoConn.pstmt = jdbc.daoConn.conn.prepareStatement(sql);

			for (int i = 0; i < param.size(); i++) {
				jdbc.daoConn.pstmt.setObject(i + 1, param.get(i));
			}

			jdbc.daoConn.rs = jdbc.daoConn.pstmt.executeQuery();

			ResultSetMetaData rsmd = jdbc.daoConn.rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			while (jdbc.daoConn.rs.next()) {
				oneRow = new HashMap<>();
				for (int i = 0; i < columnCount; i++) {
					oneRow.put(rsmd.getColumnName(i + 1), jdbc.daoConn.rs.getObject(i + 1));
				}
				info.add(oneRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	public void judgeStudent1() {
				
		LocalDate now = LocalDate.now();
		String sysdate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		
		String sql = "SELECT (TO_DATE('" + sysdate + "', 'yy-mm-dd')-TO_DATE(LD_EPDATE, 'yy-mm-dd')) dayCount +  FROM LEND WHERE STD_NO= ?"; 
		
		
//		String sql = "SELECT TO_DATE(TO_CHAR(sysdate, 'yyyy/mm/dd'))-LD_EPDATE dayCount FROM LEND WHERE STD_NO= ?";
		
//		String sql = "SELECT TO_DATE(TO_CHAR('" + sysdate+ "', 'yyyy/mm/dd'))-LD_EPDATE dayCount FROM LEND WHERE STD_NO= ?";


		String id = (String) jdbc.loginUser.get("STD_NO");
		List<Object> param = new ArrayList<>();
		param.add(id);
		
		List<Map<String, Object>> list = selectList(sql, param);
		
		for (int i = 0; i < list.size(); i++) {
			Object count = list.get(i).get("DAYDOUNT");
			System.out.println(list.get(i).get("DAYDOUNT"));
		}
		
//		System.out.println(sysdate);
		
	}

	
	public void judgeStudent() {
		Scanner sc = new Scanner(System.in);
		
		
	
//////////////////////////////////////////////////////////////////////////////////////////////
		String sql0 = "SELECT * FROM LEND WHERE STD_NO = ?";
		List<Object> param0 = new ArrayList<>();
		param0.add(jdbc.loginUser.get("STD_NO"));
		String ColumneName0 = "LD_RETDATE";
		
		List<Map<String, Object>> list0 = selectList(sql0, param0);
		
		Object epdate = null;
		for (int i = 0; i<list0.size(); i++) {
			epdate = list0.get(i).get("LD_EPDATE");
		}
		System.out.println(epdate);
		
		
		
		
		
		
///////////////////////////�Ʒ��� epdate�� ���̸鼭 ��ü �Ⱓ�� ���� �ʾ�����///////////////////////////////
		String sql = "SELECT COUNT(*) FROM BOOK WHERE BK_LDSNO = ?";
		String columnName = "COUNT(*)";
		Object param = jdbc.loginUser.get("STD_NO");
		Object countObj = jdbc.selectOneValue(sql, param, columnName);
		int count = Integer.parseInt(countObj.toString());
		
		if (count < 3) {
			System.out.println("���� ������ ������ �л��Դϴ�.");
			judgeBook();
			return; // startLoanService() �޼ҵ忡�� 2.�ƴϿ� �Է½� ����� ���ƿ� ! -> �׸���, �ٽ� �� �޼ҵ带 ȣ���� ���� �б�������
					// �̵�.
		} else {
			System.out.println("�ִ� ���� �Ǽ��� 3���Դϴ�. ���� �Ұ����� �л��Դϴ�.");
			return; // �޼ҵ� ���� ��, ȣ���� ������ ���ư�
		}
	}

	// �Է��� å��ȣ�� ���Ⱑ���� å���� �Ǵ��ϴ� �޼ҵ�
	public void judgeBook() {
		try {
			outerLoop: while (true) {

				System.out.println("�����Ͻ� ������ȣ�� �Է��ϼ��� : ");
				String inputBookNo = sc.nextLine();

				String sql = "select * from book where BK_NO = ?";
				List<Object> param = new ArrayList<>();
				param.add(inputBookNo);

				Map<String, Object> row = jdbc.selectOneRow(sql, param);
				String title = (String) row.get("BK_TITLE");
				String ldsno = (String) row.get("BK_LDSNO");
				String rsvsno = (String) row.get("BK_RSVSNO");
				String id = (String) jdbc.loginUser.get("STD_NO");

				if (ldsno != null) { // �����ڰ� �ִ� ���
					if (ldsno.equalsIgnoreCase(id)) {// �Է��� ������ �л������� �������ΰ��
						System.out.println("�л� ������ �������� å�Դϴ�. �ٸ� å�� �˻��ϼ���.");
						continue outerLoop;// �ٽ� �����˻� â����
						
						
						
						
						
						
						
						
						
						
						
					} else if (rsvsno != null) {// �Է��� ������ ������, �����ڰ� ��� �����ϴ� ���(����Ұ�)
						System.out.println("������,�����ڰ� �����ϴ� å�Դϴ�. �ٸ� å�� �˻��ϼ���.");
						continue outerLoop;// �ٽ� �����˻� â����
					} else if (rsvsno == null) {// �Է��� ������ �����ڰ� ����������, �����ڴ� �������� �ʴ� ���(����Ұ�, ���ุ����)
						System.out.println("���� ���� ���� å���� ����Ұ��մϴ�. (���డ��) ");

						innerLoop: while (true) {
							System.out.println("�����Ͻðڽ��ϱ�? \n1.��	2.�ƴϿ�");
							String answer = sc.nextLine();
							if (answer.equals("1")) {
								// ����޼ҵ� ȣ��
								break outerLoop; // (?)
							} else if (answer.equals("2")) {
								continue outerLoop;
							} else {
								System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
							}
						}
					}
				} else if (ldsno == null) { // �����ڰ� ���� ���, �������� ���� �Ǵ�
					if (rsvsno == null) { // �����ڵ�, �����ڵ� ���� ���
						System.out.println("���� ������ �����Դϴ�.");
						loanBook(inputBookNo);
						break;
					} else if (rsvsno != null) { // ������x, ������o
						if (rsvsno.equals(id)) { // �����ڰ� �л� ������ ���
							System.out.println("������ �����Դϴ�.");
							loanBook(inputBookNo);
							break;
						} else {
							System.out.println("�����ڰ� �����ϴ� å�Դϴ�. �ٸ� å�� �˻��ϼ���.");
							continue;
						}
					}
				}

			}
		} catch (Exception e) {
			System.out.println("�߸��� ���� ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
			judgeBook();
		}
	}

	public void loanBook(String inputBookNo) { // insert lend ���̺� ������ �Է��ϱ�.

		startloop: while (true) {
			System.out.println("�����Ͻðڽ��ϱ�?");
			System.out.println("1.��	2.�ƴϿ�");

			String answer = sc.nextLine();
			if (answer.equals("1")) {
				String id = (String) jdbc.loginUser.get("STD_NO");
				String pw = (String) jdbc.loginUser.get("STD_PW");

				LocalDate now = LocalDate.now();
				LocalDate l = now.plusDays(7);
				String sysdate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String ls = l.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String sql1 = "INSERT INTO LEND(BK_NO, STD_NO, LD_NO, LD_DATE, LD_EPDATE, LD_RETDATE, LD_OVERDUE) VALUES(?, ?, LENDNO_SEQ.NEXTVAL, TO_DATE('"
						+ sysdate + "','YYYY-MM-DD'), TO_DATE('" + ls + "','YYYY-MM-DD'), NULL, NULL)";
				
//				String sql1 = "INSERT INTO LEND(BK_NO, STD_NO, LD_NO, LD_DATE, LD_EPDATE, LD_RETDATE, LD_OVERDUE) VALUES(?, ?, LENDNO_SEQ.NEXTVAL, TO_DATE(sysdate,'YYYY-MM-DD'), TO_DATE(SYSDATE + 7,'YYYY-MM-DD'), NULL, NULL)";
								
				
				
				List<Object> param1 = new ArrayList<>();

				param1.add(inputBookNo);
				param1.add(id);

				int result1 = jdbc.update(sql1, param1);
				System.out.println(result1);

				String sql2 = "UPDATE BOOK SET  BK_LDSNO = ?, BK_LDCNT = BK_LDCNT + 1, BK_RSVSNO = NULL  WHERE BK_NO = ?";
				List<Object> param2 = new ArrayList<>();

				param2.add(id);
				param2.add(inputBookNo);

				int result2 = jdbc.update(sql2, param2);

				if (result1 == 1 && result2 == 1) {
					System.out.println("����Ϸ�");
				} else {
					System.out.println("�������");
				}
				break;
			} else if (answer.equals("2")) {
				break;
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}

		}

	}

	// ������ ���忡�� �������� �븮���� (�����ڰ� �α��� �ܰ踦 ��ģ �� �����ִ� ���¶�� ����)
	public void loanManage() {

		while (true) {

			System.out.println("�л��� �й��� �Է��ϼ��� : ");
			Scanner sc = new Scanner(System.in);
			Object param = sc.nextLine(); // �� ���̵� �л� ���̺��� �й��� �ִ������� �˻��ؼ� select �ؿ;���
			String columnName = "STD_NO";
			Object result = jdbc.isDuplicateSTD(param, columnName); // �� result �� Ʃ���� �� �÷�

			if (result == null) {
				System.out.println("�й��� �߸��Է��ϼ̽��ϴ�. �ٽ� �õ��ϼ���.");
			} else { // �Է��� �й��� �л� ���̺��� �й� �÷��� ������ ��,
				String sql1 = "SELECT * FROM STUDENT WHERE STD_NO = ?";
				List<Object> param1 = new ArrayList<>();
				param1.add(result);

				Map<String, Object> row = jdbc.selectOneRow(sql1, param1);

				Object stdate = row.get("STD_STDATE");

				if (stdate != null) {
					System.out.println("��ü���� ������ �����մϴ�. �ݳ� �� ���������� �����մϴ�.");
					return; // �޼ҵ� ���� ��, ȣ���� ������ ���ư�
				} else if (stdate == null) {
							
					
					
					
					
					
					
					
					
					
					
					String sql2 = "SELECT COUNT(*) FROM BOOK WHERE BK_LDSNO = ?";
					String columnName2 = "COUNT(*)";
					Object param2 = jdbc.loginUser.get("STD_NO");
					Object countObj = jdbc.selectOneValue(sql2, param2, columnName2);
					int count = Integer.parseInt(countObj.toString());
					if (count < 3) {
						System.out.println("���� ������ ������ �л��Դϴ�.");
						System.out.println("�л��̸� : " + row.get("STD_NAME"));
						System.out.println();
						judgeBook();
						return; // startLoanService() �޼ҵ忡�� 2.�ƴϿ� �Է½� ����� ���ƿ� ! -> �׸���, �ٽ� �� �޼ҵ带 ȣ���� ���� �б�������
								// �̵�.
					} else {
						System.out.println("�ִ� ���� �Ǽ��� 3���Դϴ�. ���� �Ұ����� �л��Դϴ�.");
						return; // �޼ҵ� ���� ��, ȣ���� ������ ���ư�
					}

				}
				break;
			}
		}
	}
}
