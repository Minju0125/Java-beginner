package chapter06.exam01;

public class Triangle extends Shape {
	double width;
	double height;
	
	Triangle(){}
	Triangle(double width, double height){
		this.width = width;
		this.height = height;
	}

	@Override // 메소드재정의
	public void calcArea() {
		System.out.println("면적 : " + width * height * 0.5);
	}
	
}
