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
			System.out.print("���̵� : ");
			String id=sc.nextLine();
			System.out.print("��й�ȣ : ");
			String pw=sc.nextLine();
			
			Map<String, Object> result = loginDao.loginDAO(id, pw);
			jdbc.loginUser=result;
			if (result != null) {
				if(jdbc.loginUser.get("STD_CLSCODE").equals("1")) {
					System.out.println(result.get("STD_NAME") + "�� �ݰ����ϴ�.");
				}else {
					System.out.println("�����ڸ���Դϴ�.");
				}
				break;
			}else {
				System.out.println("�й� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�.");
			}
		}
	}
}
