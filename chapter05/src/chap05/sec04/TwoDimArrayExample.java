package chap05.sec04;

public class TwoDimArrayExample {

	public static void main(String[] args) {
		TwoDimArray td = new TwoDimArray();
//td.getScore();
		td.sumOfScore();
		td.getRank();
	}

}

class TwoDimArray {

	/*
	 * 2���� �迭 ����1] 5���� 3������ ���� �� ����� ������ ����. �̸� �迭 ������ �� ����Ͻÿ�. (����� ������) [�ڷ�] �̸� ����
	 ** 
	 * �̸�(���ڿ�), ����(����)�� Ÿ���� �޶� ���� �迭 �� �� ����
	 */

	private String[] name = { "ȫ�浿", "�̼���", "������", "������", "�̼���" }; // �̸� �迭�� �� ����ҰŴϱ� �޼ҵ� �տ�

	public void getScore() { // void -> �ǵ��� �ִ� ������ ������ ȣ�⸸ �ϸ��
		int[][] score = { { 70, 80, 60 }, { 80, 90, 90 }, { 90, 80, 90 }, { 75, 80, 80 }, { 60, 70, 60 } };
		printScore(score);
	}

	public void sumOfScore() {
		int[][] score = { { 70, 80, 60, 0, 0 }, { 80, 90, 90, 0, 0 }, { 90, 80, 90, 0, 0 }, { 75, 80, 80, 0, 0 },
				{ 60, 70, 60, 0, 0 } }; // 0�� �����ϸ� 5�� 5���� ��

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < 3; j++) {
				score[i][3] = score[i][3] + score[i][j];
			}
			score[i][4] = score[i][3] / 3;
		}

		System.out.println("               ***����ǥ***              ");
		System.out.println("--------------------------------------------");
		System.out.println("�� ��    ����       ����      ����      ����      ���");
		System.out.println("--------------------------------------------");
		printScore(score);

	}

	public void getRank() {
		int[][] score = { { 70, 80, 60, 0, 0, 1 }, { 80, 90, 90, 0, 0, 1 }, { 90, 80, 90, 0, 0, 1 },
				{ 75, 80, 80, 0, 0, 1 }, { 60, 70, 60, 0, 0, 1 } }; 
		// ������ ����� �ʱⰪ�� ��� 1
		// ������ ��

		// ���� �� ���
		for (int i = 0; i< score.length; i++) {
			for (int j = 0; j < 3; j++) {
				score[i][3] = score[i][3] + score[i][j];
			}
			score[i][4] = score[i][3] / 3;
		}

		// ���
		// * �ʱⰪ�� 1
		// * �� �ڽ��� ������ ���ؼ� ������ �� ū ���� ������ ����� ����Ǿ� �ִ� ���� ���� 1�� ������Ŵ
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {
				if (score[i][3] < score[j][3]) {
					score[i][5]++;
				}

			}

			System.out.println("               ***����ǥ***              ");
			System.out.println("--------------------------------------------");
			System.out.println("�� ��    ����       ����      ����      ����      ���      ���");
			System.out.println("--------------------------------------------");
			printScore(score);
		}
	}

	public void printScore(int[][] score) {
		for (int i = 0; i < score.length; i++) { // ���� ������ 5 -> 5���� ���������� ����
			System.out.print(name[i] + " ");
			for (int j = 0; j < score[i].length; j++) { // j<3ó�� ������ ���� ��Ť������� �� �Ⱦ�
				System.out.printf("%6d", score[i][j]);
			}
			System.out.println(); // �ٹٲ�

			// �ݺ������� ���Ǵ� �κ� -> ���Ⱑ ���ؾȵ�
			// score�� ���������̰�, name �� ��������
			//
		}
	}

}