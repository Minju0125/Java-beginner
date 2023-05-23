package chapter06.exam02;

public class ShapeExample {

	public static void main(String[] args) {
		Circle c1 = new Circle(15);
		c1.calcArea(); // 또는 ! 아래처럼
		
		// 다형성을 사용하는 방법이 더 일반적임 - 자식클래스 객체가 생성되어서 부모타입의 변수에 저장 (하나의 부모에게  상속받은 자식클래스가 많음)
		Shape s2 = new Rectangle(20,40);
		s2.calcArea(); 
	}

}
