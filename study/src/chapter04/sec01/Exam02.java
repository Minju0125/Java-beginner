package chapter04.sec01;

import java.util.Scanner;

//sec01 : for �ݺ���
//Exam02 : ����ڰ� 0�� �Է��� ������ ���ڸ� �Է¹޴� �ݺ���

public class Exam02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (;;) {
			System.out.println("���ڸ� �Է��ϼ��� : ");
			int number = sc.nextInt();
			if (number == 0) {
				break;
			} 

		}
		System.out.println("����ڰ� 0�� �Է��Ͽ����ϴ�. ���α׷��� �����մϴ�.");

	}
}
