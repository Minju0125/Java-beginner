package chapter04.sec01;

import java.util.Scanner;

public class Exam03 {
	// sec01 : for �ݺ���
	// Exam03 : ���丮���� ����ϴ� �ݺ���

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("���� �Է��ϼ��� : ");
		int number = Integer.parseInt(sc.nextLine());

		// 5! = 1*2*3*4*5

		int f = 1;
		for (int i = 1; i < 6; i++) {
			f = i * f;
		}
		System.out.println(number + "! = " + f);

	}

}
