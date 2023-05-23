package chapter06.sec08;

public class Taxi extends Vehicle {

	int passenger; // 현재 탑승인원

	Taxi() {}
	Taxi(int passenger) {
		this.passenger = passenger;
	}

	@Override // 재정의됨
	public void run() {
		System.out.println("승객 " + passenger + "명을 태운 버스가 운행중입니다.");
	}
	// 업캐스팅 됐을 땐 얘가 실행 ㅁ?ㅁㅇ?ㄴ?ㅁㅇㅎ?ㅁㅇㅎ?ㅁ
}
