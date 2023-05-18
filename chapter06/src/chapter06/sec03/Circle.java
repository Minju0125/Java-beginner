package chapter06.sec03;

public class Circle {
	private double radius;
	private final double PI = 3.1415926;

	Circle(){} // 기본생성자 만드는거 습관적으로 하기!
	Circle(double radius){
		this.radius = radius; 
	} // 생성자 왜 쓰는지? 초기화
	
	public double getArea() {
		return radius*radius*PI;
	}
	
}
