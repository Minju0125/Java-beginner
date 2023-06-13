package teamProject01.sec01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscardBooks { //없는도서 삭제하려고하면 "없는도서입니다.", 삭제하기 전 확인시켜주기
}

class DiscardBooksDAO {
	JDBCUtil jdbc=JDBCUtil.getInstance();

	public void DiscardBooksDAO(String bk_no) {
		String sql = " UPDATE BOOK SET BK_STM='2', BK_LDSNO='-', BK_RSVSNO='-' WHERE BK_NO=? ";
		List<Object> param = new ArrayList<>();
		param.add(bk_no);

		int result = jdbc.update(sql, param);

		if (result == 1) {
			System.out.println("도서 폐기 완료");
		} else {
			System.out.println("도서 삭제 실패");
		}
	}
}

class DiscardBooksService {
	JDBCUtil jdbc=JDBCUtil.getInstance();
	DiscardBooksDAO dBDao = new DiscardBooksDAO();

	public void discardBooks() {
		Scanner sc = new Scanner(System.in);
		String sql = " select BK_NO 책번호, BK_TITLE 제목, BK_WRITER 저자, BK_PUB 출판사 from book where bk_no=? ";
		String bk_no=null;
		while (true) {
			System.out.print("폐기할 도서(책번호) : ");
			bk_no = sc.nextLine();
			if (bk_no.equals(jdbc.isDuplicateBK(bk_no, "BK_NO"))
					&& ((String)jdbc.isDuplicateBK(bk_no, "BK_STM")).equals("1")) { ////"1"-> STM 디폴트값 1로 변경됐는지 잘 확인
				List<Object> param = new ArrayList<>();
				param.add(bk_no);
				System.out.println(jdbc.selectOneRow(sql, param));
				System.out.println("폐기하려는 도서가 맞습니까?\n1:예\t2:아니오");
				int a = sc.nextInt();
				sc.nextLine();		
				if (a == 1) {
					dBDao.DiscardBooksDAO(bk_no);
					break;
				} else if (a == 2) {
					System.out.println("다시 입력하세요.");
				} else {
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				}
			} else {
				System.out.println("없는 도서입니다.");
			}
		}
	}
}