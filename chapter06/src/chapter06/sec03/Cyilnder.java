package chapter06.sec03;

public class Cyilnder {
/*
  	����2) ���������� �����ϴ� ���� (Cylinder)Ŭ������ �ۼ��Ͻÿ�.
	����ʵ� : ��Ŭ���� ��ü, �Ǽ�Ÿ���� ����
	�޼ҵ� : ������, ������ ����Ͽ� ��ȯ�ϴ� �޼ҵ�

	[��(Circle) Ŭ����]
	����ʵ� : ������ (�Ǽ� : radius), ���(PI, 3.1415926)
	�޼ҵ� : ������, ������ ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	 
 */
	//����ʵ�� ��Ŭ���� ��ü?
	private double height;
	Circle circle;
	
	Cyilnder(){}
	Cyilnder(double height, Circle circle){
		this.height = height;
		this.circle = circle;
		
	}
	
	
	public double getVolumn() {
		return height*circle.getArea(); //���⼭ ���� ������
	}
}


