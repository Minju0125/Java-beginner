package chapter06.sec06;

import java.util.Scanner;

public class MemberService {
// 로그인, 로그아웃 기능
	
	public boolean login(String id, String passwd) {  //로그인 할 때 현재 아이디값을 넘겨 받아, 멤버서비스의 값이 누가 로그인했는지, 
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
		System.out.println(id + "님이 로그아웃 되었습니다...");
	}
	
}
// 매개변수로 컨트롤러에 있는 아이디와 패스워드를 넘겨받아. 불리안 로그인~~~
// 그 아이디와 패스워드를 if 문 pid에서 pwd.를 키보드로 받은 것과 db에 있는 값을 대조
