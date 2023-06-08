package sec01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ModifyStudent {

	public static void main(String[] args) {
		JDBCUtil jdbcUtil = new JDBCUtil();
		ModifyStudentService mdfStd = new ModifyStudentService();
		jdbcUtil.connectConn();
		mdfStd.mdfService();
		jdbcUtil.disconnectConn();
	}

}

class ModifyStudentDAO {

	JDBCUtil jdbcUtil = new JDBCUtil();

	public int mdfSuspended(String STD_NO) { // 학번으로 학생테이블 정지일 수정 --사번으로 부서번호 수정
		String sql = " UPDATE STUDENT SET STD_STDATE=null WHERE STD_NO=? ";
		List<Object> param = new ArrayList<>();

		param.add(STD_NO);

		return jdbcUtil.update(sql, param);
	}

	public Map<String, Object> getStdInfo(String STD_NO) {
		String sql = " select std_name 이름, to_char(std_stdate, 'yyyy-mm-dd' ) 정지일 from student where std_no=? ";
		List<Object> param = new ArrayList<>();
		param.add(STD_NO);
		return jdbcUtil.selectOneRow(sql, param);

	}

}

class ModifyStudentService {
	Scanner sc = new Scanner(System.in);
	ModifyStudentDAO mdfDAO = new ModifyStudentDAO();
	JDBCUtil jdbcUtil = new JDBCUtil();

	public void mdfService() {
			System.out.println(" [ 학생정지일 수정 ] ");
			boolean bl01=true;
			while (bl01) {
					System.out.print("변경할 학생의 학번 입력 : ");
					String STD_NO = sc.nextLine();
					if (STD_NO.equals(jdbcUtil.isDuplicateSTD(STD_NO,"STD_NO"))) {
						System.out.println(mdfDAO.getStdInfo(STD_NO));
						System.out.println("변경할 학생 정보가 맞습니까?");
						System.out.println("예:1\t다시입력:2\t     나가기:3");
						int a = sc.nextInt();
						sc.nextLine();
						switch (a) {
						case 1:
							if (mdfDAO.mdfSuspended(STD_NO) == 1) {
								System.out.println();
								System.out.println("정보 수정이 완료되었습니다.");
								System.out.println(mdfDAO.getStdInfo(STD_NO));
								bl01=false;
								break;
							}else {
								System.out.println("정보 수정에 실패하였습니다");
								break;
							}
						case 2:
							System.out.println("학생 정보를 다시 입력하세요.");
							break;
						case 3:
							bl01=false;
							break;
						default:
							System.out.println("잘못된 번호입니다. 학생 정보를 다시 입력하세요.");
							break;
						}
					} else {
						System.out.println("존재하지 않는 학번입니다.");
					}
				}
			}
		}