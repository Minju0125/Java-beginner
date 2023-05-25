package chapter08.sec01;

public class OracleDao implements DataAccessObject { 
	//이 클래스는 DataAccessObject 를 구현함 -> implements
	//인터페이스도 확장자는 .java임 // 클래스는 아님 !
	
	@Override
	public void select() {// 부모인터페이스로부터 상속받음 ->> @Override 
						  //오버라이드 안되면 절대로 객체 될 수 없음 !
		System.out.println("Oracle DB에서 데이터 검색");
	}
	
	@Override
	public void insert() {
		System.out.println("Oracle DB에서 자료 삽입");
		
	}
	
	@Override
	public void update() {
		System.out.println("Oracle DB에서 자료 갱신");
	}
	
	
	
	@Override
	public void delete() {// 이 중에 하나라도 재정의하지 않겠다 하면 class 앞에 abstract 붙어야함
		System.out.println("Oracle DB에서 자료 삭제");
	} 

}
