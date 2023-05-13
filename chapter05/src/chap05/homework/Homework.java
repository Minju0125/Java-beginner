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

	
	public void method02() {
		int diceCount[] = new int[6]; // �ֻ��� 1~6�� �� �������
		String astCount[] = new String [6]; // ????
		for (int i = 0; i<astCount.length; i++) {
			astCount[i]=""; // �̰� ���ϸ� ���ڰ� �� 6�ڸ��� �������� null �� ��
		}
		for (int i = 0; i <50; i++) {
			int dice = (int) (Math.random() * 6);
			++diceCount[dice];
			astCount[dice] = astCount[dice] + "*";
			
		} for (int i = 0; i<diceCount.length; i++) {
			System.out.println("�ֻ����� : " + (i+1)+ ":" + astCount[i] + "(" + diceCount[i] + ")");
		}
		
		
	}
	
	public void method03() {

		Scanner sc = new Scanner(System.in);

		int[] score = new int[10];

		for (int i = 0; i < score.length; i++) {
			System.out.println("������ �Է��Ͻÿ�. : ");
			score[i] = sc.nextInt();
		}

		Arrays.sort(score);
		System.out.println("�ִ밪 : " + score[9]);
		System.out.println("�ּҰ� : " + score[0]);

	}
}