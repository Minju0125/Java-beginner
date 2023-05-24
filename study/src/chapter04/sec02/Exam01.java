package chapter04.sec02;

import java.util.Random;

public class Exam01 {
	// sec02 : while 반복문
	// Exam01 : 1부터 100까지의 숫자 중 홀수만 출력하는 반복문.

	public static void main(String[] args) {

//		내가 문제를 잘못 이해함 ㅎ
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

// 1~100까지의 모든 홀수를 출력하라는 말이었나봄!

		int num = 1;

		while (num <= 100) {
			if (num % 2 != 0) {
				System.out.println(num);
			}
			num++;

		}

	}

}
