package chap02.sec01;

public class VariableExample02 {
	static int val1 = 200 ; 
	public static void main(String[] args) {
		// ���� ���� ����
		int sum = 0 ;
		for (int i = 1; i <=100 ; i++ ) {
				sum = sum + i;
				System.out.println("i=" + i); // for ������ i �����߱� ������ ���� x
				
		}
		System.out.println("val1=" + val1); // val1�� ���� , ������Ÿ�� ��ġ���Ѿ� ( ���ڿ�+ anytype => ���ڿ���// ����Ŭ�� �ݴ�)

//		System.out.println("i=" + i); // for ������ i�� �����߱� ������ ����
		
		System.out.println("sum=" + sum);
		
	}
	
	public static void myMethod() {
			System.out.println("Val1=" + val1); // ���θ޼��� �ۿ��� ���� �Ʊ� ������ ���� x
//			System.out.println("sum=" + sum); // ���θ޼��忡�� ���� �Ʊ� ������ ���� o

}

}
//System.out.print �μ��� �ٹٲ��� ����
//System.out.println �ٹٲ�
//System.out.printf ���Ĵ�� ��� (�ٹٲ� ����)