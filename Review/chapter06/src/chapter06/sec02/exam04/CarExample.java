package chapter06.sec02.exam04;

public class CarExample {

	public static void main(String[] args) {
		Car c1 = new Car(); // �Ű����� ���� ������ ����
		System.out.println("c1.company : " + c1.company);
//		System.out.println(c1); // �̰� ������ ->  chapter06.sec02.exam03.Car@15db9742 ��� ��ü�� ����� �ּҰ� ���� !
		System.out.println("c1.model : " + c1.model);
		System.out.println("c1.color : " + c1.color);
		System.out.println("c1.maxSpeed : " + c1.maxSpeed);
		System.out.println();
		
		Car c2 = new Car("�ƹݶ�"); // �Ű����� 1��¥�� ������ ����
		System.out.println("c2.company : " + c2.company);
		System.out.println("c2.model : " + c2.model);
		System.out.println("c2.color : " + c2.color);
		System.out.println("c2.maxSpeed : " + c2.maxSpeed);
		System.out.println();


		Car c3 = new Car("�׷���", "����"); // �Ű����� 2��¥�� ������ ����
		System.out.println("c3.company : " + c3.company);
		System.out.println("c3.model : " + c3.model);
		System.out.println("c3.color : " + c3.color);
		System.out.println("c3.maxSpeed : " + c3.maxSpeed);
		System.out.println();


		Car c4 = new Car("�ҳ�Ÿ", "����", 200); // �Ű����� 3��¥�� ������ ����
		System.out.println("c4.company : " + c4.company);
		System.out.println("c4.model : " + c4.model);
		System.out.println("c4.color : " + c4.color);
		System.out.println("c4.maxSpeed : " + c4.maxSpeed);
		
		
	}

}