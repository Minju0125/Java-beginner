package chapter06.sec02;

public class CarExample {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.setCompany("���� �ڵ���");
		c1.setAuto(true); //?
		System.out.println(c1); // �� �ڵ��� ����?
	}

}

class Car {
	private String company;
	private boolean isAuto; // ����? true/false

	// Car class�� ������ �޼ҵ� �����
	Car() {
	}

	Car(String company, boolean isAuto) {
		this.company = company;
		this.isAuto = isAuto;

	}

	// �� �޴��� Source- �޴��� ����

	/*
	 * set �޼ҵ� ���� ��� ������ ���� ������ �� ��� (����. ������Ʈ) (�ʱ�ȭ�� ���� ������ �޼ҵ� ���) �ʱ�ȭ �� ���� ������ ��
	 * ��� �̰� ���� �� ���� �ִ� ���� ���� company, isAuto ex) ������ ȸ����� �����ͼ� (�Ű�����) �� ���� �ִ� ���������
	 * �־���
	 */

	public void setCompany(String company) {
		this.company = company;
	}

	public void setAuto(boolean isAuto) {
		this.isAuto = isAuto;
	}
	
	@Override
	public String toString() {
		String gearType=""; // �� ���� ���� �Ȱ�
		if(isAuto) {// ���̸� // ?????�� !!
			gearType = "�ڵ�";
		}else {
			gearType = "����";
		}
		return gearType;
	}

}
