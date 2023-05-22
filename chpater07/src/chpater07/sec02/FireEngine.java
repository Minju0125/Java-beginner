package chap07.sec02;

public class FireEngine extends Car01 { // car01 클래스를 상속받았다는 의미
	// 2) 부모클래스를 상속받아
	int amountWater;
	String color = "red";

	public void water() {
		System.out.println("물을 뿌리다."); 
	}

	public void stop() {
		System.out.println("소방차가 도착했습니다.");
	}
	
}
