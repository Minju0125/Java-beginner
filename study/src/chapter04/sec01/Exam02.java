package chapter04.sec01;

import java.util.Scanner;

//sec01 : for 반복문
//Exam02 : 사용자가 0을 입력할 때까지 숫자를 입력받는 반복문

public class Exam02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (;;) {
			System.out.println("숫자를 입력하세요 : ");
			int number = sc.nextInt();
			if (number == 0) {
				break;
			} 

		}
		System.out.println("사용자가 0을 입력하였습니다. 프로그램을 종료합니다.");

	}
}
