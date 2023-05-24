package chap07.sec06;

public abstract class Unit {

	// �̵��ϱ� ���ؼ��� ��ǥ�� �־��
	int x;
	int y;
	String nm; // ������ �̸� / �� ���ֵ��� �����̰� ���� (�غ�, ��ũ)

	Unit(String nm) {
		this.nm = nm;
	}

	public void stop(String nm, int x, int y) {
		System.out.println(nm + "�� " + "(" + x + "," + y + ")�� ����ϴ�.");
	}

	public abstract void move(int x, int y);// ~��ġ�� ����������, �����̴� ����� ���ָ��� �ٸ��Ƿ�.

}

class Marine extends Unit {
	Marine() {
		super("�غ�"); // Marine Ŭ������ü�� ������ ��, Unit Ŭ���� ��ü���� ����� ��
	}

	@Override // �������̵� �� �޼ҵ�
	public void move(int x, int y) {
		System.out.println(nm + "�� (" + this.x + "," + this.y + ")����" 
				+ " (" + x + "," + y + ") ��ġ�� �̵��մϴ�.");
		this.x = x;
		this.y = y; // �̵��� ���� ���⿡ ����
	}

	// ������ ������ �ִ� �����޼ҵ�
	public void stimPack() {
		System.out.println("���ݸ�� :  ������ ����");
	}
}

class Tank extends Unit {
	Tank() {
		super("��ũ"); // Unit Ŭ������ ��ü �������
	}

	@Override
	public void move(int x, int y) {
		System.out.println(nm + "�� ��ġ : (" + x + "," + y + ")");
	}

	public void sizemode() {
		System.out.println("���ݸ�� : ������� ��ȯ");
	}

}
