package chapter06.sec02.exam03;
// Car �����ڸ� �����ε� �ؼ� CarExample Ŭ�������� �پ��� ������� Car ��ü�� �����ϵ���.

public class Car {
	
	String company = "�����ڵ���";
	String model;
	String color;
	int maxSpeed; // ����ʵ�� �ʱ�ȭ���� ������ �ڵ� �ʱ�ȭ �Ǿ�, Sting ���� ""����, int ���� 0���� ��.
	
	Car () {}
	Car (String model) {
		this.model = model; // ���ڿ� ������ model ���� �޾�, this.model�� �ְڴ� ! -> ���⼭ ���� ������ ���� ����ʵ� model �� �ʱ�ȭ
	}
	
	Car (String model, String color){
		this.model = model;
		this.color = color; //�̷��� �ᵵ ������ ���ŷο� (�ڵ� �ߺ�)
	}
	
	Car (String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	

}



