package chapter06.sec06;

public class Controller {

	public static void main(String[] args) {
		new Controller().controller(); //<-?
		
	}

	public void controller () { // 스태틱 아니어도 됨
		// 멤버가 할수 있는 기능은 로그인, 로그아웃 기능
		
		MemberService memberService = new MemberService(); // 멤버서비스 객체 생성 
		Member member = new Member("홍길동","a001","1234",30); // 실제 얘는 database에 들어있는데 , 이 데이터를 가지고 와서 보관하는 클래스
		boolean result = memberService.login(member.getId(), member.getPasswd()) ;//db에 있는걸 받아서 넣어줌 , 호출해서 결과를 result 에 넣어줌
		if(result) {
			System.out.println(member.getId()+ "님이 로그인 했습니다.");
		} else {
			System.out.println("id나 혹은 passwor를 잘못 입력했습니다. ");
		}
	}
}
