package chap07.sec04;

public abstract class Shape {

	String kind;// ������ ����
	
	Shape(String kind){
		this.kind = kind;
	}
	
	//draw��� �޼ҵ�
	public abstract void draw(); // �̰� �߻�޼ҵ� -> �ﰢ��, �簢��, ���������� �׸��� ����� �ٸ��ϱ� �߻��ҵ�� ������
	
	@Override // �߻�޼ҵ带 ��ӹ޴� 
	public String toString() {
		return kind; // ?
		
	}
}
