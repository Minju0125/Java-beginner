package chapter06.sec02;

public class Shape {
	
	
	String kind = "������"; // ������ ����
	int height = 50;
	int width = 15; // �����ʱ�ȭ

	// �ʱ�ȭ ��� ���
	{
		kind = "Ÿ����";
		height = 70;
	} // ���� �ʱ�ȭ �� �����Ͱ� �������� ���⼭ �ʱ�ȭ�� �����Ͱ� ��

	Shape(String kind, int width) {
		this.kind = kind;
		this.width = width; // ������ �޼ҵ� - ���������� ����
	}

	
//������� ������ �ٲ� ������ �޼ҵ�� �ʱ�ȭ �� ���� ���?????????????
	
	@Override // �� �𸣰ڿ�
	public String toString() {
		return "���� : " + kind + "\n���� : " + width + "\n���� : " + height;
	}

}
