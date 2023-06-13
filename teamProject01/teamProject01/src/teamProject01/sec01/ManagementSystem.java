package teamProject01.sec01;

import java.util.Scanner;

public class ManagementSystem {
	
	Scanner sys = new Scanner(System.in);
	public void mainSystem() {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		jdbc.connectConn();
		loginRoop: while (true) {
			System.out.println("============시스템 화면============");
			System.out.println("1. 로그인");
			System.out.println("2. 시스템 종료");
			String menu0 = sys.nextLine();
			switch (menu0) {
			case "1":
				new LoginService().loginService();
				break;
			case "2":
				System.out.println("시스템을 종료합니다.");
				jdbc.disconnectConn();
				return;

			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}

			if (JDBCUtil.loginUser != null) {
				if (JDBCUtil.loginUser.get("STD_CLSCODE").equals("1")) {
					studentMenuRoop: while (true) {
						/* 학생 메인메뉴 */
						System.out.println("============ 메  뉴 ============");
						System.out.println("1. 도서 검색 (대출, 예약)");
						System.out.println("2. 대출 현황 조회 (반납)");
						System.out.println("3. 추천 도서 조회");
						System.out.println("4. 도서신청");
						System.out.println("5. 마이페이지");
						System.out.println("6. 로그아웃");
						System.out.print("============ 메뉴 선택 :");
						String menu1 = sys.nextLine();

						switch (menu1) {
						case "1":
							/* 도서검색 메소드 */
							/* new 클래스().메소드이름(); */
							new LoanService().judgeStudent();
							break;
						case "2":
							/* 대출 현황조회 메소드 */
							
							/* 반납 메소드 */
							new ReturnBook().returnBookForStudent();
							/* new 클래스().메소드이름(); */
							break;
						case "3":
							/* 추천 도서 조회 메소드 */
							/* 여기도 while switch case 열어서 종류별로 */
							/* new 클래스().메소드이름(); */
							break;
						case "4":
							/* 도서 신청 메소드 */
							new RequestService().requestService();
							/* new 클래스().메소드이름(); */
							break;
						case "5":
							/* 마이페이지 */
							this.myPage();
							break;
						case "6":
							new LogoutService().logout();
							if(JDBCUtil.loginUser==null) {
								continue loginRoop;
							}else {
								continue studentMenuRoop;
							}
						default:
							System.out.println("잘못된 입력입니다.");
						}

					}
				/* 로그인 유저의 분기점. 위 : 학생 , else 구문 : 관리자 */
				} else {
					managerMenuRoop: while (true) {
						/* 관리자 메인 메뉴 */
						System.out.println("============ 메  뉴 ============");
						System.out.println("1. 도서 검색");
						System.out.println("2. 학생 정보 수정");
						System.out.println("3. 대출 및 반납 대행");
						System.out.println("4. 책 등록 및 폐기");
						System.out.println("5. 연체현황 조회");
						System.out.println("6. 반납기한이 금일인 책 조회");
						System.out.println("7. 도서신청 현황 조회");
						System.out.println("8. 로그아웃");
						System.out.print("============ 메뉴 선택 :");
						String menu2 = sys.nextLine();

						switch (menu2) {
						case "1":
							/* 도서 검색 메소드 */
							/* new 클래스().메소드이름(); */
							new LoanService().loanManage();
							break;
						case "2":
							new ModifyStudentService().mdfServiceM();
							/* new 클래스().메소드이름(); */
							break;
						case "3":
							actingRoop: while (true) {
								System.out.println("============ 기능 선택 ============");
								System.out.println("1. 대출 대행");
								System.out.println("2. 반납 대행");
								System.out.println("3. 뒤로 가기");
								System.out.print("============ 메뉴 선택 :");
								String menu3 = sys.nextLine();
								switch (menu3) {
								case "1":
									/* 대출 대행 메소드 호출 */
									/* new 클래스().메소드이름(); */
									break;
								case "2":
									new ReturnBook().returnBookForManager();
									break;
								case "3":
									break actingRoop;
								default:
									System.out.println("잘못된 입력입니다.");
									break;
								}
							} // 매니저 메뉴 대출 및 반납 대행 case 종료
							break;
						case "4":
							/*완료*//* 책 등록 및 폐기 메소드 */
							newOrDiscardRoop :while(true) {
								System.out.println("============ 기능 선택 ============");
								System.out.println("1. 도서 등록");
								System.out.println("2. 도서 폐기");
								System.out.println("3. 뒤로 가기");
								System.out.print("============ 메뉴 선택 :");
								String menu4 = sys.nextLine();
								switch (menu4) {
								case "1":
									new NewBooksService().newBooksService();
									break;
								case "2":
									new DiscardBooksService().discardBooks();
									break;
								case "3":
									break newOrDiscardRoop;
								default:
									System.out.println("잘못된 선택입니다.");
									break;
								}
							}
							/* new 클래스().메소드이름(); */
							break;
						case "5":
							/* 연체 현황 조회 메소드 */
							/* new 클래스().메소드이름(); */
							break;
						case "6":
							/* 반납기한이 금일인 책 조회 메소드 */
							/* new 클래스().메소드이름(); */
							break;
						case "7":
							requestRoop : while(true) {
								System.out.println("============ 기능 선택 ============");
								System.out.println("1. 신청 도서 조회");
								System.out.println("2. 신청도서목록 초기화");
								System.out.println("3. 뒤로 가기");
								System.out.print("============ 메뉴 선택 :");
								String menu4 = sys.nextLine();
								switch (menu4) {
								case "1":
									/* 신청도서 테이블 조회 메소드 */
									break;
								case "2":
									/* 신청도서 테이블에서 튜플 삭제하는 메소드 */
									new RequestService().requestClear();
									break;
								case "3":
									break requestRoop;
								default:
									System.out.println("잘못된 입력입니다.");
								}
							}
							
							/* new 클래스().메소드이름(); */
							break;
						case "8":
							new LogoutService().logout();
							if(JDBCUtil.loginUser==null) {
								continue loginRoop;
							}else {
								continue managerMenuRoop;
							}
						default:
							System.out.println("잘못된 입력입니다.");
						}

					}
				}
			}
		}// loginRoop 끝지점
	}
	
	public void myPage() {
		while(true) {
			/*  출력정보 표기해줄 공간   */
			/*학번*/
			/*이름*/
			/*현재 대출 권수*/
			/*예약 현황 null or 책제목 , 대출가능여부*/
			System.out.println("============ 기능 선택 ============");
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 예약 취소");
			System.out.println("3. 뒤로 가기");
			System.out.print("============ 메뉴 선택 :");
			String pageMenu = sys.nextLine();
			switch (pageMenu) {
			case "1":
				new ModifyStudentService().mdfServiceS();
				break;
			case "2":
				/* 예약 취소 메소드 */
				break;
			case "3":
				return;

			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
			
			
		}
	}
}
