package chapter06.exam02;

//exam01 ������ �Ǵٸ� ���

public class Shape {
	// �����ڸ޼ҵ� ���� ������ �����Ϸ��� �ڵ����� �⺻ ������ �޼ҵ带 �����, �����Ǿ� ���� !

	public void calcArea() {
		System.out.println("������ ���� ���");
	}

}

class Circle extends Shape {
	private int radius;
	private final double PI = 3.14155926;

	Circle(int radius) {
		super(); // �θ�Ŭ������ �⺻ �����ڰ� �ڵ����� �Ҹ��� �� ! - �ڽ� Ŭ������ü�� ����� ���� �θ�Ŭ���� ��ü�� ����� �� (�Ⱦ��� ����)
		this.radius = radius;

	}

	@Override
	public void calcArea() {
		System.out.println("�� ���� : " + (radius * radius * PI));
	}

}






class Rectangle extends Shape {
	private int width;
	private int height;

	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;

	}
	@Override
	public void calcArea() {
		System.out.println("�簢�� ���� : " + (width * height));
	}
	// super() �޼ҵ尡 ������ ��- �⺻ �θ�Ŭ������ �θ��� ���۸޼ҵ� ������ ��

}
