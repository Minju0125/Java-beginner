package chapter06.sec02.exam04;

public class CarExample {

	public static void main(String[] args) {
		Car c1 = new Car(); // 매개변수 없는 생성자 선택
		System.out.println("c1.company : " + c1.company);
//		System.out.println(c1); // 이걸 찍으면 ->  chapter06.sec02.exam03.Car@15db9742 라는 객체가 저장된 주소가 찍힘 !
		System.out.println("c1.model : " + c1.model);
		System.out.println("c1.color : " + c1.color);
		System.out.println("c1.maxSpeed : " + c1.maxSpeed);
		System.out.println();
		
		Car c2 = new Car("아반떼"); // 매개변수 1개짜리 생성자 선택
		System.out.println("c2.company : " + c2.company);
		System.out.println("c2.model : " + c2.model);
		System.out.println("c2.color : " + c2.color);
		System.out.println("c2.maxSpeed : " + c2.maxSpeed);
		System.out.println();


		Car c3 = new Car("그랜저", "검정"); // 매개변수 2개짜리 생성자 선택
		System.out.println("c3.company : " + c3.company);
		System.out.println("c3.model : " + c3.model);
		System.out.println("c3.color : " + c3.color);
		System.out.println("c3.maxSpeed : " + c3.maxSpeed);
		System.out.println();


		Car c4 = new Car("소나타", "빨강", 200); // 매개변수 3개짜리 생성자 선택
		System.out.println("c4.company : " + c4.company);
		System.out.println("c4.model : " + c4.model);
		System.out.println("c4.color : " + c4.color);
		System.out.println("c4.maxSpeed : " + c4.maxSpeed);
		
		
	}

}