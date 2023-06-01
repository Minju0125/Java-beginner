package util;

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
	 * static 변수는 객체의 인스턴스 생성과 관계없이 유지됩니다. 객체의 인스턴스가 생성되지 않아도 클래스의 static 변수는 메모리에
	 * 상주하고, 값을 유지합니다. 따라서, 로그인 횟수를 static으로 선언하면, 프로그램이 실행되는 동안 로그인 횟수를 계속 추적할 수
	 * 있습니다.
	 */

	Scanner sc = new Scanner(System.in);

	public static int loginCount = 0; // 값이 계속 유지되어야 하기 때문에 static 으로 선언함. //
	LoginDAO dao = LoginDAO.getInstance(); // 싱글톤 패턴이라.

	// 로그인 메소드
	public void login() {
		System.out.println("[[로그인]]");

		System.out.print("id 입력 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 입력 : ");
		String pw = sc.nextLine();

		// dao의 로그인 메소드를 호출
		Map<String, Object> result = dao.login(id, pw);
		loginCount++; // 로그인 카운트 증가시켜야함

		// 입력받은 데이터가 없으면 오류
		// 비밀번호, 아이디를 가지고 해당 데이터가 존재하니까 , 여기까지 온거임 (?)
		if (result != null) {
			System.out.println(result.get("MEM_NAME") + "님 반갑습니다.");
		} else {
			System.out.println("다시 로그인하세요...");
		}
	}

}
