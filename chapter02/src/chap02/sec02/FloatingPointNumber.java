package chap02.sec02;

public class FloatingPointNumber {

	public static void main(String[] args) {
		// 1)float : 4byte (32bit) (1bit(부호), 8bit(지수), 23bit(가수) 형식)
		//		    1.4e - 45 ~ 3.4e + 38
		//			숫자 끝에 F(f) 추가 해야 함
		
		// 2)double : 8byte (1bit(부호), 11bit(지수), 52bit(가수) 형식)
		//			4.9e-324 ~ 1.8e+308
		//			기본 실수 타입
		
//		float pi = 3.1415926 // 오류 // f 안붙이면 더블타입으로 간주되기 때문에 3.1415926,,,,,,,,,, 인데 float의 허용 범위를 초과하기 떄문에
		float pi = 3.1415926f;
		double d1 = 3.1415926;
		double d3 = 3.1415926d; // 굳이 d 안써도 됨
		
		float f2= 0.1f;
		double d2 = 0.1;
		double res = f2;
		
		System.out.println(res);
		
		if (f2==d2) {
			
			System.out.println("같은 값");
		} else {
			System.out.println("다른 값");
		}
	}

}
