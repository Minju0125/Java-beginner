package chapter04.sec02;

import java.util.Random;

public class Exam01 {
	// sec02 : while �ݺ���
	// Exam01 : 1���� 100������ ���� �� Ȧ���� ����ϴ� �ݺ���.

	public static void main(String[] args) {

//		���� ������ �߸� ������ ��
//		int random = (int) (100 * Math.random());
//
//		while (true) {
//			if (random % 2 != 0) {
//				System.out.println(random);
//				random++;
//			} else {
//				System.out.println(random + 1);
//			}
//			break;
//		}

// 1~100������ ��� Ȧ���� ����϶�� ���̾�����!

		int num = 1;

		while (num <= 100) {
			if (num % 2 != 0) {
				System.out.println(num);
			}
			num++;

		}

	}

}
