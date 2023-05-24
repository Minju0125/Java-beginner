package chap07.sec06;

public class UnitExample {
	public static void main(String[] args) {

		Marine marine1 = new Marine();
		marine1.move(200, 700);
		marine1.stimPack();
		
		
		Unit unit1 = new Marine();
		unit1.stop("해병", 2, 4);
//		unit1.move(100, 400);
//		또는 이렇겐데
		
//		unit1.stimPack(); 이건 안됨 유닛에서 지정할 수 없음 
	}
}
