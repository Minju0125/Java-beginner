package chapter06.sec05;
// 싱글톤 걍 외워~
public class Account { // 싱글톤의 대상
	private static Account ac = null; // 어카운트 클래스 타입의참조변수
	private Account() {}		// 객체가 생성되기 전부터 쓸수 있는 정적변수 (static)
	
	// 스태틱 붙은 이유 객체가 생성되지 않는데, 호출되어야하니까 스테틱 붙임
	public static Account getInstance() {  // 반환타입이 자기 자신의 클래스 타입- 이름을 거의 geInstance 로 사용
		if(ac == null) ac =  new Account();		 //account == null 이면 아직 자신의 객체가 생성되지 않았다.
		return ac;
}
}


/*
account 라고 하는 변수가 메소드에리아에 null.
private Account() {}	-> private으로 생성자 메소드
외부에서 불러다 쓸 수 없어서, 외부에서 불러다 쓸 수 있는 getInstance() 메소드 만듦 -> 반환 타입이 클래스타입 
					-> 근데 얘도 static
				if 설명. account 가 null 이면 새로운 클래스 객체 생성 (heap에. new 니까)
								이 주소를 null 값이 들어있는 메소드 에리아의 account 에 . 
								얘를 부른 쪽에 account 변수는 Account 클래스 타입.
*/

