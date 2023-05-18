package chapter06.sec04;

public class Goods {
	private String kind; // 제품 종류
	private int price;
	
	// 생성자 메소드
	Goods(){} // 기본 생성자 메소드
	Goods(String kind, int price){
		this.kind = kind;// 상품 종류를 위에 넣어줌
		this.price = price; // 상품 가격을 위에 넣어줌
	}
	
	
	public String getKind() {
		return kind;
	}
	
	public int getPrice() {
		return price;
	}
	
}
