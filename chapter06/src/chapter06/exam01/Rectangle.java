package chapter06.exam01;

public class Rectangle extends Shape {
	double width;
	double height;
	
	Rectangle(){}
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// 여기에 오버라이드 쓰면 왜 오류?
	
	public void calcArea() {
		System.out.println("면적 : " + width * height);
	}
	
}
