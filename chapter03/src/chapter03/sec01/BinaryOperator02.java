package chapter03.sec01;

public class BinaryOperator02 {

	public static void main(String[] args) {
		// 비트, 대입, 이동 => 이항연산자
//		bitwiseOperator();
		shiftOperator();

	}

	public static void bitwiseOperator() {
		// 비트별 연산자 : |, %, ^
		int n1 = 35;
		int n2 = 23;
		System.out.println("n1 & n2 = " + (n1 & n2));
		System.out.println("n1 | n2 = " + (n1 | n2));
		System.out.println("n1 ^ n2 = " + (n1 ^ n2));

	}

	public static void shiftOperator() {
		// 이동연산자: shiftOperator
		// shift : >>(right shift), <<(left shift)
		// , >>> (right shift with sigh bit)

		int num = 35;

		System.out.println("35>>2 = " + (num >> 2));
		System.out.println("35<<2 = " + (num >> 2));

		num = -35; // 이건 모르겠음 !@
		System.out.println("35>>>2 = " + (num >>> 2));

	}

	public static void assignOperator() {
		// 대입 : =, 우선 순위가 가장 낮음
		// 결합대입연산자 : +=. -=, /=. *=, %=
		// 방법1) 변수 = 변수 연산자 (+,-,/,*) 값 							// 결과값이 저장되는 기억장소가 연산에도 사용
		// 방법2) 변수 연산자 = 값
		
		int res = 0;
		int num = 100;
		
		res = res+10; // res + = 10 ; 
		
		res = res * (num/10); // 괄호 안이 값
		res *= (num/10);
		
		
		
	}

}
