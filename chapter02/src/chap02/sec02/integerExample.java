package chap02.sec02;

public class integerExample {

	public static void main(String[] args) {
		// 정수타입 : byte, short, int(기본형), long 
		byteMethod();
		shortMethod();
		intMethod();
	}
	
	public static void byteMethod() {
		// byte : 1byte 제공
		// 		  127 ~ -128까지의 정수 저장
		//		   값의 범위를 벗어난 값을 저장하면 오류
		//		   연산된 데이터가 범위를 벗어나면 순환적용된 결과 반환
		// 		  (0,1,2,...,127,-128,-127,...,-1)
		byte b1 = 127; // 기본형은 int 타입인데, 바이트의 범위에 들기 때문에 o 
					   // int i = 127; 
		byte b2 = -128; //1byte = 8bit
		System.out.println("b1=" + b1); // byteMethod 실행하려면 메인메서드로 불러야함
		b1++; //b1에 있는 값을 1 증가시킴 -> 연산된 데이터가 범위를 벗어남 
		System.out.println("b1=" + b1); // byteMethod 실행하려면 메인메서드로 불러야함 
		System.out.println("b1=" + b1);
		System.out.println("b1=" + b1);
	}
	 
	public static void shortMethod() {
		// short : 2 byte제공
		// 		  32767~ - 32768까지의 정수를 저장
		// 		   범위를 벗어난 값을 저장하면 오류
		// 		   연산된 데이터가 범위를 벗어나면 순환적용된 결과 반환
		// 		  (0,1,2,...,32767,-32768,-32767,...,-1)
		//		   short, byte는 거의 안씀
		
		// short sh1 = 32768; 오류
		short sh2 = 200; // 범위 안에 들기 때문에 short 에 저장될 수 있음
		short sh3 = 32767;
		System.out.println(++sh3);
	}
		
	
	
	public static void intMethod() {
		// int : 4byte 제공
		//       기본정수타입, 가장 많이 사용되어지는 정수 데이터 타입
		// 		  약 21억 (2147483647) ~ - 2147483648 까지의 정수를 저장
		// 		  범위를 벗어난 값을 저장하면 오류
		// 		  연산된 데이터가 범위를 벗어나면 순환적용된 결과 반환
		// 		 (0,1,2,...,2147483647,-2147483648,- 2147483647,...,-1)
		//       int 보다 작은 타입은 연산 시 무조건 int 로 -> 헷갈리면 long으로,,
		
		
//		int num =200;
//		int num1=10000000;
//		
//		int res = num1 * num1;
//		System.out.println(res);
		
		int num = 200;
		int num1 = 10000000;
		long num2 = 1000000L;
		
		int res = num * num1;
		System.out.println(res);
		
		long res1=num1*num2;
		System.out.println(res1);
		
	}
	
		
			
	
}
