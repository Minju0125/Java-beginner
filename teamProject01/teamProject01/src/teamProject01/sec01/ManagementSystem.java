package teamProject01.sec01;

import java.util.Scanner;

public class ManagementSystem {
	
	Scanner sys = new Scanner(System.in);
	public void mainSystem() {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		jdbc.connectConn();
		loginRoop: while (true) {
			System.out.println("============�ý��� ȭ��============");
			System.out.println("1. �α���");
			System.out.println("2. �ý��� ����");
			String menu0 = sys.nextLine();
			switch (menu0) {
			case "1":
				new LoginService().loginService();
				break;
			case "2":
				System.out.println("�ý����� �����մϴ�.");
				jdbc.disconnectConn();
				return;

			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}

			if (JDBCUtil.loginUser != null) {
				if (JDBCUtil.loginUser.get("STD_CLSCODE").equals("1")) {
					studentMenuRoop: while (true) {
						/* �л� ���θ޴� */
						System.out.println("============ ��  �� ============");
						System.out.println("1. ���� �˻� (����, ����)");
						System.out.println("2. ���� ��Ȳ ��ȸ (�ݳ�)");
						System.out.println("3. ��õ ���� ��ȸ");
						System.out.println("4. ������û");
						System.out.println("5. ����������");
						System.out.println("6. �α׾ƿ�");
						System.out.print("============ �޴� ���� :");
						String menu1 = sys.nextLine();

						switch (menu1) {
						case "1":
							/* �����˻� �޼ҵ� */
							/* new Ŭ����().�޼ҵ��̸�(); */
							new LoanService().judgeStudent();
							break;
						case "2":
							/* ���� ��Ȳ��ȸ �޼ҵ� */
							
							/* �ݳ� �޼ҵ� */
							new ReturnBook().returnBookForStudent();
							/* new Ŭ����().�޼ҵ��̸�(); */
							break;
						case "3":
							/* ��õ ���� ��ȸ �޼ҵ� */
							/* ���⵵ while switch case ��� �������� */
							/* new Ŭ����().�޼ҵ��̸�(); */
							break;
						case "4":
							/* ���� ��û �޼ҵ� */
							new RequestService().requestService();
							/* new Ŭ����().�޼ҵ��̸�(); */
							break;
						case "5":
							/* ���������� */
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
							System.out.println("�߸��� �Է��Դϴ�.");
						}

					}
				/* �α��� ������ �б���. �� : �л� , else ���� : ������ */
				} else {
					managerMenuRoop: while (true) {
						/* ������ ���� �޴� */
						System.out.println("============ ��  �� ============");
						System.out.println("1. ���� �˻�");
						System.out.println("2. �л� ���� ����");
						System.out.println("3. ���� �� �ݳ� ����");
						System.out.println("4. å ��� �� ���");
						System.out.println("5. ��ü��Ȳ ��ȸ");
						System.out.println("6. �ݳ������� ������ å ��ȸ");
						System.out.println("7. ������û ��Ȳ ��ȸ");
						System.out.println("8. �α׾ƿ�");
						System.out.print("============ �޴� ���� :");
						String menu2 = sys.nextLine();

						switch (menu2) {
						case "1":
							/* ���� �˻� �޼ҵ� */
							/* new Ŭ����().�޼ҵ��̸�(); */
							new LoanService().loanManage();
							break;
						case "2":
							new ModifyStudentService().mdfServiceM();
							/* new Ŭ����().�޼ҵ��̸�(); */
							break;
						case "3":
							actingRoop: while (true) {
								System.out.println("============ ��� ���� ============");
								System.out.println("1. ���� ����");
								System.out.println("2. �ݳ� ����");
								System.out.println("3. �ڷ� ����");
								System.out.print("============ �޴� ���� :");
								String menu3 = sys.nextLine();
								switch (menu3) {
								case "1":
									/* ���� ���� �޼ҵ� ȣ�� */
									/* new Ŭ����().�޼ҵ��̸�(); */
									break;
								case "2":
									new ReturnBook().returnBookForManager();
									break;
								case "3":
									break actingRoop;
								default:
									System.out.println("�߸��� �Է��Դϴ�.");
									break;
								}
							} // �Ŵ��� �޴� ���� �� �ݳ� ���� case ����
							break;
						case "4":
							/*�Ϸ�*//* å ��� �� ��� �޼ҵ� */
							newOrDiscardRoop :while(true) {
								System.out.println("============ ��� ���� ============");
								System.out.println("1. ���� ���");
								System.out.println("2. ���� ���");
								System.out.println("3. �ڷ� ����");
								System.out.print("============ �޴� ���� :");
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
									System.out.println("�߸��� �����Դϴ�.");
									break;
								}
							}
							/* new Ŭ����().�޼ҵ��̸�(); */
							break;
						case "5":
							/* ��ü ��Ȳ ��ȸ �޼ҵ� */
							/* new Ŭ����().�޼ҵ��̸�(); */
							break;
						case "6":
							/* �ݳ������� ������ å ��ȸ �޼ҵ� */
							/* new Ŭ����().�޼ҵ��̸�(); */
							break;
						case "7":
							requestRoop : while(true) {
								System.out.println("============ ��� ���� ============");
								System.out.println("1. ��û ���� ��ȸ");
								System.out.println("2. ��û������� �ʱ�ȭ");
								System.out.println("3. �ڷ� ����");
								System.out.print("============ �޴� ���� :");
								String menu4 = sys.nextLine();
								switch (menu4) {
								case "1":
									/* ��û���� ���̺� ��ȸ �޼ҵ� */
									break;
								case "2":
									/* ��û���� ���̺��� Ʃ�� �����ϴ� �޼ҵ� */
									new RequestService().requestClear();
									break;
								case "3":
									break requestRoop;
								default:
									System.out.println("�߸��� �Է��Դϴ�.");
								}
							}
							
							/* new Ŭ����().�޼ҵ��̸�(); */
							break;
						case "8":
							new LogoutService().logout();
							if(JDBCUtil.loginUser==null) {
								continue loginRoop;
							}else {
								continue managerMenuRoop;
							}
						default:
							System.out.println("�߸��� �Է��Դϴ�.");
						}

					}
				}
			}
		}// loginRoop ������
	}
	
	public void myPage() {
		while(true) {
			/*  ������� ǥ������ ����   */
			/*�й�*/
			/*�̸�*/
			/*���� ���� �Ǽ�*/
			/*���� ��Ȳ null or å���� , ���Ⱑ�ɿ���*/
			System.out.println("============ ��� ���� ============");
			System.out.println("1. ��й�ȣ ����");
			System.out.println("2. ���� ���");
			System.out.println("3. �ڷ� ����");
			System.out.print("============ �޴� ���� :");
			String pageMenu = sys.nextLine();
			switch (pageMenu) {
			case "1":
				new ModifyStudentService().mdfServiceS();
				break;
			case "2":
				/* ���� ��� �޼ҵ� */
				break;
			case "3":
				return;

			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
			
			
		}
	}
}
