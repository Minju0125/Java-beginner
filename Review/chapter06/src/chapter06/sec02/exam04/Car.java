package chapter06.sec02.exam04;
// Car �����ڸ� �����ε� �ؼ� CarExample Ŭ�������� �پ��� ������� Car ��ü�� �����ϵ���.

public class Car {
	
	String company = "�����ڵ���";
	String model;
	String color;
	int maxSpeed; 
	
	Car () {}
	Car (String model) {
		this (model, "�޷�", 44);
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



