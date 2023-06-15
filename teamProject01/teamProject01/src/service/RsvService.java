package service;

import java.util.Map;

import dao.RsvDAO;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class RsvService {
	private static RsvService instance = null;

	private RsvService() {
	}

	public static RsvService getInstance() {
		if (instance == null)
			instance = new RsvService();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	RsvDAO r1 = RsvDAO.getInstance();

	public int rsvService() {
		System.out.println(" [ ���� ���� ] ");
		if (r1.rsvValueInfo(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), "BK_RSVSNO") == null) {
			System.out.print("å ��ȣ �Է� : ");
			String bk_no = ScanUtil.nextLine();
			if (r1.ldsno(bk_no, "BK_NO") != null) {
				Map<String, Object> bkInfo = r1.bkInfo2(bk_no);
				if (bkInfo.get("BK_RSVSNO") == null && r1.ldsno(bk_no, "BK_LDSNO") != null
						&& bkInfo.get("BK_STM").equals("1")
						&& !bkInfo.get("BK_LDSNO").equals(JDBCUtil.loginUser.get("STD_NO"))) {
					System.out.println(r1.bkInfo1(bk_no));
					System.out.println("���� ������ �����Դϴ�. �����Ͻðڽ��ϱ�?");
					System.out.println("1.��\t2.�ƴϿ�");
					String a = ScanUtil.nextLine();
					switch (a) {
					case "1":
						int result = r1.rsvDAO(JDBCUtil.loginUser.get("STD_NO"), bk_no);
						if (result == 1) {
							System.out.println("���� �Ϸ�");
						} else {
							System.out.println("���� ����");
						}
						break;
					case "2":
						System.out.println("���� ����");
						break;
					default:
						System.out.println("�߸��� ��ȣ�Դϴ�.");
					}
				} else if (r1.bkInfo2(bk_no).get("BK_STM").equals("2")) {
					System.out.println("���� �����Դϴ�.");
				} else if (r1.ldsno(bk_no, "BK_LDSNO") == null) {
					System.out.println("�����ڰ� �����ϴ�. ������ �Ұ����մϴ�.");
				} else if (bkInfo.get("BK_RSVSNO") != null) {
					System.out.println("�����ڰ� �ֽ��ϴ�. ������ �Ұ����մϴ�.");
				} else {
					System.out.println("������ �Ұ����� �����Դϴ�.");
				}
			} else {
				System.out.println("���� �����Դϴ�.");
			}
		} else {
			System.out.println("�̹� ������ ������ �ֽ��ϴ�.");
		}

		return View.S_MAIN;
	}

	
}
