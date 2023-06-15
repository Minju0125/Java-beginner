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
		System.out.println(" [ 추천 도서 ] ");
		System.out.println("1.인기책조회\t2.추천책조회\t3.뒤로가기");

		// while()
		String a = ScanUtil.nextLine();
		switch (a) {
		case "1":
			List<Map<String, Object>> list1 = new ArrayList<>();
			list1 = rcmdDAO.popularity();

			for (int i = 0; i < 10; i++) {
				System.out.print("제목 : " + list1.get(i).get("BK_TITLE") + "   |   ");
				System.out.println();
				System.out.print("저자 : " + list1.get(i).get("BK_WRITER") + "   |   ");
				System.out.print("출판사 : " + list1.get(i).get("BK_PUB") + "   |   ");
				System.out.println();
				System.out.print("책번호 : " + list1.get(i).get("BK_NO") + "   |   ");
				System.out.print("서가코드 : " + list1.get(i).get("BK_SHFCODE") + "   |   ");
				System.out.print("대출자 : " + list1.get(i).get("대출") + "   |   ");
				System.out.println("예약자 : " + list1.get(i).get("예약") + "   |   ");
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
				System.out.print("제목 : " + list2.get(num[i]).get("BK_TITLE") + "   |   ");
				System.out.println();
				System.out.print("저자 : " + list2.get(num[i]).get("BK_WRITER") + "   |   ");
				System.out.print("출판사 : " + list2.get(num[i]).get("BK_PUB") + "   |   ");
				System.out.println();
				System.out.print("책번호 : " + list2.get(num[i]).get("BK_NO") + "   |   ");
				System.out.print("서가코드 : " + list2.get(num[i]).get("BK_SHFCODE") + "   |   ");
				System.out.print("대출자 : " + list2.get(num[i]).get("대출") + "   |   ");
				System.out.println("예약자 : " + list2.get(num[i]).get("예약") + "   |   ");
				System.out.println("=========================================================================");
			}
			return View.S_RECOBOOK;
		case "3":
			return View.S_MAIN;
		default:
			System.out.println("잘못된 번호입니다.");
			return View.S_RECOBOOK;

		}
		
	}
}
