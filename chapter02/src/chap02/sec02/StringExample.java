package chap02.sec02;

public class StringExample {

	public static void main(String[] args) {
		// String : ���ڿ� ó�� ��ü
		//			""�� ���� ���ͷ� ó��
		//			"+" �����ڴ� �� ���ڿ��� ���ս�ų �� ���
		// ** ��ü�鿡 ���� �������
		// ����񱳴� .equals() �޼��带 ����ؾ� �Ѵ�.
		
		
		String name1 = "�̼���"; // name �� ���� ���� �̼����� ����� �ּ� // ����Ǳ� ������ �ּҰ� ���� �ϴϱ� null������ �����
		String name2 = "�̼���"; 
		
		//�ִ�Ÿ��+���ڿ� => ���ڿ�
		//"7" + 7 = "7" + "7"(���ڿ��� ) => 77
		// ����Ŭ�� ���� �����̱� ������ 14
		
		
		String name3 = new String ("�̼���"); // new �����ڴ� heap�� ����, ��ȣ�� ������ �޼���, �����ڸ޼���� ��ü �ʱ�ȭ
		String name4 = new String ("�̼���");
		//new ���� ������ŭ ������ ����
		
		System.out.println(name1==name2);
		System.out.println(name3==name4);
		
		System.out.println(name3.toString()); // "�̼���" ��� / 
		
				
		Person p1 = new Person ("�̼���");
		System.out.println("p1=" + p1.toString()); // �ּҰ� ���
	}

}


class Person {
	String name;
	
	Person(String name){
		this.name=name;
	}

	
	@Override						//������
	public String toString( ) {
		return name;			
	}
}
