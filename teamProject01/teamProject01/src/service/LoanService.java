package service;

import java.util.List;
import java.util.Map;
import dao.LoanDAO;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class LoanService {
	private static LoanService instance = null;

	private LoanService() {
	}

	public static LoanService getInstance() {
		if (instance == null)
			instance = new LoanService();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	LoanDAO dao = LoanDAO.getInstance();
	/* 김석호 수정사항 id 주석처리 */
//   Object id = JDBCUtil.loginUser.get("STD_NO");

	public int loanAsStudent() {

		Object stdate = JDBCUtil.loginUser.get("STD_STDATE");
		if (stdate == null) {
			List<Map<String, Object>> list = dao.judgeOverdueCount(JDBCUtil.loginUser.get("STD_NO"));
			Object[] countArray = new Object[list.size()];

			for (int i = 0; i < list.size(); i++) {
				countArray[i] = list.get(i).get("COUNT");
			}
//         System.out.println(Arrays.toString(countArray)); // (테스트용) 한 학생이 대출

			boolean hasPositive = true;
			int count = 0;

			for (int i = 0; i < countArray.length; i++) {
				Object obj = countArray[i];
				String str = obj.toString();
				count = Integer.parseInt(str);

				if (count < 0) {
					hasPositive = false;
					break;
				}
			}

			if (hasPositive) {
				Object countObj = dao.judgeMax(JDBCUtil.loginUser.get("STD_NO"));
				int countMax = Integer.parseInt(countObj.toString());

				if (countMax < 3) {
					System.out.println("==========================================================");
					System.out.println("[도서대출]");
					System.out.println("==========================================================");
					System.out.println("학생상태 : 도서대출 가능");
					// 여기서 다시 if -> 대출자 예약자 따지러.
					outerLoop: while (true) {

						System.out.print("대출도서 번호 입력 : ");
						String inputBookNo = ScanUtil.nextLine();
						Object bookNo = dao.verifyBookNo(inputBookNo);

						if (bookNo == null) {
							System.out.println("==========================================================");
							System.out.println("잘못된 도서번호입니다. 다시 시도하세요.");
							continue outerLoop;
						}

						Map<String, Object> bookInfo = dao.judgeBook(bookNo);
						String ldsno = (String) bookInfo.get("BK_LDSNO");
						String rsvsno = (String) bookInfo.get("BK_RSVSNO");

						if (ldsno != null) { // 대출자가 있는 경우
							if (ldsno.equalsIgnoreCase(JDBCUtil.loginUser.get("STD_NO").toString())) {// 입력한 도서를 학생본인이
																										// 대출중인경우
								System.out.println("학생 본인이 대출중인 책입니다. 다른 책을 검색하세요.");
								continue outerLoop;// 다시 도서검색 창으로
							} else if (rsvsno != null) {// 입력한 도서가 대출자, 예약자가 모두 존재하는 경우(대출불가)
								System.out.println("대출자,예약자가 존재하는 책입니다. 다른 책을 검색하세요.");
								continue outerLoop;// 다시 도서검색 창으로
							} else if (rsvsno == null) {// 입력한 도서가 대출자가 존재하지만, 예약자는 존재하지 않는 경우(대출불가, 예약만가능)
								System.out.println("현재 대출 중인 책으로 대출불가합니다.");

								while (true) {
									System.out.println("예약메뉴로 이동하시겠습니까? \n1.예   2.아니오");
									String answer = ScanUtil.nextLine();
									if (answer.equals("1")) {
										return View.S_RSVBOOK;
									} else if (answer.equals("2")) {
										return View.S_LRMAIN;
									} else {
										System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
									}
								}
							}
						} else if (ldsno == null) { // 대출자가 없는 경우, 예약자의 유무 판단
							if (rsvsno == null) { // 대출자도, 예약자도 없는 경우
								System.out.println("[대출가능] 대출 가능한 도서입니다.");
								System.out.println("대출하시겠습니까?");////////////////////////////////////////////////////////////////////
								System.out.println("1.예   2.아니오(뒤로가기)");
								String answer = ScanUtil.nextLine();
								if (answer.equals("1")) {
									//// 대출 메소드 (다오에있음 - 매개변수 inputBookNo?)
									int resultLendTable = dao.loanLendTable(inputBookNo,
											(String) JDBCUtil.loginUser.get("STD_NO"));
									int resultBookTable = dao.loanBookTable(inputBookNo,
											(String) JDBCUtil.loginUser.get("STD_NO"));
									if (resultLendTable == 1 && resultBookTable == 1) {
										System.out.println("[대출완료]");
										return View.S_MAIN;
									} else {
										System.out.println("[대출실패]");
										return View.S_MAIN;
									}

								} else {
									// 대출하시겠습니까 아니오(뒤로가기) 하면 어디로 가야하지,,?
									// 여기에 해당하는 코드 작성
									break;
								}
							} else if (rsvsno != null) { // 대출자x, 예약자o
								if (rsvsno.equals(JDBCUtil.loginUser.get("STD_NO"))) { // 예약자가 학생 본인인 경우
									System.out.println("[대출가능] 예약자 본인입니다.");
									System.out.println("대출하시겠습니까?");/////////////////////////////////////////////////////////////////////
									System.out.println("1.예   2.아니오(뒤로가기)");
									String answer = ScanUtil.nextLine();
									if (answer.equals("1")) {
										//// 대출 메소드 (다오에있음 - 매개변수 inputBookNo?)
										int resultLendTable = dao.loanLendTable(inputBookNo,
												(String) JDBCUtil.loginUser.get("STD_NO"));
										int resultBookTable = dao.loanBookTable(inputBookNo,
												(String) JDBCUtil.loginUser.get("STD_NO"));
										if (resultLendTable == 1 && resultBookTable == 1) {
											System.out.println("[대출완료]");
											return View.S_MAIN;
										} else {
											System.out.println("[대출실패]");
											return View.S_MAIN;
										}

									} else {
										continue;
									}
								}

							}

						}
					}
				} else {
					System.out.println("[대출불가] 최대 대출 가능 권수(3권) 초과");
				}
			} else {
				System.out.println("[대출불가] 연체된 책이 존재합니다. 반납 후 이용해주세요.");
			}
		} else {
			System.out.println("[대출불가] 정지된 계정");

		}
		return View.S_MAIN;
	}

	public int loanAsManager() {

		while (true) {
			String studentNo;
			System.out.println("학생학번입력 :");
			studentNo = ScanUtil.nextLine();

			if (studentNo.equals(String.valueOf(jdbc.isDuplicateSTD(studentNo, "STD_NO")))) {
				System.out.println("학번 : " + studentNo);
				System.out.println("이름 : " + dao.studentSelectSTDNAME(studentNo, "STD_NAME"));

				System.out.println("학생정보가 맞습니까?");
				System.out.println("1.예\t2.아니오");
				String a = ScanUtil.nextLine();

				if (a.equals("1")) {

					Object stdate = dao.getStdate(studentNo);
					if (stdate == null) {
						List<Map<String, Object>> list = dao.judgeOverdueCount(studentNo);
						Object[] countArray = new Object[list.size()];

						for (int i = 0; i < list.size(); i++) {
							countArray[i] = list.get(i).get("COUNT");
						}
//         System.out.println(Arrays.toString(countArray)); // (테스트용) 한 학생이 대출

						boolean hasPositive = true;
						int count = 0;

						for (int i = 0; i < countArray.length; i++) {
							Object obj = countArray[i];
							String str = obj.toString();
							count = Integer.parseInt(str);

							if (count < 0) {
								hasPositive = false;
								break;
							}
						}

						if (hasPositive) {
							Object countObj = dao.judgeMax(studentNo);
							int countMax = Integer.parseInt(countObj.toString());

							if (countMax < 3) {
								System.out.println("==========================================================");
								System.out.println("[도서대출]");
								System.out.println("==========================================================");
								System.out.println("학생상태 : 도서대출 가능");
								outerLoop: while (true) {

									System.out.println("대출도서 번호 입력 : ");
									String inputBookNo = ScanUtil.nextLine();
									Object bookNo = dao.verifyBookNo(inputBookNo);

									if (bookNo == null) {
										System.out
												.println("==========================================================");
										System.out.println("잘못된 도서번호입니다. 다시 시도하세요.");
										continue outerLoop;
									}

									Map<String, Object> bookInfo = dao.judgeBook(bookNo);
									String ldsno = (String) bookInfo.get("BK_LDSNO");
									String rsvsno = (String) bookInfo.get("BK_RSVSNO");

									if (ldsno != null) { // 대출자가 있는 경우
										if (ldsno.equalsIgnoreCase(JDBCUtil.loginUser.get("STD_NO").toString())) {// 입력한
																													// 도서를
																													// 학생본인이
																													// 대출중인경우
											System.out.println("학생 본인이 대출중인 책입니다. 다른 책을 검색하세요.");
											continue outerLoop;// 다시 도서검색 창으로
										} else if (rsvsno != null) {// 입력한 도서가 대출자, 예약자가 모두 존재하는 경우(대출불가)
											System.out.println("대출자,예약자가 존재하는 책입니다. 다른 책을 검색하세요.");
											continue outerLoop;// 다시 도서검색 창으로
										} else if (rsvsno == null) {// 입력한 도서가 대출자가 존재하지만, 예약자는 존재하지 않는 경우(대출불가, 예약만가능)
											System.out.println("현재 대출 중인 책으로 대출불가합니다.");

										}
									} else if (ldsno == null) { // 대출자가 없는 경우, 예약자의 유무 판단
										if (rsvsno == null) { // 대출자도, 예약자도 없는 경우
											System.out.println("[대출가능] 대출 가능한 도서입니다.");
											System.out.println("대출하시겠습니까?");////////////////////////////////////////////////////////////////////
											System.out.println("1.예   2.아니오(뒤로가기)");
											String answer = ScanUtil.nextLine();
											if (answer.equals("1")) {
												//// 대출 메소드 (다오에있음 - 매개변수 inputBookNo?)
												int resultLendTable = dao.loanLendTable(inputBookNo, studentNo);
												int resultBookTable = dao.loanBookTable(inputBookNo, studentNo);
												if (resultLendTable == 1 && resultBookTable == 1) {
													System.out.println("[대출완료]");
													return View.M_MAIN;
												} else {
													System.out.println("[대출실패]");
													return View.M_MAIN;
												}

											} else {
												// 대출하시겠습니까 아니오(뒤로가기) 하면 어디로 가야하지,,?
												// 여기에 해당하는 코드 작성
												break;
											}
										} else if (rsvsno != null) { // 대출자x, 예약자o
											if (rsvsno.equals(JDBCUtil.loginUser.get("STD_NO"))) { // 예약자가 학생 본인인 경우
												System.out.println("[대출가능] 예약자 본인입니다.");
												System.out.println("대출하시겠습니까?");/////////////////////////////////////////////////////////////////////
												System.out.println("1.예   2.아니오(뒤로가기)");
												String answer = ScanUtil.nextLine();
												if (answer.equals("1")) {
													//// 대출 메소드 (다오에있음 - 매개변수 inputBookNo?)
													int resultLendTable = dao.loanLendTable(inputBookNo, studentNo);
													int resultBookTable = dao.loanBookTable(inputBookNo, studentNo);
													if (resultLendTable == 1 && resultBookTable == 1) {
														System.out.println("[대출완료]");
														return View.M_MAIN;
													} else {
														System.out.println("[대출실패]");
														return View.M_MAIN;
													}

												} else {
													continue;
												}
											}

										}

									}
								}
							} else {
								System.out.println("[대출불가] 최대 대출 가능 권수(3권) 초과");
							}
						} else {
							System.out.println("[대출불가] 연체된 책이 존재합니다. 반납 후 이용해주세요.");
						}
					} else {
						System.out.println("[대출불가] 정지된 계정");

					}
					return View.M_MAIN;

				}else if(a.equals("2")) {
					System.out.println("다시 시도하세요.");
					continue;
				}else {
					System.out.println("번호를 잘못 입력하셨습니다.");
				}
			} else {
				System.out.println("학번을 잘못입력하셨습니다. 다시 시도하세요.");
			}
		} // while문 끝

	}
}