package chap05.sec03;

import java.util.Random;
import java.util.Scanner;

public class Word5Scaramble {

	public static void main(String[] args) {
		WordScramble ws = new WordScramble();
		String str = ws.WordSelection();// �ܾ� ��ȯ ���� ���� ���� (���õ� �ܾ�)
//		System.out.println(str); // �̰Ÿ� �ϸ� ������ ���ڿ�(�ܾ�) ��ȯ��
		
		String question = ws.shuffle(str);// str�� ������ ���� �޼ҵ� ȣ�� (���� �ܾ�)
		System.out.println("���þ� : " + question); // ���þ�
		ws.answer(str);

//	

	}

}

class WordScramble { // ���⼭ �̰� ��ũȣ�� Ŭ����
	private String[] word = { "hope", "apple", "banana", "orange", "love" };

	public String WordSelection() { //��ȯ�� ���� ȣ��
		Random rnd = new Random();
		int idx = rnd.nextInt(5); // ���� �����ؼ� ���� �߻� (0~4 ������ ������ ����)
		return word[idx]; // ��ȯ?�Ѱ� ������ ��ȯ �޾ƾ���

	}

	public String shuffle(String str) {// ** ��ȯ�ϰ��� �ϴ� Ÿ���� ���ڿ��̳�, // ���⼭ ��ȣ���� string str�ǒ�?
		char[] ch = str.toCharArray(); // ���ڿ��� ���� �迭�� ��ȯ �� ���Ǵ� �޼ҵ�
		for (int i = 0; i < 1000; i++) { // 1000�� ����
			int r = (int) (Math.random() * ch.length); // (ĳ���� �迭�� ũ��-1) ��ŭ
			char temp = ch[0];
			ch[0] = ch[r];
			ch[r] = temp;
			// **���⼭ ��ȯ�Ǵ� Ÿ���� ���� �迭�̱� ������ ���ڿ��� ��ȯ �ؾ���
		}

		return (new String(ch));

	}

	public void answer(String question) { // ��ȯ�Ǵ°��ʿ�����Ƿ� void
		Scanner sc = new Scanner(System.in);
		int count = 0; // �õ� Ƚ�� - �ݺ�Ƚ���� �����ϰ� ���س��� ����ä �ݺ� �� ���̱� ������ while �� ���
		while (true) {
			System.out.print("\n���� : ");
			String str = sc.nextLine(); // ���ڿ��� �Է¹���
			count++;
			if (str.equals(question)) {
				System.out.println("*****************");
				System.out.println("�����Դϴ�....");
				System.out.println("�õ�Ƚ�� : " + count);
				System.out.println("*****************");
			} else {
				System.out.println("*****************");
				System.out.println("������ �ƴմϴ�....");
			}
			break;
		}

	}

}