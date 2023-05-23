package chapter06.exam02;

//exam01 예제의 또다른 방법

public class Shape {
	// 생성자메소드 없기 때문에 컴파일러가 자동으로 기본 생성자 메소드를 만들고, 생략되어 있음 !

	public void calcArea() {
		System.out.println("도형의 면적 계산");
	}

}

class Circle extends Shape {
	private int radius;
	private final double PI = 3.14155926;

	Circle(int radius) {
		super(); // 부모클래스의 기본 생성자가 자동으로 불리는 것 ! - 자식 클래스객체를 만들기 위해 부모클래스 객체를 만드는 것 (안쓰면 생략)
		this.radius = radius;

	}

	@Override
	public void calcArea() {
		System.out.println("원 면적 : " + (radius * radius * PI));
	}

}






class Rectangle extends Shape {
	private int width;
	private int height;

	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;

	}
	@Override
	public void calcArea() {
		System.out.println("사각형 면적 : " + (width * height));
	}
	// super() 메소드가 생략된 것- 기본 부모클래스를 부르는 슈퍼메소드 생략된 것

}
