package chapter06.sec04.exam01;

public class Calculator {

	void powerOn() { // �ۺ��� �����ϰ� ����Ʈ�� �����ϴϱ� �����Ѱ� ���ǰ�,,?
		System.out.println("������ �մϴ�.");
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
		System.out.println("������ ���ϴ�.");
	}

}
