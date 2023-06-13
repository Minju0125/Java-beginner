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
		String sql = " select std_name �̸�, to_char(std_stdate, 'yyyy-mm-dd' ) ������ from student where std_no=? ";
		List<Object> param = new ArrayList<>();
		param.add(std_no);
		return jdbc.selectOneRow(sql, param);
	}
	
	public Map<String, Object> getPwInfo(String std_no) {
		String sql = " select std_name �̸�, std_pw ��й�ȣ from student where std_no=? ";
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
			System.out.println(" [ �л����� ���� ] ");
			boolean bl02=true;
			System.out.print("��й�ȣ ���� : 1\t������ ���� : 2\t������ : 3\n");
			int a=sc.nextInt();
			switch(a) {
			case 1: 
				System.out.println("<��й�ȣ ����>");
				while (bl02) {
					System.out.print("������ �л��� �й� �Է�(�� �� �Է�) : ");
					sc.next();
					String std_no1 = sc.nextLine();
					String std_no = sc.nextLine();
					if (std_no.equals((jdbc.isDuplicateSTD(std_no,"STD_NO")))) {
						System.out.println(mdfDAO.getPwInfo(std_no));
						System.out.println("������ �л� ������ �½��ϱ�?");
						System.out.println("��:1\t�ٽ��Է�:2\t     ������:3");
						int b = sc.nextInt();
						sc.nextLine();
						switch (b) {
						case 1:
							System.out.print("������ ��й�ȣ �Է� : ");
							String newPw=sc.nextLine();
							if (mdfDAO.mdfPw(std_no, newPw) == 1) {
								System.out.println();
								System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
								System.out.println(mdfDAO.getPwInfo(std_no));
								bl01=false;
								bl02=false;
								break;
							}else {
								System.out.println("���� ������ �����Ͽ����ϴ�");
								bl01=false;
								break;
							}
						case 2:
							System.out.println("�л� ������ �ٽ� �Է��ϼ���.");
							break;
						case 3:
							bl01=false;
							bl02 = false;
							break;
						default:
							System.out.println("�߸��� ��ȣ�Դϴ�. �л� ������ �ٽ� �Է��ϼ���.");
							break;
						}
					} else {
						System.out.println("�������� �ʴ� �й��Դϴ�.");
					}
				}
				break;
			case 2:
				System.out.println("<������ ����>");
				while (bl02) {
					System.out.print("������ �л��� �й� �Է� (�� �� �Է�) : ");
					sc.next();
					String std_no1 = sc.nextLine();
					String std_no = sc.nextLine();
					if (std_no.equals(jdbc.isDuplicateSTD(std_no,"STD_NO"))) {
						System.out.println(mdfDAO.getSpdInfo(std_no));
						System.out.println("������ �л� ������ �½��ϱ�?");
						System.out.println("��:1\t�ٽ��Է�:2\t     ������:3");
						int b = sc.nextInt();
						sc.nextLine();
						switch (b) {
						case 1:
							if (mdfDAO.mdfSuspended(std_no) == 1) {
								System.out.println();
								System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
								System.out.println(mdfDAO.getSpdInfo(std_no));
								bl01=false;
								bl02 = false;
								break;
							} else {
								System.out.println("���� ������ �����Ͽ����ϴ�");
								bl01=false;
								break;
							}
						case 2:
							System.out.println("�л� ������ �ٽ� �Է��ϼ���.");
							break;
						case 3:
							bl02 = false;
							break;
						default:
							System.out.println("�߸��� ��ȣ�Դϴ�. �л� ������ �ٽ� �Է��ϼ���.");
							break;
						}
					} else {
						System.out.println("�������� �ʴ� �й��Դϴ�.");
					}
				}
				case 3:
					bl01=false;
					break;
				default :
					System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void mdfServiceS() {
		System.out.println(" [ ��й�ȣ ���� ] ");
		boolean bl01=true;
		while (bl01) {
				String std_no = (String)jdbc.loginUser.get("STD_NO");
				System.out.print("���� ��й�ȣ �Է� : ");
				String std_pw=sc.nextLine();
				if(std_pw.equals(jdbc.loginUser.get("STD_PW"))){
					System.out.print("������ ��й�ȣ �Է� : ");
					String newPw=sc.nextLine();
					if (mdfDAO.mdfPw(std_no, newPw) == 1) {
						System.out.println();
						System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
						System.out.println(mdfDAO.getPwInfo(std_no));
						bl01=false;
						break;
					}else {
						System.out.println("���� ������ �����Ͽ����ϴ�");
						break;
					}
					
				} else {
					System.out.println("��й�ȣ�� �ٽ� �Է��ϼ���.");
				}
			}
		}
	}
