package chapter04.sec03;

import java.util.Scanner;

public class WhileStatementExample {

	public static void main(String[] args) {
		WhileStatement ws = new WhileStatement();
//		 ws.method1();
		ws.method2();
	}
}

class WhileStatement {
	int numOfChop = 0; // 도끼질 횟수

	public void method1() {
		while (numOfChop < 9) { // 10이 되면 넘어가야 하기 때문
			numOfChop++;
			System.out.println(numOfChop + "번 찍었습니다.");
			System.out.println("아직 안넘어갔네요...");
		}
		System.out.println("---------------------");
		System.out.println((++numOfChop) + "번 찍었습니다."); // (numOfChop++)하면 안됨 이거로 하면 여기에 9를 먼저 넣어주기 때문
		System.out.println("나무가 드디어 넘어 갔습니다...");
	}

	public void method2() {
		String menu = "*** 커피 메뉴 ***\n";
		menu += "1.아메리카노		2000원 \n";
		menu += "2.카페라떼			3500원 \n";
		menu += "3.카라멜마키야또		5000원 \n";
		menu += "4.자바칩 프라프치노		6500원 \n";
		menu += "5.종료 \n";		//큰 문자열 쓸대는 어펜트?? 라는 메소드 사용 (기억장소 낭비)
		
		int sum = 0; // 커피구매금액
		int exit = 0; //5번이 선택되었을 때 exit 값이 -1이면 종료

		String bill = "    *** 영수증 ***\n";
		bill+="--------------------\n";

		while (true) { //while (true) 는 무한루프
			System.out.println(menu);
			Scanner sc = new Scanner(System.in);
			System.out.print("커피를 선택하세요...");
			int choice = Integer.parseInt(sc.nextLine()); // Integer.parseInt(sc.nextLine()) 괄호안의 String 타입의 숫자를 int
														// 타입으로 변환해주는 메소드
			switch (choice) {
			case 1:
				sum += 2000;
				bill += "1.아메리카노		2000원 \n";
				break;
			case 2:
				sum += 3500;
				bill += "2.카페라떼		3500원 \n";
				
				break;
			case 3:
				sum += 5000;
				bill += "3.카라멜마키야또		5000원 \n";
				break;
			case 4:
				sum += 6500;
				bill += "4.자바칩 프라프치노		6500원 \n";
				break;
			case 5 :
				exit = -1;
				break;
			default:
				System.out.println("잘못된 선택입니다.");

			}// end switch

			if (exit == -1) { //5번 선택시
				System.out.println("프로그램 종료");
				break;
			}

		} // end while

		bill+="--------------------\n";
		bill+=" 합계 :      "+sum + "원";
		System.out.println(bill);
		
	} 
	
}
