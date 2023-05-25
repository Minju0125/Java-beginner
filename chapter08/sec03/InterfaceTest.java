package chapter08.sec03;

public class InterfaceTest {

	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B());


	}

}


// * a.methodA(new B());
// * A라는 사용자는 제공자 B가 제공하는 클래스를 구현해서 사용
// * -> A와 B가 밀접하게 관련 (객체지향언어에서 회피해야할 기능 중 하나)
// * User, Provider 관련된 관계를 직접관계라고 함
/*
 *사용자는 인터페이스 밖에 모름 (B클래스 존재를 모름)
 *인터페이스에 있는 메소드 B를 호출 - > 실제로는 B 클래스 안에 있는 메소드 B가 호출됨
 *B클래스의 메소드 B는 인터페이스의 메소드 B를 재정의한것-> 얘가 호출됨
 *
 *부모클래스를 구현한 클래스 B에 있는 메소드 B가 호출됨
 *특정한 클래스를 감추고 클래스에서 제공하는 메소드만 호출하고 싶을때 인퍼페이스 적용
 */
 
