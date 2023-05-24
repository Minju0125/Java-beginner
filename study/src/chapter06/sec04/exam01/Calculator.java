package chapter06.sec04.exam01;

public class Calculator {

	void powerOn() { // 퍼블릭도 가능하고 디폴트도 가능하니까 간단한걸 쓴건가,,?
		System.out.println("전원을 켭니다.");
	}

	int plus(int x, int y) {
		int result = x + y;
		return result;
	}

	double divide(int x, int y) {
		double result = x / (double) y;
		return result;
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

}
