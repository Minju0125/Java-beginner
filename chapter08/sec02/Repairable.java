package chapter08.sec02;

public interface Repairable {} // �� �������̽��� �ٵ� ���� -> �������� ������ ���� ! 

class Unit {
	int hitpoint; //����. 0 (�Һ��ϰ� ���� ��) // (hitpoint �� ������ ������ ����ϰ� ���� ������)
	final int MAX_HP; // ���. ����� �Ǳ� ���ؼ��� 1)�ѹ��� = ���� ���� ������ !. ������ ���� �� �ִ� �ִ밪

	Unit(int hp) {
		MAX_HP = hp; //2) �̰� ���� ���� ���� �����. �� ��ü�� �����ڰ� ����� �� �� �ѹ� ���� �������� �� = ���� ����
	}
}

class GroundUnit extends Unit{
	GroundUnit (int hp){
		super(hp); 
	}
}

class AirUnit extends Unit{
	AirUnit (int hp){
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable{
		Tank(){
			super(150);
			
	}
		@Override
		public String toString() {
			return "TANK";
		}
}

class SCV extends GroundUnit implements Repairable{
	SCV(){
		super(150);
}

	@Override
	public String toString() {
		return "SCV";
	}
	
	//150��ŭ �ٽ� ���� (����)
	public void repair(Repairable r) {
		if(r instanceof Unit){ // Tank, Marine, DropShip�� r�� ���� ����. r�� ���� ���°� Unit Ÿ���� ��ü�� ���Գ�?
			Unit u = (Unit)r; // true ��� r�� Unit ��ü�� �ٿ�ĳ�����ض� (��ĳ���� �� �͸� �ٿ�ĳ��Ʈ ����)
			while(u.hitpoint != u.MAX_HP) { // ���� �ʴٸ�
				u.hitpoint++; // hitpoint �������Ѷ�.
			}
			System.out.println(u.toString() + "�� ������ �������ϴ�.");
	} 	//scv.repair(new Tank()); -> ������ .
		// �θ�ü�� �ڽ� Ŭ���� �� ��.
}
}


class Marine extends GroundUnit{ // Repairable �� �θ� �ƴ�.-> ���� ó�� ȣ���� �� ����. -> scv�� �ִ� repair �޼ҵ� ȣ���� �� ����/
		Marine(){
			super(100);
	}
		@Override
		public String toString() {
			return "Marine";
		}
}
	

	

class DropShip extends AirUnit implements Repairable{
		DropShip(){
			super(1);
		}
	

	
	
}

