package chap07.sec03;

public class HiMart {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv t = new Tv();
		Computer c = new Computer();
		SmartPhone s = new SmartPhone();

//		b.buy(t);
//		System.out.println("남은 돈 : " + b.money);
//
//		b.buy(s);
//		System.out.println("남은 돈 : " + b.money);
//
//		b.buy(c);
//		System.out.println("남은 돈 : " + b.money);
		
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		// 산물건을 보관해야함. -> 변수르 쓰면 x, (새로운게 들어오면 먼저들어온게 사라지기 때문ㅇㅔ)
//		-> 배열을 쓰면 고정된 길이 때문에 안됨 -> arraylist
		
		b.summary();
	}

}
