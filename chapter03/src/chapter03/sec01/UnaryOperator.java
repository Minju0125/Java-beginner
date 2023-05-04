package chapter03.sec01;

public class UnaryOperator {

	public static void main(String[] args) {
		// 단항연산자 : 부호(+,-), 증감 (++,--), 논리부정 (!)

		// 메인메소드가 끝나면 전체 프로그램이 종료

//		signOperator(); // 아래 void 실행시키고 다음 연산 -> 여기서 다음 연산은 메인메소드 종료이기 때문에 실행 끝.
		// 반환값의 유무에 따라 void -> 메소드 이름만 부르기
		// 아래를 실행시키고 메인메소드로 다시 돌아옴 (메소드의 호출방법)

//		incrementOperator()
		
		
		logicalNot();

	}

	public static void signOperator() { // 괄호있으니까 메소드 -> 뒤에 중괄호는 메소드의 범위
		// 부호연산자 : 음수(-), 양수(+)
		int num1 = 100;
		int num2 = -num1;

		// (번외) 1-2+3-4.......-10=?
		// 여기서 규칙성 숫자가 1~10까지 나옴
		// 부호가 +, - 번갈아나옴
		// 어떤 값을 -1로 놓고 계속해서 -1을 곱하ㅐ줌
		// -1을 곱해주는데 첫 값이 -1이어야함

		System.out.println("num1=" + num1); // 문자열 + 애니타입 -> 문자로 // num1은 변수 // 문자열을 출력하고 줄바꾸세요.//기억장소에 저장된 값이 문자열이 됨
		System.out.println("num2=" + num2);

	}

	public static void incrementOperator() { // incrementOperator() 라는 메서드를 위에 메인메소드에서 불러야함!!!!

		// 증감연산자 : ++, --,
		int num = 100;
		int res1 = 0; // result : res
		int res2 = 0;

//		res1 = num++; //num에 들어있는 100을 res1에 넣고 1증가 // postfix 표기방법
//		System.out.println("num=" + num + "\nres1="+res1);

		System.out.println("num++=" + (num++) + "num=" + (num));
		// 현재 num에 들어있는 값을 넣어줌 (아직 자기 자신이 증가 전, res1 역할) 그리고 1 증가시켜서 여기 넣어줌

		num = 100;
//		res2 = ++num; // prefix 표기방법
//		System.out.println("num=" + num + "\nres2="+res2);
//		
		System.out.println("++num" + (++num) + "num=" + num);

	}

	public static void logicalNot() {
		// 논리 부정 연산자 : ! (Not)
		// 토글기능 (toggle) : 참과 거짓이 반복되는 기능
		// 한영변환, 삽입/편집기능 등

		boolean powerState = true;
		while (true) { // 무한루프 돌릴 때 - while : 내 중괄호에 있는 명령문을 반복하시오 (참인경우- 무한루프), 
			if (powerState) { // 괄호안에 있는게 참이라면
				System.out.println("전원 스위치가 on 상태"); 
			} else { 
				System.out.println(" 전원 스위치가 off 상태");
			}
			powerState = !powerState; // powerState 현재 참이면 거짓으로, 거짓이면 참으로 // 사용자가 정지할 때 까지  
		}

	}

}
