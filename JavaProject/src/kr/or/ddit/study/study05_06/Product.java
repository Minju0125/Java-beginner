package kr.or.ddit.study.study05_06;

public class Product {
	/* ����1)
	 * 
	 * �ʵ带 ������ּ���.
	 * - ���ڿ� Ÿ���� id			//��ǰID
	 * - ���ڿ� Ÿ���� name			//��ǰ��
	 * - ������ Ÿ���� price			//����
	 * - ������ Ÿ���� stock			//����
	 * 
	 * �����ڸ� ������ּ���.
	 * - �⺻�����ڸ� ������ּ���
	 * - ��ǰ ID�� ��ǰ���� �޴� Custom �����ڸ� ������ּ���.
	 * 
	 * �Լ��� ������ּ���.
	 * - ��ǰ ID�� �������� �Լ��� ������ּ���. (getID)
	 * - ��ǰ ID�� ������ �Լ��� ������ּ���. (setID)
	 * - ��ǰ���� �������� �Լ��� ������ּ���. (getName)
	 * - ��ǰ���� ������ �Լ��� ������ּ���. (setName)
	 * - ������ �������� �Լ��� ������ּ���. (getPrice)
	 * - ������ ������ �Լ��� ������ּ���. (setPrice)
	 * - ������ �������� �Լ��� ������ּ���. (getStock)
	 * - ������ ������ �Լ��� ������ּ���. (setStock)
	 * 
	 */
	
	String id;
	String name;
	int price;
	int stock;
	
	public Product(){} 
	
	public Product(String id, String name){
		this.id = id;
		this.name = name;
	}

	public String getId() { //���� �����ö� . getter�� ȣ���ϴ� ���� ���� ������ �� ����
		return id;
	}

	public void setId(String id) { //���� ����
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
