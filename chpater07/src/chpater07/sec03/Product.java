package chap07.sec03;

public class Product {
	int price; // 2) 1000
	int bonusPoint; //3) 100 // 변수는 상속가능 -> 
	//4) 1000과 100을 갖는 price 와 bouusPoint , Tv 클래스에도 그대로 상속됨.
	
	public Product(int price) { // 1) super(1000)의 1000이 여기 price 로
		this.price = price;
		bonusPoint = price/10;
		
	}

}
