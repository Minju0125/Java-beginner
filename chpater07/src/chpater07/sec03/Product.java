package chap07.sec03;

public class Product {
	int price; // 2) 1000
	int bonusPoint; //3) 100 // ������ ��Ӱ��� -> 
	//4) 1000�� 100�� ���� price �� bouusPoint , Tv Ŭ�������� �״�� ��ӵ�.
	
	public Product(int price) { // 1) super(1000)�� 1000�� ���� price ��
		this.price = price;
		bonusPoint = price/10;
		
	}

}
