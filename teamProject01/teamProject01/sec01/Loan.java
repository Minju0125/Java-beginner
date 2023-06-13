package teamProject01.sec01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Loan {
	public Loan() {
	}

	public static void main(String[] args) {

		JDBCUtil jdbc=JDBCUtil.getInstance();
		LoginService login = new LoginService();

		jdbc.connectConn();
		login.loginService();

		LoanService loan = new LoanService();
		loan.judgeStudent();
		loan.loanManage();
	}
}

class LoanService {
	
	Scanner sc = new Scanner (System.in);
	JDBCUtil jdbc=JDBCUtil.getInstance();

// �α����� �л��� ���������� ������ �л����� �Ǵ��ϴ� �޼ҵ�
	public void judgeStudent() {
		Scanner sc = new Scanner(System.in);
//		
		Object stdate = jdbc.loginUser.get("STD_STDATE");

		if (stdate != null) {
			System.out.println("��ü���� ������ �����մϴ�. �ݳ� �� ���������� �����մϴ�.");
			return; // �޼ҵ� ���� ��, ȣ���� ������ ���ư�
		} else if (stdate == null) {
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

				String sql1 = "INSERT INTO LEND(BK_NO, STD_NO, LD_NO, LD_DATE, LD_EPDATE, LD_RETDATE, LD_OVERDUE) VALUES(?, ?, LENDNO_SEQ.NEXTVAL, TO_DATE(SYSDATE,'YYYY-MM-DD'), TO_DATE(SYSDATE + 7,'YYYY-MM-DD'), NULL, NULL)";
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
