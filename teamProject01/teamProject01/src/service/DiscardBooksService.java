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
			System.out.print("폐기할 도서(책번호) : ");
			bk_no = ScanUtil.nextLine();;
			if (bk_no.equals(jdbc.isDuplicateBK(bk_no, "BK_NO"))
					&& ((String) jdbc.isDuplicateBK(bk_no, "BK_STM")).equals("1")) { //// "1"-> STM 디폴트값 1로 변경됐는지 잘 확인
				List<Object> param = new ArrayList<>();
				param.add(bk_no);
				System.out.println(dBDao.bkInfo(bk_no));
				System.out.println("폐기하려는 도서가 맞습니까?\n1:예\t2:아니오");
				String a = ScanUtil.nextLine();;
				if (a.equals("1")) {
					int result1 = dBDao.discardBooksDAO(bk_no);
					if (dBDao.retInfo(bk_no) != null) {
						int result2 = dBDao.setdcbDate(bk_no);
						if (result1 == 1 && result2 == 1) {
							System.out.println("도서 폐기 완료");
						} else if (result1 != 1) {
							System.out.println("도서 폐기 실패(폐기처리 오류)");
						} else if (result2 != 1) {
							System.out.println("도서 폐기 실패(폐기날짜 기입 오류)");
						}
					} else {
						if (result1 == 1) {
							System.out.println("도서 폐기 완료");
							break loop;
						} else {
							System.out.println("도서 폐기 실패(폐기처리 오류)");
							break;
						}
					}
					
				} else if (a.equals("2")) {
					System.out.println("다시 입력하세요.");
				} else {
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				}
			} else {
				System.out.println("없는 도서입니다.");
			}
		}

		return View.M_MANBOOK;
	}
}
