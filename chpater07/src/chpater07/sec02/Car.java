package chap07.sec02;

public class Car {

	public static void main(String[] args) {
//3) car01 class ����
		Car01 c1 = new FireEngine(); // c1�� �θ�Ŭ���� Car01 Ŭ������ ��ü�ϱ�
			// c1.color ��
		System.out.println("c1.color = " + c1.color); //upcasting
//		�θ�Ŭ���� Ÿ���� ������ ȣ�� (blue) . �ڽ�Ŭ������ �ִ� red�� ȣ���ϴ°� �ƴ϶� �θ�Ÿ�Կ� �ִ� blue �� �����Ͽ� ȣ��
		c1.dirve(); // �θ�Ŭ������ �޼ҵ� ȣ��
		c1.stop(); // override (������) �Ȱ� 
//		c1.water(); // �̰� �ڽ�Ŭ�������� �����ϰ� ������ ���̱� ������ ȣ���� �� ����
		
		FireEngine fe = null;
		if(c1 instanceof FireEngine) {
			fe = (FireEngine) c1;
		}
		fe.water();
		System.out.println("fe.color = " +fe.color);
	}

}

class Car01 {
//	1) Car01 Ŭ���� ��ü ����

	String color = "blue";
	int door;

	public void dirve() {
		System.out.println("���� ���� ���Դϴ�.");
	}

	public void stop() {
		System.out.println("���� ���߾����ϴ�.");
	}

}
