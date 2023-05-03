package chap02.sec02;

public class CharExample {

	public static void main(String[] args) {
		// char : 2 byte (부호없는 정수: 0~65535)
		
		char ch1 = 44032;
		//char ch1 = '가';
		
		System.out.println(ch1); //문자출력
		System.out.println(ch1 + 10); // 숫자 출력
		System.out.println((char)ch1 + 10);// 숫차 출력 char보다 int 가 크니까
		System.out.println((char)(ch1 + 10)); // 문자 출력 // 가에서 시작해서 열번째 글자 출력 (갊)
		
		for (char ch = 'A'; ch<= 'Z'; ch++) {
			System.out.println(ch+"="+(int)ch); //ch의 유니코드 값이 변환되어서 출력
		}
		for (int i = 0; i<=255; i++) {	
			System.out.println(i+ "=>" + (char)i);
		}
		
//		short sh1 = 200; // 200을 short 타입 변수에 저장 (o)
//		char ch = sh1; // 참조는 실행했을 때 일어나기 때문에 오류 발생
//		short sh= 'A';
//		
//		char ch1 = (short)200; //컴파일 하기 전에 리터럴 형식으로 값이 제공 -> 양수이기 때문에 음수가 아닌걸 알기 땜누에 형변환해서 저장 가능
		
	}

}
