package chapter04.sec01;

import java.util.Scanner;

public class SwtichStatementExample {

	public static void main(String[] args) {

		SwitchStatement sw = new SwitchStatement(); // ��ü����
//		sw.method1();
//		sw.method2();
		sw.method3();
//		sw.method4();
	}

}

class SwitchStatement {
	Scanner sc = new Scanner(System.in); // ��ĳ�� Ŭ���� ������ߵǴµ� ����Ʈ �Ƚ�Ű�� ���� // ���θ޼ҵ� - ����ƽ���� �޼ҵ�. ������ ����ƽ�پ����.

		public void method1() {
		System.out.println("ȸ�� ��� �Է� (1 - 3)");
		int grade = Integer.parseInt(sc.nextLine());

		switch (grade) {
		case 1:
			System.out.println("VIP ȸ���Դϴ�.");
			break;
		case 2:
			System.out.println("���ȸ���Դϴ�.");
			break;
		case 3:
			System.out.println("�Ϲ�ȸ���Դϴ�.");
			break;
		default:
			System.out.println(grade + "�� �߸��� ��� �ڵ��Դϴ�."); // ����Ʈ�� switch ���� ���̱� ������ �극��ũ x

		}

	}
	
	public void method2() {	
		System.out.println("�� �Է� (1-12)");
		int month = sc.nextInt();
		
//		int month = sc.nextInt();
//		nextLine�� ����Ű�� ġ�� ������ �� �ٿ��� �Է¹��� ���� ������ -> �̰� ���� ��������
//		-> �������� �ڷḦ ���ÿ� �Է� ���� �� (����Ű�� ����)
		
		switch (month) {
			case 1:	case 3: case  5: case 7:
			case 8: case 10:case 12: 		
				// if ������ ������, 
				// if(month ==1 || ~~~) �����
				// or �� ����Ǿ����� ���� �� ��(7�� �߿� �ϳ��� �����ϸ� �Ʒ� �޼��� ���)
				System.out.println(month + "���� ������ ��¥�� 31�ϱ��� �ִ� ���Դϴ�.");
				break;
			case 4: case 6: case 9: case 11:
				System.out.println(month + "���� ������ ��¥�� 30�ϱ��� �ִ� ���Դϴ�.");
				break;
			default: 
				System.out.println("����¥�� 28���� 2���Դϴ�.");
				// if ���� ���� ����
				
		}
	}
		
		/* ��3)
		 
		����1) �������� �����ڵ� (kr,jp,ch)�� �Է¹޾� �ѱ۷� �������� ��� (��ø switch-case ���)
		
		*/
			
	public void method3() {
		System.out.println("������(�����ڵ�) : ");
		String nation = sc.nextLine();
		
//		switch (nation) {
//		case "kr" :
//			System.out.println("�ѱ�");
//			break;
//		case "jp" :
//			System.out.println("�Ϻ�");
//			break;
//		default : 	
//			System.out.println("�߱�");
		
//		switch (nation) {
//			case "kr": 
//				System.out.println("�ѱ�");
//					switch (nation) {
//						case "jp" :
//							System.out.println("�ѱ�");}	
//				System.out.println("�߱�");
//						}
		
		
//		switch (nation) 
		
		}
		
		
		
		
		
		
		
	
				
	public void method4() {
		System.out.println("�����Է� : ");
		int score = sc.nextInt();
		String grade = "";
		
//		������ �Է¹޾�
//		 99-97 : A+ 
//		 96-93 : A0
//		92-90 : A- 
//
//		89-87 : B+
//		86-83 : B0
//		82-80 : B-
//				
//		79-77 : C+
//		76-73 : C0
//		72-70 : C- 
		
		switch(score/10) {
		case 10 :
			grade = "A+";
			break;
		case 9 :
			grade = "A";
			switch(score%10) {
			case 0: case 1: case 2:
				grade = grade + "-";
				break;
			case 3: case 4: case 5: case 6:
				grade = grade + "0";
				break;
			case 7: case 8: case 9:
				grade = grade + "-";
					}
			break;
		case 8 :
			grade = "B";
			switch(score%10) {
			case 0: case 1: case 2:
				grade = grade + "-";
				break;
			case 3: case 4: case 5: case 6:
				grade = grade + "0";
				break;
			case 7: case 8: case 9:
				grade = grade + "-";
			} 
			break;
		default : 
			grade = "fail";
		}
		System.out.println("����" + score + "�� " + grade + "�����Դϴ�.");
			
			
		
		
		}
	
		
		
		
		
		
	}
			

			
			
			


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		