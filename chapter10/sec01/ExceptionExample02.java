package sec01;

public class ExceptionExample02 {
	public static void main(String[] args) {
		try {
			throw new CustomException("내가 만든 예외클래스"); // throw (s없음) 강제로 예외를 발생시키세요 -> new 연산자를 통해 객체를 직접 생성 시킴
		} catch (CustomException e) { // Exception 만 써도 됨
			e.printStackTrace();
		}
	}
}

/*
 * 사용자 정의 예외클래스 : 컴파일러가 체크할 수 없는 예외들 일반예외클래스와, 실행예외클래스가 있음 1) 일반 예외클래스 :
 * Exception 클래스를 상속 받아 생성. 주로 이걸 많이 사용함 2) 실행 예외클래스 : RuntimeException 클래스를
 * 상속받아 생성
 * 
 * 
 * 매개변수가 없는 생성자 메소드와 있는 사용자 메소드를 포함하고 있는 것이 가장 기본적인 예문
 * 
 */           

class CustomException extends Exception { // Exception 를 상속받아 CustomException를 만들어놓음ㄴ

	CustomException() {
	} // 디폴트 생성자 메소드 // 매개변수 없는 예외클래스 만들 때 기본 생성자 메소드 사용
		// 만약 위에 try 안에 throw new CustomException() 이렇게 매개변수 없으면 이걸 사용 -> 잘 안씀

	CustomException(String message) { // 메세지가 들엉있는 생성자 메소드 // 주로 이 방법 사용
		super(message); // (메세지를 가지고) 메소드를 super를 통해 부모에게 전달 // 부모에 이 모양의 생성자 메소드 존재하니까 부른거 -> Exception
						// 로 전달
						// 예외가 발생된 원인이 "내가 만든 예외클래스"
						// 부모클래스로 메세지를 보내서 자식클래스가 다시 상속받은 것
	}
}

/*예외처리 할 수 있는 곳은 예외처리 해줘야 견고한 프로그램
 */
