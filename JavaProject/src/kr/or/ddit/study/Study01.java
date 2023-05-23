package kr.or.ddit.study;

import java.util.Scanner;

public class Study01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 1. 조건문 - 조건식의 결과에 따라 블록 실행 여부가 결정
		 * 
		 * > 조건문의 종류로는 if 문, switch 문이 있습니다. > if 문은 조건식의 결과가 true/false 냐에 따라 실행문이
		 * 결정됩니다. > switch 문은 변수의 값에 따라 각 case 의 값과 일치하는 실행문이 결정됩니다.
		 * 
		 */
		//~일떄, 어떤 조건에 대한 식에 대한 문제를 ㅁ나났을 때 조건문 if 셋트가 생각나도록 공부한다 !

		// 조건문 if 연습해보기
		// 조건문 중, 가장 단골 문제인 짝수/홀수 문제
		// 입력을 위한 Scanner 객체

		System.out.println("숫자를 입력해주세요 : ");
		// 입력받은 문자열의 값을 int 로 형변환 해줌
		int numValue = Integer.parseInt(sc.nextLine());
		String result = "";

		if (numValue % 2 == 0) { // 짝수
			result = numValue + " :  짝수입니다."; // -> 문자열
		} else { // 홀수
			result = numValue + " :  홀수입니다.";
		}
		System.out.println(result);

		// on, off 로 켤수 있는 전등 스위치 만들어보자
		// 뮨제1)
		// - 문자열 click이라는 변수를 null 로 선언 및 초기화해주세요.
		// - 1 또는 2를 입력 받아서 입력 받은 값에 따라서 아래 내용을 출력해주세요.
		// > click 의 값이 1일때, '전동 스위치가 on됩니다.'를 출력해주세요.
		// > click 의 값이 2일 떄, '전등스위치가 off됩니다.'를 출력해주세요.

		System.out.println("숫자입력 : ");

		String click = null;
		click = sc.nextLine();

//		if (click == "1") { // 주소비교
		if (click.equals("1")) { // 문자열에 대한 값비교 !!!!!!
			System.out.println("전등스위치가 on됩니다.");
		} else if (click.equals("2")) {
			System.out.println("전등스위치가 off 됩니다.");
		} else {
			System.out.println("?");
		}

		/*
		 * 성적 프로그램을 만들어보자 문제2) [성적 출력 조건] 90점 이상은 A 80점 이상, 90점 미만 B 70점 이상, 80점 미만 C
		 * 60점 이상, 70점 미만 D 60점 미만은 F - 점수를 콘솔창에 입력받고, 성적 출력 조건에 따라 결과를 출력해주세요.
		 * 
		 */

		System.out.println("성적 입력 : ");
		String in = sc.nextLine();
		int num = Integer.parseInt(in);
		String grade = "";

		if (num >= 90) {
			grade = "A";
		} else if (num >= 80) {
			grade = "B";
		} else if (num >= 70) {
			grade = "C";
		} else if (num >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		System.out.println("입력하신 점수의 성적은 " + num + "(" + grade + ")");
	}
}
