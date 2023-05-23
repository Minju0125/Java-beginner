package chapter06.sec07;

public class InheritanceExample {
	public static void main(String[] args) {
			Child c1 = new Child("남성", "홍길동", 45); // q부모객체가 생성될 필요가 없음 (?)
			System.out.println("이름 : " + c1.getName());
			System.out.println("나이 : " + c1.getAge());
	}
}
