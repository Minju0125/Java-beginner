package chapter06.sec03;

public class Cyilnder {
/*
  	예제2) 다음조건을 만족하는 원통 (Cylinder)클래스를 작성하시오.
	멤버필드 : 원클래스 객체, 실수타입의 높이
	메소드 : 생성자, 면적을 계산하여 반환하는 메소드

	[원(Circle) 클래스]
	멤버필드 : 반지름 (실수 : radius), 상수(PI, 3.1415926)
	메소드 : 생성자, 면적을 계산하여 반환하는 메소드
	 
 */
	//멤버필드로 원클래스 객체?
	private double height;
	Circle circle;
	
	Cyilnder(){}
	Cyilnder(double height, Circle circle){
		this.height = height;
		this.circle = circle;
		
	}
	
	
	public double getVolumn() {
		return height*circle.getArea(); //여기서 넓이 구해줌
	}
}


