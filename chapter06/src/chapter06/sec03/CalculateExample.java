package chapter06.sec03;

public class CalculateExample {
/*
 * ����3)	�ΰ��� ���ڸ� �Է� �޾� ������ ����� ��ȯ�ϴ� �޼ҵ带 �ۼ��Ͻÿ�.
	�� ������ Ÿ���� [int, int], [int, double], [double, int], [int, float]�̴�.
 */
	public static void main(String[] args) {
		// �ܺ� Ŭ�������� �ش� �޼ҵ� �θ� ����, �ش� �޼ҵ��� ��ü�� �����ؾ���.
		Calculate c1 = new Calculate ();
		int res1 = c1.add(100, 200); // �Ű������� ���� � add ���� ȣ������ ������.--1 �� add �޼ҵ� ȣ��
		double res2 = c1.add(27.5, 50); // --3�� �޼ҵ� ȣ��
		
		System.out.println(res2);
				
	}

}

class Calculate{
	
	public int add(int a, int b) { // ---1
		return (a+b);
	}
	
	public double add (int a, double b) { // --2
		return (a+b);
	}
	
	public double add (double a, int b) {//--3
		return (a+b);
	}
	
	public float add (int a, float b) {
		return (a+b);
	}
	// ��ȯ�Ǵ� ������Ÿ�� �ٸ���, �迭 �ٸ� -> �������̵� �����
	
}