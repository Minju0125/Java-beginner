package chapter11.sec01;
//StringBuffer, StringBuilder : String 클래스의 단점 (immutable)
//을 보완한 클래스
//append() 메서드를 이용하여 저장된 문자열 끝에 새로운 문자열 추가 가능
//연산 후 toString() 을 이용하여 문자열 (String) 타입으로 변환

public class StringBufferExample {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		StringBuffer sb1 = new StringBuffer("홍길동"); // 문자열을 직접 정의해서 생성해도 됨
		StringBuffer sb2 = new StringBuffer("홍길동");
		
//		if(sb1.equals(sb2)) {
//			System.out.println("같은 내용");
//		} else {
//			System.out.println("다른 내용");
//		} // toString 이 재정의 되어있지 않기때문에, 주소값으로 판단하는데. (다른내용 출력)
		// equals 메소드에 의해 내용비교 불가능함.
		// 내용비교하려면 toString
		
		if(sb1.toString().equals(sb2.toString())) {
			System.out.println("같은 내용");
		} else {
			System.out.println("다른 내용");
		} // 재정의 안되면 getClass ~어쩌구가 반환 (주소값) 
		//문자열로 바꿔서 실행하는 execute 쿼리나 ~어쩌구 쿼리에 전달해줘야 정상적으로 실행함.
		//간단한 경우에는 toString 사용할 수 있지만, 
		//복잡한 쿼리의 경우에는 StringBuffer, StringBuilder 를 주로 사용함.
		
		sb.append("  select * \n  "); // append 인수로 전달된 값을 문자열로 변환한 후, 해당 문자열의 마지막에 추가
		sb.append("  from member \n  ");
		sb.append("  where mem_id = ?  ");
		// 각각을 나누어서 기술함.
		// append() 는 만들어진 것 끝에 추가하는 메소드
		// ""안에는 하나 이상의 공백을 마련해주는 것이 안전한 방법 - > 붙여서 사용하게 되면 공백 없이 다 붙을 수 있음. -> 근데, 오라클은 공백에 의해 구분되기 때문에
		// 공백 또는 \n을 이용해서 구분
		// 쿼리안에  
		
		
		//String 타입이 아닌데, 쿼리 실행을 위해서는 반드시 매개변수가 String 타입이어야함
		//그래서, toString 씀
		String str = sb.toString();
		System.out.println(str);
	
	}
}
