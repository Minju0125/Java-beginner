package chap07.sec04;

public class ShapeExample {

	public static void main(String[] args) {
//		Triangle t1 = new Triangle("삼각형");
//		Circle c1 = new Circle("타원형"); 
//		t1.draw();
//		c1.draw();
//		이렇게 해도 되고
		
		Shape s1 = new Triangle("삼각형");
		Shape s2 = new Triangle("타원형");
		
		s1.draw();
		s2.draw();
		// 이렇게 하는게 다형성 !
		
	}

}
