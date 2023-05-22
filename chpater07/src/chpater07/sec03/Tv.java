package chap07.sec03;

public class Tv extends Product { // product 클래스를 상속받음
	Tv() { // 기본생성자메소드
		super(1000); // 1000을 가지고 부모클래스(Product)의 생성자 메소드를 부름
			// 자식클래스가 생성되려면, tv클래스를 위한 product 클래스 만들어져야하는데, 이 때 super 메소드 사용
		//실제로는 정의하지 않고 상속만 받음
		//상속 안되는 두가지 -> private으로 선언된 메소드나 변수, 생성자 메소드
		// 부모클래스의 생성자 메소드불러라~ :super // 매개변수의 타입 똑같으니까 1000이 price 로 배정
	}

	@Override
	public String toString() {
		return "TV";
		

	}
}
