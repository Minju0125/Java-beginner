package chapter04.sec02;

import java.util.Scanner;

public class ForStatementExample01 {

	public static void main(String[] args) {
		ForStatement fs = new ForStatement();
//		fs.method1();
//		fs.method2();
//		fs.method3();
//		fs.method4();
//		fs.method5();
//		fs.method6();
		fs.method7();
//		fs.method8();
	}
}

class ForStatement {
	Scanner sc = new Scanner(System.in);

	public void method1() {
		// 1~10 사이의 수 한줄에 출력 - 반복횟수 알고 있음
		// 합 구하기

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			System.out.printf("%3d", (i + 1));
			sum += i;
		}
		System.out.println("\nsum=" + sum);

		// System.out.println("i=" + i); 실행 안됨 i는 for 문 안에서 선언되었기 때문에

	}

public void method2() {
		// 1~100 사이의 짝수의 합과 홀수의 합을 구하시오.

		int sumOfEven = 0; // 짝수의 값이 저장될 공간은 for 문 밖에서
		int sumOfOdd = 0; // 홀수의 값이 저장될 공간

		for (int i = 1; i < 101; i++) {
			if (i % 2 == 0) {
				sumOfEven = sumOfEven + i;
			} else {
				sumOfOdd = sumOfOdd + i;
			}

		}

		System.out.println("짝수의 합 :" + sumOfEven);
		System.out.println("홀수의 합 :" + sumOfOdd);

	}

	public void method3() {
		// 문자열과 정수를 입력 받아 해당 문자열을 입력된 숫자만큼 반복하여 출력하시오.
		System.out.println("문자열 입력 : ");
		String str = sc.nextLine();

		System.out.println("정수 입력 : ");
		int count = sc.nextInt();

		for (int i = 0; i < count; i++) {
			System.out.print(str + ",");
		}
	}

	public void method4() {
		// 알파펫 A~Z 까지를 한줄로 인쇄하시오.

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}

//		for(int ch = 'A'; ch<= 'Z'; ch++) {
//			System.out.print((char)ch);	
//				-> 이거도 가능함 ! //아스키코드	
	}

	public void method5() {
		// 1~50사이의 정수형 난수 (random number)를 발생시켜 그 수까지 홀수의 합을 출력하시오.

		int rnd = (int) (Math.random() * 50) + 1;
		int sum = 0;
		for (int i = 0; i < rnd; i++) {
			sum = sum + i;
		}
		System.out.println("1부터" + rnd + "까지의 합 = " + sum);

	}

	public void method6() {
//		문제 1] 1/1 + 1/2 + 1/3 +... +1/10 의 합을 구하시오.

		double sum = 0;

		for (int i = 1; i < 11; i++) {
			double j = 1 / (double) i;

			/*
			 * i 앞에 double 을 붙여준 이유는 1/i 는 정수형이므로 결과는 정수형인데 double j 에서 강제 형변환을 했기 때문에 얻으려는
			 * 값이 나오지 않는다.
			 */
			sum = sum + j;
		}
		System.out.println("합 = " + sum);
	}

//	public void method7() {
//
//		/*
//		 * 문제 2] 1-2+3-4+......-10=xx 를 구하여 출력하시오 출력도 반드시 위의 형식대로 출력할것
//		 */
//
//		int j = 0;
//		int sum = 0;
//
//		for (int i = 1; i < 11; i++) {
//			if (i % 2 == 0) {
//				j = i * (-1);
//				System.out.print(j);
//			} else {
//				if (i == 1) {
//					j = i;
//					System.out.print(j);
//				} else {
//					j = i;
//					System.out.print("+" + j);
//				}
//			}
//
//			sum = sum + j;
//
//		}
//
//		System.out.print("=" + sum);
//
//	}

	
	public void method7() {

		/*
		 * 문제 2] 1-2+3-4+......-10=xx 를 구하여 출력하시오 출력도 반드시 위의 형식대로 출력할것
		 */

		int j = 0;
		int sum = 0;

		for (int i = 1; i < 11; i++) {
			if (i % 2 == 0) {
				j = i * (-1);
				System.out.print(j);
			} else { 
				j =i ;
				if (i ==1) {
					System.out.print(j);
				} else {
					System.out.print("+" + j);
				}
									
		}

			sum = sum + j;

		}

		System.out.print("=" + sum);

	}
	
	
//	public void method7() {
//
//		int num;
//		int sum = 0;
//
//		for (num = 1; num <= 10; num++)
//			if (num % 2 == 0) {
//				sum = sum + (-num);
//			} else {
//				sum = sum + num;
//			}
//		System.out.println(sum);
//	}

	public void method8() {
//		문제 3] 컴퓨터와 가위,바위,보 게임을 하려고 한다 이를 프로그램하시오(난수 사용)

		System.out.println("가위(1), 바위(2), 보(3) 입력 : ");
		int i = sc.nextInt();

		int com = (int) (Math.random() * 3);

		if (i == 1) {
			System.out.println("당신은 가위를 냈습니다.");
			switch (com) {
			case 1:
				System.out.println("컴퓨터는 가위를 냈습니다. \n비겼습니다.");
				break;
			case 2:
				System.out.println("컴퓨터는 바위를 냈습니다. \n컴퓨터가 이겼습니다.");
				break;
			default:
				System.out.println("컴퓨터는 보를 냈습니다. \n당신이 이겼습니다!");
			}
		} else if (i == 2) {
			System.out.println("당신은 바위를 냈습니다.");
			switch (com) {
			case 1:
				System.out.println("컴퓨터는 가위를 냈습니다. \n당신이 이겼습니다!");
				break;
			case 2:
				System.out.println("컴퓨터는 바위를 냈습니다. \n비겼습니다.");
				break;
			default:
				System.out.println("컴퓨터는 보를 냈습니다. \n컴퓨터가 이겼습니다.");
			}
		} else {
			System.out.println("당신은 보를 냈습니다.");
			switch (com) {
			case 1:
				System.out.println("컴퓨터는 가위를 냈습니다. \n컴퓨터가 이겼습니다.");
				break;
			case 2:
				
				System.out.println("컴퓨터는 바위를 냈습니다. \n당신이 이겼습니다!");
				break;
			default:
				System.out.println("컴퓨터는 보를 냈습니다. \n비겼습니다.");
			}
		}

	}
}