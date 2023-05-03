package chap02.sec02;

public class integerExample {

	public static void main(String[] args) {
		// ����Ÿ�� : byte, short, int(�⺻��), long 
		byteMethod();
		shortMethod();
		intMethod();
	}
	
	public static void byteMethod() {
		// byte : 1byte ����
		// 		  127 ~ -128������ ���� ����
		//		   ���� ������ ��� ���� �����ϸ� ����
		//		   ����� �����Ͱ� ������ ����� ��ȯ����� ��� ��ȯ
		// 		  (0,1,2,...,127,-128,-127,...,-1)
		byte b1 = 127; // �⺻���� int Ÿ���ε�, ����Ʈ�� ������ ��� ������ o 
					   // int i = 127; 
		byte b2 = -128; //1byte = 8bit
		System.out.println("b1=" + b1); // byteMethod �����Ϸ��� ���θ޼���� �ҷ�����
		b1++; //b1�� �ִ� ���� 1 ������Ŵ -> ����� �����Ͱ� ������ ��� 
		System.out.println("b1=" + b1); // byteMethod �����Ϸ��� ���θ޼���� �ҷ����� 
		System.out.println("b1=" + b1);
		System.out.println("b1=" + b1);
	}
	 
	public static void shortMethod() {
		// short : 2 byte����
		// 		  32767~ - 32768������ ������ ����
		// 		   ������ ��� ���� �����ϸ� ����
		// 		   ����� �����Ͱ� ������ ����� ��ȯ����� ��� ��ȯ
		// 		  (0,1,2,...,32767,-32768,-32767,...,-1)
		//		   short, byte�� ���� �Ⱦ�
		
		// short sh1 = 32768; ����
		short sh2 = 200; // ���� �ȿ� ��� ������ short �� ����� �� ����
		short sh3 = 32767;
		System.out.println(++sh3);
	}
		
	
	
	public static void intMethod() {
		// int : 4byte ����
		//       �⺻����Ÿ��, ���� ���� ���Ǿ����� ���� ������ Ÿ��
		// 		  �� 21�� (2147483647) ~ - 2147483648 ������ ������ ����
		// 		  ������ ��� ���� �����ϸ� ����
		// 		  ����� �����Ͱ� ������ ����� ��ȯ����� ��� ��ȯ
		// 		 (0,1,2,...,2147483647,-2147483648,- 2147483647,...,-1)
		//       int ���� ���� Ÿ���� ���� �� ������ int �� -> �򰥸��� long����,,
		
		
//		int num =200;
//		int num1=10000000;
//		
//		int res = num1 * num1;
//		System.out.println(res);
		
		int num = 200;
		int num1 = 10000000;
		long num2 = 1000000L;
		
		int res = num * num1;
		System.out.println(res);
		
		long res1=num1*num2;
		System.out.println(res1);
		
	}
	
		
			
	
}
