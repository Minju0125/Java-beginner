package chapter05.sec02.exam10;

public class AdvancedForExample {

	public static void main(String[] args) {
		int[] scores = { 95, 75, 84, 93, 87 };

		int sum = 0;
		for (int score : scores) {// scores �迭�� �ε���[0] ���� 95�� score�� ����� ��,
			sum = score + sum; // ���๮ ���� ! ��� ������ ���๮�� ��� ����Ǹ� �ٽ� ������ ���� ���� ����, �� ���� �迭���� score�� ������
								// for���� �ݺ� Ƚ���� �迭�� �׸�� ��ŭ �ݺ�!
		}
		System.out.println("���� ���� : " + sum);
		
		double avg = ((double) sum )/ scores.length;
		System.out.println("���� ��� : " + avg);
	}
}
