package chapter06.exam01;

public class ShapeExample {

	public static void main(String[] args) {
		Shape s = new Shape();
		s.calcArea();
		
		System.out.println("��");
		Circle c = new Circle(5.5);
		c.calcArea();
		c.calcCircum();
		
		System.out.println();		
		System.out.println("�簢��");
		Rectangle r = new Rectangle(4.5, 3.5);
		r.calcArea();
		
		System.out.println();		
		System.out.println("�ﰢ��");
		Triangle t = new Triangle(1.5, 3.0);
		t.calcArea();
		
	}

}
