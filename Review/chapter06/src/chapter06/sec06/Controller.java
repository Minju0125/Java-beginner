package chapter06.sec06;

public class Controller {

	public static void main(String[] args) {
		new Controller().controller(); //<-?
		
	}

	public void controller () { // ����ƽ �ƴϾ ��
		// ����� �Ҽ� �ִ� ����� �α���, �α׾ƿ� ���
		
		MemberService memberService = new MemberService(); // ������� ��ü ���� 
		Member member = new Member("ȫ�浿","a001","1234",30); // ���� ��� database�� ����ִµ� , �� �����͸� ������ �ͼ� �����ϴ� Ŭ����
		boolean result = memberService.login(member.getId(), member.getPasswd()) ;//db�� �ִ°� �޾Ƽ� �־��� , ȣ���ؼ� ����� result �� �־���
		if(result) {
			System.out.println(member.getId()+ "���� �α��� �߽��ϴ�.");
		} else {
			System.out.println("id�� Ȥ�� passwor�� �߸� �Է��߽��ϴ�. ");
		}
	}
}
