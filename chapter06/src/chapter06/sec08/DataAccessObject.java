package chapter06.sec08;

public class DataAccessObject {
	public void select() { 
		String sql = "select * from cart";
		System.out.println("데이터 검색 query");
	}
	
	public void insert() {
		System.out.println("데이터 삽입 query");
	}
	
	public void update() {
		System.out.println("데이터 갱신 query");
	}
	
	public void delete() {
		System.out.println("데이터 삭제 query");
	}
}
