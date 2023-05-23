package chapter06.exam01;

public class Circle extends Shape {
	double radius;
	
	Circle(){}
	Circle(double radius){
		this.radius = radius;		
	}
	
	@Override // 메소드재정의
	public void calcArea() {
		double areaCircle = radius * radius * Math.PI;
		System.out.println("면적 : " + areaCircle);
	}
	
	public void calcCircum() {
		System.out.println("둘레 : " + radius * 2* Math.PI);
	}
	
	

}
