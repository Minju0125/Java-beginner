package sec01;

public class ExceptionExample02 {
	public static void main(String[] args) {
		try {
			throw new CustomException("���� ���� ����Ŭ����"); // throw (s����) ������ ���ܸ� �߻���Ű���� -> new �����ڸ� ���� ��ü�� ���� ���� ��Ŵ
		} catch (CustomException e) { // Exception �� �ᵵ ��
			e.printStackTrace();
		}
	}
}

/*
 * ����� ���� ����Ŭ���� : �����Ϸ��� üũ�� �� ���� ���ܵ� �Ϲݿ���Ŭ������, ���࿹��Ŭ������ ���� 1) �Ϲ� ����Ŭ���� :
 * Exception Ŭ������ ��� �޾� ����. �ַ� �̰� ���� ����� 2) ���� ����Ŭ���� : RuntimeException Ŭ������
 * ��ӹ޾� ����
 * 
 * 
 * �Ű������� ���� ������ �޼ҵ�� �ִ� ����� �޼ҵ带 �����ϰ� �ִ� ���� ���� �⺻���� ����
 * 
 */           

class CustomException extends Exception { // Exception �� ��ӹ޾� CustomException�� ����������

	CustomException() {
	} // ����Ʈ ������ �޼ҵ� // �Ű����� ���� ����Ŭ���� ���� �� �⺻ ������ �޼ҵ� ���
		// ���� ���� try �ȿ� throw new CustomException() �̷��� �Ű����� ������ �̰� ��� -> �� �Ⱦ�

	CustomException(String message) { // �޼����� ����ִ� ������ �޼ҵ� // �ַ� �� ��� ���
		super(message); // (�޼����� ������) �޼ҵ带 super�� ���� �θ𿡰� ���� // �θ� �� ����� ������ �޼ҵ� �����ϴϱ� �θ��� -> Exception
						// �� ����
						// ���ܰ� �߻��� ������ "���� ���� ����Ŭ����"
						// �θ�Ŭ������ �޼����� ������ �ڽ�Ŭ������ �ٽ� ��ӹ��� ��
	}
}

/*����ó�� �� �� �ִ� ���� ����ó�� ����� �߰��� ���α׷�
 */
