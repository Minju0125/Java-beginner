package chapter06.sec05;

public class ProductExample {
	
	public static void main(String[] args) {
		Product p1 = new Product ("����"); 
		System.out.println(p1); // p1.toString �� �����Ȱ�
		
		Product p2 = new Product ("���찳"); // �̷��� �ϸ� ���� ��������� �������
		System.out.println(p2);
		
		Product p3 = new Product ("����Ʈ��"); // �̷��� �ϸ� ���� ��������� �������
		System.out.println(p3);
		System.out.println(p1);
		
	}

}

//��ǰ �ڵ�� 1001���� �ڵ������Ǿ� pid �� ����
//	�� ������ �޼ҵ忡�� 
class Product {
	static long pid=1000; //��������� �ʱ������� ������ �ڵ��ʱ�ȭ
	String pName;
	
	Product(){}
	Product(String pName){		 // ��ü�� ������ �� 1�� �ο�
			pid++;
			this.pName = pName;
	}
	
	@Override
	public String toString() {  // �������̵�� �ݵ�� �ۺ� / �θ� �ۺ�, �ڽ��� �ۺ� ���� ������ ����� �� ���� , �������̵�� ������
		return "��ǰ��ȣ : " + pid + "\n��ǰ�� : " + pName ;				// �ش� Ŭ������ ������ �ִ� ������ ���ڿ��� ���� ��ȯ 
				
//		����, ����Ʈ�� �޼ҵ�
//		���ʹ� �����ϳ��ϳ�, ����Ʈ���� ��׸� ���
	}
	
	
}