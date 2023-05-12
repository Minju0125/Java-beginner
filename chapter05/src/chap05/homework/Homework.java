package chap05.homework;
// 아직 진행중...
import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		Homework01 hw = new Homework01();
		Homework02 hw2 = new Homework02();
//		hw.method01();
		hw2.diceSuffle();
		hw2.diceget();

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
	}


class Homework02 {
	int[] dice = { 1, 2, 3, 4, 5, 6 };

	public void diceSuffle() {
		/*
		 * 2. 주사위를 50번던져 나온 각각의 눈의 횟수를 구하고 이를 히스토그램으로 출력하시오
		 * 
		 * ex) 1 : ********(8) 2 : *********(9) 3 : **********(10) 4 : ********(8) 5 :
		 * *********(9) 6 : *******(7)
		 * 
		 */

		for (int i = 0; i < 10000000; i++) {
			int rnd = (int) (Math.random() * 6);
			int temp = dice[0];
			dice[0] = dice[rnd];
			dice[rnd] = temp;

		}
	}

	/*
	 * 주사위를 던진 횟수는 50회
	 * 
	 * 
	 */

	public void diceget() {
		int i;
		int rnd = (int) (Math.random() * 6);
		for (i = 0; i < 50; i++) {
			diceSuffle();
			switch(dice[rnd]) {
			
			
			}

		}

	}

}
