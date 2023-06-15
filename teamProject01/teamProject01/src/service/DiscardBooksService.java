package service;

import java.util.ArrayList;
import java.util.List;
import dao.DiscardBooksDAO;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class DiscardBooksService {
	private static DiscardBooksService instance = null;

	private DiscardBooksService() {
	}

	public static DiscardBooksService getInstance() {
		if (instance == null)
			instance = new DiscardBooksService();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	DiscardBooksDAO dBDao = DiscardBooksDAO.getInstance();

	public int discardBooks() {
		String bk_no = null;
		loop : while (true) {
			System.out.print("����� ����(å��ȣ) : ");
			bk_no = ScanUtil.nextLine();;
			if (bk_no.equals(jdbc.isDuplicateBK(bk_no, "BK_NO"))
					&& ((String) jdbc.isDuplicateBK(bk_no, "BK_STM")).equals("1")) { //// "1"-> STM ����Ʈ�� 1�� ����ƴ��� �� Ȯ��
				List<Object> param = new ArrayList<>();
				param.add(bk_no);
				System.out.println(dBDao.bkInfo(bk_no));
				System.out.println("����Ϸ��� ������ �½��ϱ�?\n1:��\t2:�ƴϿ�");
				String a = ScanUtil.nextLine();;
				if (a.equals("1")) {
					int result1 = dBDao.discardBooksDAO(bk_no);
					if (dBDao.retInfo(bk_no) != null) {
						int result2 = dBDao.setdcbDate(bk_no);
						if (result1 == 1 && result2 == 1) {
							System.out.println("���� ��� �Ϸ�");
						} else if (result1 != 1) {
							System.out.println("���� ��� ����(���ó�� ����)");
						} else if (result2 != 1) {
							System.out.println("���� ��� ����(��⳯¥ ���� ����)");
						}
					} else {
						if (result1 == 1) {
							System.out.println("���� ��� �Ϸ�");
							break loop;
						} else {
							System.out.println("���� ��� ����(���ó�� ����)");
							break;
						}
					}
					
				} else if (a.equals("2")) {
					System.out.println("�ٽ� �Է��ϼ���.");
				} else {
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
				}
			} else {
				System.out.println("���� �����Դϴ�.");
			}
		}

		return View.M_MANBOOK;
	}
}
