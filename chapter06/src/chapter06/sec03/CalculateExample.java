package chapter06.sec03;

public class CalculateExample {
/*
 * 예제3)	두개의 숫자를 입력 받아 덧셈의 결과를 반환하는 메소드를 작성하시오.
	두 숫자의 타입은 [int, int], [int, double], [double, int], [int, float]이다.
 */
	public static void main(String[] args) {
		// 외부 클래스에서 해당 메소드 부를 때는, 해당 메소드의 객체를 생성해야함.
		Calculate c1 = new Calculate ();
		int res1 = c1.add(100, 200); // 매개변수를 보고 어떤 add 문을 호출할지 결정함.--1 번 add 메소드 호출
		double res2 = c1.add(27.5, 50); // --3번 메소드 호출
		
		System.out.println(res2);
				
	}

}

class Calculate{
	
	public int add(int a, int b) { // ---1
		return (a+b);
	}
	
	public double add (int a, double b) { // --2
		return (a+b);
	}
	
	public double add (double a, int b) {//--3
		return (a+b);
	}
	
	public float add (int a, float b) {
		return (a+b);
	}
	// 반환되는 데이터타입 다르고, 배열 다름 -> 오버라이드 적용됨
	
}