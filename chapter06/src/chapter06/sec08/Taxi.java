package chapter06.sec08;

public class Taxi extends Vehicle {

	int passenger; // ���� ž���ο�

	Taxi() {}
	Taxi(int passenger) {
		this.passenger = passenger;
	}

	@Override // �����ǵ�
	public void run() {
		System.out.println("�°� " + passenger + "���� �¿� ������ �������Դϴ�.");
	}
	// ��ĳ���� ���� �� �갡 ���� ��?����?��?������?������?��
}
