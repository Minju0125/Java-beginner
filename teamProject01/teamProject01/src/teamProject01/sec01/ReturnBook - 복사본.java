package teamProject01.sec01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ReturnBook {
	Scanner sc = new Scanner(System.in);
	ReturnBook(){}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//ȣ���ϱ� ���� �ݳ��� å��ȣ�� �Է¹޾Ƽ� �����ְ�, �й��� �Է�or �α��� �������� ������ ����ͼ� �Ű������� �־��ݴϴ�.
	public void returnBook(String stdNo, String bkNo){
		Map<String,Object> returnBookRow = null;
		ResultSet rsrs = null;
		int overDue = 0;
		int update = 0;
		LocalDate now = LocalDate.now();
		String sysdate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate result =null;
		String result1 = "";
		String sql = "SELECT * FROM BOOK WHERE BK_LDSNO = ?";
		//��ü ���̺� �ݳ����ڸ� ������Ʈ�ϴ� ������
		String sql1 = "UPDATE LEND SET LD_RETDATE = TO_DATE('" + sysdate + "', 'yyyy-mm-dd') WHERE LD_NO = (SELECT LD_NO FROM (SELECT LD_NO FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '"+ bkNo +"' ORDER BY LD_NO DESC) WHERE ROWNUM = 1)";
		// ������Ʈ �� �� ���� ������� sql��
		String sql2 = "SELECT * FROM (SELECT * FROM LEND WHERE STD_NO = '"+ stdNo +"' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1";
		// ��ü�� �ش� ���� ���� ���̺��� ��ü���� ���ؼ� ������Ʈ�ϴ� ������
		String sql3 = "UPDATE LEND SET LD_OVERDUE = (SELECT LD_RETDATE - LD_EPDATE FROM (SELECT * FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1) WHERE LD_NO = (SELECT LD_NO FROM (SELECT LD_NO FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1)";
		// ��ü���� ������� ������
		String sqlOverDue ="SELECT LD_OVERDUE FROM (SELECT * FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1";
		// �ݳ� �� å ���̺��� �����ڸ� null�� ������ִ� ������
		String sql5 = "UPDATE BOOK SET BK_LDSNO = NULL WHERE BK_NO = '" + bkNo + "'";
		// ��õ�� �ϳ� ������Ű�� ������
		String sql6 = "UPDATE BOOK SET BK_RCNT = (SELECT BK_RCNT FROM BOOK WHERE BK_NO = '" + bkNo + "')+1 WHERE BK_NO = '" + bkNo + "'";
		// ��� �ݳ��� å�� ��ü���� Ȯ���ϴ� ������
		String sql7 = "SELECT * FROM (SELECT * FROM (SELECT * FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1) a where a.ld_retdate > a.ld_epdate";
		if(bkNo.equals((String)(jdbc.isDuplicateBK(bkNo,"BK_NO")))) { //�Է��� å��ȣ�� ��ȿ�� ���
			if(stdNo.equals((String)(jdbc.selectOneValue(sql, stdNo, "BK_LDSNO")))) { //�Է��� å�� �Է��� �й����� ������ �´°��
				try {
					jdbc.daoConn.stmt.executeUpdate(sql5); 
					update = jdbc.daoConn.stmt.executeUpdate(sql1);
					jdbc.daoConn.conn.commit();
				}catch(SQLException e) {
					System.out.println("�����߻�");
					e.printStackTrace();
				}
				try {
					rsrs = jdbc.daoConn.stmt.executeQuery(sql7);
					if(rsrs!=null) {
						System.out.println("��ü�Ǿ����ϴ�. ��ü������ ������Ʈ�մϴ�.");
						jdbc.daoConn.stmt.executeUpdate(sql3);
						jdbc.daoConn.conn.commit();
						ResultSet rsrsrs = jdbc.daoConn.stmt.executeQuery(sqlOverDue);
						rsrsrs.next();
						overDue = Integer.parseInt((String.valueOf(rsrsrs.getObject("LD_OVERDUE"))));
						result = now.plusDays(overDue);
						result1 = result.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						// ��ü�� �ش� �л��� �������� sysdate+��ü���ڷ� ������Ʈ�ϴ� ������
						String sql4 = "UPDATE STUDENT SET STD_STDATE = TO_DATE('" + result1 + "', 'YYYY-MM-DD') WHERE STD_NO = '" + stdNo + "'";
						jdbc.daoConn.stmt.executeUpdate(sql4);
						jdbc.daoConn.conn.commit();
					}
				} catch (SQLException e) {
					System.out.println("�����߻�");
					e.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("�����ڰ� �ٸ� ����Դϴ�.");
				return;
			}
		}else { // �Է��� å ��ȣ�� ��ȿ���� ���� ���
			System.out.println("å ��ȣ�� ��ȿ���� �ʽ��ϴ�.");
			return;
		}
		System.out.println("�ݳ� �Ͻ� å�� �ٸ� �л����Ե� ��õ�Ͻðڽ��ϱ�?");
		System.out.print("1. ��õ\t|2. ����õ");
		String reco = sc.nextLine();
		switch (reco) {
		case "1": 
			try {
				jdbc.daoConn.stmt.executeUpdate(sql6);
			} catch (SQLException e) {
				System.out.println("��õ �� ���� �߻�");
				e.printStackTrace();
			}
			break;
		case "2":
			System.out.println("��õ���� �ʰ� �ݳ��� �����մϴ�.");	
			return;
		default:
			System.out.println("�߸��ԷµǾ� ��õ�� ���� �ʽ��ϴ�.");
			return;
		}
	}
	
	public void returnBookForStudent() {
		System.out.println("�ݳ��� å�� å ��ȣ�� �Է����ּ���");
		System.out.print("å ��ȣ : ");
		String bkno = sc.nextLine();
		returnBook((String)(jdbc.loginUser.get("STD_NO")),bkno);
	}
	
	public void returnBookForManager() {
		
		System.out.println("�ݳ��ϴ� �л��� �й��� �Է����ּ���");
		System.out.print("�й� : ");
		String stdno = sc.nextLine();
		System.out.println("�ݳ��� å�� å ��ȣ�� �Է����ּ���");
		System.out.print("å ��ȣ : ");
		String bkno = sc.nextLine();
		returnBook(stdno,bkno);
	}
	
	
	
	
	
	
	
}