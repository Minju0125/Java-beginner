package chapter04.sec01;

import java.util.Scanner;

public class SwtichStatementExample {

	public static void main(String[] args) {

		SwitchStatement sw = new SwitchStatement(); // 객체생성
//		sw.method1();
//		sw.method2();
		sw.method3();
//		sw.method4();
	}

}

class SwitchStatement {
	Scanner sc = new Scanner(System.in); // 스캐너 클래스 시켜줘야되는데 임포트 안시키면 오류 // 메인메소드 - 스태틱붙은 메소드. 변수도 스태틱붙어야함.

		public void method1() {
		System.out.println("회원 등급 입력 (1 - 3)");
		int grade = Integer.parseInt(sc.nextLine());

		switch (grade) {
		case 1:
			System.out.println("VIP 회원입니다.");
			break;
		case 2:
			System.out.println("우수회원입니다.");
			break;
		case 3:
			System.out.println("일반회원입니다.");
			break;
		default:
			System.out.println(grade + "는 잘못된 등급 코드입니다."); // 디폴트가 switch 문의 끝이기 때문에 브레이크 x

		}

	}
	
	public void method2() {	
		System.out.println("월 입력 (1-12)");
		int month = sc.nextInt();
		
//		int month = sc.nextInt();
//		nextLine은 엔터키를 치기 전까지 그 줄에서 입력받은 것을 정수로 -> 이게 좀더 안정적임
//		-> 여러개의 자료를 동시에 입력 받을 때 (엔터키값 포함)
		
		switch (month) {
			case 1:	case 3: case  5: case 7:
			case 8: case 10:case 12: 		
				// if 문으로 쓰려면, 
				// if(month ==1 || ~~~) 길어짐
				// or 로 연결되어있을 때는 쭉 씀(7개 중에 하나라도 만족하면 아래 메세지 출력)
				System.out.println(month + "월은 끝나는 날짜가 31일까지 있는 달입니다.");
				break;
			case 4: case 6: case 9: case 11:
				System.out.println(month + "월은 끝나는 날짜가 30일까지 있는 달입니다.");
				break;
			default: 
				System.out.println("끝날짜가 28일인 2월입니다.");
				// if 보다 쓰기 쉬움
				
		}
	}
		
		/* 예3)
		 
		문제1) 국가명을 영문코드 (kr,jp,ch)를 입력받아 한글로 국가명을 출력 (중첩 switch-case 사용)
		
		*/
			
	public void method3() {
		System.out.println("국가명(영문코드) : ");
		String nation = sc.nextLine();
		
//		switch (nation) {
//		case "kr" :
//			System.out.println("한국");
//			break;
//		case "jp" :
//			System.out.println("일본");
//			break;
//		default : 	
//			System.out.println("중국");
		
//		switch (nation) {
//			case "kr": 
//				System.out.println("한국");
//					switch (nation) {
//						case "jp" :
//							System.out.println("한국");}	
//				System.out.println("중국");
//						}
		
		
//		switch (nation) 
		
		}
		
		
		
		
		
		
		
	
				
	public void method4() {
		System.out.println("점수입력 : ");
		int score = sc.nextInt();
		String grade = "";
		
//		점수를 입력받아
//		 99-97 : A+ 
//		 96-93 : A0
//		92-90 : A- 
//
//		89-87 : B+
//		86-83 : B0
//		82-80 : B-
//				
//		79-77 : C+
//		76-73 : C0
//		72-70 : C- 
		
		switch(score/10) {
		case 10 :
			grade = "A+";
			break;
		case 9 :
			grade = "A";
			switch(score%10) {
			case 0: case 1: case 2:
				grade = grade + "-";
				break;
			case 3: case 4: case 5: case 6:
				grade = grade + "0";
				break;
			case 7: case 8: case 9:
				grade = grade + "-";
					}
			break;
		case 8 :
			grade = "B";
			switch(score%10) {
			case 0: case 1: case 2:
				grade = grade + "-";
				break;
			case 3: case 4: case 5: case 6:
				grade = grade + "0";
				break;
			case 7: case 8: case 9:
				grade = grade + "-";
			} 
			break;
		default : 
			grade = "fail";
		}
		System.out.println("점수" + score + "는 " + grade + "학점입니다.");
			
			
		
		
		}
	
		
		
		
		
		
	}
			

			
			
			


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		