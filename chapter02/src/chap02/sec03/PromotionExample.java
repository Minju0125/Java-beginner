package chap02.sec03;

public class PromotionExample {

	public static void main(String[] args) {
		// promotion : �ڵ�����ȯ
		// ǥ�������� ū������ ��ȯ
		// ���Ŀ����� int���� ���� Ÿ���� �ڷ�� int�� ��ȯ��
		
		byte b1 = 100; //128 �̳�
		short s1 = 20; //20�� int �������� short�ȿ� ���ԵǱ� ������
		
//		short res1 = b1 + s1;  // ���Ŀ����� int���� ���� Ÿ���� �ڷ�� int�� ��ȯ��!!!!!!!!!!!
//							   // b1��, s1 �� int �� ��ȯ
		
		int res1 = b1 + s1;
		
		
		
		
		float f1 = 20f;
		long l1 = 1000L;
		
		float res2 = f1 + l1; // �������� ũ�Ⱑ �ƴ϶� ǥ�� ���� ������ ���� ���� - l1�� float�� (1000.0)
							// float, long�� float�� !!!!!!!!!!!!!!!
		
		
		
		System.out.println(res1);
		System.out.println(res2);
		
		
		
		
		

	}

}
