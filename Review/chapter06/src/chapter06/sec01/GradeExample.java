package chapter06.sec01;

import java.util.Scanner;

//문제6
//세과목의 점수를 입력받아 총점과 평균을 출력하는 Grade  클래스 생성

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

//	public SetScore() { 이렇게만 쓰면 오류 -왜? // void 안쓰려면 (반환값이  있는 경우)  반환타입 지정해줘야 함. 
	// 만약 public int Setcore()를 쓰려고 하면 반환이 어디로 되는지?????/

	public void SetScore() {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println("점수를 입렵 : ");
//			score[i] = sc.nextInt(); // 이거말고 파스 인트 왜 쓰는지? 이거는 스페이스바만 ㅊ쳐도 입력이 되고, nextline은 엔터를 기준으로 !! 
			score[i]=Integer.parseInt(sc.nextLine());
			sum = sum + score[i];
			avg = (double) sum / 3;
		} 
	}

	public void PrintScoreSum() { // 리턴값을 적기 전까지는 오류 // void로 프린트스크린 하면 될듯?
		System.out.println(sum);
	}

	public void PrintScoreAvg() { // 리턴값을 적기 전까지는 오류
		System.out.println(avg);
	}
}
