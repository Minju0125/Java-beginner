package kr.or.ddit.study.study05_06;

public class Product {
	/* 문제1)
	 * 
	 * 필드를 만들어주세요.
	 * - 문자열 타입의 id			//상품ID
	 * - 문자열 타입의 name			//상품명
	 * - 정수형 타입의 price			//가격
	 * - 정수형 타입의 stock			//재고수
	 * 
	 * 생성자를 만들어주세요.
	 * - 기본생성자를 만들어주세요
	 * - 상품 ID와 상품명을 받는 Custom 생성자를 만들어주세요.
	 * 
	 * 함수를 만들어주세요.
	 * - 상품 ID를 가져오는 함수를 만들어주세요. (getID)
	 * - 상품 ID를 저장할 함수를 만들어주세요. (setID)
	 * - 상품명을 가져오는 함수를 만들어주세요. (getName)
	 * - 상품명을 저장할 함수를 만들어주세요. (setName)
	 * - 가격을 가져오는 함수를 만들어주세요. (getPrice)
	 * - 가격을 저장할 함수를 만들어주세요. (setPrice)
	 * - 재고수를 가져오는 함수를 만들어주세요. (getStock)
	 * - 재고수를 저장할 함수를 만들어주세요. (setStock)
	 * 
	 */
	
	String id;
	String name;
	int price;
	int stock;
	
	public Product(){} 
	
	public Product(String id, String name){
		this.id = id;
		this.name = name;
	}

	public String getId() { //값을 가져올때 . getter를 호출하는 순간 값을 가져올 수 있음
		return id;
	}

	public void setId(String id) { //값을 저장
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
