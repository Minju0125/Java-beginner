package chapter11.sec01;

public class ObjectExample {
	public static void main(String[] args) {
		Person p1 = new Person("ȫ�浿");
		System.out.println("getinfo() : " + p1.getinfo());
		System.out.println("toString() : " + p1.toString());

		Person p2 = new Person("ȫ���");
		if (p2.toString().equals(p1.toString())) {
			System.out.println("���� ����");
		} else {
			System.out.println("�ٸ� ����");
		}
	}

}

class Person {
	private String name;

	Person(String name) { // ���ڿ� ������ �̸��� �Ű������� ������ ������ �޼ҵ�
		this.name = name; // �Ű����� �ִ� ������ �޼ҵ� ����ϸ� �⺻ ������ �޼ҵ� ������ ����
	}

	String getinfo() {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}

	@Override
	public String toString() { // ��������� private ���� �Ǿ��־ �ܺο��� �̸� ������ �Ұ�����.
		// Person Ŭ������ ���ڿ��� �̸��̶�� ������ ������ ����. ������ ���������� private �ܺο��� ���� x
		// Ŭ���� �ۿ����� ���嵵, ���������� ����
		// Ŭ������ ��κ� private ���� ������. ����� ������� ���� ��κ��� Ŭ������ private ���� ����
		// db�� ����� �� Ŭ������ �ϳ��� (��ü �ϳ���) ����Ǿ���� -> single tone

		return name;
	}
}

//���� ��ü �Ƿ��� �ּҰ��� ���ƾ���.
//��ü�� ������ ������ ���� ���� equals() �޼ҵ�
//��ҹ��� �������ϴ� �� -> equalsIgnore()

/*
private ���� ����� ������� ������ ��κ� ������ �޼ҵ� �Ἥ �ʱ�ȭ�� (private�� Ŭ���� �ۿ��� ���� �Ұ�. ���� ���Ѵٴ� ���� ���� �����ϰų�, ���� x)
Ŭ���� �ۿ����� �� ������ ������ ����. ��ü�� ������ �� �ش絥���͸� ���� ����

<������ ��������>
�� �������� �ϳ��� Ŭ���� ������ �������ų�. �ϳ��� �ۿ� �ִ� ������ �����ϰ��� �Ҷ��� ����, ���� (������ ������ ���)
����������� ��� ������ �ִ� ������ �ѹ��� ����ϰ� ���� �� (�ѹ��� ��� ������ ��������)-> toString ( ) (�ϰ��� ������ ���)
*/
