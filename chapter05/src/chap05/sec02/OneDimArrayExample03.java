package chap05.sec02;

import java.util.Scanner;

public class OneDimArrayExample03 {
	public static void main(String[] args) {
		OneDimArray03 od3 = new OneDimArray03();
		od3.suffle();
		od3.getLottoNumer();
	}
}

class OneDimArray03 {
	int[] lotto = new int[45];

	// �ʱ�ȭ 1~45 ������ ���� ����Ǿ� �־����.// ������� 45���� �����ϰ�
	OneDimArray03() {
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;

		} // ���� ���� 45���� 1���� 45������ ���ڸ� �־����. Ŭ���� �� �޼ҵ� ���� �ʵ�
			// �Ʒ����� ��� ���ű� ������ ����ٰ� ����
	}

	public void suffle() {
		for (int i = 0; i < 10000000; i++) {
			int rnd = (int) (Math.random() * 45);// ?
			int temp = lotto[0];
			lotto[0] = lotto[rnd];
			lotto[rnd] = temp;
		}

	}

	public void getLottoNumer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���Աݾ��� 1000�� ������ �Է� : ");
		int money = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= money / 1000; i++) {
			suffle();
			System.out.printf("%2d : ", i);
			for (int j = 0; j < 6; j++) { // 6�� ��������
				System.out.printf("%5d", lotto[j]); // 1 :
			}
			System.out.println();
		}
	}

}