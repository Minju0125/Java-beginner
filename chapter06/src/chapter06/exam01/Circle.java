package chapter06.exam01;

public class Circle extends Shape {
	double radius;
	
	Circle(){}
	Circle(double radius){
		this.radius = radius;		
	}
	
	@Override // �޼ҵ�������
	public void calcArea() {
		double areaCircle = radius * radius * Math.PI;
		System.out.println("���� : " + areaCircle);
	}
	
	public void calcCircum() {
		System.out.println("�ѷ� : " + radius * 2* Math.PI);
	}
	
	

}
