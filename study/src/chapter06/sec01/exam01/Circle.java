package chapter06.sec01.exam01;

public class Circle {
	//원점
	int x; 
	int y;
	
	//반지름, 파이값
	double radius;
	final double PI = 3.1415926;

	//원점을 표시하는 메소드
	public void getPoint() {
		//원점 표시 메소드는 그냥 정수형의 x,y 값을 받아서 표시하기만 하면 됨
		System.out.println("(x,y) = (" +x +","+y+")");
	}
	
	//너비를 구하는 메소드
	//너비도 위에거 처럼 void를 써서 해도 되고,
	//반환값을 지정하는 형식으로 해도됨 ! ( 이 메소드는 void를 사용하겠음)
	public void getArea() {
		double area = PI * radius * radius;
		System.out.println("원의 넓이 = " + area);
		// 이렇게 해놓고 메인 메소드에서 Circle 객체 생성후, 이 메소드를 호출하면 됨 !
		
	}
	
	//둘레를 구하는 메소드
	//얘는 void 안쓰고 반환값이 있는 형식으로 기술할 것임
	public double getCircumference() {
		double circumference = PI * 2 * radius;
		return circumference; // 또는, return PI * 2 * radius; 라고 써도됨
	}
	
}