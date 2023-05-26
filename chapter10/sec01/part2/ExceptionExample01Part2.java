package sec01.part2;

public class ExceptionExample01Part2 {

	public static void main(String[] args) {
		methodA();

	}

	public static void methodA() {
		int res = 0;
		int num = 10;

		try {
			for (int i = 0; i < 15; i++) {
				res = 100 / num; // ���ܰ� �߻��� �� �ִ� ���輺�� �ִ� ��ɹ� !
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
			System.out.println("�̰��� ������ ����Ǵ� ����Դϴ�.");
		}

	}

}
