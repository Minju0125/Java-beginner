package chapter06.sec04;

public class Goods {
	private String kind; // ��ǰ ����
	private int price;
	
	// ������ �޼ҵ�
	Goods(){} // �⺻ ������ �޼ҵ�
	Goods(String kind, int price){
		this.kind = kind;// ��ǰ ������ ���� �־���
		this.price = price; // ��ǰ ������ ���� �־���
	}
	
	
	public String getKind() {
		return kind;
	}
	
	public int getPrice() {
		return price;
	}
	
}
