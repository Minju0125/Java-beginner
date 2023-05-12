package chap05.sec02;

import java.util.Scanner;

public class OneDimArrayExample03 {
	public static void main(String[] args) {
		OneDimArray03 od3 = new OneDimArray03();
		od3.suffle();
		od3.getLottoNumer();
	}
}

class OneDimArray03 {
	int[] lotto = new int[45];

	// 초기화 1~45 까지의 값이 저장되어 있어야함.// 저장공간 45개를 생성하고
	OneDimArray03() {
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;

		} // 저장 공간 45개에 1부터 45까지의 숫자를 넣어ㅏ놨다. 클래스 안 메소드 안은 필드
			// 아래에서 계속 쓸거기 때문에 여기다가 선언
	}

	public void suffle() {
		for (int i = 0; i < 10000000; i++) {
			int rnd = (int) (Math.random() * 45);// ?
			int temp = lotto[0];
			lotto[0] = lotto[rnd];
			lotto[rnd] = temp;
		}

	}

	public void getLottoNumer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("구입금액을 1000원 단위로 입력 : ");
		int money = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= money / 1000; i++) {
			suffle();
			System.out.printf("%2d : ", i);
			for (int j = 0; j < 6; j++) { // 6개 끊어읽음
				System.out.printf("%5d", lotto[j]); // 1 :
			}
			System.out.println();
		}
	}

}