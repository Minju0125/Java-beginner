package sec01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscardBooks { //���µ��� �����Ϸ����ϸ� "���µ����Դϴ�.", �����ϱ� �� Ȯ�ν����ֱ�

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
			System.out.println("���� ��� �Ϸ�");
		} else {
			System.out.println("���� ���� ����");
		}
	}
}

class DiscardBooksService {
	JDBCUtil jdbcUtil = new JDBCUtil();
	DiscardBooksDAO dBDao = new DiscardBooksDAO();

	public void discardBooks() {
		Scanner sc = new Scanner(System.in);
		String sql = " select BK_NO å��ȣ, BK_TITLE ����, BK_WRITER ����, BK_PUB ���ǻ� from book where bk_no=? ";
		String BK_NO=null;
		while (true) {
			System.out.print("����� ����(å��ȣ) : ");
			BK_NO = sc.nextLine();
			Object result = jdbcUtil.isDuplicateBK(BK_NO, "BK_NO");
			if (BK_NO.equals(result)) {
				List<Object> param = new ArrayList<>();
				param.add(BK_NO);
				System.out.println(jdbcUtil.selectOneRow(sql, param));
				System.out.println("����Ϸ��� ������ �½��ϱ�?\n1:��\t2:�ƴϿ�");
				int a = sc.nextInt();
				sc.nextLine();		
				if (a == 1) {
					dBDao.DiscardBooksDAO(BK_NO);
					break;
				} else if (a == 2) {
					System.out.println("�ٽ� �Է��ϼ���.");
				} else {
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
				}
			} else {
				System.out.println("���� �����Դϴ�.");
			}
		}
	}
}