package chap07.sec03;

public class HiMart {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv t = new Tv();
		Computer c = new Computer();
		SmartPhone s = new SmartPhone();

//		b.buy(t);
//		System.out.println("���� �� : " + b.money);
//
//		b.buy(s);
//		System.out.println("���� �� : " + b.money);
//
//		b.buy(c);
//		System.out.println("���� �� : " + b.money);
		
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		// �깰���� �����ؾ���. -> ������ ���� x, (���ο�� ������ �������°� ������� ��������)
//		-> �迭�� ���� ������ ���� ������ �ȵ� -> arraylist
		
		b.summary();
	}

}
