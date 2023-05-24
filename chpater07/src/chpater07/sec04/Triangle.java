package chap07.sec04;

public  class Triangle extends Shape {

	
	Triangle(String kind) {
		super(kind); // 부모클래스에도 이거랑 똑같이 생긴 생성자 메소드 있어야함
		
	}
	@Override
	public void draw() {
		System.out.println(kind + "을 그립니다.");
	}

}
