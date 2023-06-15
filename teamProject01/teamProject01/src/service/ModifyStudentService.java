package service;


import dao.ModifyStudentDAO;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class ModifyStudentService {
	private static ModifyStudentService instance = null;

	private ModifyStudentService() {
	}

	public static ModifyStudentService getInstance() {
		if (instance == null)
			instance = new ModifyStudentService();
		return instance;
	}

	ModifyStudentDAO mdfDAO = ModifyStudentDAO.getInstance();
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public int mdfServiceM() {
		boolean bl01 = true;
		while (bl01) {
			System.out.println(" [ 학생정보 수정 ] ");
			boolean bl02 = true;
			System.out.print("비밀번호 변경 : 1\t정지일 변경 : 2\t나가기 : 3\n");
			String a = ScanUtil.nextLine();
			/* 김석호 수정사항 */
			switch (a) {
			case "1":
				System.out.println("<비밀번호 변경>");
				while (bl02) {
					System.out.print("변경할 학생의 학번 입력(두 번 입력) : ");
					/* 0615 10:23 김석호 수정
					 * sc.close 추가. 원본 주석처리
					 */
//					sc.next();
//					String std_no1 = sc.nextLine();
					
					String std_no = ScanUtil.nextLine();
					
					if (std_no.equals((jdbc.isDuplicateSTD(std_no, "STD_NO")))) {
						System.out.println(mdfDAO.getPwInfo(std_no));
						System.out.println("변경할 학생 정보가 맞습니까?");
						System.out.println("예:1\t다시입력:2\t     나가기:3");
						String b = ScanUtil.nextLine();
						switch (b) {
						case "1":
							System.out.print("변경할 비밀번호 입력 : ");
							String newPw = ScanUtil.nextLine();
							if (mdfDAO.mdfPw(std_no, newPw) == 1) {
								System.out.println();
								System.out.println("정보 수정이 완료되었습니다.");
								System.out.println(mdfDAO.getPwInfo(std_no));
								bl01 = false;
								bl02 = false;
								break;
							} else {
								System.out.println("정보 수정에 실패하였습니다");
								bl01 = false;
								bl02 = false;
								break;
							}
						case "2":
							System.out.println("학생 정보를 다시 입력하세요.");
							break;
						case "3":
							bl02 = false;
							break;
						default:
							System.out.println("잘못된 번호입니다. 학생 정보를 다시 입력하세요.");
							break;
						}
					} else {
						System.out.println("존재하지 않는 학번입니다.");
					}
				}
				break;
			case "2":
				System.out.println("<정지일 변경>");
				while (bl02) {
					System.out.print("변경할 학생의 학번 입력 (두 번 입력) : ");
					/* 김석호 수정사항 */
//					sc.next();
//					String std_no1 = sc.nextLine();
					String std_no = ScanUtil.nextLine();
					if (std_no.equals(jdbc.isDuplicateSTD(std_no, "STD_NO"))) {
						System.out.println(mdfDAO.getSpdInfo(std_no));
						System.out.println("변경할 학생 정보가 맞습니까?");
						System.out.println("예:1\t다시입력:2\t     나가기:3");
						String b = ScanUtil.nextLine();
						switch (b) {
						case "1":
							if (mdfDAO.mdfSuspended(std_no) == 1) {
								System.out.println();
								System.out.println("정보 수정이 완료되었습니다.");
								System.out.println(mdfDAO.getSpdInfo(std_no));
								bl01 = false;
								bl02 = false;
								break;
							} else {
								System.out.println("정보 수정에 실패하였습니다");
								bl01 = false;
								bl02 = false;
								break;
//								bl01=false;
//								break;
							}
						case "2":
							System.out.println("학생 정보를 다시 입력하세요.");
							break;
						case "3":
							bl02 = false;
							break;
						default:
							System.out.println("잘못된 번호입니다. 학생 정보를 다시 입력하세요.");
							break;
						}
					} else {
						System.out.println("존재하지 않는 학번입니다.");
					}
				}
			case "3":
				return View.M_MAIN;
//					bl01=false;
//					break;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
			}
		}
		return View.M_MAIN;
	}

	public int mdfServiceS() {
		System.out.println(" [ 비밀번호 변경 ] ");
		boolean bl01 = true;
		while (bl01) {
			String std_no = (String) JDBCUtil.loginUser.get("STD_NO");
			System.out.print("현재 비밀번호 입력 : ");
			String std_pw = ScanUtil.nextLine();
			if (std_pw.equals(JDBCUtil.loginUser.get("STD_PW"))) {
				System.out.print("변경할 비밀번호 입력 : ");
				String newPw = ScanUtil.nextLine();
				if (mdfDAO.mdfPw(std_no, newPw) == 1) {
					System.out.println();
					System.out.println("정보 수정이 완료되었습니다.");
					System.out.println(mdfDAO.getPwInfo(std_no));
					bl01 = false;
					break;
				} else {
					System.out.println("정보 수정에 실패하였습니다");
					bl01 = false;
					break;
				}

			} else {
				System.out.println("비밀번호를 다시 입력하세요.");
			}
		}
		return View.S_MAIN;
	}
}
