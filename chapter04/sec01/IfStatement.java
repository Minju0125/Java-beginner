package chapter04.sec01;

import java.util.Scanner;

public class IfStatement {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		method1();
		method2();
//		method3();
//		method4();	
//		method5();
//		method6();
//		method7();

	}

	public static void method1() {
		// ����� �̸��� ������ �Է� �޾� 60�� �̻��̸�
		// "�̸� �հ��Դϴ�" �޼��� ���

		String message= "" ; // null �� �ʱ�ȭ
		System.out.println("�̸� �Է� : ");
		String name = sc.nextLine();// ���� Ŀ���� �ִ� �ʿ��� �Է¹��� ��ü�� name �� ��
		System.out.print("���� �Է� : ");// ���� �ٿ� �Է�
		int score = sc.nextInt(); // �� ���� �ǹ�?

		if (score >= 60) {
			message = name + "��(��) �հ��Դϴ�.";
		} else {
			message = name + "��(��) ���հ��Դϴ�.";
		}
		System.out.println(message); // ���� �ϳ��� �����ؼ� �ѱ������� �����ϴ� ���� ����
	}

	public static void method2() {
//		 ����� �̸��� ������ �Է� �޾� 60�� �̻��̸�
//		 "�̸� �հ��Դϴ�." �޼��� ���

		String message = ""; // null �� �ʱ�ȭ
		System.out.println("�̸� �Է� : ");
		String name = sc.nextLine();// ���� Ŀ���� �ִ� �ʿ��� �Է¹��� ��ü�� name �� ��
		System.out.print("���� �Է� : ");// ���� �ٿ� �Է�
		int score = sc.nextInt();

		if (score >= 60) {
			message = name + "��(��) �հ��Դϴ�.";
		}
		System.out.println(message);
	}

	public static void method3() {
//		����1 ���� �Է¹޾� 
//		3~5�� : "���Դϴ�."
//		6~8�� : "�����Դϴ�."
//		9~11�� : "�����Դϴ�."
//		12~2�� : "�ܿ��Դϴ�."

		String message = "";
		System.out.println("�� : ");

		int month = sc.nextInt();

//		if (month>=3 && month<=5) {
//			message = "���Դϴ�.";
//		}else if (month>=6 && month<=8) {
//			message = "�����Դϴ�.";
//		}else if (month>=9 && month<=11) {
//			message = "�����Դϴ�.";
//		}else if ((month>=1 && month<=2) || month==12) { // ���� ���ǵ��� ��� �ƴϸ� ���� �ʿ䰡 ���� ������ ������ else if ������ �� �ʿ� ���� !
//			message = "�ܿ��Դϴ�.";
//		}
//		System.out.println(message);

		if (month >= 3 && month <= 5) {
			message = "���Դϴ�.";
		} else if (month >= 6 && month <= 8) {
			message = "�����Դϴ�.";
		} else if (month >= 9 && month <= 11) {
			message = "�����Դϴ�.";
		} else {
			message = "�ܿ��Դϴ�.";
		}
		System.out.println(message);

	}

	public static void method4() {
//		����2 ü�߰� Ű�� �Է��Ͽ� BMI ������ ���ϰ� BMI ������ ���� �򰡸� ����ϴ� ���α׷� �ۼ�	
//		BMI ���� = ü�� (kg) /Ű(m)*Ű(m)

//		0.0~18.4 ��ü��
//		18.5~22.9 ����
//		23.0~24.9 ��ü��
//		25.0~29.9 ��
//		30.0~���̻� ����

		String message = "";
		System.out.println("ü��");
		int weight = sc.nextInt();
		System.out.println("Ű");
		double height = sc.nextDouble();

		double BMI = weight / height * height;

		if (BMI >= 0.0 && BMI <= 18.4) {
			message = "��ü��";
		} else if (BMI >= 18.5 && BMI <= 22.9) { // BMI>=18.5 �Ƚᵵ �ǳ� Ȯ�� �غ���
			message = "����";
		} else if (BMI >= 23.0 && BMI <= 24.9) {
			message = "����";
		} else if (BMI >= 25.0 && BMI <= 29.9) {
			message = "��";
		} else {
			message = "����";
		}
		System.out.println("���� : " + message);

	}

	public static void method5() {

//		�����Ϸ��� �Ѵ�. ������ ������ ���̰� 18�� �̻��̸�, �����԰� 50kg ���̾�� �Ѵ�.
//		�̸� ��ø if ���� ����Ͽ� �����Ͻÿ�.
//		���̿� �����Դ� ������(= ������ ���)

		String message = "";

		System.out.println("����:");
		int age = sc.nextInt();
		System.out.println("������:");
		int weight = sc.nextInt();

		if (age >= 18) {
			if (weight >= 50) {
				message = "���� ����";
			} else {
				message = "���� �Ұ���";
			}
		} else {
			message = "���� �Ұ���";
		}

		System.out.println(message);
	}

	public static void method6() {

//		������ ���� �Է� �޾� Ȧ���� ¦���� �Ǻ��Ͻÿ�,.

		String message = "";

		System.out.println("Random");
		int number = sc.nextInt();

		if (number % 2 == 0) {
			message = "¦��";
		}
		message = "Ȧ��";

		System.out.println(message);
	}

	public static void method7() {

		/*
		 * 99-97 : A+ 
		 * 96-93 : A0
		 * 92-90 : A- // char �ȵǰ� ���ڿ��� ��
		 * 
		 * 89-87 : B+
		 * 86-83 : B0
		 * 82-80 : B-
		 * 
		 * 79-77 : C+
		 * 76-73 : C0
		 * 72-70 : C- 
		 * 
		 * �� ���ϴ� F => ��ø if ���
		 */

		int score = 73;
		String grade = ""; // �ʱⰪ �� ������

		if (score >= 90) {
			grade = "A";
			if (score <= 92) {
				grade = grade + "+";
			} else {
				if (score <= 96) {
					grade = grade + "0";
				} else {
					grade = grade + "-";
				}
			}

		} else if (score >= 80) {
			grade = "B";
			if (score <= 82) {
				grade = grade + "+";
			} else {
				if (score <= 86) {
					grade = grade + "0";
				} else {
					grade = grade + "-";
				}
			}
			
		} else if (score >= 70) {
			grade = "C";
			if (score <= 72) {
				grade = grade + "+";
			} else {
				if (score <= 76) {
					grade = grade + "0";
				} else {
					grade = grade + "-";
				}
			}
			
		} else
			grade = "F";

		System.out.println(grade);

	}

}
