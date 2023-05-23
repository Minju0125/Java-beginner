package chapter06.sec08;

public class Bus extends Vehicle {
	
	int passenger; //현재 탑승인원 // 승객수를 보관하는 자기 클래스 자신 유일한 멤버변수.
					// 버스클래스 객체가 생성되어서 부모 타입으로 저장했을 떄, 접근할수 없음

	Bus() {}
	Bus(int passenger) {
		this.passenger = passenger;
	}
	
	
	@Override // 재정의됨 / 저위에 상속 되었다고 안쓰면 여기 오류뜸
	public void run() {
		System.out.println("승객 "+ passenger + "명을 태운 버스가 운행중입니다." );
	} // 여기서 재정의했음 여기까진 ㄱㅊ

}

// 재정의했다면 자식클래스가 재정의한 게 호출됨 자식클래스인 버스 클래스의 런 메소드가 출력됨