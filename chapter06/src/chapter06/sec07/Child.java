package chapter06.sec07;

public class Child extends Parent { // <- �ڽ� Ŭ������ ������ ���� �θ�Ŭ���� �����.
	String gender;
	int age = 25;
	

	

	Child(String gender, String name, int age) { // <- �θ�Ŭ������ �����ڸ޼ҵ忡 �Ѱ��� �����͸� �ڽ�Ŭ�������� ����
		super(name, age); // �θ�Ŭ���� ȣ�� ! // super �޼ҵ带 �ҷ����� �θ�Ŭ���� ��ü�� �������
							// �θ�Ŭ���� ��ü�� ����������� super
							// �θ�Ŭ�������� �⺻ �����ڰ� ���ٸ�, �ڽ�Ŭ�������� �����߻�
		this.gender = gender;

	}

	public String getName() { 

		return name;
	}

	public int getAge() {

		return age;
	}
}
