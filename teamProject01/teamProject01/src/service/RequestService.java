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
		System.out.println(" [ ���� ��û ] ");
		System.out.print("���� �Է� : ");
		String req_title = ScanUtil.nextLine();
		System.out.print("���� �Է� : ");
		String req_writer = ScanUtil.nextLine();
		System.out.print("���ǻ� �Է� : ");
		String req_pub = ScanUtil.nextLine();
		System.out.print("���� �Է�(0) : ");
		int req_price = ScanUtil.nextInt();
		
		/*�������� : null �Է½� ������û ���� ��� / �ڹ��� / 2023.06.15, 11:38*/
		if(req_title.equals("") || req_writer.equals("")|| req_pub.equals("")) {
			System.out.println("���� ��û ����");
			return View.S_MAIN;
			
		} 
		System.out.println("---------------------------------------");
		
		System.out.println("���� : "+req_title);
		System.out.println("���� : "+ req_writer);
		System.out.println("���ǻ� : "+req_pub);
		System.out.println("���� : "+req_price);
			
		System.out.println("������ ��û�Ͻðڽ��ϱ�?");
		System.out.println("�� : 1\t�ƴϿ� :2");
		String a = ScanUtil.nextLine();
		System.out.println("---------------------------------------");
		switch(a) {
		case "1" : 
			int result = reqDAO.requestDAO(req_title, req_writer, req_pub, req_price);
			if (result == 1) {
				System.out.println("���� ��û �Ϸ�");
			} else {
				System.out.println("���� ��û ����");
			}
			break;
		case "2" :	//while������ �ƴϿ� Ŭ������ �� �ٽ� �Է¹��������ϸ� �����Է� sc.nextLine ������
			System.out.println("���� ��û ����");
			break;
		default : 
			System.out.println("�߸��� ��ȣ�Դϴ�.");
		}
		
		return View.S_MAIN;
	}
	
	public int requestClear() {
		
		int countRequest = reqDAO.countRequestListDAO();
		if(countRequest!=0) {
			System.out.println("�� " + countRequest + "���� ���� ��û�� �˻��Ǿ����ϴ�.");
			System.out.println("���� ��û ����� ���ðڽ��ϱ�?");
			System.out.print("1. ���� | 2. ���");
			String menu = ScanUtil.nextLine();
			switch (menu) {
			case "1":
				int result = reqDAO.clearRequestListDAO();
				if(result == countRequest) System.out.println("���������� ��û����� ������ϴ�.");
			case "2":
				System.out.println("��û ����� ����� �ʰ� �����ϴ�.");
			default:
				System.out.println("�Է��� �߸��Ǿ� ȭ���� �����ϴ�.");
			}
		}else {
			System.out.println("���� ��û ����� �����ϴ�.");
		}
		return View.M_MAIN;
	}
}