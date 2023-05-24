package chap07.sec04;

public class Circle extends Shape {

	Circle(String kind) {
		super(kind);
		
	}

// 재정의를 하지 않으면 앞에 abstract 써야함

	@Override
	public void draw() {
		System.out.println(kind + "을 그립니다.");

	}

}
