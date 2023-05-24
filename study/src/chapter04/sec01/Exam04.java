package chapter04.sec01;

import java.util.Scanner;

public class Exam04 {
	// sec01 : for 반복문
	// Exam04 : 배열 요소의 합을 계산하는 반복문.

//	public static void main(String[] args) {
//		
//		int[] array = { 1, 2, 3, 4, 5 };
//		int sum = 0;
//		for(int i=0; i<array.length; i++) {
//			sum = array[i] +sum;
//		}
//		System.out.println("배열 요소의 합 : " + sum);
//	}

//	또는.

	public static void main(String[] args) {
		// 배열을 입력받기

		Scanner sc = new Scanner(System.in);

		System.out.print("배열의 길이 : ");
		int length = Integer.parseInt(sc.nextLine());

		int array[] = new int[length];

		System.out.println("배열의 요소를 입력하세요.");

		for (int i = 0; i < array.length; i++) {
			System.out.println("요소" + (i + 1) + ":");
			array[i] = Integer.parseInt(sc.nextLine());
		}

	}

}
