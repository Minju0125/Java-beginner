package service;

import util.ScanUtil;
import util.JDBCUtil;
import util.View;

public class LogoutService {
	private static LogoutService instance=null;
	private LogoutService() {}
	
	public static LogoutService getInstance() {
		if(instance==null) instance=new LogoutService();
		return instance;
	}
	
	JDBCUtil jdbc=JDBCUtil.getInstance();

	
	public int logout() {
		System.out.println(JDBCUtil.loginUser.get("STD_NAME")+"�� �α׾ƿ��Ͻðڽ��ϱ�?");
		System.out.println("1:��\n2:�ƴϿ�");
		String a=ScanUtil.nextLine();
		if(a.equals("1")) {
			JDBCUtil.loginUser=null;
		}else if(a.equals("2")){
			if(Integer.parseInt(String.valueOf(JDBCUtil.loginUser.get("STD_CLSCODE")))==1) {
				return View.S_MAIN;
			}else {
				return View.M_MAIN;
			}
		}else {
			System.out.println("�߸��� ��ȣ�Դϴ�.");
			if(Integer.parseInt(String.valueOf(JDBCUtil.loginUser.get("STD_CLSCODE")))==1) {
				return View.S_MAIN;
			}else {
				return View.M_MAIN;
			}
		}
		return View.MAIN;
	}
}
