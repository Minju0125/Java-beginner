package sec01;

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
		} catch (ArithmeticException e) { //여기서 예외객체 e 는 이름이 중복되어도 괜찮다. 근데 가독성을 위해 다르게 쓰는 것을 권장함
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("이곳은 언제나 시행되는 블록입니다.");
		}
		
	}
}
