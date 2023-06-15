package service;

import java.util.Map;

import dao.LoginDAO;
import util.JDBCUtil;
import util.View;
import util.ScanUtil;

public class LoginService {
	private static LoginService instance=null;
	private LoginService(){}
	
	public static LoginService getInstance() {
		if(instance==null) instance=new LoginService();
		return instance;
	}
	
	LoginDAO loginDao=LoginDAO.getInstance();
	JDBCUtil jdbc=JDBCUtil.getInstance();
	
	public int loginService() {
		
		while (true) {
			System.out.print("아이디 : ");
			String id=ScanUtil.nextLine();
			System.out.print("비밀번호 : ");
			String pw=ScanUtil.nextLine();
			
			Map<String, Object> result = loginDao.loginDAO(id, pw);
			JDBCUtil.loginUser=result;
			if (result != null) {
				if(JDBCUtil.loginUser.get("STD_CLSCODE").equals("1")) {
					System.out.println(result.get("STD_NAME") + "님 반갑습니다.");
					return View.S_MAIN;
				}else {
					System.out.println("관리자모드입니다.");
					return View.M_MAIN;
				}
			}else {
				System.out.println("학번 또는 비밀번호가 잘못되었습니다.");
			}
		}

	}
}
