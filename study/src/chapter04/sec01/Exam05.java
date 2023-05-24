package chapter04.sec01;

import java.util.Scanner;

public class Exam05 {
	// sec01 : for 반복문
	// Exam05 : 주어진 문자열을 역순으로 출력하는 반복문.

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String array[] = new String[5];
		System.out.println("문자 5자 입력 : ");

		for (int i = 0; i < 5; i++) {
			System.out.println("("+ (i+1) +") : ");
			array[i] = sc.nextLine();
		}

		System.out.println(
				"입력하신 문자는 : " + array[0] + "," + array[1] + "," + array[2] + "," + array[3] + "," + array[4] + "입니다.");
		System.out.println("역순으로 출력 : " + array[4] + "," + array[3] + "," + array[2] + "," + array[1] + "," + array[0]);

	}

}
