package chapter08.sec01;

public class MySqlDao implements DataAccessObject {

	// 인터페이스에서는 상위클래스의 모든 메소드를 재정의하는 것이 상속의 조건임.

	@Override
	public void select() {}
	public void insert() {}
	public void update() {}
	public void delete() {}
	// MySql을 사용하지 않아 해당 메소드의 바디에 코드없더라도,
	// 반드시 오버라이드해야함.
	
	/* 재정의할 때, 접근지정자는 원래 추상메소드보다 더 좁혀서 쓸 수 없다 !
	 * 여기서는, DataAccessObject 에서 
	 * select(),insert(),update(),delete() 모두 public 으로 썼기 떄문에
	 * 재정의할 때 public 보다 좁혀서 쓸 수 없음 !  
	 */

}
