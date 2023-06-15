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
			System.out.println(" [ �л����� ���� ] ");
			boolean bl02 = true;
			System.out.print("��й�ȣ ���� : 1\t������ ���� : 2\t������ : 3\n");
			String a = ScanUtil.nextLine();
			/* �輮ȣ �������� */
			switch (a) {
			case "1":
				System.out.println("<��й�ȣ ����>");
				while (bl02) {
					System.out.print("������ �л��� �й� �Է�(�� �� �Է�) : ");
					/* 0615 10:23 �輮ȣ ����
					 * sc.close �߰�. ���� �ּ�ó��
					 */
//					sc.next();
//					String std_no1 = sc.nextLine();
					
					String std_no = ScanUtil.nextLine();
					
					if (std_no.equals((jdbc.isDuplicateSTD(std_no, "STD_NO")))) {
						System.out.println(mdfDAO.getPwInfo(std_no));
						System.out.println("������ �л� ������ �½��ϱ�?");
						System.out.println("��:1\t�ٽ��Է�:2\t     ������:3");
						String b = ScanUtil.nextLine();
						switch (b) {
						case "1":
							System.out.print("������ ��й�ȣ �Է� : ");
							String newPw = ScanUtil.nextLine();
							if (mdfDAO.mdfPw(std_no, newPw) == 1) {
								System.out.println();
								System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
								System.out.println(mdfDAO.getPwInfo(std_no));
								bl01 = false;
								bl02 = false;
								break;
							} else {
								System.out.println("���� ������ �����Ͽ����ϴ�");
								bl01 = false;
								bl02 = false;
								break;
							}
						case "2":
							System.out.println("�л� ������ �ٽ� �Է��ϼ���.");
							break;
						case "3":
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
			case "2":
				System.out.println("<������ ����>");
				while (bl02) {
					System.out.print("������ �л��� �й� �Է� (�� �� �Է�) : ");
					/* �輮ȣ �������� */
//					sc.next();
//					String std_no1 = sc.nextLine();
					String std_no = ScanUtil.nextLine();
					if (std_no.equals(jdbc.isDuplicateSTD(std_no, "STD_NO"))) {
						System.out.println(mdfDAO.getSpdInfo(std_no));
						System.out.println("������ �л� ������ �½��ϱ�?");
						System.out.println("��:1\t�ٽ��Է�:2\t     ������:3");
						String b = ScanUtil.nextLine();
						switch (b) {
						case "1":
							if (mdfDAO.mdfSuspended(std_no) == 1) {
								System.out.println();
								System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
								System.out.println(mdfDAO.getSpdInfo(std_no));
								bl01 = false;
								bl02 = false;
								break;
							} else {
								System.out.println("���� ������ �����Ͽ����ϴ�");
								bl01 = false;
								bl02 = false;
								break;
//								bl01=false;
//								break;
							}
						case "2":
							System.out.println("�л� ������ �ٽ� �Է��ϼ���.");
							break;
						case "3":
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
			case "3":
				return View.M_MAIN;
//					bl01=false;
//					break;
			default:
				System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		return View.M_MAIN;
	}

	public int mdfServiceS() {
		System.out.println(" [ ��й�ȣ ���� ] ");
		boolean bl01 = true;
		while (bl01) {
			String std_no = (String) JDBCUtil.loginUser.get("STD_NO");
			System.out.print("���� ��й�ȣ �Է� : ");
			String std_pw = ScanUtil.nextLine();
			if (std_pw.equals(JDBCUtil.loginUser.get("STD_PW"))) {
				System.out.print("������ ��й�ȣ �Է� : ");
				String newPw = ScanUtil.nextLine();
				if (mdfDAO.mdfPw(std_no, newPw) == 1) {
					System.out.println();
					System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
					System.out.println(mdfDAO.getPwInfo(std_no));
					bl01 = false;
					break;
				} else {
					System.out.println("���� ������ �����Ͽ����ϴ�");
					bl01 = false;
					break;
				}

			} else {
				System.out.println("��й�ȣ�� �ٽ� �Է��ϼ���.");
			}
		}
		return View.S_MAIN;
	}
}
