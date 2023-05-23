package chapter06.sec08;

public class MySqlDao extends DataAccessObject {
	@Override
	
	public void update() {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE CART \n");
		sb.append("   SET CART_QTY = 10 \n");
		sb.append("   WHERE CART_NO = ? ");
		String sql = sb.toString();
		System.out.println("데이터 갱신 query");
	}

	public void select() {
		String sql = "SELECT * FROM CART";
		System.out.println("데이터 검색 query");
	}

	public void insert() {
		System.out.println("데이터 삽입 query");
	}

	public void delete() {
		System.out.println("데이터 삭제 query");
	}
}
