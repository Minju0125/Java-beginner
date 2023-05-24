package chapter06.sec01.exam01;

public class CircleExample {
	public static void main(String[] args) {
		Circle circle = new Circle();
	
		circle.radius = 5.0;
		circle.x = 1;
		circle.y = 2;
		
		circle.getPoint();
		circle.getArea();
		
		double circumference1 = circle.getCircumference();
		circle.getCircumference();
		System.out.println("원의 둘레 = "+ circumference1);
		
		
	}
}