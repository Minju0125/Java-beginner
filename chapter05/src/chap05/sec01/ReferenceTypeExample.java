package chap05.sec01;

public class ReferenceTypeExample {

	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 50);  
		String str = new String ("홍길동");
		
		
		int[] score = new int[10];
		
		
		
		
		
		System.out.println("p1=" + p1.toString()); // 절대 경로값 get name?? chap05.sec01.Person@15db9742 (주소값이 16 진수로 표현)
								//멤버 변수가 가지고 있는 값
		System.out.println("str=" + str.toString());
	 //toString 생략
		System.out.println("score="+ score);
		
		}

}

class Person{ // 여기 클래스에는 이름과 나이라고 하는 특성 (속성)을 가지고 있음 
	
	String name; // 멤버변수 - 클래스가 가지고 있는 특징을 보관하는 변수 // 
	int age;
	
	Person() {} // 매개변수x (기본 생성자) // 생성자 메소드는 new 다음 메소드 -> 
	
	Person(String name, int age){ // 메소드 오버로딩? 한클래스 내에서 이름이 똑같은 메소드
								
		this.name = name;
		this.age = age;
		
		
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}