package chapter04.sec01;

import java.util.Scanner;

public class Exam05 {
	// sec01 : for �ݺ���
	// Exam05 : �־��� ���ڿ��� �������� ����ϴ� �ݺ���.

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String array[] = new String[5];
		System.out.println("���� 5�� �Է� : ");

		for (int i = 0; i < 5; i++) {
			System.out.println("("+ (i+1) +") : ");
			array[i] = sc.nextLine();
		}

		System.out.println(
				"�Է��Ͻ� ���ڴ� : " + array[0] + "," + array[1] + "," + array[2] + "," + array[3] + "," + array[4] + "�Դϴ�.");
		System.out.println("�������� ��� : " + array[4] + "," + array[3] + "," + array[2] + "," + array[1] + "," + array[0]);

	}

}
