package chapter04.sec03;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {

//		����1] 10��, 50��, 100��¥�� �������� 860���� �����ϴ� ����� ��� ����Ͻÿ�.
//    �� ��� ������ 1�� �̻� ����ؾ� �Ѵ�.(for�� ���)
		Homework01 hw = new Homework01();

//		 hw.method01();
		// hw.method02();
//		hw.method03();
//		hw.method04();
//		hw.method05();
		hw.method06();

	}

}

class Homework01 {

	Scanner sc = new Scanner(System.in);

	void method01() {
//		����1] 10��, 50��, 100��¥�� �������� 860���� �����ϴ� ����� ��� ����Ͻÿ�.
//	    �� ��� ������ 1�� �̻� ����ؾ� �Ѵ�.(for�� ���)

		int i = 0;
		int j = 0;
		int k = 0;

		for (i = 1; i < 100; i++) { // ��� ������ 1�� �̻� ����Ѵٰ� �����ϱ�, 50�� 1��, 100�� �Ѱ� ���������, 10���� �ִ� ���� ���� =76��
			for (j = 1; j < 100; j++) {
				for (k = 1; k < 100; k++) {
					if ((10 * i) + (50 * j) + (100 * k) == 860) {
						System.out.println("10�� " + i + "�� 50��" + j + "�� 100��" + k + "��");
					}
				}

			}
		}

	}

	void mehtod02() {
// ����2] ������ ���� �������� ��� �ǵ��� ���α׷����Ͻÿ�.(for�� ���)		

		int i = 0;

		for (i = 1; i < 10; i++) {
			System.out.println("2 * " + i + " = " + 2 * i + "\t3* " + i + " = " + 3 * i + "\t4* " + i + " = " + 4 * i);
		}

	}

	void method03() {

		/*
		 * ����3] 1 ~ 50 ������ ������ �ϳ� �߻���Ű��, ����ڰ� �� ���� ���ߴ� ���α׷��� �ۼ��Ͻÿ� ��, ����ڰ� �Է��� ���� �߻���
		 * �������� ������ "��ū���� �Է��ϼ���"��� �޽�����, �������� ū ���̸� "�� ���� ���� �Է��ϼ���" ��� �޽����� ����� �� ���ο� ����
		 * �Է� �޴´� ������ ����ڰ� �Է��� ���� ������ "�����Դϴ�"��� �޽����� �׶����� �õ��� Ƚ���� ����Ѵ�. (while�� ���)
		 */

		int random = (int) (Math.random() * 50) + 1;
		int count = 0; // �õ� Ƚ��
		boolean flag = true;

		while (flag) {
			System.out.print("������ ���� �Է��Ͻÿ�. : ");
			int input = sc.nextInt();
			count++;
			if (input < random) {
				System.out.println("�� ū���� �Է��ϼ���.");
			} else if (input > random) {
				System.out.println("�� ���� ���� �Է��ϼ���.");
			} else {
				flag = false;
			}
		}
		System.out.println("�����Դϴ�. �õ��� Ƚ�� : " + count);

	}

	void method04() {
//		����4] �� ���� �ֻ����� ������ ��, ���� ���� 6�� �Ǵ� ��� ����� ����
//		����ϴ� ���α׷��� �ۼ��Ͻÿ�.        (for��)

		int r1 = (int) (Math.random() * 6) + 1;
		int r2 = (int) (Math.random() * 6) + 1;

		for (r1 = 1; r1 >= 1; r1++) {
			for (r2 = 1; r2 >= 1; r2++) {
				if (r1 + r2 == 6) {
					System.out.println("�ֻ��� 1 : " + r1 + "\t�ֻ��� 2 : " + r2);
				}

			}

		}

	}

	void method05() {

//	����5] ���ڷ� �̷���� ���ڿ� str�� ���� ��, �� �ڸ��� ���� ���� ����� ����ϴ� �ڵ带 �ϼ��϶�.
//	���� ���ڿ��� "12345"���, ��1+2+3+4+5���� ����� 15�� ��µǾ�� �Ѵ�.(for��)

		String str = "12345";
//		
//		String s1= str.substring(i,1); 
//		i�� 0����

		// �� ���ڿ��� ������ ��ȯ�ؼ�
//		sum = sum + ������ ������ ������
//		System.out.println(s1);

		int i = 0;
		int sum = 0;

		for (i = 0; i < str.length(); i++) {

			char charValue = str.charAt(i);
			int num = charValue - '0';
			sum = sum + num;
		}
		System.out.println(sum);

	}

	void method06() {
//		 int Ÿ���� ���� num�� ���� ��, �� �ڸ��� ���� ���� ����� ����ϴ� �ڵ带 �ϼ��϶�
//         ���� ���� �� ���� ��� . num 12345 , ��1+2+3+4+5���� ����� 15�� ����϶�(while��)

		
		
		
		int num = 12345;
		String str = Integer.toString(num);
		int i = 0;
		int sum = 0;
		
		
		while (i<str.length()) {
			char charValue = str.charAt(i);
			int intnum = charValue - '0';
			sum = sum + intnum;
			i++;
			}
		
		
		System.out.println(sum);
			

		}

}
