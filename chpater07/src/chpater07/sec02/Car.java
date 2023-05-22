package chap07.sec02;

public class Car {

	public static void main(String[] args) {
//3) car01 class 생성
		Car01 c1 = new FireEngine(); // c1은 부모클래스 Car01 클래스의 객체니까
			// c1.color 는
		System.out.println("c1.color = " + c1.color); //upcasting
//		부모클래스 타입의 변수를 호출 (blue) . 자식클래스에 있는 red를 호출하는게 아니라 부모타입에 있는 blue 를 참조하여 호출
		c1.dirve(); // 부모클래스의 메소드 호출
		c1.stop(); // override (재정의) 된것 
//		c1.water(); // 이건 자식클래스에서 고유하게 정외한 것이기 때문에 호출할 수 없음
		
		FireEngine fe = null;
		if(c1 instanceof FireEngine) {
			fe = (FireEngine) c1;
		}
		fe.water();
		System.out.println("fe.color = " +fe.color);
	}

}

class Car01 {
//	1) Car01 클래스 객체 구형

	String color = "blue";
	int door;

	public void dirve() {
		System.out.println("차가 운행 중입니다.");
	}

	public void stop() {
		System.out.println("차가 멈추었습니다.");
	}

}
