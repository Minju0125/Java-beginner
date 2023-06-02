package service;

import java.util.Map;
import java.util.Scanner;

import dao.LoginDAO;

public class LoginService {
	private static LoginService instance;

	private LoginService() {
	}

	public static LoginService getInstance() {
		if (instance == null)
			instance = new LoginService();
		return instance;
	}

	/*
	 * static ������ ��ü�� �ν��Ͻ� ������ ������� �����˴ϴ�. ��ü�� �ν��Ͻ��� �������� �ʾƵ� Ŭ������ static ������ �޸𸮿�
	 * �����ϰ�, ���� �����մϴ�. ����, �α��� Ƚ���� static���� �����ϸ�, ���α׷��� ����Ǵ� ���� �α��� Ƚ���� ��� ������ ��
	 * �ֽ��ϴ�.
	 */

	Scanner sc = new Scanner(System.in);

	public static int loginCount = 0; // ���� ��� �����Ǿ�� �ϱ� ������ static ���� ������. //
	LoginDAO dao = LoginDAO.getInstance(); // �̱��� �����̶�.
	Map<String, Object> result=null;
	
	// �α��� �޼ҵ�
	public void login() {
		System.out.println("[[�α���]]");
		while(true) {

		System.out.print("id �Է� : ");
		String id = sc.nextLine();

		System.out.print("��й�ȣ �Է� : ");
		String pw = sc.nextLine();

		// dao�� �α��� �޼ҵ带 ȣ�� .
		//�Է¹��� ���� ������ sql��
		Map<String, Object> result = dao.login(id, pw);
		loginCount++; // �α��� ī��Ʈ �������Ѿ���
		if(loginCount>2) break;

		// �Է¹��� �����Ͱ� ������ ����
		// ��й�ȣ, ���̵� ������ �ش� �����Ͱ� �����ϴϱ� , ������� �°��� (?)
		if (result != null) {
			System.out.println(result.get("MEM_NAME") + "�� �ݰ����ϴ�.");
			break;

		} else {
			System.out.println("�ٽ� �α����ϼ���...");
		}
	}

}
	public Map<String, Object> isDuplicate(String id) { // �ߺ��˻�
		result=dao.select(id); //daoŬ������ �ִ� select �޼ҵ� ȣ�� // ���⿡ ��ȯ��
		return result; // �� result�� �ٽ� preapre ��¼�� Ŭ������ ��ȯ
	}
}
