package chapter06.sec03;

public class CyilnderExample {
	public static void main(String[] args) {
		Cyilnder c1 = new Cyilnder(32.5, new Circle(10)); // 원의 클래스 객체가 뉴 연산자에 의해 생성됨. 그러면 주소값이 들어감

		System.out.println("원통의 부피 : " + c1.getVolumn());

	}
}
