package chapter11.sec02;

import java.util.ArrayList;

public class ArrayListExample02 {

	public static void main(String[] args) {
		// ���ʸ� : �÷��� ������ ��ũ ��ü�� ����Ǵ� �����͸� ������
		// �Է��ڷḦ �˻��Ͽ� ������ �ּ�ȭ ��Ŵ
		// �������
		// �÷��ǰ�ü <Ÿ��> ���� = new �÷��ǰ�ü <Ÿ��>();
		// -> ���� �� <Ÿ��>�� ��ü Ÿ���̾����. (�ϳ��� ��ü ������)
		// <Ÿ��>�� ����ϸ� �Է��ϴ� ������ Ÿ���� �� Ÿ������ ���ѵ�.

		ArrayList<String> list = new ArrayList<String>();
		list.add("ȫ�浿"); // String�� ��ӹ޴� ��ü�� ����
		list.add("������ �߱� ���� 846");
//		list.add(100); // �����Ͱ� ���ڿ��� �ƴϸ� �Է� �Ұ����� !!!!
//		list.add(new Person("������")); // �Ұ�����. (��ȣ���� Ÿ���� String ���� ���ѵǾ��ֱ� ������)
		
		ArrayList<Person> list1 = new ArrayList<Person> (); // �Ʊ� ���� Pesron Ŭ���� ��ü�� ����
		
	}

}
