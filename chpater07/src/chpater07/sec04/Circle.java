package chap07.sec04;

public class Circle extends Shape {

	Circle(String kind) {
		super(kind);
		
	}

// �����Ǹ� ���� ������ �տ� abstract �����

	@Override
	public void draw() {
		System.out.println(kind + "�� �׸��ϴ�.");

	}

}
