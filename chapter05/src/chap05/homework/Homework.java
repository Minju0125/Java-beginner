package chap05.homework;
// ���� ������...
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

	// ���� 01. Ű����� �Ž������� �Է¹޾� ȭ��������� �˼��� ���Ͻÿ�.(ȭ�����: 10000,5000,1000,500,100,50,10)
	public void method01() {

		Scanner sc = new Scanner(System.in);
		System.out.println("�Ž����� �ݾ��� �Է��ϼ��� : ");
		int money = sc.nextInt();

		int[] unit = { 10000, 5000, 1000, 500, 100, 50, 10 };

		int i = 0;

		int quotient = 0;

		for (i = 0; i < unit.length; i++) {
			quotient = money / unit[i];
			money = money - quotient * unit[i];
			System.out.println(unit[i] + "�� : " + quotient + "��");
		} 
		 
		}
	}


class Homework02 {
	int[] dice = { 1, 2, 3, 4, 5, 6 };

	public void diceSuffle() {
		/*
		 * 2. �ֻ����� 50������ ���� ������ ���� Ƚ���� ���ϰ� �̸� ������׷����� ����Ͻÿ�
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
	 * �ֻ����� ���� Ƚ���� 50ȸ
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
