package chap05.sec04;

public class TwoDimArrayExample {

	public static void main(String[] args) {
		TwoDimArray td = new TwoDimArray();
//td.getScore();
		td.sumOfScore();
		td.getRank();
	}

}

class TwoDimArray {

	/*
	 * 2차원 배열 예제1] 5명이 3과목을 시험 본 결과가 다음과 같다. 이를 배열 저장한 후 출력하시오. (평균은 정수로) [자료] 이름 국어
	 ** 
	 * 이름(문자열), 점수(숫자)는 타입이 달라서 같이 배열 쓸 수 없음
	 */

	private String[] name = { "홍길동", "이순신", "정몽주", "강감찬", "이성계" }; // 이름 배열은 쭉 사용할거니까 메소드 앞에

	public void getScore() { // void -> 되돌려 주는 값없이 위에서 호출만 하면됨
		int[][] score = { { 70, 80, 60 }, { 80, 90, 90 }, { 90, 80, 90 }, { 75, 80, 80 }, { 60, 70, 60 } };
		printScore(score);
	}

	public void sumOfScore() {
		int[][] score = { { 70, 80, 60, 0, 0 }, { 80, 90, 90, 0, 0 }, { 90, 80, 90, 0, 0 }, { 75, 80, 80, 0, 0 },
				{ 60, 70, 60, 0, 0 } }; // 0을 삽입하면 5행 5열이 됨

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < 3; j++) {
				score[i][3] = score[i][3] + score[i][j];
			}
			score[i][4] = score[i][3] / 3;
		}

		System.out.println("               ***성적표***              ");
		System.out.println("--------------------------------------------");
		System.out.println("이 름    국어       영어      수학      총점      평균");
		System.out.println("--------------------------------------------");
		printScore(score);

	}

	public void getRank() {
		int[][] score = { { 70, 80, 60, 0, 0, 1 }, { 80, 90, 90, 0, 0, 1 }, { 90, 80, 90, 0, 0, 1 },
				{ 75, 80, 80, 0, 0, 1 }, { 60, 70, 60, 0, 0, 1 } }; 
		// 각각의 등수의 초기값은 모두 1
		// 총점을 비교

		// 총점 및 평균
		for (int i = 0; i< score.length; i++) {
			for (int j = 0; j < 3; j++) {
				score[i][3] = score[i][3] + score[i][j];
			}
			score[i][4] = score[i][3] / 3;
		}

		// 등수
		// * 초기값은 1
		// * 내 자신의 총점을 비교해서 나보다 더 큰 값이 있으면 등수가 저장되어 있는 방의 값을 1씩 증가시킴
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {
				if (score[i][3] < score[j][3]) {
					score[i][5]++;
				}

			}

			System.out.println("               ***성적표***              ");
			System.out.println("--------------------------------------------");
			System.out.println("이 름    국어       영어      수학      총점      평균      등수");
			System.out.println("--------------------------------------------");
			printScore(score);
		}
	}

	public void printScore(int[][] score) {
		for (int i = 0; i < score.length; i++) { // 행의 갯수가 5 -> 5보다 작을때까지 실행
			System.out.print(name[i] + " ");
			for (int j = 0; j < score[i].length; j++) { // j<3처럼 고정된 값은 배ㅕㅇㄹ에서 잘 안씀
				System.out.printf("%6d", score[i][j]);
			}
			System.out.println(); // 줄바꿈

			// 반복적으로 사용되는 부분 -> 여기가 이해안됨
			// score는 지역변수이고, name 은 지역변수
			//
		}
	}

}