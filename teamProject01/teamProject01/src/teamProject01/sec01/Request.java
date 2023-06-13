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
		System.out.println(" [ 도서 신청 ] ");
		System.out.print("제목 입력 : ");
		String req_title = sc.nextLine();
		System.out.print("저자 입력 : ");
		String req_writer = sc.nextLine();
		System.out.print("출판사 입력 : ");
		String req_pub = sc.nextLine();
		System.out.print("가격 입력(0) : ");
		int req_price = Integer.parseInt(sc.nextLine());
		System.out.println("---------------------------------------");
		
		System.out.println("제목 : "+req_title);
		System.out.println("저자 : "+ req_writer);
		System.out.println("출판사 : "+req_pub);
		System.out.println("가격 : "+req_price);
			
		System.out.println("해당도서를 신청하시겠습니까?");
		System.out.println("예 : 1\t아니오 :2");
		int a = sc.nextInt();
		System.out.println("---------------------------------------");
		switch(a) {
		case 1 : 
			int result = reqDAO.requestDAO(req_title, req_writer, req_pub, req_price);
			if (result == 1) {
				System.out.println("도서 신청 완료");
			} else {
				System.out.println("도서 신청 실패");
			}
			break;
		case 2 :	//while문으로 아니오 클릭했을 때 다시 입력받으려고하면 제목입력 sc.nextLine 오류남
			System.out.println("도서 신청 실패");
			break;
		default : 
			System.out.println("잘못된 번호입니다.");
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
				System.out.println("총 " + countRequest + "건의 도서 신청이 검색되었습니다.");
				System.out.println("도서 신청 목록을 비우시겠습니까?");
				System.out.print("1. 비우기 | 2. 취소");
				String menu = sc.nextLine();
				switch (menu) {
				case "1":
					sql = "DELETE FROM REQUEST WHERE 1=1";
					int result = reqDAO.jdbc.daoConn.stmt.executeUpdate(sql);
					if(result == countRequest) System.out.println("성공적으로 신청목록을 비웠습니다.");
					break;
				case "2":
					System.out.println("신청 목록을 비우지 않고 나갑니다.");
					break;
					
				default:
					System.out.println("입력이 잘못되어 화면을 나갑니다.");
					return;
				}
			}else {
				System.out.println("도서 신청 목록이 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println("오류발생");
			e.printStackTrace();
		}
	}
	
	
}
