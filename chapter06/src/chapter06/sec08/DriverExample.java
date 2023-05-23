package chapter06.sec08;

public class DriverExample {

	public static void main(String[] args) {
		new DriverExample().controller(); //메인메소드가 static 이기 떄문에
	// 자기 자신을 생성하고, 해당 메소드호출하면 아래가 스태틱일 필요 없음
	}
	
	public void controller() {
		Driver driver = new Driver();
		
		Taxi taxi = new Taxi();
		driver.drive(taxi); // 택시클래스 생성되어서 "차량이 달린다" -> 차량클래스가 호출 된것
		driver.drive(new Bus(15)); // 직접생성해서 매개변수로 전달됨.
	}

}
