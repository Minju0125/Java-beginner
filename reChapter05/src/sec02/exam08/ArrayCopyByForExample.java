package sec02.exam08;

public class ArrayCopyByForExample {
// �迭 ����
	public static void main(String[] args) {
		int[] oldIntArray = { 1, 2, 3 };
		int[] newIntArray = new int[5];// new �����ڷ� �迭�� ó�� ������ ��� �迭�� �ڵ������� �⺻������ �ʱ�ȭ�ȴ�.

		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
				//oldIntArray[0], oldIntArray[1]. oldIntArray[2] ���� �ټ�ĭ ¥�� newIntArray �迭�� ��  
				//���� ���� ���� newIntArray[3], newIntArray[4]���� 0�� ��
					//int �迭�� �ʱⰪ 0, String �迭�� �ʱⰪ null
		}
		for (int i = 0; i < newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ",");
		}

	}

}
