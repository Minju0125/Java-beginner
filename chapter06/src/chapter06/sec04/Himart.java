package chapter06.sec04;

public class Himart {

	public static void main(String[] args) {
		int sum=0;
		String list = "";
		
		Goods computer = new Goods("computer", 1000);
		Goods audio = new Goods("audio", 300);
		Goods notepad = new Goods("notepad", 600);
		
		Buyer buyer = new Buyer();
		sum = sum + buyer.saleGoods(computer, 2);
		list+=computer.getKind();
		
		sum=sum+buyer.saleGoods(notepad, 1);
		list+=","+ notepad.getKind();
		
		
		System.out.println("구매품목 : " + list);
		
		
	}

}
