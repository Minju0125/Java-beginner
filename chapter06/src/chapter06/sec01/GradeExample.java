package chapter06.sec01;

import java.util.Scanner;

//����6
//�������� ������ �Է¹޾� ������ ����� ����ϴ� Grade  Ŭ���� ����

public class GradeExample {
	public static void main(String[] args) {
		
		Score s1 = new Score();
		s1.SetScore();
		s1.PrintScoreSum();
		s1.PrintScoreAvg();
	
		
		
	}
}

class Score {
	private int[] score = new int[3];
	private int sum;
	private double avg;

//	public SetScore() { �̷��Ը� ���� ���� -��? // void �Ⱦ����� (��ȯ����  �ִ� ���)  ��ȯŸ�� ��������� ��. 
	// ���� public int Setcore()�� ������ �ϸ� ��ȯ�� ���� �Ǵ���?????/

	public void SetScore() {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println("������ �Է� : ");
//			score[i] = sc.nextInt(); // �̰Ÿ��� �Ľ� ��Ʈ �� ������? �̰Ŵ� �����̽��ٸ� ���ĵ� �Է��� �ǰ�, nextline�� ���͸� �������� !! 
			score[i]=Integer.parseInt(sc.nextLine());
			sum = sum + score[i];
			avg = (double) sum / 3;
		} 
	}

	public void PrintScoreSum() { // ���ϰ��� ���� �������� ���� // void�� ����Ʈ��ũ�� �ϸ� �ɵ�?
		System.out.println(sum);
	}

	public void PrintScoreAvg() { // ���ϰ��� ���� �������� ����
		System.out.println(avg);
	}
}
