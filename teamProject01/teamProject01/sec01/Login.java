package teamProject01.sec01;

import java.io.ObjectOutputStream.PutField;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Login{

}


class LoginDAO{
	JDBCUtil jdbc=JDBCUtil.getInstance();
	
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
	JDBCUtil jdbc=JDBCUtil.getInstance();
	
	public void loginService() {
		
		while (true) {
			System.out.print("아이디 : ");
			String id=sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw=sc.nextLine();
			
			Map<String, Object> result = loginDao.loginDAO(id, pw);
			jdbc.loginUser=result;
			if (result != null) {
				if(jdbc.loginUser.get("STD_CLSCODE").equals("1")) {
					System.out.println(result.get("STD_NAME") + "님 반갑습니다.");
				}else {
					System.out.println("관리자모드입니다.");
				}
				break;
			}else {
				System.out.println("학번 또는 비밀번호가 잘못되었습니다.");
			}
		}
	}
}
