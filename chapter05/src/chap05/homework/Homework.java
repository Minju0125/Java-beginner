package chap05.homework;

import java.util.Arrays;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		Homework01 hw = new Homework01();

//		hw.method01();
		hw.method02();
//		hw.method03();
	}

}

class Homework01 {

	// 문제 01. 키보드로 거스름돈을 입력받아 화폐단위별로 맷수를 구하시오.(화폐단위: 10000,5000,1000,500,100,50,10)
	public void method01() {

		Scanner sc = new Scanner(System.in);
		System.out.println("거스름돈 금액을 입력하세요 : ");
		int money = sc.nextInt();

		int[] unit = { 10000, 5000, 1000, 500, 100, 50, 10 };

		int i = 0;

		int quotient = 0;

		for (i = 0; i < unit.length; i++) {
			quotient = money / unit[i];
			money = money - quotient * unit[i];
			System.out.println(unit[i] + "원 : " + quotient + "매");
		}

	}

	
	public void method02() {
		int diceCount[] = new int[6]; // 주사위 1~6이 들어갈 저장공간
		String astCount[] = new String [6]; // ????
		for (int i = 0; i<astCount.length; i++) {
			astCount[i]=""; // 이걸 안하면 문자가 들어갈 6자리의 기억공간에 null 이 들어감
		}
		for (int i = 0; i <50; i++) {
			int dice = (int) (Math.random() * 6);
			++diceCount[dice];
			astCount[dice] = astCount[dice] + "*";
			
		} for (int i = 0; i<diceCount.length; i++) {
			System.out.println("주사위눈 : " + (i+1)+ ":" + astCount[i] + "(" + diceCount[i] + ")");
		}
		
		
	}
	
	public void method03() {

		Scanner sc = new Scanner(System.in);

		int[] score = new int[10];

		for (int i = 0; i < score.length; i++) {
			System.out.println("정수를 입력하시오. : ");
			score[i] = sc.nextInt();
		}

		Arrays.sort(score);
		System.out.println("최대값 : " + score[9]);
		System.out.println("최소값 : " + score[0]);

	}
}