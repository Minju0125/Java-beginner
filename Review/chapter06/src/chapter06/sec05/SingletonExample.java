package chapter06.sec05;

public class SingletonExample {

	public static void main(String[] args) {
//		Account ac = new Account();  // 클래스가 바뀌어서 접근할 수 없음! - private이라서
		Account ac1 = Account.getInstance(); //어카운트 객체를 생성하지 않아도 얼마든지 불러다 쓸 수 있음
		Account ac2 = Account.getInstance();
		Account ac3 = Account.getInstance();
		System.out.println("ac1 = " +ac1);
		System.out.println("ac2 = " +ac2);
		System.out.println("ac3 = " +ac3); // 같은 주소 값 반환해주는데, .......... 몰러..........
	}

}
