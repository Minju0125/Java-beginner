package chapter08.sec01;

public class DaoExample {

	public static void main(String[] args) {
		OracleDao od = new OracleDao();
		MySqlDao md = new MySqlDao();

		od.insert();

		DataAccessObject dao = new OracleDao();
		dao.insert();
	}
}

// DataAcessObject 얘는 인터페이스
// -> 다형성.
// DataAcessObject 은 인터페이스지만,
// 인터페이스도 다형성이 지원되어 이렇게 사용가능함.

/*
 * 다형성을 사용하면 다형성을 지ㅜ언하는 부모클래스에서 선언해놓은 메소드만 사용가능 부모클래스에서 정의해놓은 변수만 참조가능함 부모클래스에서
 * 선언해놓은 메소드가 자식클래스에서 재정의되었다면 자식 클래스에서 호출되는 것을 다형성이라고함 부모인터페이스에서 정의해놓은 메소드만 불러다
 * 쓰겠다. 부모인터페이스에서 정의해놓은 것은 몸통이없고, 오라클다오에서 재정의함 오라클다오세너는 부모인터페이스의 모든 메소드가 재정의되어야
 * 객체가 될 수 있음
 * 
 * 인터페이스는 추상메소드만 있음 이 추상메소드를 구현된 자식클래스는 인터페이스에서 정의해놓은 모든 메소드를 모두 재정의해야함 그래야 객체 될
 * 수 있음 추상메소드를 하나라도 보유하면 절대 객체될 수 없음 DataAcessObject는 인터페이스고 여기엔 추상클래스만 있고 얘를
 * 구현한 객체인 오라클다오는 인터페이스에서 선언해놓은 모든 메소드를 재정의함. -> 그래야객체가 됨
 * 
 * 부모타입으로 설정해놓은 dao를 통해 접근할 수 있는 메소드는 DataAcessObject 에서 선언한 메소드 인에 오라클 다오에서
 * 재정의했기 때문에 실체 호출은 오라클 다오에서 재정의한 메소드가 호출됨
 * 
 * 부모클래스에서 정의한 변수,메소드만 호출 (다형성의 원칙) 부모클래스에서 만든 메소드를 재정의했다면, 자식클래스의 메소드가 호출(이것도
 * 다형성)
 */