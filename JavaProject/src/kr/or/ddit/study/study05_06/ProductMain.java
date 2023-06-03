package kr.or.ddit.study.study05_06;

public class ProductMain {

	public static void main(String[] args) {
		/*
		 * 문제)
		 * 
		 * Product 클래스를 이용하여 상품3개를 만들어주세요.
		 * - notebook, phone, tablet 을 만들어주세요.
		 * 
		 * [notebook]
		 * 상품ID : P001
		 * 상품명 : 대덕노트북
		 * 가격 : 1500000
		 * 재고수 : 100
		 * 
		 * [phone]
		 * 상품ID : P002
		 * 상품명 : 대덕핸드폰
		 * 가격 : 1100000
		 * 재고수 : 100
		 * 
		 * [tablet]
		 * 상품ID : P003
		 * 상품명 : 대덕태블릿
		 * 가격 : 700000
		 * 재고수 : 100
		 * 
		 * */
	
		Product notebook = new Product("P001", "대덕노트북");
		
		notebook.setPrice(1500000);
		notebook.setStock(100);
		
		System.out.println("상품ID : " + notebook.id); //이건 메소드를 활용안하고 변수를 사용한 것
		
		System.out.println("[notebook]");
		System.out.println("상품ID : " + notebook.getId());
		System.out.println("상품명 : " + notebook.getName());
		System.out.println("가격 : " + notebook.getPrice());
		System.out.println("재고수 : " + notebook.getStock());
		System.out.println();
		
		Product phone = new Product("P002", "대덕핸드폰");
		phone.setPrice(1100000);
		phone.setStock(100);
		
		System.out.println("[phone]");
		System.out.println("상품ID : " + phone.getId());
		System.out.println("상품명 : " + phone.getName());
		System.out.println("가격 : " + phone.getPrice());
		System.out.println("재고수 : " + phone.getStock());
		System.out.println();
		
		Product tablet = new Product("P003", "대덕태블릿");
		tablet.setPrice(700000);
		tablet.setStock(100);
		
		System.out.println("[tablet]");
		System.out.println("상품ID : " + tablet.getId());
		System.out.println("상품명 : " + tablet.getName());
		System.out.println("가격 : " + tablet.getPrice());
		System.out.println("재고수 : " + tablet.getStock());

		
	
	}
	
	

}
