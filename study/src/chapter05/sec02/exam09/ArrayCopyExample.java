package chapter05.sec02.exam09;

public class ArrayCopyExample {

	public static void main(String[] args) {
		
		String[] oldStrArray = {"java", "array", "copy"};
		String[] newStrArray = new String[5]; // new �����ڸ� �̿��� �迭�� �������� ���, �ʱ�ȭ���� �⺻������ �Ҵ�ȴ�.
											// String �迭�̱� ������ �ʱⰪ�� null ��

		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
			// �� �޼ҵ��� �ǹ̴� oldStrArray�� 0��° �ε��� �����Ͽ�, newStrArray�� 0��° �� �ٿ��ְڴ�. oldStrArray�� ���̸�ŭ !
		
		for(int i = 0; i<newStrArray.length; i++) {
			System.out.print(newStrArray[i]+",");
		}
		
	}

}
