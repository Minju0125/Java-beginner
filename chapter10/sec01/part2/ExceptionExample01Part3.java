package sec01.part2;

public class ExceptionExample01Part3 {

	public static void main(String[] args) {
		try {
		methodA();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	} // methodA를 불러다 쓰려면  ArithmeticException, Exception 이걸 처리하고 써라.

	public static void methodA() throws ArithmeticException, Exception {

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
