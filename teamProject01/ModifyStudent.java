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

	public int mdfSuspended(String STD_NO) { // �й����� �л����̺� ������ ���� --������� �μ���ȣ ����
		String sql = " UPDATE STUDENT SET STD_STDATE=null WHERE STD_NO=? ";
		List<Object> param = new ArrayList<>();

		param.add(STD_NO);

		return jdbcUtil.update(sql, param);
	}

	public Map<String, Object> getStdInfo(String STD_NO) {
		String sql = " select std_name �̸�, to_char(std_stdate, 'yyyy-mm-dd' ) ������ from student where std_no=? ";
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
			System.out.println(" [ �л������� ���� ] ");
			boolean bl01=true;
			while (bl01) {
					System.out.print("������ �л��� �й� �Է� : ");
					String STD_NO = sc.nextLine();
					if (STD_NO.equals(jdbcUtil.isDuplicateSTD(STD_NO,"STD_NO"))) {
						System.out.println(mdfDAO.getStdInfo(STD_NO));
						System.out.println("������ �л� ������ �½��ϱ�?");
						System.out.println("��:1\t�ٽ��Է�:2\t     ������:3");
						int a = sc.nextInt();
						sc.nextLine();
						switch (a) {
						case 1:
							if (mdfDAO.mdfSuspended(STD_NO) == 1) {
								System.out.println();
								System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
								System.out.println(mdfDAO.getStdInfo(STD_NO));
								bl01=false;
								break;
							}else {
								System.out.println("���� ������ �����Ͽ����ϴ�");
								break;
							}
						case 2:
							System.out.println("�л� ������ �ٽ� �Է��ϼ���.");
							break;
						case 3:
							bl01=false;
							break;
						default:
							System.out.println("�߸��� ��ȣ�Դϴ�. �л� ������ �ٽ� �Է��ϼ���.");
							break;
						}
					} else {
						System.out.println("�������� �ʴ� �й��Դϴ�.");
					}
				}
			}
		}