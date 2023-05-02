package chap02.sec01;

public class VariableExample02 {
	static int val1 = 200 ; 
	public static void main(String[] args) {
		// 변수 참조 영역
		int sum = 0 ;
		for (int i = 1; i <=100 ; i++ ) {
				sum = sum + i;
				System.out.println("i=" + i); // for 문에서 i 선언했기 때문에 오류 x
				
		}
		System.out.println("val1=" + val1); // val1이 변수 , 데이터타입 일치시켜야 ( 문자열+ anytype => 문자열로// 오라클은 반대)

//		System.out.println("i=" + i); // for 문에서 i를 선언했기 때문에 오류
		
		System.out.println("sum=" + sum);
		
	}
	
	public static void myMethod() {
			System.out.println("Val1=" + val1); // 메인메서드 밖에서 선언 됐기 때문에 오류 x
//			System.out.println("sum=" + sum); // 메인메서드에서 선언 됐기 때문에 오류 o

}

}
//System.out.print 인쇄후 줄바꾸지 않음
//System.out.println 줄바꿈
//System.out.printf 형식대로 출력 (줄바꿈 없음)