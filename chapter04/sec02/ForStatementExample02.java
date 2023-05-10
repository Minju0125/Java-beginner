package chapter04.sec02;

import java.util.Scanner;

public class ForStatementExample02 {

	public static void main(String[] args) {
		ForStatement02 fs02 = new ForStatement02();
//		fs02.numberOfVowels();
		fs02.fibonacciNumber();

	}

}

class ForStatement02 {
	Scanner sc = new Scanner(System.in); // ��ĳ�ʴ� Ŭ���� Ÿ��

	public void numberOfVowels() {

//(���� 6)  Ű����� �ܾ �Է� �޾� �ܾ ���Ե� ���� (a,e,i,o,i)�� ���� ����Ͻÿ�.
//		�޼ҵ� �ȿ��� ����Ǵ� �������� ������ ������ �ݵ�� �ʱ�ȭ�ؾ���.
//		������ ���� üũ�� ������ 1���� ī���� (length) // index �� �����ε� 0������ -> length���� index�� �ϳ� ���� ��
//		string ���ڿ����� �ѱ��� ���� -> char (����)
//		charAt(�ε���) �ε��� ��ġ�� ���ڸ� �ϳ� �����ؼ� ĳ���ͷ� ��ȯ�Ͻÿ� ��� �޼ҵ�
//		��Ʈ�� Ŭ������ ���� �ѱ��� ���ڸ� ��ȯ�ϴ� �޼ҵ�

		int count = 0; // ������ ���� ���� ����

		System.out.println("�ܾ� �Է� : ");
		String word = sc.nextLine();

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' 
				|| word.charAt(i) == 'i' || word.charAt(i) == 'o'
				|| word.charAt(i) == 'u') {
				count++;
				}
		}

		System.out.println(word + "�� ���Ե� ������ ���� " + count);

	}

//	���� 7 ) 1-50 ���̿� �����ϴ� fiboncacci ������ ����Ͻÿ�.
//	** fibonacci ���� : ù ���� �ι�°���� 1�� �־����� �� �������� �� �μ��� ���� ������� �Ǵ� ����
//		==> �ڷ� �˻� �˰��� ��� (�Ǻ���ġ �˻�)

	public void fibonacciNumber() {
		int ppNum = 1; // ������
		int pNum = 1; // ����
		int currNum = 0; // �����

		System.out.printf("%3d%3d", 1, 1); // �������� ���ڿ� ���� % // 3d �� �ι� ����Ұ��̱� ������ ,1,1
		for (int i = 1; i < 50; i++) { // ���⼭ i�� �ƹ��ǹ� ���� ī���ø� ���ִ� ��
			currNum = ppNum + pNum;
			if (currNum >= 50) {
				break; // break �ڱⰡ ���� �ݺ��� (for��). switch-case ����.
			} else {
				System.out.printf("%3d", currNum);
				ppNum = pNum; // �Ʒ��ٰ� ���� �ٲ�� x - �����ϱ� !
				pNum = currNum;
			}

		}
	}
}

