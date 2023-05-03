package chap02.sec03;

public class PromotionExample {

	public static void main(String[] args) {
		// promotion : 자동형변환
		// 표현범위가 큰쪽으로 변환
		// 수식에서는 int보다 작은 타입의 자료는 int로 변환됨
		
		byte b1 = 100; //128 이내
		short s1 = 20; //20은 int 형이지만 short안에 포함되기 때문에
		
//		short res1 = b1 + s1;  // 수식에서는 int보다 작은 타입의 자료는 int로 변환됨!!!!!!!!!!!
//							   // b1도, s1 도 int 로 변환
		
		int res1 = b1 + s1;
		
		
		
		
		float f1 = 20f;
		long l1 = 1000L;
		
		float res2 = f1 + l1; // 기억공간의 크기가 아니라 표현 값의 범위에 따라 결정 - l1이 float로 (1000.0)
							// float, long은 float로 !!!!!!!!!!!!!!!
		
		
		
		System.out.println(res1);
		System.out.println(res2);
		
		
		
		
		

	}

}
