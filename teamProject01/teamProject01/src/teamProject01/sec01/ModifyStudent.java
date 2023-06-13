package teamProject01.sec01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ModifyStudent {
}

class ModifyStudentDAO {
	JDBCUtil jdbc=JDBCUtil.getInstance();

	public int mdfSuspended(String std_no) {
		String sql = " UPDATE STUDENT SET STD_STDATE=null WHERE STD_NO=? ";
		List<Object> param = new ArrayList<>();
		
		param.add(std_no);
		
		return jdbc.update(sql, param);
	}
	
	public int mdfPw(String std_no, String std_pw) {
		
		
		
		String sql = " UPDATE STUDENT SET STD_PW=? WHERE STD_NO=? ";
		List<Object> param = new ArrayList<>();
		
		param.add(std_pw);
		param.add(std_no);
		
		return jdbc.update(sql, param);
	}

	public Map<String, Object> getSpdInfo(String std_no) {
		String sql = " select std_name 이름, to_char(std_stdate, 'yyyy-mm-dd' ) 정지일 from student where std_no=? ";
		List<Object> param = new ArrayList<>();
		param.add(std_no);
		return jdbc.selectOneRow(sql, param);
	}
	
	public Map<String, Object> getPwInfo(String std_no) {
		String sql = " select std_name 이름, std_pw 비밀번호 from student where std_no=? ";
		List<Object> param = new ArrayList<>();
		param.add(std_no);
		return jdbc.selectOneRow(sql, param);
	}
	
}

class ModifyStudentService {
	Scanner sc = new Scanner(System.in);
	ModifyStudentDAO mdfDAO = new ModifyStudentDAO();
	JDBCUtil jdbc=JDBCUtil.getInstance();

	public void mdfServiceM() {
		boolean bl01=true;
		while(bl01) {
			System.out.println(" [ 학생정보 수정 ] ");
			boolean bl02=true;
			System.out.print("비밀번호 변경 : 1\t정지일 변경 : 2\t나가기 : 3\n");
			int a=sc.nextInt();
			switch(a) {
			case 1: 
				System.out.println("<비밀번호 변경>");
				while (bl02) {
					System.out.print("변경할 학생의 학번 입력(두 번 입력) : ");
					sc.next();
					String std_no1 = sc.nextLine();
					String std_no = sc.nextLine();
					if (std_no.equals((jdbc.isDuplicateSTD(std_no,"STD_NO")))) {
						System.out.println(mdfDAO.getPwInfo(std_no));
						System.out.println("변경할 학생 정보가 맞습니까?");
						System.out.println("예:1\t다시입력:2\t     나가기:3");
						int b = sc.nextInt();
						sc.nextLine();
						switch (b) {
						case 1:
							System.out.print("변경할 비밀번호 입력 : ");
							String newPw=sc.nextLine();
							if (mdfDAO.mdfPw(std_no, newPw) == 1) {
								System.out.println();
								System.out.println("정보 수정이 완료되었습니다.");
								System.out.println(mdfDAO.getPwInfo(std_no));
								bl01=false;
								bl02=false;
								break;
							}else {
								System.out.println("정보 수정에 실패하였습니다");
								bl01=false;
								break;
							}
						case 2:
							System.out.println("학생 정보를 다시 입력하세요.");
							break;
						case 3:
							bl01=false;
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
			case 2:
				System.out.println("<정지일 변경>");
				while (bl02) {
					System.out.print("변경할 학생의 학번 입력 (두 번 입력) : ");
					sc.next();
					String std_no1 = sc.nextLine();
					String std_no = sc.nextLine();
					if (std_no.equals(jdbc.isDuplicateSTD(std_no,"STD_NO"))) {
						System.out.println(mdfDAO.getSpdInfo(std_no));
						System.out.println("변경할 학생 정보가 맞습니까?");
						System.out.println("예:1\t다시입력:2\t     나가기:3");
						int b = sc.nextInt();
						sc.nextLine();
						switch (b) {
						case 1:
							if (mdfDAO.mdfSuspended(std_no) == 1) {
								System.out.println();
								System.out.println("정보 수정이 완료되었습니다.");
								System.out.println(mdfDAO.getSpdInfo(std_no));
								bl01=false;
								bl02 = false;
								break;
							} else {
								System.out.println("정보 수정에 실패하였습니다");
								bl01=false;
								break;
							}
						case 2:
							System.out.println("학생 정보를 다시 입력하세요.");
							break;
						case 3:
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
				case 3:
					bl01=false;
					break;
				default :
					System.out.println("잘못된 번호입니다. 다시 입력하세요.");
			}
		}
	}
	
	public void mdfServiceS() {
		System.out.println(" [ 비밀번호 변경 ] ");
		boolean bl01=true;
		while (bl01) {
				String std_no = (String)jdbc.loginUser.get("STD_NO");
				System.out.print("현재 비밀번호 입력 : ");
				String std_pw=sc.nextLine();
				if(std_pw.equals(jdbc.loginUser.get("STD_PW"))){
					System.out.print("변경할 비밀번호 입력 : ");
					String newPw=sc.nextLine();
					if (mdfDAO.mdfPw(std_no, newPw) == 1) {
						System.out.println();
						System.out.println("정보 수정이 완료되었습니다.");
						System.out.println(mdfDAO.getPwInfo(std_no));
						bl01=false;
						break;
					}else {
						System.out.println("정보 수정에 실패하였습니다");
						break;
					}
					
				} else {
					System.out.println("비밀번호를 다시 입력하세요.");
				}
			}
		}
	}
