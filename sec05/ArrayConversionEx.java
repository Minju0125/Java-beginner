package chap05.sec05;
//주사위 과제 풀이//

public class ArrayConversionEx {

	public static void main(String[] args) {
		ArrayConversion ac = new ArrayConversion(); // 클래스 생성하면 자동으로 public 메소드 사용가능
//		ac.histogram();
		ac.ontToTwo();
	}

}

class ArrayConversion {
	private int[] dice = new int[6]; // 주사위 각 눈의 발생 횟수 저장
										// 6개의 저장공간 생기면서 초기값 0으로 설정됨

	public ArrayConversion() {
		for (int i = 0; i < 50; i++) {
			int rnd = (int) (Math.random() * 6);
			dice[rnd]++;

		}

	}

	// 수평 히스토그램 그리기
	public void histogram() {

		for (int i = 0; i < dice.length; i++) {
			System.out.print((i + 1) + " : ");
			for (int j = 0; j < dice[i]; j++) {// dice 배열에 들어있는 값 만큼 *이 줄바꿈 없이 출력되어야함
				System.out.print("*");
			}
			System.out.println("(" + dice[i] + ")");
		}

	}

	public void ontToTwo() {
// 수직 히스토그램 그리기
		int rowCount = dice[0]; // 임시최대값
		for (int i = 1; i < dice.length; i++) { // 왜 여기는 0부터 ㅣㅅ작 안앟함
			if (rowCount < dice[i]) {
				rowCount = dice[i]; // dice 배열의 가장 큰 값이 rowCount로 // 배열의 행 첨자가 됨
			}
		}

		char[][] ch = new char[rowCount][6]; // rowCount값에 따라서 생성되는 char 배열은 행의 갯수가 달라짐
		for (int i = 0; i < ch[0].length; i++) { // 열
			for (int j = 0; j < dice[i]; j++) {
				ch[j][i] = '*';

			}
		}

		// 출력
		for (int i = rowCount - 1; i >= 0; i--) {// 최대 맥시멈 행번호
			System.out.printf("%3d |", (i + 1));
			for (int j = 0; j < ch[i].length; j++) {
				System.out.printf("%5s", ch[i][j]);
			}
			System.out.println();

		}
	}

}
