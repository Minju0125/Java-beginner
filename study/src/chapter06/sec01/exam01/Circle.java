package chapter06.sec01.exam01;

public class Circle {
	//����
	int x; 
	int y;
	
	//������, ���̰�
	double radius;
	final double PI = 3.1415926;

	//������ ǥ���ϴ� �޼ҵ�
	public void getPoint() {
		//���� ǥ�� �޼ҵ�� �׳� �������� x,y ���� �޾Ƽ� ǥ���ϱ⸸ �ϸ� ��
		System.out.println("(x,y) = (" +x +","+y+")");
	}
	
	//�ʺ� ���ϴ� �޼ҵ�
	//�ʺ� ������ ó�� void�� �Ἥ �ص� �ǰ�,
	//��ȯ���� �����ϴ� �������� �ص��� ! ( �� �޼ҵ�� void�� ����ϰ���)
	public void getArea() {
		double area = PI * radius * radius;
		System.out.println("���� ���� = " + area);
		// �̷��� �س��� ���� �޼ҵ忡�� Circle ��ü ������, �� �޼ҵ带 ȣ���ϸ� �� !
		
	}
	
	//�ѷ��� ���ϴ� �޼ҵ�
	//��� void �Ⱦ��� ��ȯ���� �ִ� �������� ����� ����
	public double getCircumference() {
		double circumference = PI * 2 * radius;
		return circumference; // �Ǵ�, return PI * 2 * radius; ��� �ᵵ��
	}
	
}