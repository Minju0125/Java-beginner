package sec01;

import java.util.Scanner;

public class Logout{

	public static void main(String[] args) {
		JDBCUtil jdbc=new JDBCUtil();
		LoginService login = new LoginService();
		LogoutService logout = new LogoutService();
		jdbc.connectConn();
		login.loginService();
		logout.logout();
		jdbc.disconnectConn();
	}
}

class LogoutService {
	JDBCUtil jdbc=new JDBCUtil();
	Scanner sc=new Scanner(System.in);
	
	public LogoutService() {}
	
	public void logout() {
		System.out.println(jdbc.loginUser.get("STD_NAME")+"님 로그아웃하시겠습니까?");
		System.out.println("1:예\n2:아니오");
		int a=sc.nextInt();
		if(a==1) {
			jdbc.loginUser=null;
			System.out.println(jdbc.loginUser);
		}
	}
}
