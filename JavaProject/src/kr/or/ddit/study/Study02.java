package kr.or.ddit.study;

import java.util.Scanner;

public class Study02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ���ǹ� switch �����غ���
		// ���ǹ� ��, ���� �ܰ��� ¦��/Ȧ�� ���ϱ�
		System.out.println("���ڸ� �Է����ּ��� : ");
		String input = sc.nextLine();

		switch (Integer.parseInt(input) % 2) { // ���� �Ǵ� ���ǽĿ� ���� ��
		case 0:
			System.out.println(input + ": ¦��");
			break;
		case 1:
			System.out.println(input + ": Ȧ��");
			break;
		default:
			System.out.println("?");
			break;
		}

		/*
		 * ���������������� ������ ����1) A����� B����� ���������� ������ �մϴ�. A����� �� ���������� B ����� �� ������������ ����
		 * ����� ������ּ���. - ���ʻ���� �������� ����� ����غ��ô� > ���� ����, ���� ����, �� �� : �����ϴ�. > ���� ����, ����
		 * ��, �� ����: �����ϴ�. > ���� ����, �� ����, ���� �� : �̰���ϴ�.
		 * 
		 */

		System.out.println("��� a : ");
		String first = sc.nextLine();

		System.out.println("��� b : ");
		String second = sc.nextLine();

		switch (first) {
		case "����":

			switch (second) {
			case "����":
				System.out.println("�����ϴ�.");
				break;
			case "����":
				System.out.println("�����ϴ�.");
				break;
			case "��":
				System.out.println("�̰���ϴ�.");
				break;
			default:
				System.out.println("��� B �� �����Ѱ� �½��ϴ�...");
				break;
			} break;

		case "����":

			switch (second) {
			case "����":
				System.out.println("�����ϴ�.");
				break;
			case "����":
				System.out.println("�����ϴ�.");
				break;
			case "��":
				System.out.println("�̰���ϴ�.");
				break;
			default:
				System.out.println("��� B �� �����Ѱ� �½��ϴ�...");
				break;
			} break;

		case "��":

			switch (second) {
			case "����":
				System.out.println("�����ϴ�.");
				break;
			case "����":
				System.out.println("�̰���ϴ�.");
				break;
			case "��":
				System.out.println("�����ϴ�.");
				break;
			default:
				System.out.println("��� B �� �����Ѱ� �½��ϴ�...");
				break;
			}
			break;
		default:
			System.out.println("��� A �� ������ �� �½��ϴ�.");
			break;

		}
	}
}
