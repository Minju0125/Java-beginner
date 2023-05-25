package chapter08.sec03;

interface I{
	public void methodB();
}

public class A { // 사용자
	public void methodA(I i) { //매개변수가 인터페이스로.
		i.methodB();
	} 
}

class B implements I{ // 제공자
	@Override
	public void methodB() {
		System.out.println("methodB()");
	}
	
}
