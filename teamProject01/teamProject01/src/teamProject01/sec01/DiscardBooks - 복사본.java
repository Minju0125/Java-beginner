package teamProject01.sec01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscardBooks { //���µ��� �����Ϸ����ϸ� "���µ����Դϴ�.", �����ϱ� �� Ȯ�ν����ֱ�
}

class DiscardBooksDAO {
	JDBCUtil jdbc=JDBCUtil.getInstance();

	public void DiscardBooksDAO(String bk_no) {
		String sql = " UPDATE BOOK SET BK_STM='2', BK_LDSNO='-', BK_RSVSNO='-' WHERE BK_NO=? ";
		List<Object> param = new ArrayList<>();
		param.add(bk_no);

		int result = jdbc.update(sql, param);

		if (result == 1) {
			System.out.println("���� ��� �Ϸ�");
		} else {
			System.out.println("���� ���� ����");
		}
	}
}

class DiscardBooksService {
	JDBCUtil jdbc=JDBCUtil.getInstance();
	DiscardBooksDAO dBDao = new DiscardBooksDAO();

	public void discardBooks() {
		Scanner sc = new Scanner(System.in);
		String sql = " select BK_NO å��ȣ, BK_TITLE ����, BK_WRITER ����, BK_PUB ���ǻ� from book where bk_no=? ";
		String bk_no=null;
		while (true) {
			System.out.print("����� ����(å��ȣ) : ");
			bk_no = sc.nextLine();
			if (bk_no.equals(jdbc.isDuplicateBK(bk_no, "BK_NO"))
					&& ((String)jdbc.isDuplicateBK(bk_no, "BK_STM")).equals("1")) { ////"1"-> STM ����Ʈ�� 1�� ����ƴ��� �� Ȯ��
				List<Object> param = new ArrayList<>();
				param.add(bk_no);
				System.out.println(jdbc.selectOneRow(sql, param));
				System.out.println("����Ϸ��� ������ �½��ϱ�?\n1:��\t2:�ƴϿ�");
				int a = sc.nextInt();
				sc.nextLine();		
				if (a == 1) {
					dBDao.DiscardBooksDAO(bk_no);
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