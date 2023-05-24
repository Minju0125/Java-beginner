package chapter05.sec02.exam10;

public class AdvancedForExample {

	public static void main(String[] args) {
		int[] scores = { 95, 75, 84, 93, 87 };

		int sum = 0;
		for (int score : scores) {// scores 배열의 인덱스[0] 값인 95가 score에 저장된 후,
			sum = score + sum; // 실행문 실행 ! 블록 내부의 실행문이 모두 실행되면 다시 루프를 돌아 위로 가서, 그 다음 배열값을 score에 저장함
								// for문의 반복 횟수는 배열의 항목수 만큼 반복!
		}
		System.out.println("점수 총합 : " + sum);
		
		double avg = ((double) sum )/ scores.length;
		System.out.println("점수 평균 : " + avg);
	}
}
