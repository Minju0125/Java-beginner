package chapter08.sec03;

interface I{
	public void methodB();
}

public class A { // �����
	public void methodA(I i) { //�Ű������� �������̽���.
		i.methodB();
	} 
}

class B implements I{ // ������
	@Override
	public void methodB() {
		System.out.println("methodB()");
	}
	
}
