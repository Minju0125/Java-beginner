package chap05.sec02;

public class OneDimArrayExample {

	public static void main(String[] args) {

		int score[] = {80,75,95,80,88};
		
		OneDimArray od = new OneDimArray();
		od.method1();
		System.out.println("\n�հ�" +od.addArray(score));
//		int sum=od.addArray(score); 
		
			//od Ŭ���� ��ü�� addarray score�� ??????

	}

}

class OneDimArray {

	public void method1() {
		// ���� 5���� �����ϴ� �迭�� �����ϰ�, 10,20,30,40,50�� ������ �� ����Ͻÿ�.
		int[] num1 = null;
		num1 = new int [5];
		
//		char[] num2 = new char[5]; // char �� �ʱ�ȭ���� �ʾ��� ��� ���� ���
								 // boolean�� false �� ���
		char[] num2;// �迭 ����
		num2 = new char[] {'a','b','c','d','e'};
		
		char[] num4 = new char [] {'a','b','c','d','e'};
		
		char[] num5 = {'a','b','c','d','e'}; // new �� �����Ǿ��� �� (�迭�� string Ŭ���������� ���� ����)
											// �ڵ����� ������
											// �̰� ���� ���� ��
		
		boolean[] num3 = new boolean [5]; 
		
		
		for(int i=0; i<num2.length; i++) {
			System.out.print(num3[i] + ",");
		}
		
		System.out.println(num3); // ������ �����̱� ������ �Ϲ� ���� ������ �� ����.
		

	}


	public int addArray(int[] jumsu) {
		int sum = 0;
		for(int i=0; i<jumsu.length; i++) {
			sum+=jumsu[i];
			
		}
		return sum;
	}
}