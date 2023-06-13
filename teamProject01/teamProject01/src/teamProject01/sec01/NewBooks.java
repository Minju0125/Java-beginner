package teamProject01.sec01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewBooks {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		NewBooksService newBooks = new NewBooksService();

		jdbc.connectConn();
		newBooks.newBooksService();
		jdbc.disconnectConn();

	}
}

class NewBooksDao {
	Scanner sc = new Scanner(System.in);
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public int newBooksDao(String bk_ctcode, String bk_shfcode, String bk_title, String bk_writer, String bk_pub) {
		String sql = " {CALL reg_book( ?, ?, ?, ?, ?)} ";// '분류코드', '책장번호', '책제목, '저자', '출판사'
		List<Object> param = new ArrayList<>();
		param.add(bk_ctcode);
		param.add(bk_shfcode);
		param.add(bk_title);
		param.add(bk_writer);
		param.add(bk_pub);

		return jdbc.procedureUpdate(sql, param);
	}
}

class NewBooksService {
	Scanner sc = new Scanner(System.in);
	JDBCUtil jdbc = JDBCUtil.getInstance();
	NewBooksDao newBooksDAO = new NewBooksDao();

	public void newBooksService() {
		boolean bl01 = true;
		while (bl01) {
			System.out.println("[ 도서 입력 ]");
			System.out.print("분류번호 입력 : ");
			String bk_ctcode = sc.nextLine();
			System.out.print("서가코드 입력 : ");
			String bk_shfcode = sc.nextLine();
			System.out.print("책제목 입력 : ");
			String bk_title = sc.nextLine();
			System.out.print("저자 입력 : ");
			String bk_writer = sc.nextLine();
			System.out.print("출판사 입력 : ");
			String bk_pub = sc.nextLine();
			System.out.println("---------------------------------------");
			System.out.println("분류번호 : " + bk_ctcode);
			System.out.println("서가코드 : " + bk_shfcode);
			System.out.println("책제목 : " + bk_title);
			System.out.println("저자 : " + bk_writer);
			System.out.println("출판사 : " + bk_pub);
			System.out.println("도서를 등록하시겠습니까?");
			System.out.println("예 : 1\t아니오 : 2\t      나가기 : 3");
			int a = sc.nextInt();
			System.out.println("---------------------------------------");
			switch(a) {
			case 1 :
				int result = newBooksDAO.newBooksDao(bk_ctcode, bk_shfcode, bk_title, bk_writer, bk_pub);
				if (result == 1) {
					System.out.println("도서 입력 완료");
					bl01 = false;
				} else {
					System.out.println("도서 입력 실패");
					bl01 = false;
				}
				break;
			case 2 :				//while문으로 아니오 클릭했을 때 다시 입력받으려고하면 분류코드입력 sc.nextLine 오류남
				System.out.println("도서 입력 실패");
				bl01=false;
				break;
			default :
				System.out.println("잘못된 번호입니다.");
				bl01=false;
				
			}
		}
	}
}