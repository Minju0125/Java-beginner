package chapter06.sec06;

import java.util.Scanner;

public class MemberService {
// �α���, �α׾ƿ� ���
	
	public boolean login(String id, String passwd) {  //�α��� �� �� ���� ���̵��� �Ѱ� �޾�, ��������� ���� ���� �α����ߴ���, 
		Scanner sc = new Scanner (System.in);
		System.out.println("id : ");
		String pid = sc.nextLine();
		
		System.out.println("password : ");
		String pwd = sc.nextLine();
		
		if(pid.equals(id) && pwd.equals(passwd)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void logout(String id) {
		System.out.println(id + "���� �α׾ƿ� �Ǿ����ϴ�...");
	}
	
}
// �Ű������� ��Ʈ�ѷ��� �ִ� ���̵�� �н����带 �Ѱܹ޾�. �Ҹ��� �α���~~~
// �� ���̵�� �н����带 if �� pid���� pwd.�� Ű����� ���� �Ͱ� db�� �ִ� ���� ����
