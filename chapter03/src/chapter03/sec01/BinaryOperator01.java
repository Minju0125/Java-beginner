package chapter03.sec01;

import java.util.Scanner;

public class BinaryOperator01 {
	static Scanner sc = new Scanner(System.in); // �� Ŭ���� �ȿ����� ��𿡼��� sc �� �� �� ���� (�������)

	public static void main(String[] args) {
		// ���� ������ : ��κ��� ������ (���, �� ����, ����///// ��Ʈ, ����, �̵�)

//		arthmeticOperator();
//		relationalOperator();
		logicalOperator();

	}

	public static void arthmeticOperator() {
		// ��� ������ : +,-,/,*,%
		int n1 = 100;
		int n2 = 15;
		System.out.println("n1=" + n1 + "\nn2=" + n2);

		System.out.println("n1 + n2" + (n1 + n2));
		System.out.println("n1 - n2" + (n1 - n2));
		System.out.println("n1 * n2" + (n1 * n2));
		System.out.println("n1 / n2 " + (n1 / n2));
		System.out.println("n1 % n2: " + (n1 % n2));
	}

	public static void relationalOperator() {
		// ���迬���� : >, <, =, >=, <=, !=(<>)
		// ��ĳ�� Ŭ���� �ϴ� �ܿ��α� // �ܼ�â���� ������ �Է��ϰ� �Ǿ��ִµ� �޼����� �������
		// ������????????????????????
		System.out.print("�����Է� : "); // ��½�Ű�� �޼���

		// ������ ��κ� 0-100 ���̱� ������ ���� - > ������
		int score = Integer.parseInt(sc.nextLine()); // Ŭ���� �̸��� �빮�ڷ� ���� / ���ڿ��� �޾Ƽ� (int) integer��
		String grade = ""; // null ���� ������

		if (score >= 90) {
			grade = "A����";

		} else if (score >= 80) {
			grade = "B����";

		} else if (score >= 70) {
			grade = "c����";

		} else if (score >= 60) {
			grade = "D����";

		} else {
			grade = "F����";

		}
		System.out.println("���� : " + score + "\n���� :" + grade);
	}

	public static void logicalOperator() {
		// ������ �����߱� ������ sc ��� ����
		// ���� : 4�� ����̸鼭 100�� ����� �ƴϰų� �Ǵ� 400�� ����� �Ǵ� ��

		System.out.print("�⵵ �Է� : ");
		int year = sc.nextInt(); // ������ ����?

		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println(year + "�⵵�� �����Դϴ�.");
		} else {
			System.out.println(year + "�⵵�� ����Դϴ�.");
		}

	}

}
