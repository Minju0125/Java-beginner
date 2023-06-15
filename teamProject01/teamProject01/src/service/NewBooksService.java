package service;

import util.ScanUtil;
import dao.NewBooksDAO;
import util.JDBCUtil;
import util.View;

public class NewBooksService {
	private static NewBooksService instance = null;

	private NewBooksService() {
	}

	public static NewBooksService getInstance() {
		if (instance == null)
			instance = new NewBooksService();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	NewBooksDAO newBooksDAO = NewBooksDAO.getInstance();

	public int newBooksService() {
		boolean bl01 = true;
		while (bl01) {
			System.out.println("[ ���� �Է� ]");
			System.out.print("�з���ȣ �Է� : ");
			String bk_ctcode = ScanUtil.nextLine();
			System.out.print("�����ڵ� �Է� : ");
			String bk_shfcode = ScanUtil.nextLine();
			System.out.print("å���� �Է� : ");
			String bk_title = ScanUtil.nextLine();
			System.out.print("���� �Է� : ");
			String bk_writer = ScanUtil.nextLine();
			System.out.print("���ǻ� �Է� : ");
			String bk_pub = ScanUtil.nextLine();
			System.out.println("---------------------------------------");
			System.out.println("�з���ȣ : " + bk_ctcode);
			System.out.println("�����ڵ� : " + bk_shfcode);
			System.out.println("å���� : " + bk_title);
			System.out.println("���� : " + bk_writer);
			System.out.println("���ǻ� : " + bk_pub);
			System.out.println("������ ����Ͻðڽ��ϱ�?");
			System.out.println("�� : 1\t�ƴϿ� : 2\t      ������ : 3");
			String a = ScanUtil.nextLine();
			System.out.println("---------------------------------------");
			switch (a) {
			case "1":
				int result = newBooksDAO.newBooksDao(bk_ctcode, bk_shfcode, bk_title, bk_writer, bk_pub);
				if (result == 1) {
					System.out.println("���� �Է� �Ϸ�");
					bl01 = false;
				} else {
					System.out.println("���� �Է� ����");
					bl01 = false;
				}
				break;
			case "2": // while������ �ƴϿ� Ŭ������ �� �ٽ� �Է¹��������ϸ� �з��ڵ��Է� sc.nextLine ������
				System.out.println("���� �Է� ����");
				bl01 = false;
				break;
			default:
				System.out.println("�߸��� ��ȣ�Դϴ�.");
				bl01 = false;

			}
		}
		return View.M_MANBOOK;
	}
}
