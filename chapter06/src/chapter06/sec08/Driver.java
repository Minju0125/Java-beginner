package chapter06.sec08;

public class Driver {
	//Drive 라는 메소드에서 매개변수를/  Vehicle 클래스의 vehicle.run 메소드를 매개변수로 호출 - 클래스의 메소드를 매개변수로 호출한다는게 무슨의미지?
	public void drive(Vehicle vehicle) { //부모클래스의 이름의 택시 클래스 생성 (다형성)
		vehicle.run(); 
		
		
	}


}
// 한클래스 내에 존재 
// 이름 같아야
// 괄호 안 타입, 갯수, 배열 상태 달라야
// -> 오버로딩
/*
다형성 짱 많이 씀.
부모클래스 객체의 타입으로 메소드의 매개변수를 정해놓고
이 메소드를 부ㅡ룰때 자식클래스의 객체를 생성해서
매개변수로 사용함




*/