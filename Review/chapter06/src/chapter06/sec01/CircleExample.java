package chapter06.sec01;

public class CircleExample {

	public static void main(String[] args) {
		Circle circle = new Circle() ;
		circle.radius=10.2;
		circle.x=300;
		circle.y=500;  // circle�� �ִ� radius,x,y�� �ʱ�ȭ�ϰڴ�?
		
		/* Circle Ŭ�������� radius, x, y�� ��� ����Ʈ�� �����Ǿ���. chapter06�̶�� ������ ��Ű���� �����ϱ� ������ �ҷ��� �� ����.
		 *  (�ڱ� Ŭ���������� �� �� �ִ� private�� ��ٸ� ���⼭ ����)
		 */
		
		
		circle.getPoint(); 
		//getPoint() �޼ҵ带 �����ϰ�, �ش� �޼ҵ尡 ������ ��ȯ���� ������ �ٽ� ����� ���ƿ� => ��� ����� �־��� ������ ���⼭ �� �޼ҵ��� ��ȯ���� ����Ʈ��ũ�� ��¼��
		circle.getCircumference(); 
		 
		
		
		// �Ʒ� ���� �Ѱ��� ���
		double res = circle.getArea();
//		System.out.println("���� ���� : " + circle.getArea();
	}

}
