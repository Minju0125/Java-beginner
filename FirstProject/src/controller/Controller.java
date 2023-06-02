package controller;

import service.LoginService;

public class Controller {

	public static void main(String[] args) {

		new Controller().init();

	}

	public void init() { // 주 메뉴를 여기에 기술. 
		//static 이 아닌 일반 메소드 사용하고, static 인 메인 메소드에서 사용하려고 -> 자기 자신의 생성자(자기 자신을 객체) -> init 호출
		LoginService loginService = LoginService.getInstance();
		loginService.login();
		
		//loginService 에서는 사용자가 쿼리 실행을 위한 외부 데이터를 입력받는곳.
		//다오 클래스로 입력받은 값을 넘겨줘서 해당 쿼리가 거기서 완성됨
		//
	
				
	}

}
