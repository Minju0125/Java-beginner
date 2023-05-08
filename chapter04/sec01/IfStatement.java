package chapter04.sec01;

import java.util.Scanner;

public class IfStatement {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		method1();
		method2();
//		method3();
//		method4();	
//		method5();
//		method6();
//		method7();

	}

	public static void method1() {
		// 사용자 이름과 점수를 입력 받아 60점 이상이면
		// "이름 합격입니다" 메세지 출력

		String message= "" ; // null 로 초기화
		System.out.println("이름 입력 : ");
		String name = sc.nextLine();// 현재 커서가 있는 쪽에서 입력받은 전체가 name 에 들어감
		System.out.print("점수 입력 : ");// 같은 줄에 입력
		int score = sc.nextInt(); // 이 줄의 의미?

		if (score >= 60) {
			message = name + "은(는) 합격입니다.";
		} else {
			message = name + "은(는) 불합격입니다.";
		}
		System.out.println(message); // 변수 하나만 지정해서 한군데에서 실행하는 것이 좋음
	}

	public static void method2() {
//		 사용자 이름과 점수를 입력 받아 60점 이상이면
//		 "이름 합격입니다." 메세지 출력

		String message = ""; // null 로 초기화
		System.out.println("이름 입력 : ");
		String name = sc.nextLine();// 현재 커서가 있는 쪽에서 입력받은 전체가 name 에 들어감
		System.out.print("점수 입력 : ");// 같은 줄에 입력
		int score = sc.nextInt();

		if (score >= 60) {
			message = name + "은(는) 합격입니다.";
		}
		System.out.println(message);
	}

	public static void method3() {
//		문제1 월을 입력받아 
//		3~5월 : "봄입니다."
//		6~8월 : "여름입니다."
//		9~11월 : "가을입니다."
//		12~2월 : "겨울입니다."

		String message = "";
		System.out.println("월 : ");

		int month = sc.nextInt();

//		if (month>=3 && month<=5) {
//			message = "봄입니다.";
//		}else if (month>=6 && month<=8) {
//			message = "여름입니다.";
//		}else if (month>=9 && month<=11) {
//			message = "가을입니다.";
//		}else if ((month>=1 && month<=2) || month==12) { // 위의 조건들이 모두 아니면 비교할 필요가 없기 때문에 마지막 else if 조건을 쓸 필요 없음 !
//			message = "겨울입니다.";
//		}
//		System.out.println(message);

		if (month >= 3 && month <= 5) {
			message = "봄입니다.";
		} else if (month >= 6 && month <= 8) {
			message = "여름입니다.";
		} else if (month >= 9 && month <= 11) {
			message = "가을입니다.";
		} else {
			message = "겨울입니다.";
		}
		System.out.println(message);

	}

	public static void method4() {
//		문제2 체중과 키를 입력하여 BMI 지수를 구하고 BMI 지수에 따른 평가를 출력하는 프로그램 작성	
//		BMI 지수 = 체중 (kg) /키(m)*키(m)

//		0.0~18.4 저체중
//		18.5~22.9 정상
//		23.0~24.9 과체중
//		25.0~29.9 비만
//		30.0~그이상 고도비만

		String message = "";
		System.out.println("체중");
		int weight = sc.nextInt();
		System.out.println("키");
		double height = sc.nextDouble();

		double BMI = weight / height * height;

		if (BMI >= 0.0 && BMI <= 18.4) {
			message = "저체중";
		} else if (BMI >= 18.5 && BMI <= 22.9) { // BMI>=18.5 안써도 되나 확인 해보기
			message = "정상";
		} else if (BMI >= 23.0 && BMI <= 24.9) {
			message = "정상";
		} else if (BMI >= 25.0 && BMI <= 29.9) {
			message = "비만";
		} else {
			message = "고도비만";
		}
		System.out.println("판정 : " + message);

	}

	public static void method5() {

//		헌혈하려고 한다. 헌혈의 조건은 나이가 18세 이상이며, 몸무게가 50kg 사이어야 한다.
//		이를 중첩 if 문을 사용하여 구성하시오.
//		나이와 몸무게는 설정함(= 연산자 사용)

		String message = "";

		System.out.println("나이:");
		int age = sc.nextInt();
		System.out.println("몸무게:");
		int weight = sc.nextInt();

		if (age >= 18) {
			if (weight >= 50) {
				message = "헌혈 가능";
			} else {
				message = "헌혈 불가능";
			}
		} else {
			message = "헌혈 불가능";
		}

		System.out.println(message);
	}

	public static void method6() {

//		임의의 수를 입력 받아 홀수와 짝수를 판별하시오,.

		String message = "";

		System.out.println("Random");
		int number = sc.nextInt();

		if (number % 2 == 0) {
			message = "짝수";
		}
		message = "홀수";

		System.out.println(message);
	}

	public static void method7() {

		/*
		 * 99-97 : A+ 
		 * 96-93 : A0
		 * 92-90 : A- // char 안되고 문자열만 됨
		 * 
		 * 89-87 : B+
		 * 86-83 : B0
		 * 82-80 : B-
		 * 
		 * 79-77 : C+
		 * 76-73 : C0
		 * 72-70 : C- 
		 * 
		 * 그 이하는 F => 중첩 if 사용
		 */

		int score = 73;
		String grade = ""; // 초기값 빈 값으로

		if (score >= 90) {
			grade = "A";
			if (score <= 92) {
				grade = grade + "+";
			} else {
				if (score <= 96) {
					grade = grade + "0";
				} else {
					grade = grade + "-";
				}
			}

		} else if (score >= 80) {
			grade = "B";
			if (score <= 82) {
				grade = grade + "+";
			} else {
				if (score <= 86) {
					grade = grade + "0";
				} else {
					grade = grade + "-";
				}
			}
			
		} else if (score >= 70) {
			grade = "C";
			if (score <= 72) {
				grade = grade + "+";
			} else {
				if (score <= 76) {
					grade = grade + "0";
				} else {
					grade = grade + "-";
				}
			}
			
		} else
			grade = "F";

		System.out.println(grade);

	}

}
