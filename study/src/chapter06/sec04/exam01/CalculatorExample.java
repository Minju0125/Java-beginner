package chapter06.sec04.exam01;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator myCal = new Calculator();
		myCal.powerOn();
		
		int result1 = myCal.plus(5, 6);
		System.out.println("���ϱ� ����� " + result1);
		
//		double result2 = myCal.divide(6, 4); �̷��� �ᵵ �ǰ� �Ʒ�ó�� �ᵵ �� !
//		System.out.println("������ ����� " + result2);
		
		byte x = 10; 
		byte y = 4;
		double result2 = myCal.divide(x, y);
		System.out.println("������ ����� " + result2);
		
		myCal.powerOff();
		

	}

}
