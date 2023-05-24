package chapter06.sec01.exam02;

public class Shape {

	String kind;
	int height;
	int width;

	Shape() {
	}

	Shape(String kind, int width, int height) {
		this.kind = kind;
		this.height = height;
		this.width = width;
	}

	@Override
	public String toString() {
		return "도형 : " + kind + "\n가로 : " + width + "\n세로 : " + height;
	}

}
