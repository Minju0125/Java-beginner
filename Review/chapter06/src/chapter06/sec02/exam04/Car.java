package chapter06.sec02.exam04;
// Car 생성자를 오버로딩 해서 CarExample 클래스에서 다양한 방법으로 Car 객체를 생성하도록.

public class Car {
	
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed; 
	
	Car () {}
	Car (String model) {
		this (model, "메롱", 44);
	}
	
	Car (String model, String color){
		this.model = model;
		this.color = color; 
	}
	
	Car (String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	

}



