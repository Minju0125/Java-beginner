package chap07.sec04;

public  class Triangle extends Shape {

	
	Triangle(String kind) {
		super(kind); // �θ�Ŭ�������� �̰Ŷ� �Ȱ��� ���� ������ �޼ҵ� �־����
		
	}
	@Override
	public void draw() {
		System.out.println(kind + "�� �׸��ϴ�.");
	}

}
