package chap07.sec06;

public class UnitExample {
	public static void main(String[] args) {

		Marine marine1 = new Marine();
		marine1.move(200, 700);
		marine1.stimPack();
		
		
		Unit unit1 = new Marine();
		unit1.stop("�غ�", 2, 4);
//		unit1.move(100, 400);
//		�Ǵ� �̷��յ�
		
//		unit1.stimPack(); �̰� �ȵ� ���ֿ��� ������ �� ���� 
	}
}
