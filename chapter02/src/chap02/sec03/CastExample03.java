package chap02.sec03;

public class CastExample03 {

	public static void main(String[] args) {

//		[����] 1���� 365.2422���̴�. �� �ڷ��
//        "1����  365��   xx �ð�  xx��  xx�� �̴�"�� ����ϵ��� ���α׷� �Ͻÿ�....

		System.out.println(0.2422 * 24);
		System.out.println(0.8128 * 60);

		int hour = (int) (0.2422 * 24);
		System.out.println(hour);

		int minute = (int) (((0.2422 * 24) - (double) hour) * 60);
		System.out.println(minute);

		int second = (int) (((((0.2422 * 24) - (double) hour) * 60) - (double) minute) * 60);
		System.out.println(second);

		System.out.println("1���� 365�� " + hour + "�ð� " + minute + "�� " + second + "�� �̴�.");

	}

}
