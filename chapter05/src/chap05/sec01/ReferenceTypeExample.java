package chap05.sec01;

public class ReferenceTypeExample {

	public static void main(String[] args) {
		Person p1 = new Person("ȫ�浿", 50);  
		String str = new String ("ȫ�浿");
		
		
		int[] score = new int[10];
		
		
		
		
		
		System.out.println("p1=" + p1.toString()); // ���� ��ΰ� get name?? chap05.sec01.Person@15db9742 (�ּҰ��� 16 ������ ǥ��)
								//��� ������ ������ �ִ� ��
		System.out.println("str=" + str.toString());
	 //toString ����
		System.out.println("score="+ score);
		
		}

}

class Person{ // ���� Ŭ�������� �̸��� ���̶�� �ϴ� Ư�� (�Ӽ�)�� ������ ���� 
	
	String name; // ������� - Ŭ������ ������ �ִ� Ư¡�� �����ϴ� ���� // 
	int age;
	
	Person() {} // �Ű�����x (�⺻ ������) // ������ �޼ҵ�� new ���� �޼ҵ� -> 
	
	Person(String name, int age){ // �޼ҵ� �����ε�? ��Ŭ���� ������ �̸��� �Ȱ��� �޼ҵ�
								
		this.name = name;
		this.age = age;
		
		
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}