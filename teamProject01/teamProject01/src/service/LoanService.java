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
	/* �輮ȣ �������� id �ּ�ó�� */
//   Object id = JDBCUtil.loginUser.get("STD_NO");

	public int loanAsStudent() {

		Object stdate = JDBCUtil.loginUser.get("STD_STDATE");
		if (stdate == null) {
			List<Map<String, Object>> list = dao.judgeOverdueCount(JDBCUtil.loginUser.get("STD_NO"));
			Object[] countArray = new Object[list.size()];

			for (int i = 0; i < list.size(); i++) {
				countArray[i] = list.get(i).get("COUNT");
			}
//         System.out.println(Arrays.toString(countArray)); // (�׽�Ʈ��) �� �л��� ����

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
					System.out.println("[��������]");
					System.out.println("==========================================================");
					System.out.println("�л����� : �������� ����");
					// ���⼭ �ٽ� if -> ������ ������ ������.
					outerLoop: while (true) {

						System.out.print("���⵵�� ��ȣ �Է� : ");
						String inputBookNo = ScanUtil.nextLine();
						Object bookNo = dao.verifyBookNo(inputBookNo);

						if (bookNo == null) {
							System.out.println("==========================================================");
							System.out.println("�߸��� ������ȣ�Դϴ�. �ٽ� �õ��ϼ���.");
							continue outerLoop;
						}

						Map<String, Object> bookInfo = dao.judgeBook(bookNo);
						String ldsno = (String) bookInfo.get("BK_LDSNO");
						String rsvsno = (String) bookInfo.get("BK_RSVSNO");

						if (ldsno != null) { // �����ڰ� �ִ� ���
							if (ldsno.equalsIgnoreCase(JDBCUtil.loginUser.get("STD_NO").toString())) {// �Է��� ������ �л�������
																										// �������ΰ��
								System.out.println("�л� ������ �������� å�Դϴ�. �ٸ� å�� �˻��ϼ���.");
								continue outerLoop;// �ٽ� �����˻� â����
							} else if (rsvsno != null) {// �Է��� ������ ������, �����ڰ� ��� �����ϴ� ���(����Ұ�)
								System.out.println("������,�����ڰ� �����ϴ� å�Դϴ�. �ٸ� å�� �˻��ϼ���.");
								continue outerLoop;// �ٽ� �����˻� â����
							} else if (rsvsno == null) {// �Է��� ������ �����ڰ� ����������, �����ڴ� �������� �ʴ� ���(����Ұ�, ���ุ����)
								System.out.println("���� ���� ���� å���� ����Ұ��մϴ�.");

								while (true) {
									System.out.println("����޴��� �̵��Ͻðڽ��ϱ�? \n1.��   2.�ƴϿ�");
									String answer = ScanUtil.nextLine();
									if (answer.equals("1")) {
										return View.S_RSVBOOK;
									} else if (answer.equals("2")) {
										return View.S_LRMAIN;
									} else {
										System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
									}
								}
							}
						} else if (ldsno == null) { // �����ڰ� ���� ���, �������� ���� �Ǵ�
							if (rsvsno == null) { // �����ڵ�, �����ڵ� ���� ���
								System.out.println("[���Ⱑ��] ���� ������ �����Դϴ�.");
								System.out.println("�����Ͻðڽ��ϱ�?");////////////////////////////////////////////////////////////////////
								System.out.println("1.��   2.�ƴϿ�(�ڷΰ���)");
								String answer = ScanUtil.nextLine();
								if (answer.equals("1")) {
									//// ���� �޼ҵ� (�ٿ������� - �Ű����� inputBookNo?)
									int resultLendTable = dao.loanLendTable(inputBookNo,
											(String) JDBCUtil.loginUser.get("STD_NO"));
									int resultBookTable = dao.loanBookTable(inputBookNo,
											(String) JDBCUtil.loginUser.get("STD_NO"));
									if (resultLendTable == 1 && resultBookTable == 1) {
										System.out.println("[����Ϸ�]");
										return View.S_MAIN;
									} else {
										System.out.println("[�������]");
										return View.S_MAIN;
									}

								} else {
									// �����Ͻðڽ��ϱ� �ƴϿ�(�ڷΰ���) �ϸ� ���� ��������,,?
									// ���⿡ �ش��ϴ� �ڵ� �ۼ�
									break;
								}
							} else if (rsvsno != null) { // ������x, ������o
								if (rsvsno.equals(JDBCUtil.loginUser.get("STD_NO"))) { // �����ڰ� �л� ������ ���
									System.out.println("[���Ⱑ��] ������ �����Դϴ�.");
									System.out.println("�����Ͻðڽ��ϱ�?");/////////////////////////////////////////////////////////////////////
									System.out.println("1.��   2.�ƴϿ�(�ڷΰ���)");
									String answer = ScanUtil.nextLine();
									if (answer.equals("1")) {
										//// ���� �޼ҵ� (�ٿ������� - �Ű����� inputBookNo?)
										int resultLendTable = dao.loanLendTable(inputBookNo,
												(String) JDBCUtil.loginUser.get("STD_NO"));
										int resultBookTable = dao.loanBookTable(inputBookNo,
												(String) JDBCUtil.loginUser.get("STD_NO"));
										if (resultLendTable == 1 && resultBookTable == 1) {
											System.out.println("[����Ϸ�]");
											return View.S_MAIN;
										} else {
											System.out.println("[�������]");
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
					System.out.println("[����Ұ�] �ִ� ���� ���� �Ǽ�(3��) �ʰ�");
				}
			} else {
				System.out.println("[����Ұ�] ��ü�� å�� �����մϴ�. �ݳ� �� �̿����ּ���.");
			}
		} else {
			System.out.println("[����Ұ�] ������ ����");

		}
		return View.S_MAIN;
	}

	public int loanAsManager() {

		while (true) {
			String studentNo;
			System.out.println("�л��й��Է� :");
			studentNo = ScanUtil.nextLine();

			if (studentNo.equals(String.valueOf(jdbc.isDuplicateSTD(studentNo, "STD_NO")))) {
				System.out.println("�й� : " + studentNo);
				System.out.println("�̸� : " + dao.studentSelectSTDNAME(studentNo, "STD_NAME"));

				System.out.println("�л������� �½��ϱ�?");
				System.out.println("1.��\t2.�ƴϿ�");
				String a = ScanUtil.nextLine();

				if (a.equals("1")) {

					Object stdate = dao.getStdate(studentNo);
					if (stdate == null) {
						List<Map<String, Object>> list = dao.judgeOverdueCount(studentNo);
						Object[] countArray = new Object[list.size()];

						for (int i = 0; i < list.size(); i++) {
							countArray[i] = list.get(i).get("COUNT");
						}
//         System.out.println(Arrays.toString(countArray)); // (�׽�Ʈ��) �� �л��� ����

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
								System.out.println("[��������]");
								System.out.println("==========================================================");
								System.out.println("�л����� : �������� ����");
								outerLoop: while (true) {

									System.out.println("���⵵�� ��ȣ �Է� : ");
									String inputBookNo = ScanUtil.nextLine();
									Object bookNo = dao.verifyBookNo(inputBookNo);

									if (bookNo == null) {
										System.out
												.println("==========================================================");
										System.out.println("�߸��� ������ȣ�Դϴ�. �ٽ� �õ��ϼ���.");
										continue outerLoop;
									}

									Map<String, Object> bookInfo = dao.judgeBook(bookNo);
									String ldsno = (String) bookInfo.get("BK_LDSNO");
									String rsvsno = (String) bookInfo.get("BK_RSVSNO");

									if (ldsno != null) { // �����ڰ� �ִ� ���
										if (ldsno.equalsIgnoreCase(JDBCUtil.loginUser.get("STD_NO").toString())) {// �Է���
																													// ������
																													// �л�������
																													// �������ΰ��
											System.out.println("�л� ������ �������� å�Դϴ�. �ٸ� å�� �˻��ϼ���.");
											continue outerLoop;// �ٽ� �����˻� â����
										} else if (rsvsno != null) {// �Է��� ������ ������, �����ڰ� ��� �����ϴ� ���(����Ұ�)
											System.out.println("������,�����ڰ� �����ϴ� å�Դϴ�. �ٸ� å�� �˻��ϼ���.");
											continue outerLoop;// �ٽ� �����˻� â����
										} else if (rsvsno == null) {// �Է��� ������ �����ڰ� ����������, �����ڴ� �������� �ʴ� ���(����Ұ�, ���ุ����)
											System.out.println("���� ���� ���� å���� ����Ұ��մϴ�.");

										}
									} else if (ldsno == null) { // �����ڰ� ���� ���, �������� ���� �Ǵ�
										if (rsvsno == null) { // �����ڵ�, �����ڵ� ���� ���
											System.out.println("[���Ⱑ��] ���� ������ �����Դϴ�.");
											System.out.println("�����Ͻðڽ��ϱ�?");////////////////////////////////////////////////////////////////////
											System.out.println("1.��   2.�ƴϿ�(�ڷΰ���)");
											String answer = ScanUtil.nextLine();
											if (answer.equals("1")) {
												//// ���� �޼ҵ� (�ٿ������� - �Ű����� inputBookNo?)
												int resultLendTable = dao.loanLendTable(inputBookNo, studentNo);
												int resultBookTable = dao.loanBookTable(inputBookNo, studentNo);
												if (resultLendTable == 1 && resultBookTable == 1) {
													System.out.println("[����Ϸ�]");
													return View.M_MAIN;
												} else {
													System.out.println("[�������]");
													return View.M_MAIN;
												}

											} else {
												// �����Ͻðڽ��ϱ� �ƴϿ�(�ڷΰ���) �ϸ� ���� ��������,,?
												// ���⿡ �ش��ϴ� �ڵ� �ۼ�
												break;
											}
										} else if (rsvsno != null) { // ������x, ������o
											if (rsvsno.equals(JDBCUtil.loginUser.get("STD_NO"))) { // �����ڰ� �л� ������ ���
												System.out.println("[���Ⱑ��] ������ �����Դϴ�.");
												System.out.println("�����Ͻðڽ��ϱ�?");/////////////////////////////////////////////////////////////////////
												System.out.println("1.��   2.�ƴϿ�(�ڷΰ���)");
												String answer = ScanUtil.nextLine();
												if (answer.equals("1")) {
													//// ���� �޼ҵ� (�ٿ������� - �Ű����� inputBookNo?)
													int resultLendTable = dao.loanLendTable(inputBookNo, studentNo);
													int resultBookTable = dao.loanBookTable(inputBookNo, studentNo);
													if (resultLendTable == 1 && resultBookTable == 1) {
														System.out.println("[����Ϸ�]");
														return View.M_MAIN;
													} else {
														System.out.println("[�������]");
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
								System.out.println("[����Ұ�] �ִ� ���� ���� �Ǽ�(3��) �ʰ�");
							}
						} else {
							System.out.println("[����Ұ�] ��ü�� å�� �����մϴ�. �ݳ� �� �̿����ּ���.");
						}
					} else {
						System.out.println("[����Ұ�] ������ ����");

					}
					return View.M_MAIN;

				}else if(a.equals("2")) {
					System.out.println("�ٽ� �õ��ϼ���.");
					continue;
				}else {
					System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				}
			} else {
				System.out.println("�й��� �߸��Է��ϼ̽��ϴ�. �ٽ� �õ��ϼ���.");
			}
		} // while�� ��

	}
}