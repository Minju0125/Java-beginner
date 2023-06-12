package teamProject01.sec01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewBooks {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		NewBooksService newBooks = new NewBooksService();

		jdbc.connectConn();
		newBooks.newBooksService();
		jdbc.disconnectConn();

	}
}

class NewBooksDao {
	Scanner sc = new Scanner(System.in);
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public int newBooksDao(String bk_ctcode, String bk_shfcode, String bk_title, String bk_writer, String bk_pub) {
		String sql = " {CALL reg_book( ?, ?, ?, ?, ?)} ";// '�з��ڵ�', 'å���ȣ', 'å����, '����', '���ǻ�'
		List<Object> param = new ArrayList<>();
		param.add(bk_ctcode);
		param.add(bk_shfcode);
		param.add(bk_title);
		param.add(bk_writer);
		param.add(bk_pub);

		return jdbc.procedureUpdate(sql, param);
	}
}

class NewBooksService {
	Scanner sc = new Scanner(System.in);
	JDBCUtil jdbc = JDBCUtil.getInstance();
	NewBooksDao newBooksDAO = new NewBooksDao();

	public void newBooksService() {
		boolean bl01 = true;
		while (bl01) {
			System.out.println("[ ���� �Է� ]");
			System.out.print("�з���ȣ �Է� : ");
			String bk_ctcode = sc.nextLine();
			System.out.print("�����ڵ� �Է� : ");
			String bk_shfcode = sc.nextLine();
			System.out.print("å���� �Է� : ");
			String bk_title = sc.nextLine();
			System.out.print("���� �Է� : ");
			String bk_writer = sc.nextLine();
			System.out.print("���ǻ� �Է� : ");
			String bk_pub = sc.nextLine();
			System.out.println("---------------------------------------");
			System.out.println("�з���ȣ : " + bk_ctcode);
			System.out.println("�����ڵ� : " + bk_shfcode);
			System.out.println("å���� : " + bk_title);
			System.out.println("���� : " + bk_writer);
			System.out.println("���ǻ� : " + bk_pub);
			System.out.println("������ ����Ͻðڽ��ϱ�?");
			System.out.println("�� : 1\t�ƴϿ� : 2\t      ������ : 3");
			int a = sc.nextInt();
			System.out.println("---------------------------------------");
			switch(a) {
			case 1 :
				int result = newBooksDAO.newBooksDao(bk_ctcode, bk_shfcode, bk_title, bk_writer, bk_pub);
				if (result == 1) {
					System.out.println("���� �Է� �Ϸ�");
					bl01 = false;
				} else {
					System.out.println("���� �Է� ����");
					bl01 = false;
				}
				break;
			case 2 :				//while������ �ƴϿ� Ŭ������ �� �ٽ� �Է¹��������ϸ� �з��ڵ��Է� sc.nextLine ������
				System.out.println("���� �Է� ����");
				bl01=false;
				break;
			default :
				System.out.println("�߸��� ��ȣ�Դϴ�.");
				bl01=false;
				
			}
		}
	}
}