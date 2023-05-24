package chap07.sec06;

public abstract class Unit {

	// 이동하기 위해서는 좌표점 있어여함
	int x;
	int y;
	String nm; // 유닛의 이름 / 이 유닛들은 움직이고 멈춤 (해병, 탱크)

	Unit(String nm) {
		this.nm = nm;
	}

	public void stop(String nm, int x, int y) {
		System.out.println(nm + "이 " + "(" + x + "," + y + ")에 멈춥니다.");
	}

	public abstract void move(int x, int y);// ~위치로 움직이지만, 움직이는 방식은 유닛마다 다르므로.

}

class Marine extends Unit {
	Marine() {
		super("해병"); // Marine 클래스객체가 생성될 때, Unit 클래스 객체부터 만드는 것
	}

	@Override // 오버라이드 된 메소드
	public void move(int x, int y) {
		System.out.println(nm + "이 (" + this.x + "," + this.y + ")에서" 
				+ " (" + x + "," + y + ") 위치로 이동합니다.");
		this.x = x;
		this.y = y; // 이동된 값을 여기에 저장
	}

	// 마린이 가지고 있는 고유메소드
	public void stimPack() {
		System.out.println("공격모드 :  스팀팩 장전");
	}
}

class Tank extends Unit {
	Tank() {
		super("탱크"); // Unit 클래스의 객체 만들어짐
	}

	@Override
	public void move(int x, int y) {
		System.out.println(nm + "의 위치 : (" + x + "," + y + ")");
	}

	public void sizemode() {
		System.out.println("공격모드 : 시즈모드로 전환");
	}

}
