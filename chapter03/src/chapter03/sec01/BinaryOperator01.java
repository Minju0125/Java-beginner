package chapter03.sec01;

import java.util.Scanner;

public class BinaryOperator01 {
	static Scanner sc = new Scanner(System.in); // 이 클래스 안에서는 어디에서나 sc 를 쓸 수 있음 (멤버변수)

	public static void main(String[] args) {
		// 이항 연산자 : 대부분의 연산자 (산술, 논리 연산, 관계///// 비트, 대입, 이동)

//		arthmeticOperator();
//		relationalOperator();
		logicalOperator();

	}

	public static void arthmeticOperator() {
		// 산술 연산자 : +,-,/,*,%
		int n1 = 100;
		int n2 = 15;
		System.out.println("n1=" + n1 + "\nn2=" + n2);

		System.out.println("n1 + n2" + (n1 + n2));
		System.out.println("n1 - n2" + (n1 - n2));
		System.out.println("n1 * n2" + (n1 * n2));
		System.out.println("n1 / n2 " + (n1 / n2));
		System.out.println("n1 % n2: " + (n1 % n2));
	}

	public static void relationalOperator() {
		// 관계연산자 : >, <, =, >=, <=, !=(<>)
		// 스캐너 클래스 일단 외워두기 // 콘솔창에서 데이터 입력하게 되어있는데 메세지를 출력하지
		// 않으면????????????????????
		System.out.print("점수입력 : "); // 출력시키는 메세지

		// 점수는 대부분 0-100 점이기 때문에 정수 - > 정수형
		int score = Integer.parseInt(sc.nextLine()); // 클래스 이름은 대문자로 시작 / 문자열을 받아서 (int) integer로
		String grade = ""; // null 값의 데이터

		if (score >= 90) {
			grade = "A학점";

		} else if (score >= 80) {
			grade = "B학점";

		} else if (score >= 70) {
			grade = "c학점";

		} else if (score >= 60) {
			grade = "D학점";

		} else {
			grade = "F학점";

		}
		System.out.println("점수 : " + score + "\n학점 :" + grade);
	}

	public static void logicalOperator() {
		// 위에서 선언했기 때문에 sc 사용 가능
		// 윤년 : 4의 배수이면서 100의 배수가 아니거나 또는 400의 배수가 되는 해

		System.out.print("년도 입력 : ");
		int year = sc.nextInt(); // 공백을 기준?

		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println(year + "년도는 윤년입니다.");
		} else {
			System.out.println(year + "년도는 평년입니다.");
		}

	}

}
