package kr.or.ddit.study;

public class Study06 {

	/*
	 * ��ü(Ŭ����)��? - (1)�ʵ�, (2)�޼ҵ�, (3)������
	 * 
	 * - ���������� �����ϰų� �߻������� ������ �� �ִ� ���߿��� �ڽ��� �Ӽ��� ������ �����鼭 �ĺ� �����Ѱ� - ��ü�� �Ӽ��� ��������
	 * �����Ǿ� �ִ�. > �̸�, ����, ������ ���� �ʵ�(����) > �ȴ�, ���ϴ�, ���ߴٿ� ���� �޼��� (�Լ�) - ��ü(Ŭ����) ������ ����
	 * Ŭ������ ���� �� �� �ִ�. - ** ��ü(Ŭ����)�� ������, �ʵ�, �޼ҵ�� �����Ǿ� �ִ�. > �ʵ�: �����Ͱ� ����Ǵ� �� (����) >
	 * ������ : ���� �ʱ�ȭ�ϴ� ���� ��� > �޼ҵ� : ����� �����ϴ� ��� - new �����ڸ� ���� ������ ��ü(Ŭ����)�� �����µ� �̰�
	 * �ν��Ͻ�ȭ��� �Ѵ�. - ��ü(Ŭ����)�� �ձ��ڰ� �� �빮�ڿ����Ѵ�.
	 * 
	 */

	// Study06 Ŭ������ �ʵ�(����)�� �����غ���.
	String name; // �̸�
	int age; // ����
	String gender; // ����

	// Study06 Ŭ������ �����ڸ� ������.
	// - �⺻������, Custom ������
	public Study06() {}

	// Study06 Ŭ������ Custom �����ڸ� ������
	public Study06(String name) {
		this.name = name;
	}

	public Study06(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Study06(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	// ������ �����ε�
	// public Study06() {}
	// public Study06(String name) {}
	// public Study06(String name, int age) {}
	// public Study06(String name, int age, String gender) {}
	
	//Study06 Ŭ������ �Լ��� ������
	public void stydy() {
		System.out.println(name + "�л��� ���θ� �մϴ�!");
				
	}
	//getter �Լ� : Ư�� ���� ���� ��
	public String getName() {
		return name;
	}
	
	//���� ���� - �Ķ���� �ʿ�
	//setter �Լ� : ���� ������ ��
	public void setName(String name) {
		this.name = name;
	}

	//�������̵�(������)
	//toString() �Լ��� �츮�� Ŭ������ ����ٺ��� ���� ���� ���� �Լ��Դϴ�.
	// �� �༮�� @Override �Ǿ� �ִ� �Լ��� �θ� Ŭ�������� �����Ǿ� �ִ� �Լ���
	// Study06 Ŭ������ ���� �ڽ� Ŭ�������� '������'�Ͽ� ����ϴ� �Լ��ε�
	// �θ� Ŭ������ Object �̰� Object�� ��ӵǴ°� default�� ���������ϴ�.
	@Override
	public String toString() {
		return "������������ ������������0��������������������������������"; // �� ���� ����?
	}
	
	

	


	
	
	
	
	
	
}
