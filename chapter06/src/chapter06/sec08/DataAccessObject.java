package chapter06.sec08;

public class DataAccessObject {
	public void select() { 
		String sql = "select * from cart";
		System.out.println("������ �˻� query");
	}
	
	public void insert() {
		System.out.println("������ ���� query");
	}
	
	public void update() {
		System.out.println("������ ���� query");
	}
	
	public void delete() {
		System.out.println("������ ���� query");
	}
}
