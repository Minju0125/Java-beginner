package chapter04.sec03;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {

//		문제1] 10원, 50원, 100원짜리 동전으로 860원을 구성하는 방법을 모두 출력하시오.
//    단 모든 동전은 1개 이상 사용해야 한다.(for문 사용)
		Homework01 hw = new Homework01();

//		 hw.method01();
		// hw.method02();
//		hw.method03();
//		hw.method04();
//		hw.method05();
		hw.method06();

	}

}

class Homework01 {

	Scanner sc = new Scanner(System.in);

	void method01() {
//		문제1] 10원, 50원, 100원짜리 동전으로 860원을 구성하는 방법을 모두 출력하시오.
//	    단 모든 동전은 1개 이상 사용해야 한다.(for문 사용)

		int i = 0;
		int j = 0;
		int k = 0;

		for (i = 1; i < 100; i++) { // 모든 동전은 1개 이상 사용한다고 했으니까, 50원 1개, 100원 한개 사용했을때, 10원의 최대 사용된 개수 =76개
			for (j = 1; j < 100; j++) {
				for (k = 1; k < 100; k++) {
					if ((10 * i) + (50 * j) + (100 * k) == 860) {
						System.out.println("10원 " + i + "개 50원" + j + "개 100원" + k + "개");
					}
				}

			}
		}

	}

	void mehtod02() {
// 문제2] 다음과 같이 구구단이 출력 되도록 프로그래밍하시오.(for문 사용)		

		int i = 0;

		for (i = 1; i < 10; i++) {
			System.out.println("2 * " + i + " = " + 2 * i + "\t3* " + i + " = " + 3 * i + "\t4* " + i + " = " + 4 * i);
		}

	}

	void method03() {

		/*
		 * 문제3] 1 ~ 50 사이의 난수를 하나 발생시키고, 사용자가 그 수를 맞추는 프로그램을 작성하시오 즉, 사용자가 입력한 수가 발생된
		 * 난수보다 작으면 "더큰수를 입력하세요"라는 메시지를, 난수보다 큰 수이면 "더 작은 수를 입력하세요" 라는 메시지를 출력한 후 새로운 값을
		 * 입력 받는다 난수와 사용자가 입력한 값이 같은면 "정답입니다"라는 메시지와 그때까지 시도한 횟수도 출력한다. (while문 사용)
		 */

		int random = (int) (Math.random() * 50) + 1;
		int count = 0; // 시도 횟수
		boolean flag = true;

		while (flag) {
			System.out.print("임의의 수를 입력하시오. : ");
			int input = sc.nextInt();
			count++;
			if (input < random) {
				System.out.println("더 큰수를 입력하세요.");
			} else if (input > random) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				flag = false;
			}
		}
		System.out.println("정답입니다. 시도한 횟수 : " + count);

	}

	void method04() {
//		문제4] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를
//		출력하는 프로그램을 작성하시오.        (for문)

		int r1 = (int) (Math.random() * 6) + 1;
		int r2 = (int) (Math.random() * 6) + 1;

		for (r1 = 1; r1 >= 1; r1++) {
			for (r2 = 1; r2 >= 1; r2++) {
				if (r1 + r2 == 6) {
					System.out.println("주사위 1 : " + r1 + "\t주사위 2 : " + r2);
				}

			}

		}

	}

	void method05() {

//	문제5] 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
//	만일 문자열이 "12345"라면, ‘1+2+3+4+5’의 결과인 15가 출력되어야 한다.(for문)

		String str = "12345";
//		
//		String s1= str.substring(i,1); 
//		i는 0부터

		// 이 문자열을 정수로 변환해서
//		sum = sum + 위에서 추출한 정수값
//		System.out.println(s1);

		int i = 0;
		int sum = 0;

		for (i = 0; i < str.length(); i++) {

			char charValue = str.charAt(i);
			int num = charValue - '0';
			sum = sum + num;
		}
		System.out.println(sum);

	}

	void method06() {
//		 int 타입의 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라
//         만일 변수 의 값이 라면 . num 12345 , ‘1+2+3+4+5’의 결과인 15를 출력하라(while문)

		
		
		
		int num = 12345;
		String str = Integer.toString(num);
		int i = 0;
		int sum = 0;
		
		
		while (i<str.length()) {
			char charValue = str.charAt(i);
			int intnum = charValue - '0';
			sum = sum + intnum;
			i++;
			}
		
		
		System.out.println(sum);
			

		}

}
