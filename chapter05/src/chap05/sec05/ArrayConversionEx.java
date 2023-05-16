package chap05.sec05;
//�ֻ��� ���� Ǯ��//

public class ArrayConversionEx {

	public static void main(String[] args) {
		ArrayConversion ac = new ArrayConversion(); // Ŭ���� �����ϸ� �ڵ����� public �޼ҵ� ��밡��
//		ac.histogram();
		ac.ontToTwo();
	}

}

class ArrayConversion {
	private int[] dice = new int[6]; // �ֻ��� �� ���� �߻� Ƚ�� ����
										// 6���� ������� ����鼭 �ʱⰪ 0���� ������

	public ArrayConversion() {
		for (int i = 0; i < 50; i++) {
			int rnd = (int) (Math.random() * 6);
			dice[rnd]++;

		}

	}

	// ���� ������׷� �׸���
	public void histogram() {

		for (int i = 0; i < dice.length; i++) {
			System.out.print((i + 1) + " : ");
			for (int j = 0; j < dice[i]; j++) {// dice �迭�� ����ִ� �� ��ŭ *�� �ٹٲ� ���� ��µǾ����
				System.out.print("*");
			}
			System.out.println("(" + dice[i] + ")");
		}

	}

	public void ontToTwo() {
// ���� ������׷� �׸���
		int rowCount = dice[0]; // �ӽ��ִ밪
		for (int i = 1; i < dice.length; i++) { // �� ����� 0���� �Ӥ��� �ȝ���
			if (rowCount < dice[i]) {
				rowCount = dice[i]; // dice �迭�� ���� ū ���� rowCount�� // �迭�� �� ÷�ڰ� ��
			}
		}

		char[][] ch = new char[rowCount][6]; // rowCount���� ���� �����Ǵ� char �迭�� ���� ������ �޶���
		for (int i = 0; i < ch[0].length; i++) { // ��
			for (int j = 0; j < dice[i]; j++) {
				ch[j][i] = '*';

			}
		}

		// ���
		for (int i = rowCount - 1; i >= 0; i--) {// �ִ� �ƽø� ���ȣ
			System.out.printf("%3d |", (i + 1));
			for (int j = 0; j < ch[i].length; j++) {
				System.out.printf("%5s", ch[i][j]);
			}
			System.out.println();

		}
	}

}
