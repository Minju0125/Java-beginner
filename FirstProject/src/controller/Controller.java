package controller;

import service.LoginService;

public class Controller {

	public static void main(String[] args) {

		new Controller().init();

	}

	public void init() { // �� �޴��� ���⿡ ���. 
		//static �� �ƴ� �Ϲ� �޼ҵ� ����ϰ�, static �� ���� �޼ҵ忡�� ����Ϸ��� -> �ڱ� �ڽ��� ������(�ڱ� �ڽ��� ��ü) -> init ȣ��
		LoginService loginService = LoginService.getInstance();
		loginService.login();
		
		//loginService ������ ����ڰ� ���� ������ ���� �ܺ� �����͸� �Է¹޴°�.
		//�ٿ� Ŭ������ �Է¹��� ���� �Ѱ��༭ �ش� ������ �ű⼭ �ϼ���
		//
	
				
	}

}
