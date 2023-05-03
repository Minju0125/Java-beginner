package chap02.sec02;

public class StringExample {

	public static void main(String[] args) {
		// String : 문자열 처리 객체
		//			""로 묶인 리터럴 처리
		//			"+" 연산자는 두 문자열을 결합시킬 때 사용
		// ** 객체들에 대한 동등연산자
		// 내용비교는 .equals() 메서드를 사용해야 한다.
		
		
		String name1 = "이순신"; // name 에 들어가는 값은 이순신이 저장된 주소 // 실행되기 전에는 주소가 들어가야 하니까 null값으로 저장됨
		String name2 = "이순신"; 
		
		//애니타입+문자열 => 문자열
		//"7" + 7 = "7" + "7"(문자열로 ) => 77
		// 오라클은 숫자 위주이기 때문에 14
		
		
		String name3 = new String ("이순신"); // new 연산자는 heap에 저장, 괄호가 붙으면 메서드, 생성자메서드는 객체 초기화
		String name4 = new String ("이순신");
		//new 사용된 갯수만큼 기억공간 만듦
		
		System.out.println(name1==name2);
		System.out.println(name3==name4);
		
		System.out.println(name3.toString()); // "이순신" 출력 / 
		
				
		Person p1 = new Person ("이순신");
		System.out.println("p1=" + p1.toString()); // 주소값 출력
	}

}


class Person {
	String name;
	
	Person(String name){
		this.name=name;
	}

	
	@Override						//재정의
	public String toString( ) {
		return name;			
	}
}
