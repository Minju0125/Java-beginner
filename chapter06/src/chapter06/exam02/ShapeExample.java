package chapter06.exam02;

public class ShapeExample {

	public static void main(String[] args) {
		Circle c1 = new Circle(15);
		c1.calcArea(); // �Ǵ� ! �Ʒ�ó��
		
		// �������� ����ϴ� ����� �� �Ϲ����� - �ڽ�Ŭ���� ��ü�� �����Ǿ �θ�Ÿ���� ������ ���� (�ϳ��� �θ𿡰�  ��ӹ��� �ڽ�Ŭ������ ����)
		Shape s2 = new Rectangle(20,40);
		s2.calcArea(); 
	}

}
