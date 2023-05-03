package chap02.sec02;

public class BooleanExample {

	public static void main(String[] args) {
		// boolean : true / false 를 표현하는 논리타입
		// 			 1byte 사용, 조건문에 주로 사용되어 프로그램 실행제어 수행
		//			  다른 타입과 형변환이 발생되지 않음
		
		int age = 30;
		boolean flag = false;
		
		// boolean flag = true; 해도 출력값은 true -> 왜?
		// 그럼 왜 boolean 값에 데이터를 넣는 거임?
		
		flag = age >= 25;
		
		System.out.println(flag);

	}

}
