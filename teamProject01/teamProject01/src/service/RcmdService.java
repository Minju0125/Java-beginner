package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import dao.RcmdDAO;
import util.View;
import util.ScanUtil;
public class RcmdService {
	private static RcmdService instance = null;

	private RcmdService() {
	}

	public static RcmdService getInstance() {
		if (instance == null)
			instance = new RcmdService();
		return instance;
	}

	RcmdDAO rcmdDAO = RcmdDAO.getInstance();

	public int rcmdService() {			
		System.out.println(" [ ��õ ���� ] ");
		System.out.println("1.�α�å��ȸ\t2.��õå��ȸ\t3.�ڷΰ���");

		// while()
		String a = ScanUtil.nextLine();
		switch (a) {
		case "1":
			List<Map<String, Object>> list1 = new ArrayList<>();
			list1 = rcmdDAO.popularity();

			for (int i = 0; i < 10; i++) {
				System.out.print("���� : " + list1.get(i).get("BK_TITLE") + "   |   ");
				System.out.println();
				System.out.print("���� : " + list1.get(i).get("BK_WRITER") + "   |   ");
				System.out.print("���ǻ� : " + list1.get(i).get("BK_PUB") + "   |   ");
				System.out.println();
				System.out.print("å��ȣ : " + list1.get(i).get("BK_NO") + "   |   ");
				System.out.print("�����ڵ� : " + list1.get(i).get("BK_SHFCODE") + "   |   ");
				System.out.print("������ : " + list1.get(i).get("����") + "   |   ");
				System.out.println("������ : " + list1.get(i).get("����") + "   |   ");
				System.out.println("=========================================================================");
			}
			return View.S_RECOBOOK;
		case "2":
			List<Map<String, Object>> list2 = new ArrayList<>();
			list2 = rcmdDAO.suggestion();
			int[] num = new int[list2.size()];
			for (int i = 0; i < num.length; i++) {
				num[i] = i;
			}
			for (int i = 0; i < 100000; i++) {
				int rnd = (int) (Math.random() * num.length);
				int temp = num[0];
				num[0] = num[rnd];
				num[rnd] = temp;
			}
			for (int i = 0; i < 10; i++) {
				System.out.print("���� : " + list2.get(num[i]).get("BK_TITLE") + "   |   ");
				System.out.println();
				System.out.print("���� : " + list2.get(num[i]).get("BK_WRITER") + "   |   ");
				System.out.print("���ǻ� : " + list2.get(num[i]).get("BK_PUB") + "   |   ");
				System.out.println();
				System.out.print("å��ȣ : " + list2.get(num[i]).get("BK_NO") + "   |   ");
				System.out.print("�����ڵ� : " + list2.get(num[i]).get("BK_SHFCODE") + "   |   ");
				System.out.print("������ : " + list2.get(num[i]).get("����") + "   |   ");
				System.out.println("������ : " + list2.get(num[i]).get("����") + "   |   ");
				System.out.println("=========================================================================");
			}
			return View.S_RECOBOOK;
		case "3":
			return View.S_MAIN;
		default:
			System.out.println("�߸��� ��ȣ�Դϴ�.");
			return View.S_RECOBOOK;

		}
		
	}
}
