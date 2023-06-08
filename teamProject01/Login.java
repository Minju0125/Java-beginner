package sec01;

import java.io.ObjectOutputStream.PutField;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.ObjectOutputStream.PutField;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Login{

	public static void main(String[] args) {
		JDBCUtil jdbc=new JDBCUtil();
		LoginService login = new LoginService();

		jdbc.connectConn();
		login.loginService();
		jdbc.disconnectConn();
	}
}


class LoginDAO{	
	JDBCUtil jdbc=new JDBCUtil();
	
	public Map<String, Object> loginDAO(String id, String pw) {
		String sql="select * from student where std_no=? and std_pw=?";
		List<Object> param=new ArrayList<>();
		
		param.add(id);
		param.add(pw);
		
		return jdbc.selectOneRow(sql, param);
	}
}

class LoginService {
	Scanner sc=new Scanner(System.in);
	LoginDAO loginDao=new LoginDAO();
	JDBCUtil jdbc=new JDBCUtil();
	
	public void loginService() {
		
		while (true) {
			System.out.print("아이디 : ");
			String id=sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw=sc.nextLine();
			
			Map<String, Object> result = loginDao.loginDAO(id, pw);
			jdbc.loginUser=result;
			if (result != null) {
				System.out.println(result);
				System.out.println(result.get("STD_NAME") + "님 반갑습니다.");
				break;
			}else {
				System.out.println("다시 로그인하세요.");
			}
		}
	}
}
