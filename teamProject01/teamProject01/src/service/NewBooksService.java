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
			System.out.println("[ 도서 입력 ]");
			System.out.print("분류번호 입력 : ");
			String bk_ctcode = ScanUtil.nextLine();
			System.out.print("서가코드 입력 : ");
			String bk_shfcode = ScanUtil.nextLine();
			System.out.print("책제목 입력 : ");
			String bk_title = ScanUtil.nextLine();
			System.out.print("저자 입력 : ");
			String bk_writer = ScanUtil.nextLine();
			System.out.print("출판사 입력 : ");
			String bk_pub = ScanUtil.nextLine();
			System.out.println("---------------------------------------");
			System.out.println("분류번호 : " + bk_ctcode);
			System.out.println("서가코드 : " + bk_shfcode);
			System.out.println("책제목 : " + bk_title);
			System.out.println("저자 : " + bk_writer);
			System.out.println("출판사 : " + bk_pub);
			System.out.println("도서를 등록하시겠습니까?");
			System.out.println("예 : 1\t아니오 : 2\t      나가기 : 3");
			String a = ScanUtil.nextLine();
			System.out.println("---------------------------------------");
			switch (a) {
			case "1":
				int result = newBooksDAO.newBooksDao(bk_ctcode, bk_shfcode, bk_title, bk_writer, bk_pub);
				if (result == 1) {
					System.out.println("도서 입력 완료");
					bl01 = false;
				} else {
					System.out.println("도서 입력 실패");
					bl01 = false;
				}
				break;
			case "2": // while문으로 아니오 클릭했을 때 다시 입력받으려고하면 분류코드입력 sc.nextLine 오류남
				System.out.println("도서 입력 실패");
				bl01 = false;
				break;
			default:
				System.out.println("잘못된 번호입니다.");
				bl01 = false;

			}
		}
		return View.M_MANBOOK;
	}
}
