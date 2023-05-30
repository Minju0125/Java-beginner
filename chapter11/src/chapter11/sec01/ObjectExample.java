package chapter11.sec01;

public class ObjectExample {
	public static void main(String[] args) {
		Person p1 = new Person("홍길동");
		System.out.println("getinfo() : " + p1.getinfo());
		System.out.println("toString() : " + p1.toString());

		Person p2 = new Person("홍길순");
		if (p2.toString().equals(p1.toString())) {
			System.out.println("같은 내용");
		} else {
			System.out.println("다른 내용");
		}
	}

}

class Person {
	private String name;

	Person(String name) { // 문자열 형태의 이름을 매개변수로 가지는 생성자 메소드
		this.name = name; // 매개변수 있는 생성자 메소드 기술하면 기본 생성자 메소드 만들지 않음
	}

	String getinfo() {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}

	@Override
	public String toString() { // 멤버변수가 private 으로 되어있어서 외부에서 이름 참조가 불가능함.
		// Person 클래스는 문자열로 이름이라는 변수를 가지고 있음. 변수의 접근지정자 private 외부에서 접근 x
		// 클래스 밖에서는 저장도, 내보낼수도 없음
		// 클래스가 대부분 private 으로 설정함. 상속을 사용하지 않은 대부분의 클래스는 private 으로 선언
		// db를 사용할 땐 클래스가 하나만 (객체 하나만) 선언되어야함 -> single tone

		return name;
	}
}

//같은 객체 되려면 주소값도 같아야함.
//객체가 가지는 내용을 비교할 때는 equals() 메소드
//대소문자 구별안하는 건 -> equalsIgnore()

/*
private 으로 선언된 멤버변수 있으면 대부분 생성자 메소드 써서 초기화함 (private은 클래스 밖에서 접근 불가. 접근 못한다는 것은 값을 저장하거나, 변경 x)
클래스 밖에서는 이 변수가 보이지 않음. 객체가 생성될 때 해당데이터를 집어 넣음

<밖으로 내보낼때>
그 변수들중 하나씩 클래스 밖으로 내보내거나. 하나씩 밖에 있는 값으로 변경하고자 할때는 게터, 세터 (개별적 데이터 출력)
멤버변수들을 묶어서 변수에 있는 내용을 한번에 출력하고 싶을 때 (한번에 묶어서 밖으로 내보낼때)-> toString ( ) (일괄적 데이터 출력)
*/
