package chapter04.sec02;

public class ForStatementExample03 {

	public static void main(String[] args) {
		ForStatement03 fs03 = new ForStatement03();
		System.out.println("[1������]");
		fs03.shape01();
		System.out.println("\n[2������]");
		fs03.shape02();
		System.out.println("\n[3������]");
		fs03.shape03();
		System.out.println("\n[4������]");
		fs03.shape04();
		System.out.println("\n[5������]");
		fs03.shape05();
	}
}

class ForStatement03 {

	public void shape01() {
		for (int i = 0; i < 5; i++) { // ���� ���
			for (int j = 0; j <= i; j++) { // i�� 0�̸� j�� 0���� // i�� 1�̸� j�� 0���� 1���� // ...
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void shape02() {
		for (int i = 0; i < 5; i++) { // ���� ���
			for (int j = 0; j < i; j++) { // ���� ���
				System.out.print(" ");
			} // �Ʒ� for ���� j�� �ٸ� j (�������ٰ� �ٽ� ���� j)

			for (int j = 0; j <= (5 - i); j++) { // "*" ��� ���
				System.out.print("*"); // (�������ٰ� �ٽ� ���� j)
			}
			System.out.println();
		}
	}

	public void shape03() {
		for (int i = 0; i < 5; i++) { // ���� ���
			for (int j = 0; j < (4 - i); j++) { // ���� ���
				System.out.print(" ");
			} // �Ʒ� for ���� j�� �ٸ� j (�������ٰ� �ٽ� ���� j)

			for (int j = 0; j <= (i * 2) + 1; j++) { // "*" ��� ���
				System.out.print("*"); // (�������ٰ� �ٽ� ���� j)
			}
			System.out.println();
		}
	}

	public void shape04() {
		for (int i = 0; i < 5; i++) { // ���� ���
			for (int j = 0; j < (4 - i); j++) { // ���� ���
				System.out.print(" ");
			} // �Ʒ� for ���� j�� �ٸ� j (�������ٰ� �ٽ� ���� j)

			for (int j = 0; j <= i; j++) { // "*" ��� ���
				System.out.print("*"); // (�������ٰ� �ٽ� ���� j)
			}
			System.out.println();
		}
	}

	public void shape05() {
		for (int i = 0; i < 5; i++) { // ���� ���

			for (int j = 0; j < (5 - i); j++) { // "*" ��� ���
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
