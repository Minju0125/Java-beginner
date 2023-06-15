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
		System.out.println(" [ 도서 예약 ] ");
		if (r1.rsvValueInfo(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), "BK_RSVSNO") == null) {
			System.out.print("책 번호 입력 : ");
			String bk_no = ScanUtil.nextLine();
			if (r1.ldsno(bk_no, "BK_NO") != null) {
				Map<String, Object> bkInfo = r1.bkInfo2(bk_no);
				if (bkInfo.get("BK_RSVSNO") == null && r1.ldsno(bk_no, "BK_LDSNO") != null
						&& bkInfo.get("BK_STM").equals("1")
						&& !bkInfo.get("BK_LDSNO").equals(JDBCUtil.loginUser.get("STD_NO"))) {
					System.out.println(r1.bkInfo1(bk_no));
					System.out.println("예약 가능한 도서입니다. 예약하시겠습니까?");
					System.out.println("1.예\t2.아니오");
					String a = ScanUtil.nextLine();
					switch (a) {
					case "1":
						int result = r1.rsvDAO(JDBCUtil.loginUser.get("STD_NO"), bk_no);
						if (result == 1) {
							System.out.println("예약 완료");
						} else {
							System.out.println("예약 실패");
						}
						break;
					case "2":
						System.out.println("예약 실패");
						break;
					default:
						System.out.println("잘못된 번호입니다.");
					}
				} else if (r1.bkInfo2(bk_no).get("BK_STM").equals("2")) {
					System.out.println("없는 도서입니다.");
				} else if (r1.ldsno(bk_no, "BK_LDSNO") == null) {
					System.out.println("대출자가 없습니다. 예약이 불가능합니다.");
				} else if (bkInfo.get("BK_RSVSNO") != null) {
					System.out.println("예약자가 있습니다. 예약이 불가능합니다.");
				} else {
					System.out.println("대출이 불가능한 도서입니다.");
				}
			} else {
				System.out.println("없는 도서입니다.");
			}
		} else {
			System.out.println("이미 예약한 도서가 있습니다.");
		}

		return View.S_MAIN;
	}

	
}
