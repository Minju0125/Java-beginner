package chap02.sec02;

public class CharExample {

	public static void main(String[] args) {
		// char : 2 byte (��ȣ���� ����: 0~65535)
		
		char ch1 = 44032;
		//char ch1 = '��';
		
		System.out.println(ch1); //�������
		System.out.println(ch1 + 10); // ���� ���
		System.out.println((char)ch1 + 10);// ���� ��� char���� int �� ũ�ϱ�
		System.out.println((char)(ch1 + 10)); // ���� ��� // ������ �����ؼ� ����° ���� ��� (��)
		
		for (char ch = 'A'; ch<= 'Z'; ch++) {
			System.out.println(ch+"="+(int)ch); //ch�� �����ڵ� ���� ��ȯ�Ǿ ���
		}
		for (int i = 0; i<=255; i++) {	
			System.out.println(i+ "=>" + (char)i);
		}
		
//		short sh1 = 200; // 200�� short Ÿ�� ������ ���� (o)
//		char ch = sh1; // ������ �������� �� �Ͼ�� ������ ���� �߻�
//		short sh= 'A';
//		
//		char ch1 = (short)200; //������ �ϱ� ���� ���ͷ� �������� ���� ���� -> ����̱� ������ ������ �ƴѰ� �˱� ������ ����ȯ�ؼ� ���� ����
		
	}

}
