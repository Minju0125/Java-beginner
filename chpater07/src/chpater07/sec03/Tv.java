package chap07.sec03;

public class Tv extends Product { // product Ŭ������ ��ӹ���
	Tv() { // �⺻�����ڸ޼ҵ�
		super(1000); // 1000�� ������ �θ�Ŭ����(Product)�� ������ �޼ҵ带 �θ�
			// �ڽ�Ŭ������ �����Ƿ���, tvŬ������ ���� product Ŭ���� ����������ϴµ�, �� �� super �޼ҵ� ���
		//�����δ� �������� �ʰ� ��Ӹ� ����
		//��� �ȵǴ� �ΰ��� -> private���� ����� �޼ҵ峪 ����, ������ �޼ҵ�
		// �θ�Ŭ������ ������ �޼ҵ�ҷ���~ :super // �Ű������� Ÿ�� �Ȱ����ϱ� 1000�� price �� ����
	}

	@Override
	public String toString() {
		return "TV";
		

	}
}
