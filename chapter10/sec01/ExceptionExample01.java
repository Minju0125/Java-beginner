package sec01;

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
		} catch (ArithmeticException e) { //���⼭ ���ܰ�ü e �� �̸��� �ߺ��Ǿ ������. �ٵ� �������� ���� �ٸ��� ���� ���� ������
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("�̰��� ������ ����Ǵ� ����Դϴ�.");
		}
		
	}
}
