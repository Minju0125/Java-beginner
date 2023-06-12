package teamProject01.sec01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Request {
}

class RequestDAO {
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public int requestDAO(String req_title, String req_writer, String req_pub, int req_price) {
		String sql = " INSERT INTO REQUEST(REQ_TITLE,REQ_WRITER,REQ_PUB,REQ_PRICE) " + "VALUES( ?, ?, ?, ?) ";
		List<Object> param = new ArrayList<>();
		param.add(req_title);
		param.add(req_writer);
		param.add(req_pub);
		param.add(req_price);

		return jdbc.update(sql, param);
	}
}

class RequestService {
	Scanner sc = new Scanner(System.in);
	RequestDAO reqDAO = new RequestDAO();

	public void requestService() {
		System.out.println(" [ ���� ��û ] ");
		System.out.print("���� �Է� : ");
		String req_title = sc.nextLine();
		System.out.print("���� �Է� : ");
		String req_writer = sc.nextLine();
		System.out.print("���ǻ� �Է� : ");
		String req_pub = sc.nextLine();
		System.out.print("���� �Է�(0) : ");
		int req_price = Integer.parseInt(sc.nextLine());
		System.out.println("---------------------------------------");
		
		System.out.println("���� : "+req_title);
		System.out.println("���� : "+ req_writer);
		System.out.println("���ǻ� : "+req_pub);
		System.out.println("���� : "+req_price);
			
		System.out.println("�ش絵���� ��û�Ͻðڽ��ϱ�?");
		System.out.println("�� : 1\t�ƴϿ� :2");
		int a = sc.nextInt();
		System.out.println("---------------------------------------");
		switch(a) {
		case 1 : 
			int result = reqDAO.requestDAO(req_title, req_writer, req_pub, req_price);
			if (result == 1) {
				System.out.println("���� ��û �Ϸ�");
			} else {
				System.out.println("���� ��û ����");
			}
			break;
		case 2 :	//while������ �ƴϿ� Ŭ������ �� �ٽ� �Է¹��������ϸ� �����Է� sc.nextLine ������
			System.out.println("���� ��û ����");
			break;
		default : 
			System.out.println("�߸��� ��ȣ�Դϴ�.");
		}
	}
	
	public void requestClear() {
		String sql = "SELECT COUNT(*) A FROM REQUEST";
		int countRequest = 0;
		try {
			reqDAO.jdbc.daoConn.rs = reqDAO.jdbc.daoConn.stmt.executeQuery(sql);
			reqDAO.jdbc.daoConn.rs.next();
			countRequest = reqDAO.jdbc.daoConn.rs.getInt("A");
			if(countRequest!=0) {
				System.out.println("�� " + countRequest + "���� ���� ��û�� �˻��Ǿ����ϴ�.");
				System.out.println("���� ��û ����� ���ðڽ��ϱ�?");
				System.out.print("1. ���� | 2. ���");
				String menu = sc.nextLine();
				switch (menu) {
				case "1":
					sql = "DELETE FROM REQUEST WHERE 1=1";
					int result = reqDAO.jdbc.daoConn.stmt.executeUpdate(sql);
					if(result == countRequest) System.out.println("���������� ��û����� ������ϴ�.");
					break;
				case "2":
					System.out.println("��û ����� ����� �ʰ� �����ϴ�.");
					break;
					
				default:
					System.out.println("�Է��� �߸��Ǿ� ȭ���� �����ϴ�.");
					return;
				}
			}else {
				System.out.println("���� ��û ����� �����ϴ�.");
			}
		} catch (SQLException e) {
			System.out.println("�����߻�");
			e.printStackTrace();
		}
	}
	
	
}
