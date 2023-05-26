package sec01.part2;

public class ExceptionExample01 {
	public static void main(String[] args) {
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

// 100�� 0���� ������ ���� �߻�,
//�׷��� �� �������δ� ���� ����
/*
 * (��� ����Ʈ �� ���� )java.lang.ArithmeticException : 0�� �Ǹ� ���θ޼ҵ尡 ���� �Ͽ� ����ִµ� /by
 * zero �� �������� java.lang.ArithmeticException�� �߻��Ͽ��ٴ� �ǹ� �̰� ȣ�� ���ÿ� ����ִ� ����. / by
 * zero �̰� getMessage() �� �ش�Ǵ� ����.
 */
