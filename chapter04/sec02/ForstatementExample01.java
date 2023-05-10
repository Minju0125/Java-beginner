package chapter04.sec02;

import java.util.Scanner;

public class ForStatementExample01 {

	public static void main(String[] args) {
		ForStatement fs = new ForStatement();
//		fs.method1();
//		fs.method2();
//		fs.method3();
//		fs.method4();
//		fs.method5();
//		fs.method6();
		fs.method7();
//		fs.method8();
	}
}

class ForStatement {
	Scanner sc = new Scanner(System.in);

	public void method1() {
		// 1~10 ������ �� ���ٿ� ��� - �ݺ�Ƚ�� �˰� ����
		// �� ���ϱ�

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			System.out.printf("%3d", (i + 1));
			sum += i;
		}
		System.out.println("\nsum=" + sum);

		// System.out.println("i=" + i); ���� �ȵ� i�� for �� �ȿ��� ����Ǿ��� ������

	}

public void method2() {
		// 1~100 ������ ¦���� �հ� Ȧ���� ���� ���Ͻÿ�.

		int sumOfEven = 0; // ¦���� ���� ����� ������ for �� �ۿ���
		int sumOfOdd = 0; // Ȧ���� ���� ����� ����

		for (int i = 1; i < 101; i++) {
			if (i % 2 == 0) {
				sumOfEven = sumOfEven + i;
			} else {
				sumOfOdd = sumOfOdd + i;
			}

		}

		System.out.println("¦���� �� :" + sumOfEven);
		System.out.println("Ȧ���� �� :" + sumOfOdd);

	}

	public void method3() {
		// ���ڿ��� ������ �Է� �޾� �ش� ���ڿ��� �Էµ� ���ڸ�ŭ �ݺ��Ͽ� ����Ͻÿ�.
		System.out.println("���ڿ� �Է� : ");
		String str = sc.nextLine();

		System.out.println("���� �Է� : ");
		int count = sc.nextInt();

		for (int i = 0; i < count; i++) {
			System.out.print(str + ",");
		}
	}

	public void method4() {
		// ������ A~Z ������ ���ٷ� �μ��Ͻÿ�.

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}

//		for(int ch = 'A'; ch<= 'Z'; ch++) {
//			System.out.print((char)ch);	
//				-> �̰ŵ� ������ ! //�ƽ�Ű�ڵ�	
	}

	public void method5() {
		// 1~50������ ������ ���� (random number)�� �߻����� �� ������ Ȧ���� ���� ����Ͻÿ�.

		int rnd = (int) (Math.random() * 50) + 1;
		int sum = 0;
		for (int i = 0; i < rnd; i++) {
			sum = sum + i;
		}
		System.out.println("1����" + rnd + "������ �� = " + sum);

	}

	public void method6() {
//		���� 1] 1/1 + 1/2 + 1/3 +... +1/10 �� ���� ���Ͻÿ�.

		double sum = 0;

		for (int i = 1; i < 11; i++) {
			double j = 1 / (double) i;

			/*
			 * i �տ� double �� �ٿ��� ������ 1/i �� �������̹Ƿ� ����� �������ε� double j ���� ���� ����ȯ�� �߱� ������ ��������
			 * ���� ������ �ʴ´�.
			 */
			sum = sum + j;
		}
		System.out.println("�� = " + sum);
	}

//	public void method7() {
//
//		/*
//		 * ���� 2] 1-2+3-4+......-10=xx �� ���Ͽ� ����Ͻÿ� ��µ� �ݵ�� ���� ���Ĵ�� ����Ұ�
//		 */
//
//		int j = 0;
//		int sum = 0;
//
//		for (int i = 1; i < 11; i++) {
//			if (i % 2 == 0) {
//				j = i * (-1);
//				System.out.print(j);
//			} else {
//				if (i == 1) {
//					j = i;
//					System.out.print(j);
//				} else {
//					j = i;
//					System.out.print("+" + j);
//				}
//			}
//
//			sum = sum + j;
//
//		}
//
//		System.out.print("=" + sum);
//
//	}

	
	public void method7() {

		/*
		 * ���� 2] 1-2+3-4+......-10=xx �� ���Ͽ� ����Ͻÿ� ��µ� �ݵ�� ���� ���Ĵ�� ����Ұ�
		 */

		int j = 0;
		int sum = 0;

		for (int i = 1; i < 11; i++) {
			if (i % 2 == 0) {
				j = i * (-1);
				System.out.print(j);
			} else { 
				j =i ;
				if (i ==1) {
					System.out.print(j);
				} else {
					System.out.print("+" + j);
				}
									
		}

			sum = sum + j;

		}

		System.out.print("=" + sum);

	}
	
	
//	public void method7() {
//
//		int num;
//		int sum = 0;
//
//		for (num = 1; num <= 10; num++)
//			if (num % 2 == 0) {
//				sum = sum + (-num);
//			} else {
//				sum = sum + num;
//			}
//		System.out.println(sum);
//	}

	public void method8() {
//		���� 3] ��ǻ�Ϳ� ����,����,�� ������ �Ϸ��� �Ѵ� �̸� ���α׷��Ͻÿ�(���� ���)

		System.out.println("����(1), ����(2), ��(3) �Է� : ");
		int i = sc.nextInt();

		int com = (int) (Math.random() * 3);

		if (i == 1) {
			System.out.println("����� ������ �½��ϴ�.");
			switch (com) {
			case 1:
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�. \n�����ϴ�.");
				break;
			case 2:
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�. \n��ǻ�Ͱ� �̰���ϴ�.");
				break;
			default:
				System.out.println("��ǻ�ʹ� ���� �½��ϴ�. \n����� �̰���ϴ�!");
			}
		} else if (i == 2) {
			System.out.println("����� ������ �½��ϴ�.");
			switch (com) {
			case 1:
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�. \n����� �̰���ϴ�!");
				break;
			case 2:
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�. \n�����ϴ�.");
				break;
			default:
				System.out.println("��ǻ�ʹ� ���� �½��ϴ�. \n��ǻ�Ͱ� �̰���ϴ�.");
			}
		} else {
			System.out.println("����� ���� �½��ϴ�.");
			switch (com) {
			case 1:
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�. \n��ǻ�Ͱ� �̰���ϴ�.");
				break;
			case 2:
				
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�. \n����� �̰���ϴ�!");
				break;
			default:
				System.out.println("��ǻ�ʹ� ���� �½��ϴ�. \n�����ϴ�.");
			}
		}

	}
}