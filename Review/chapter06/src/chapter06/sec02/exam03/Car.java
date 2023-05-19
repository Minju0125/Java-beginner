package chapter06.sec02.exam03;
// Car 생성자를 오버로딩 해서 CarExample 클래스에서 다양한 방법으로 Car 객체를 생성하도록.

public class Car {
	
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed; // 멤버필드는 초기화하지 않으면 자동 초기화 되어, Sting 에는 ""공백, int 에는 0값이 들어감.
	
	Car () {}
	Car (String model) {
		this.model = model; // 문자열 형태의 model 값을 받아, this.model에 넣겠다 ! -> 여기서 받은 값으로 위의 멤버필드 model 값 초기화
	}
	
	Car (String model, String color){
		this.model = model;
		this.color = color; //이렇게 써도 되지만 번거로움 (코드 중복)
	}
	
	Car (String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	

}



