package chapter04.sec03;

import java.util.Scanner;

public class WhileStatementExample {

	public static void main(String[] args) {
		WhileStatement ws = new WhileStatement();
//		 ws.method1();
		ws.method2();
	}
}

class WhileStatement {
	int numOfChop = 0; // ������ Ƚ��

	public void method1() {
		while (numOfChop < 9) { // 10�� �Ǹ� �Ѿ�� �ϱ� ����
			numOfChop++;
			System.out.println(numOfChop + "�� ������ϴ�.");
			System.out.println("���� �ȳѾ�׿�...");
		}
		System.out.println("---------------------");
		System.out.println((++numOfChop) + "�� ������ϴ�."); // (numOfChop++)�ϸ� �ȵ� �̰ŷ� �ϸ� ���⿡ 9�� ���� �־��ֱ� ����
		System.out.println("������ ���� �Ѿ� �����ϴ�...");
	}

	public void method2() {
		String menu = "*** Ŀ�� �޴� ***\n";
		menu += "1.�Ƹ޸�ī��		2000�� \n";
		menu += "2.ī���			3500�� \n";
		menu += "3.ī��ḶŰ�߶�		5000�� \n";
		menu += "4.�ڹ�Ĩ ������ġ��		6500�� \n";
		menu += "5.���� \n";		//ū ���ڿ� ����� ����Ʈ?? ��� �޼ҵ� ��� (������ ����)
		
		int sum = 0; // Ŀ�Ǳ��űݾ�
		int exit = 0; //5���� ���õǾ��� �� exit ���� -1�̸� ����

		String bill = "    *** ������ ***\n";
		bill+="--------------------\n";

		while (true) { //while (true) �� ���ѷ���
			System.out.println(menu);
			Scanner sc = new Scanner(System.in);
			System.out.print("Ŀ�Ǹ� �����ϼ���...");
			int choice = Integer.parseInt(sc.nextLine()); // Integer.parseInt(sc.nextLine()) ��ȣ���� String Ÿ���� ���ڸ� int
														// Ÿ������ ��ȯ���ִ� �޼ҵ�
			switch (choice) {
			case 1:
				sum += 2000;
				bill += "1.�Ƹ޸�ī��		2000�� \n";
				break;
			case 2:
				sum += 3500;
				bill += "2.ī���		3500�� \n";
				
				break;
			case 3:
				sum += 5000;
				bill += "3.ī��ḶŰ�߶�		5000�� \n";
				break;
			case 4:
				sum += 6500;
				bill += "4.�ڹ�Ĩ ������ġ��		6500�� \n";
				break;
			case 5 :
				exit = -1;
				break;
			default:
				System.out.println("�߸��� �����Դϴ�.");

			}// end switch

			if (exit == -1) { //5�� ���ý�
				System.out.println("���α׷� ����");
				break;
			}

		} // end while

		bill+="--------------------\n";
		bill+=" �հ� :      "+sum + "��";
		System.out.println(bill);
		
	} 
	
}
