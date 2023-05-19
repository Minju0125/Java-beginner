package chapter06.sec01;

public class StudentExample {

	public static void main(String[] args) {
// 해당되는 객체 생성시 학생정보를 같이 집어넣는 방법으로 써본 것
		Student s1 = new Student(); // 이걸 쓰면 학생클래스 객체는 만들어 지지만

//		private long stdID; // private - 외부에서 여기에 데이터를 집어 넣을 수 없다.
//		private String stdName; 여기에 접근 할 수 없음(다른 클래스라)
//		-> set 메소드 사용해야함
		
		s1.setStdID(1001);
		s1.setStdName("이순신");
		
		System.out.println(s1);
		
		Student s2 = new Student(1002,"홍길순"); // 두번째 생성자 메소드 불러서 반환해서0
		System.out.println(s2); // 여기로 
		
		
		
		
//		//학번 : 1001
//		이름 : null
//		학번 : 1002
//		이름 : 홍길순
// 왜 결과 이렇게 나오지?
	}

}

class Student { // 워크호스 클래스
	private long stdID; // private - 외부에서 여기에 데이터를 집어 넣을 수 없다.
	private String stdName;

	public Student() {
	} // 매개변수 없을 때는 얘가 불리고
		// 있으 ㄹㄸ는 아래 줄이 불러짐

	public Student(long stdID, String stdName) { // 괄호 안을 매개변수 앞의 메소드에 소속된 것, 메소드에서 정의되는 지역변수 // 멤버변수와 지경변수는 별개임 !!
		// 위의 지역변수가 존재할 수 있는 공간은 여기 중괄호 안
		// 20번째줄 지역변수 (16,17번째 x)
		// 외부에서 데이터 받아서 위의 멤버변수에게 전달 (16.17줄)
		// stdID의 값을 stdID 에 전달해야하니까 할당 연산자 =
		this.stdID = stdID; // stdID = stdID 이렇게 하면 22줄의 지역변수만 대답하고 16은 대답 못함
							// 그래서 자바에서 특수한 참조변수 -> 자기 주소 가지고 있는 참조변수 (this) ?????????????????????????????

		this.stdName = stdName; // 여기까지 하면 초기화 끝난것

//지역변수가 멤버변수가 똑같은 모습일때- 지역변수 대신에 멤버변수를 지칭할 때 사용함
		// 보통은 똑같은 변수명을 쓰고 this를 붙임
		
		// 클래스 객체 생성하려면 생성자 메소드
		// 값이 있는 생성자 메소드의 매개변수 값, 타입
//		매개변수가 두개이고, 매개변수의 타입이 정수, 스트링

	}

	public void setStdID(long stdID) {

		this.stdID = stdID;
	}
	// set 메소드는 반환값 없음 ( ex) 이름주고 부르면 끝 = 매개변수 없음) -> void
	// get 메소드는 이름을 꺼내오는 것 (반환값 o) (매개변수 있음)
	// 매개변수를 위에 멤버변수에 집어 넣어야하니까

	public void setStdName(String StdName) {

		this.stdName = stdName;
	}

	public void showInfo() {
		System.out.println("학번 : " + stdID); // this 붙여도 되고 안붙여도.. 매개변수와 멤버변수가 같은 스펠링일 때 지역변수대신 멤버변수 호출할 때 사용
		System.out.println("이름 : " + stdName); // 위에서 private 으로 선언되었어도 자기 클래스 안쪽이기 때문에 얼마든지 쓸 수 잇므
		// 하나의 클래스 안에서는 접근지정자 뭐든 참조가능

	}

	@Override
	public String toString() {// 재정의 부분//여기 까지는 단 하나의 글자도 변경하면 x// 재정의해주는 부분이기 떄문에 접근지정자도 다른걸 쓰면 안됨 @
								// 문자열로 반환하세요~
		return "학번 : " + stdID + "\n이름 : " + stdName; // 반환시켜주는 것
	}

}