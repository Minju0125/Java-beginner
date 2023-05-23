package chapter06.sec07;

public class Child extends Parent { // <- 자식 클래스를 정의할 때는 부모클래스 써야함.
	String gender;
	int age = 25;
	

	

	Child(String gender, String name, int age) { // <- 부모클래스의 생성자메소드에 넘겨줄 데이터를 자식클래스에서 정의
		super(name, age); // 부모클래스 호출 ! // super 메소드를 불러야지 부모클래스 객체가 만들어짐
							// 부모클래스 객체가 만들어지려면 super
							// 부모클래스에서 기본 생성자가 없다면, 자식클래스에서 오류발생
		this.gender = gender;

	}

	public String getName() { 

		return name;
	}

	public int getAge() {

		return age;
	}
}
