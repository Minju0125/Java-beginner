package chap07.sec03;

public class SmartPhone extends Product {
	SmartPhone() { // 기본생성자메소드
		super(1500);
	}

	@Override
	public String toString() {
		return "Smartphone";

	}
}
