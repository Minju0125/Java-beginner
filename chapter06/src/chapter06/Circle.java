package chapter06;

//예제1. 원점과 반지름을 보유한 원(Circle)클래스를 생성하시오.
//또 너비와 둘레를 구하는 메서드도 포함하시오.

public class Circle {

	double radius; // 접근제어자 기술을 생략하면 자동으로 default : 해당패키지 내에서만 접근 가능
	final double PI = 3.1415926; // final 이 변수 앞에 붙으면 상수가 됨
								// 상수는 원래 연산자 왼편에 올 수 없으나, 3.1415926 라는 값을 저장할 때 딱 한번만
								// =연산자 왼편에 올 수 있다.
	int x;
	int y; // 여기까지는 선언만. 

//	너비, 둘레 결과는 double타입
//	원 넓이 

	public double getArea() { // 반환할 필요 있는 것은 타입을 지정해줘야 함 !!
							// public 으로 설정하면 public 접근제어자가 붙은 변수, 메서드는 어떤 클래스에서라도 접근이 가능하다!
		double area = radius * radius * PI;
		return area; 
		/*
		 * return
		 * 해당 메소드를 종료하고 자신을 호출한 메소드로 돌아가는 예약어
		 * 반환값(리턴값)을 가지고 자신을 호출한 메소드로 돌아갈 수 있음.
		 * 	=> 해당 메소드를 종료하고 반환값을 가지고 자신을 호출한 메소드로 돌아감.
		 * void 메소드의 경우 rturn;을 명시적으로 작성하지 않아도 컴파일러가 자동으로 추가함.
		 * 
		 */
		
	}

	
	
	// 아래 두개는 void 를 썼기 때문에 반환할 필요가 없어서, 뒤에 CircleExample 메소드에서 그냥 실행만 시켜주면 됨
	
	// 원의 둘레
	public void getPoint() {// void -> 반활할 필요 x (이 의미는, 반환하지 않고 여기서 출력하겠다는 의미!)
		System.out.println("원의 원점 : (" + x + ", " + y + ")");
	
	}
	
	public void getCircumference() {
		System.out.println("원의 둘레 : " + (2 * radius * PI));
	}

}
