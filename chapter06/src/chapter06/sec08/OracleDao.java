package chapter06.sec08;

public class OracleDao extends DataAccessObject{
	@Override
	public void select() { 
		String sql = "select * from cart";
		System.out.println(sql);
		System.out.println("오라클 데이터 검색 query");
	}
	
	@Override
	public void insert() {
		String sql = "insert into cart values(?,?,?,?)";
		System.out.println(sql);
		System.out.println("오라클 데이터 삽입 query");
	}
	
}
