package service;


import dao.RequestDAO;
import util.ScanUtil;
import util.View;

public class RequestService {
	private static RequestService instance=null;
	private RequestService() {}
	
	public static RequestService getInstance() {
		if(instance==null) instance=new RequestService();
		return instance;
	}
	
	RequestDAO reqDAO = RequestDAO .getInstance();

	public int requestService() {
		System.out.println(" [ 도서 신청 ] ");
		System.out.print("제목 입력 : ");
		String req_title = ScanUtil.nextLine();
		System.out.print("저자 입력 : ");
		String req_writer = ScanUtil.nextLine();
		System.out.print("출판사 입력 : ");
		String req_pub = ScanUtil.nextLine();
		System.out.print("가격 입력(0) : ");
		int req_price = ScanUtil.nextInt();
		
		/*수정사항 : null 입력시 도서신청 실패 출력 / 박민주 / 2023.06.15, 11:38*/
		if(req_title.equals("") || req_writer.equals("")|| req_pub.equals("")) {
			System.out.println("도서 신청 실패");
			return View.S_MAIN;
			
		} 
		System.out.println("---------------------------------------");
		
		System.out.println("제목 : "+req_title);
		System.out.println("저자 : "+ req_writer);
		System.out.println("출판사 : "+req_pub);
		System.out.println("가격 : "+req_price);
			
		System.out.println("도서를 신청하시겠습니까?");
		System.out.println("예 : 1\t아니오 :2");
		String a = ScanUtil.nextLine();
		System.out.println("---------------------------------------");
		switch(a) {
		case "1" : 
			int result = reqDAO.requestDAO(req_title, req_writer, req_pub, req_price);
			if (result == 1) {
				System.out.println("도서 신청 완료");
			} else {
				System.out.println("도서 신청 실패");
			}
			break;
		case "2" :	//while문으로 아니오 클릭했을 때 다시 입력받으려고하면 제목입력 sc.nextLine 오류남
			System.out.println("도서 신청 실패");
			break;
		default : 
			System.out.println("잘못된 번호입니다.");
		}
		
		return View.S_MAIN;
	}
	
	public int requestClear() {
		
		int countRequest = reqDAO.countRequestListDAO();
		if(countRequest!=0) {
			System.out.println("총 " + countRequest + "건의 도서 신청이 검색되었습니다.");
			System.out.println("도서 신청 목록을 비우시겠습니까?");
			System.out.print("1. 비우기 | 2. 취소");
			String menu = ScanUtil.nextLine();
			switch (menu) {
			case "1":
				int result = reqDAO.clearRequestListDAO();
				if(result == countRequest) System.out.println("성공적으로 신청목록을 비웠습니다.");
			case "2":
				System.out.println("신청 목록을 비우지 않고 나갑니다.");
			default:
				System.out.println("입력이 잘못되어 화면을 나갑니다.");
			}
		}else {
			System.out.println("도서 신청 목록이 없습니다.");
		}
		return View.M_MAIN;
	}
}