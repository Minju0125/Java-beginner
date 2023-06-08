package sec01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//�����뿩 Ŭ����
class Loan {
	public Loan() {
	}

	public static void main(String[] args) {

		JDBCUtil jdbc = new JDBCUtil();
		LoginService login = new LoginService();

////		�α����� ���̵� �Է¹޾Ƽ� , �����Ҷ� (test) 
//		jdbc.connectConn();
//		login.loginService();
		/////////////////////////////

		LoanService loan = new LoanService();
		loan.loanService();
	}
}

class LoanService extends JDBCUtil {
	public void loanService() {
		Scanner sc = new Scanner(System.in);
		// ���� ���� ������ �Ǽ� ������ �ϴ¸޼ҵ� ������
		System.out.println("[������ �뿩�Ͻðڽ��ϱ�?] -- ���� �Է�");
		System.out.println("1. �� \n2. �ƴϿ�(������)");
		int answer = Integer.parseInt(sc.nextLine());
		while (true) {
			if (answer == 1) {
				judgement();
				break;

			} else if (answer == 2) {

				// Ȩȭ������.
				break;
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				System.out.println("1. �� \n2. �ƴϿ�(������)");
				answer = Integer.parseInt(sc.nextLine());
			}

		}

	}

	// �����뿩�� �������� �Ǵ��ϴ� �޼ҵ�
	public void judgement() {
		daoConn.connectConn(); // db�� Ŀ�ؼ��ϴ� �޼ҵ�.

		System.out.println("å��ȣ�� �Է��ϼ��� : ");
		String inputBookNo = sc.nextLine(); // �� å��ȣ�� ������ selectOneRow�� Ʃ�� �ϳ��� �����´�!
		///////////////

		String sql = "select * from book where BK_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(inputBookNo);

		JDBCUtil jdbc = new JDBCUtil();

		Map<String, Object> row = jdbc.selectOneRow(sql, param);
		String title = (String) row.get("BK_TITLE");
		String ldsno = (String) row.get("BK_LDSNO");
		String rsvsno = (String) row.get("BK_RSVSNO");

//		System.out.println(title); //å��ȣ�� �Է¹޾� �� Ʃ���� �÷�/ ��� ����ϴ°ű����� �� !
//		System.out.println(rsvsno);

		if (ldsno != null && rsvsno != null) {
			System.out.println("�뿩����");
		} else if (ldsno != null) {
			System.out.println("���� ���� ���� å���� ����Ұ��մϴ�. ");
			System.out.println("�����Ͻðڽ��ϱ�? \n1.��	2.�ƴϿ�");
			int answer = Integer.parseInt(sc.nextLine());
			while (true) {
				if (answer == 1) {
					// ����޼ҵ� ȣ��
					break;
				} else if (answer == 2) {
					// Ȩ���� ������ ? �ڷ� ����?
					break;
				} else {
					System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
					answer = Integer.parseInt(sc.nextLine());
				}
			}

		} else {
			System.out.println("���� ������ �����Դϴ�.�����Ͻðڽ��ϱ�?");
			System.out.println("1.��	2.�ƴϿ�");
			int answer = Integer.parseInt(sc.nextLine());
			// 1. �� ������ insert �޼ҵ� ȣ��
			while (true) {
				if (answer == 1) {
					Object id = jdbc.loginUser.get("STD_ID");
					String sql1 = "UPDATE BOOK SET BK_LDSNO = ?, BK_LDCNT = BK_LDCNT + 1";
					List<Object> param1 = new ArrayList<>();
					param1.add(id);
					jdbc.update(sql1, param1);
					break;
				} else if (answer == 2) {
					// Ȩ���� ������ ? �ڷ� ����?
					break;
				} else {
					System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
					answer = Integer.parseInt(sc.nextLine());
				}

			}

			/*
			 * �� -> book ���̺�)BK_LDSNO �� �й� �߰� BK_LDCNT +1 LEND ���̺�) INSERT LD_NO, LD_DATE����
			 * SYSDATE, STD_ID �߰�, BK_NO �߰�
			 * 
			 * �ϰ�, ȭ�鿡 �ݳ�����, �� ���� ����ֱ� ( �й� : �̸� : ���⵵���� : ���⵵����ȣ : ������ : �ݳ����� :
			 * 
			 */

		}
	}

}

/*
 * �����˻��� ���� ������ å ���̺��� �����ڰ� null�̸鼭, �����ڰ� null �̸鼭, �л����̺��� �α��� �� ���� �Է¹��� id�� �ش�
 * Ʃ�� �� �л��� ���� �뿩�����Ǽ��� 3 �̸��� ��쿡 �뿩�� �����ϴ�.
 */
// �������� null �ΰ͵� �߰��ؾ���.
//
//	if(BK_RSVID==null&&BK_LDID==null)
//
//	{// �ش� å�� ������, �����ڰ� ���� ���
//		if (����뿩�����Ǽ� < 3) {// �л��� ���� �뿩�����Ǽ��� 3�̸��� ���, ���Ⱑ��
//			System.out.println("(3-����뿩���ε����Ǽ�)�� �����뿩 ����. \n �뿩�Ͻðڽ��ϱ�?");
//			System.out.println("1.�� // 2.�ƴϿ�");
//			if (Integer.parseInt(sc.nextLine()) == 1) {
//				loan();// 1��
//						// �Է��ϸ�,
//						// �����뿩
//						// �޼ҵ�
//						// ȣ��
//			} else if (Integer.parseInt(sc.nextLine()) == 2) {
//				// ������. ?? break �� �ƴѵ�,, ����
//				break; // �극��ũ�ϸ� ���� �����°���?
//			}
//		} else {
//			System.out.println("�ִ� �뿩 �Ǽ�(3��)�� �ʰ��Ͽ�, �뿩 �Ұ����մϴ�.");
//			// �뿩���� å�� �߸� ������? -> list �� ��������
//			// List<String> listBooks = �ش� id�� �л��� �뿩���� å list �����ϰ�
//			// for(int i = 0; i<listBooks.length; i++) {
//			// System.out.println("���� �뿩���� å")
//			// System.out.println(i + "." + listBooks[i])
//		}
//	}

//	}

//public Map<String, Object> selectOne(String sql, List<Object> param) {
// sql="SELECT * FROM tbl_member WHERE mem_id = ? and
// mem_pass = ? "
