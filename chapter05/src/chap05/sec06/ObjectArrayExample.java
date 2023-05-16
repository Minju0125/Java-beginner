package chap05.sec06;

public class ObjectArrayExample {

	public static void main(String[] args) {
//		Books[] book = new Books[3]; // Books�� ���� ��ü�� ���� ��������� �ʾ���. new ������ ��ȣ�� ������ �ִ� ������ �޼ҵ� ���;� ��ü �������/ �迭�� ������
//		book[0] = new Books("���ʺ� ����", "EBS", 15000);
//		book[1] = new Books("���� �Թ���", "����ȣ", 30000);
//		book[2] = new Books("��ũ���׽� ����", "������", 10000);

		Books[] book = {new Books("���ʺ� ����", "EBS", 15000), //Ŭ���� ��ü ���� �����ؼ�, ���� �ڵ� ����
				new Books("���� �Թ���", "����ȣ", 30000),
				new Books("��ũ���׽� ����", "������", 10000)};
				
		
		
		System.out.println("------------------------");
		for (Books b : book) {

			System.out.println(b); // ������ �ּҰ� �￩�� �ϳ�, 
			System.out.println("-----------------------");
		}

	}

}

class Books { // ���Ⱑ ��ũȣ�� Ŭ����
	private String title; // -> pirvate���� �����߱� ������ �ܺ� Ŭ�������� ���� �Ұ��� (Books Ŭ���������� ���� ����)!
	private String writer;
	private int price;

	// �ʱⰪ ���� �Ұ� - ��?
	// ������ �޼ҵ� - ��ü �ʱ�ȭ(��� ���� �ʱ�ȭ)

	public Books() {
	}

	public Books(String title, String writer, int price) {
		this.title = title;
		this.writer = writer;
		this.price = price;

		/*
		 * �Ȱ��� Books �޼ҵ� �ΰ� �����ε�
		 * 
		 * ����Ʈ�� �޼ҵ�� ������Ʈ Ŭ������� Ŭ������ �Ͻ��� �������ؼ� ��ӹ޾� ����ϰ� ����.
		 * 
		 * �����ε� �������̵� ��ü ���� ���� �� �ΰ��� ���ǰ� ����
		 * 
		 * �Ͻ� �������� �ͽ��ٽ� ������Ʈ�� ���µȰ�. ��
		 *
		 * 
		 */

	}

	@Override
	public String toString() {
		return "å�̸�: " + title + "\n����: :" + writer + "\n���� : " + price;

	}
}


