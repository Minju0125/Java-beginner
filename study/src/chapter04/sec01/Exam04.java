package chapter04.sec01;

import java.util.Scanner;

public class Exam04 {
	// sec01 : for �ݺ���
	// Exam04 : �迭 ����� ���� ����ϴ� �ݺ���.

//	public static void main(String[] args) {
//		
//		int[] array = { 1, 2, 3, 4, 5 };
//		int sum = 0;
//		for(int i=0; i<array.length; i++) {
//			sum = array[i] +sum;
//		}
//		System.out.println("�迭 ����� �� : " + sum);
//	}

//	�Ǵ�.

	public static void main(String[] args) {
		// �迭�� �Է¹ޱ�

		Scanner sc = new Scanner(System.in);

		System.out.print("�迭�� ���� : ");
		int length = Integer.parseInt(sc.nextLine());

		int array[] = new int[length];

		System.out.println("�迭�� ��Ҹ� �Է��ϼ���.");

		for (int i = 0; i < array.length; i++) {
			System.out.println("���" + (i + 1) + ":");
			array[i] = Integer.parseInt(sc.nextLine());
		}

	}

}
