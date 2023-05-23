package kr.or.ddit.study;

public class Study {

	public static void main(String[] args) {
		/*
		 * 2. 반복문 - 작업 단위가 반복적으로 실행되도록 할 때 사용
		 * 
		 * > 반복문의 종류로는 for문, while문이 있습니다. (do-while 문은 기본적으로 잘 안쓰기 떄문에 안함) > for 문은 반복
		 * 횟수를 알 수 있어, 횟수만큼 반복문이 실행됩니다. > while 문은 조건이 참인 경우 반복문이 실행되고. 참이 아닌 조건이 발생했을 때
		 * while이 종료된다.
		 */

		/*
		 * 반복문 for 연습해보기 반복문 for 문을 이용해서 0-9까지의 숫자를 차례대로 출력해봅시다.
		 */

		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		}

		System.out.println();

		/*
		 * 짝수와 홀수를 구분지어 출력해봅시다. - 홀수일때는, '_'를 붙여서 출력해봅시다.
		 */

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) { // 짝수
				System.out.print(i + " ");
			} else {
				System.out.print(i + "__");
			}

		}
		System.out.println();

		/*
		 * 문제1) 구구단을 출력해봅시다. [출력예시] 1x1=1 1x2=2 1x3=3 ... 1x9=9 2x1=2 2x2=4 2x3=6 ...
		 * 2x9=18 ... 1단부터 9단까지의 구구단을 출력해보세요 ! [힌트] for문을 중첩으로 사용해서 만들어보세요 ! for 문 사용할
		 * 때에는 규칙성 찾아야함 !
		 */


		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i + "x" + j + "=" + i * j + "\t");
			}
			System.out.println();
		}

		System.out.println();
//		for (int i = 1; i < 10; i++) {
//			System.out.print("[" + i + "단]" + "\t");
//		}
//		System.out.println();

		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				for (int k = 1; k < 10; k++) {
					System.out.print("[" + k + "단]" + "\t");

				}
				System.out.println();
			} else {
				for (int j = 1; j < 10; j++) {
					System.out.print(j + "x" + i + "=" + i * j + "\t");

				}
				System.out.println();
			}

		}
	}
}
