package teamProject01.sec01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Loan {
	public Loan() {
	}

	public static void main(String[] args) {

		JDBCUtil jdbc=JDBCUtil.getInstance();
		LoginService login = new LoginService();

		jdbc.connectConn();
		login.loginService();

		LoanService loan = new LoanService();
		loan.judgeStudent();
		loan.loanManage();
	}
}

class LoanService {
	
	Scanner sc = new Scanner (System.in);
	JDBCUtil jdbc=JDBCUtil.getInstance();

// 로그인한 학생이 도서대출이 가능한 학생인지 판단하는 메소드
	public void judgeStudent() {
		Scanner sc = new Scanner(System.in);
//		
		Object stdate = jdbc.loginUser.get("STD_STDATE");

		if (stdate != null) {
			System.out.println("연체중인 도서가 존재합니다. 반납 후 도서대출이 가능합니다.");
			return; // 메소드 종료 후, 호출한 곳으로 돌아감
		} else if (stdate == null) {
			String sql = "SELECT COUNT(*) FROM BOOK WHERE BK_LDSNO = ?";
			String columnName = "COUNT(*)";
			Object param = jdbc.loginUser.get("STD_NO");
			Object countObj = jdbc.selectOneValue(sql, param, columnName);
			int count = Integer.parseInt(countObj.toString());
			if (count < 3) {
				System.out.println("도서 대출이 가능한 학생입니다.");
				judgeBook();
				return; // startLoanService() 메소드에서 2.아니오 입력시 여기로 돌아옴 ! -> 그리고, 다시 이 메소드를 호출한 직전 분기점으로
						// 이동.
			} else {
				System.out.println("최대 대출 권수는 3권입니다. 대출 불가능한 학생입니다.");
				return; // 메소드 종료 후, 호출한 곳으로 돌아감
			}
		}
	}

	// 입력한 책번호가 대출가능한 책인지 판단하는 메소드
	public void judgeBook() {
		try {
			outerLoop: while (true) {

				System.out.println("대출하실 도서번호를 입력하세요 : ");
				String inputBookNo = sc.nextLine();

				String sql = "select * from book where BK_NO = ?";
				List<Object> param = new ArrayList<>();
				param.add(inputBookNo);

				Map<String, Object> row = jdbc.selectOneRow(sql, param);
				String title = (String) row.get("BK_TITLE");
				String ldsno = (String) row.get("BK_LDSNO");
				String rsvsno = (String) row.get("BK_RSVSNO");
				String id = (String) jdbc.loginUser.get("STD_NO");

				if (ldsno != null) { // 대출자가 있는 경우
					if (ldsno.equalsIgnoreCase(id)) {// 입력한 도서를 학생본인이 대출중인경우
						System.out.println("학생 본인이 대출중인 책입니다. 다른 책을 검색하세요.");
						continue outerLoop;// 다시 도서검색 창으로
					} else if (rsvsno != null) {// 입력한 도서가 대출자, 예약자가 모두 존재하는 경우(대출불가)
						System.out.println("대출자,예약자가 존재하는 책입니다. 다른 책을 검색하세요.");
						continue outerLoop;// 다시 도서검색 창으로
					} else if (rsvsno == null) {// 입력한 도서가 대출자가 존재하지만, 예약자는 존재하지 않는 경우(대출불가, 예약만가능)
						System.out.println("현대 대출 중인 책으로 대출불가합니다. (예약가능) ");

						innerLoop: while (true) {
							System.out.println("예약하시겠습니까? \n1.예	2.아니오");
							String answer = sc.nextLine();
							if (answer.equals("1")) {
								// 예약메소드 호출
								break outerLoop; // (?)
							} else if (answer.equals("2")) {
								continue outerLoop;
							} else {
								System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
							}
						}
					}
				} else if (ldsno == null) { // 대출자가 없는 경우, 예약자의 유무 판단
					if (rsvsno == null) { // 대출자도, 예약자도 없는 경우
						System.out.println("대출 가능한 도서입니다.");
						loanBook(inputBookNo);
						break;
					} else if (rsvsno != null) { // 대출자x, 예약자o
						if (rsvsno.equals(id)) { // 예약자가 학생 본인인 경우
							System.out.println("예약자 본인입니다.");
							loanBook(inputBookNo);
							break;
						} else {
							System.out.println("예약자가 존재하는 책입니다. 다른 책을 검색하세요.");
							continue;
						}
					}
				}
				
			}
		} catch (Exception e) {
			System.out.println("잘못된 도서 번호입니다. 다시 입력해주세요.");
			judgeBook();
		}
	}

	public void loanBook(String inputBookNo) { // insert lend 테이블에 테이터 입력하기.

		startloop: while (true) {
			System.out.println("대출하시겠습니까?");
			System.out.println("1.예	2.아니오");

			String answer = sc.nextLine();
			if (answer.equals("1")) {
				String id = (String) jdbc.loginUser.get("STD_NO");
				String pw = (String) jdbc.loginUser.get("STD_PW");

				String sql1 = "INSERT INTO LEND(BK_NO, STD_NO, LD_NO, LD_DATE, LD_EPDATE, LD_RETDATE, LD_OVERDUE) VALUES(?, ?, LENDNO_SEQ.NEXTVAL, TO_DATE(SYSDATE,'YYYY-MM-DD'), TO_DATE(SYSDATE + 7,'YYYY-MM-DD'), NULL, NULL)";
				List<Object> param1 = new ArrayList<>();

				param1.add(inputBookNo);
				param1.add(id);

				int result1 = jdbc.update(sql1, param1);
				System.out.println(result1);

				String sql2 = "UPDATE BOOK SET  BK_LDSNO = ?, BK_LDCNT = BK_LDCNT + 1, BK_RSVSNO = NULL  WHERE BK_NO = ?";
				List<Object> param2 = new ArrayList<>();

				param2.add(id);
				param2.add(inputBookNo);

				int result2 = jdbc.update(sql2, param2);

				if (result1 == 1 && result2 == 1) {
					System.out.println("대출완료");
				} else {
					System.out.println("대출실패");
				}
				break;
			} else if (answer.equals("2")) {
				break;
			} else {
				System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
				continue;
			}

		}

	}

	// 관리자 입장에서 도서대출 대리수행 (관리자가 로그인 단계를 거친 후 들어와있는 상태라고 가정)
	public void loanManage() {

		while (true) {

			System.out.println("학생의 학번을 입력하세요 : ");
			Scanner sc = new Scanner(System.in);
			Object param = sc.nextLine(); // 이 아이디가 학생 테이블의 학번에 있는지부터 검사해서 select 해와야함
			String columnName = "STD_NO";
			Object result = jdbc.isDuplicateSTD(param, columnName); // 이 result 는 튜플의 한 컬럼

			if (result == null) {
				System.out.println("학번을 잘못입력하셨습니다. 다시 시도하세요.");
			} else { // 입력한 학번이 학생 테이블의 학번 컬럼에 존재할 때,
				String sql1 = "SELECT * FROM STUDENT WHERE STD_NO = ?";
				List<Object> param1 = new ArrayList<>();
				param1.add(result);

				Map<String, Object> row = jdbc.selectOneRow(sql1, param1);

				Object stdate = row.get("STD_STDATE");

				if (stdate != null) {
					System.out.println("연체중인 도서가 존재합니다. 반납 후 도서대출이 가능합니다.");
					return; // 메소드 종료 후, 호출한 곳으로 돌아감
				} else if (stdate == null) {
					String sql2 = "SELECT COUNT(*) FROM BOOK WHERE BK_LDSNO = ?";
					String columnName2 = "COUNT(*)";
					Object param2 = jdbc.loginUser.get("STD_NO");
					Object countObj = jdbc.selectOneValue(sql2, param2, columnName2);
					int count = Integer.parseInt(countObj.toString());
					if (count < 3) {
						System.out.println("도서 대출이 가능한 학생입니다.");
						System.out.println("학생이름 : " + row.get("STD_NAME"));
						System.out.println();
						judgeBook();
						return; // startLoanService() 메소드에서 2.아니오 입력시 여기로 돌아옴 ! -> 그리고, 다시 이 메소드를 호출한 직전 분기점으로
								// 이동.
					} else {
						System.out.println("최대 대출 권수는 3권입니다. 대출 불가능한 학생입니다.");
						return; // 메소드 종료 후, 호출한 곳으로 돌아감
					}

				}
				break;
			}
		}
	}
}
