package chapter06.exam01;

public class Triangle extends Shape {
	double width;
	double height;
	
	Triangle(){}
	Triangle(double width, double height){
		this.width = width;
		this.height = height;
	}

	@Override // �޼ҵ�������
	public void calcArea() {
		System.out.println("���� : " + width * height * 0.5);
	}
	
}
