package chapter06.exam01;

public class Rectangle extends Shape {
	double width;
	double height;
	
	Rectangle(){}
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// ���⿡ �������̵� ���� �� ����?
	
	public void calcArea() {
		System.out.println("���� : " + width * height);
	}
	
}
