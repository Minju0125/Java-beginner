package chapter08.sec02;

public interface Repairable {} // 이 인터페이스는 바디가 없음 -> 재정의할 내용이 없다 ! 

class Unit {
	int hitpoint; //변수. 0 (소비하고 남은 것) // (hitpoint 는 각각의 유닛이 사용하고 남은 에너지)
	final int MAX_HP; // 상수. 상수가 되기 위해서는 1)한번은 = 쓰고 값이 나야함 !. 각각이 가질 수 있는 최대값

	Unit(int hp) {
		MAX_HP = hp; //2) 이걸 쓰고 나면 오류 사라짐. 이 객체의 생성자가 실행될 때 딱 한번 값을 배정받을 때 = 왼편에 쓰임
	}
}

class GroundUnit extends Unit{
	GroundUnit (int hp){
		super(hp); 
	}
}

class AirUnit extends Unit{
	AirUnit (int hp){
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable{
		Tank(){
			super(150);
			
	}
		@Override
		public String toString() {
			return "TANK";
		}
}

class SCV extends GroundUnit implements Repairable{
	SCV(){
		super(150);
}

	@Override
	public String toString() {
		return "SCV";
	}
	
	//150만큼 다시 충전 (수리)
	public void repair(Repairable r) {
		if(r instanceof Unit){ // Tank, Marine, DropShip이 r을 통해 들어옴. r을 통해 들어온게 Unit 타입의 객체로 들어왔냐?
			Unit u = (Unit)r; // true 라면 r을 Unit 객체로 다운캐스팅해라 (업캐스팅 된 것만 다운캐스트 가능)
			while(u.hitpoint != u.MAX_HP) { // 같지 않다면
				u.hitpoint++; // hitpoint 증가시켜라.
			}
			System.out.println(u.toString() + "의 수리가 끝났습니다.");
	} 	//scv.repair(new Tank()); -> 다형성 .
		// 부모객체에 자식 클래스 들어간 것.
}
}


class Marine extends GroundUnit{ // Repairable 이 부모가 아님.-> 위에 처럼 호출할 수 없음. -> scv에 있는 repair 메소드 호출할 수 없음/
		Marine(){
			super(100);
	}
		@Override
		public String toString() {
			return "Marine";
		}
}
	

	

class DropShip extends AirUnit implements Repairable{
		DropShip(){
			super(1);
		}
	

	
	
}

