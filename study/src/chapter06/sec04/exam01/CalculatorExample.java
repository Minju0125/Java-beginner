package chapter06.sec04.exam01;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator myCal = new Calculator();
		myCal.powerOn();
		
		int result1 = myCal.plus(5, 6);
		System.out.println("더하기 결과는 " + result1);
		
//		double result2 = myCal.divide(6, 4); 이렇게 써도 되고 아래처럼 써도 됨 !
//		System.out.println("나누기 결과는 " + result2);
		
		byte x = 10; 
		byte y = 4;
		double result2 = myCal.divide(x, y);
		System.out.println("나누기 결과는 " + result2);
		
		myCal.powerOff();
		

	}

}
