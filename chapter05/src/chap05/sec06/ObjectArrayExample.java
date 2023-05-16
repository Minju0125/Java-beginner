package chap05.sec06;

public class ObjectArrayExample {

	public static void main(String[] args) {
//		Books[] book = new Books[3]; // Books에 대한 객체는 아직 만들어지지 않았음. new 다음에 괄호를 가지고 있는 생성자 메소드 나와야 객체 만들어짐/ 배열만 생성됨
//		book[0] = new Books("왕초보 영어", "EBS", 15000);
//		book[1] = new Books("경제 입문학", "박정호", 30000);
//		book[2] = new Books("소크라테스 변론", "김유원", 10000);

		Books[] book = {new Books("왕초보 영어", "EBS", 15000), //클래스 객체 직접 생성해서, 각각 자동 저장
				new Books("경제 입문학", "박정호", 30000),
				new Books("소크라테스 변론", "김유원", 10000)};
				
		
		
		System.out.println("------------------------");
		for (Books b : book) {

			System.out.println(b); // 원래는 주소가 찍여야 하나, 
			System.out.println("-----------------------");
		}

	}

}

class Books { // 여기가 워크호스 클래스
	private String title; // -> pirvate으로 선언했기 때문에 외부 클래스에서 접근 불가능 (Books 클래스에서만 접근 가능)!
	private String writer;
	private int price;

	// 초기값 설정 불가 - 왜?
	// 생성자 메소드 - 객체 초기화(멤버 변수 초기화)

	public Books() {
	}

	public Books(String title, String writer, int price) {
		this.title = title;
		this.writer = writer;
		this.price = price;

		/*
		 * 똑같은 Books 메소드 두개 오버로딩
		 * 
		 * 투스트링 메소드는 오브젝트 클래스라는 클래스를 북스가 재정의해서 상속받아 사용하고 있음.
		 * 
		 * 오버로드 오버라이드 객체 지향 개념 중 두가지 사용되고 있음
		 * 
		 * 북스 다음에는 익스텐스 오브젝트가 생력된것. 엥
		 *
		 * 
		 */

	}

	@Override
	public String toString() {
		return "책이름: " + title + "\n저자: :" + writer + "\n가격 : " + price;

	}
}


