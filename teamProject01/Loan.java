package sec01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//도서대여 클래스
class Loan {
	public Loan() {
	}

	public static void main(String[] args) {

		JDBCUtil jdbc = new JDBCUtil();
		LoginService login = new LoginService();

////		로그인한 아이디 입력받아서 , 대출할때 (test) 
//		jdbc.connectConn();
//		login.loginService();
		/////////////////////////////

		LoanService loan = new LoanService();
		loan.loanService();
	}
}

class LoanService extends JDBCUtil {
	public void loanService() {
		Scanner sc = new Scanner(System.in);
		// 현재 대출 가능한 권수 따져서 하는메소드 깜빡스
		System.out.println("[도서를 대여하시겠습니까?] -- 숫자 입력");
		System.out.println("1. 예 \n2. 아니오(나가기)");
		int answer = Integer.parseInt(sc.nextLine());
		while (true) {
			if (answer == 1) {
				judgement();
				break;

			} else if (answer == 2) {

				// 홈화면으로.
				break;
			} else {
				System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
				System.out.println("1. 예 \n2. 아니오(나가기)");
				answer = Integer.parseInt(sc.nextLine());
			}

		}

	}

	// 도서대여가 가능한지 판단하는 메소드
	public void judgement() {
		daoConn.connectConn(); // db에 커넥션하는 메소드.

		System.out.println("책번호를 입력하세요 : ");
		String inputBookNo = sc.nextLine(); // 이 책번호를 가지고 selectOneRow로 튜플 하나를 가져온다!
		///////////////

		String sql = "select * from book where BK_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(inputBookNo);

		JDBCUtil jdbc = new JDBCUtil();

		Map<String, Object> row = jdbc.selectOneRow(sql, param);
		String title = (String) row.get("BK_TITLE");
		String ldsno = (String) row.get("BK_LDSNO");
		String rsvsno = (String) row.get("BK_RSVSNO");

//		System.out.println(title); //책번호를 입력받아 한 튜플의 컬럼/ 결과 출력하는거까지는 끝 !
//		System.out.println(rsvsno);

		if (ldsno != null && rsvsno != null) {
			System.out.println("대여못행");
		} else if (ldsno != null) {
			System.out.println("현대 대출 중인 책으로 대출불가합니다. ");
			System.out.println("예약하시겠습니까? \n1.예	2.아니오");
			int answer = Integer.parseInt(sc.nextLine());
			while (true) {
				if (answer == 1) {
					// 예약메소드 호출
					break;
				} else if (answer == 2) {
					// 홈으로 나가기 ? 뒤로 가기?
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
					answer = Integer.parseInt(sc.nextLine());
				}
			}

		} else {
			System.out.println("대출 가능한 도서입니다.대출하시겠습니까?");
			System.out.println("1.예	2.아니오");
			int answer = Integer.parseInt(sc.nextLine());
			// 1. 예 누르면 insert 메소드 호출
			while (true) {
				if (answer == 1) {
					Object id = jdbc.loginUser.get("STD_ID");
					String sql1 = "UPDATE BOOK SET BK_LDSNO = ?, BK_LDCNT = BK_LDCNT + 1";
					List<Object> param1 = new ArrayList<>();
					param1.add(id);
					jdbc.update(sql1, param1);
					break;
				} else if (answer == 2) {
					// 홈으로 나가기 ? 뒤로 가기?
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
					answer = Integer.parseInt(sc.nextLine());
				}

			}

			/*
			 * 예 -> book 테이블)BK_LDSNO 에 학번 추가 BK_LDCNT +1 LEND 테이블) INSERT LD_NO, LD_DATE에는
			 * SYSDATE, STD_ID 추가, BK_NO 추가
			 * 
			 * 하고, 화면에 반납기한, 등 정보 띄어주기 ( 학번 : 이름 : 대출도서명 : 대출도서번호 : 대출일 : 반납기한 :
			 * 
			 */

		}
	}

}

/*
 * 도서검색을 통해 가져온 책 테이블의 예약자가 null이면서, 대출자가 null 이면서, 학생테이블에서 로그인 을 통해 입력받은 id의 해당
 * 튜플 중 학생의 현재 대여도서권수가 3 미만일 경우에 대여가 가능하다.
 */
// 정지일이 null 인것도 추가해야함.
//
//	if(BK_RSVID==null&&BK_LDID==null)
//
//	{// 해당 책의 대출자, 예약자가 없는 경우
//		if (현재대여도서권수 < 3) {// 학생의 현재 대여도서권수가 3미만인 경우, 대출가능
//			System.out.println("(3-현재대여중인도서권수)권 도서대여 가능. \n 대여하시겠습니까?");
//			System.out.println("1.예 // 2.아니오");
//			if (Integer.parseInt(sc.nextLine()) == 1) {
//				loan();// 1을
//						// 입력하면,
//						// 도서대여
//						// 메소드
//						// 호출
//			} else if (Integer.parseInt(sc.nextLine()) == 2) {
//				// 나가기. ?? break 도 아닌데,, 오잉
//				break; // 브레이크하면 어디로 나가는거지?
//			}
//		} else {
//			System.out.println("최대 대여 권수(3권)을 초과하여, 대여 불가능합니다.");
//			// 대여중인 책도 뜨면 좋을듯? -> list 로 가져오기
//			// List<String> listBooks = 해당 id의 학생이 대여중이 책 list 저장하고
//			// for(int i = 0; i<listBooks.length; i++) {
//			// System.out.println("현재 대여중인 책")
//			// System.out.println(i + "." + listBooks[i])
//		}
//	}

//	}

//public Map<String, Object> selectOne(String sql, List<Object> param) {
// sql="SELECT * FROM tbl_member WHERE mem_id = ? and
// mem_pass = ? "
