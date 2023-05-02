package chap02.sec01;

public class VariableExample01 {
	static int days; // 멤버변수?
	public static void main(String[] args) {
		Variable02 var2 = null; 	// Variable02 : 클래스 
									// 타입명 변수명 / var2는 참조형변수 (4가지 암기. 배열/클래스/인터페이스/enum?), 참조형변수는 주소 기억
									// null 길이를 갖지 않는 문자열 데이터 , 데이터가 존재하지 않는 상태 ("" <- 이것도 null , white space이라고 함, 문자열을 초기화시킬때 사용)
		var2 = new Variable02(); // Variable02() : 뒤에 괄호 붙으면 생성자 메서드( 유일하게 대문자로 시작하는 메서드) / new 는 주소 연산자-참조형
//		var2.value1=100;
//		value1=100;
		System.out.println(var2.Value1);
		
/*		int sum = 0; 
		int days = 0;
		int amountMoney = 100;
		while(true) {
			days++;
			sum = sum + amountMoney;
			if(sum>=1000000) { break; }
			amountMoney=amountMoney*2;
		}
		// 메인 메서드가 포함되어진 클래스명 앞에만 퍼블릭 붙일 수 있음, 메인메서드는 하나만 올 수 있음
		System.out.println("경과일수 : " + days);
		System.out.println("저축금액 : " + sum);
	*/ 
		}
	
}

class Variable02{
	int Value1; //멤버변수 , 다른 클래스에 있는것 끌어다쓰려면 클래스의 객체를 사용해야함 -> 변수 선언, // 자동초기화
}
// class Vairable02 라고 클래스를 하나 더 만들어도 메인메서드는 위에 있는 것이기 때문에 (퍼블릭) -> 파일이름은 메인메서드가 포함된 클래스명이 저장됨

