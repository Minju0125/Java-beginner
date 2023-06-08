package sec01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscardBooks { //없는도서 삭제하려고하면 "없는도서입니다.", 삭제하기 전 확인시켜주기

	public static void main(String[] args) {
		JDBCUtil jdbcUtil = new JDBCUtil();
		DiscardBooksService discard = new DiscardBooksService();
		try {
			jdbcUtil.connectConn();
			discard.discardBooks();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.disconnectConn();
		}
	}
}

class DiscardBooksDAO {
	JDBCUtil jdbcUtil = new JDBCUtil();

	public void DiscardBooksDAO(String BK_NO) {
		String sql = " UPDATE BOOK SET BK_STM='2' WHERE BK_NO=? ";
		List<Object> param = new ArrayList<>();
		param.add(BK_NO);

		int result = jdbcUtil.update(sql, param);

		if (result == 1) {
			System.out.println("도서 폐기 완료");
		} else {
			System.out.println("도서 삭제 실패");
		}
	}
}

class DiscardBooksService {
	JDBCUtil jdbcUtil = new JDBCUtil();
	DiscardBooksDAO dBDao = new DiscardBooksDAO();

	public void discardBooks() {
		Scanner sc = new Scanner(System.in);
		String sql = " select BK_NO 책번호, BK_TITLE 제목, BK_WRITER 저자, BK_PUB 출판사 from book where bk_no=? ";
		String BK_NO=null;
		while (true) {
			System.out.print("폐기할 도서(책번호) : ");
			BK_NO = sc.nextLine();
			Object result = jdbcUtil.isDuplicateBK(BK_NO, "BK_NO");
			if (BK_NO.equals(result)) {
				List<Object> param = new ArrayList<>();
				param.add(BK_NO);
				System.out.println(jdbcUtil.selectOneRow(sql, param));
				System.out.println("폐기하려는 도서가 맞습니까?\n1:예\t2:아니오");
				int a = sc.nextInt();
				sc.nextLine();		
				if (a == 1) {
					dBDao.DiscardBooksDAO(BK_NO);
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