package chapter04.sec01;

import java.util.Scanner;

public class Exam03 {
	// sec01 : for 반복문
	// Exam03 : 팩토리얼을 계산하는 반복문

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("수를 입력하세요 : ");
		int number = Integer.parseInt(sc.nextLine());

		// 5! = 1*2*3*4*5

		int f = 1;
		for (int i = 1; i < 6; i++) {
			f = i * f;
		}
		System.out.println(number + "! = " + f);

	}

}
