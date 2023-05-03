package chap02.sec03; // 이 클래스가 있는 위치 : package~

import java.util.Scanner;

//import java.util.Scanner;




public class CastExample01 {

	public static void main(String[] args) {
		// 키보드로 글자 하나를 입력 받아 그 글자의 유니코드를 출력하시오.
		// 스캐너클래스
		
		Scanner sc = new Scanner (System.in);// 생성자 메서드 // import 해야함 -> 밖에 있는 걸 이 클래스 안으로 가져오는 것 export는 자바에 없음
		System.out.print("숫자 하나 입력 : "); // 한줄에서 메세지 출력되고 그 줄에서 출력하기 위함
		
//		char ch1 = (char)sc.nextInt();
		char ch2 = (char)Integer.parseInt(sc.nextLine());
		System.out.println("character : " + ch2 );
		
		
		// 자바는 클래스로 구성 
		// 자바에서 클래스 밖에서 쓰일 수 있는 딱 2개 명령 : import, class
		// 순서: package - import (순서 바뀌면 오류) // - 객체 생성 (예)sc // 
		// 내가 사용하고자 하는 기능을 가지고 있는 클래스를 지금 클래스로 불러 쓰기 위함 (import)
		

	}

}
