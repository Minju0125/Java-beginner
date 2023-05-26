package sec01.part2;

public class ExceptionExample01 {
	public static void main(String[] args) {
		int res = 0;
		int num = 10;

		try {
			for (int i = 0; i < 15; i++) {
				res = 100 / num; // 예외가 발생될 수 있는 위험성이 있는 명령문 !
				System.out.println(res); 
				num--;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("이곳은 언제나 시행되는 블록입니다.");
		}

	
}
}

// 100을 0으로 나누면 오류 발생,
//그러면 그 다음으로는 실행 안함
/*
 * (결과 프린트 된 것중 )java.lang.ArithmeticException : 0이 되면 메인메소드가 제일 믿에 들어있는데 /by
 * zero 가 원인으로 java.lang.ArithmeticException가 발생하였다는 의미 이게 호출 스택에 들어있는 내용. / by
 * zero 이건 getMessage() 에 해당되는 내용.
 */
