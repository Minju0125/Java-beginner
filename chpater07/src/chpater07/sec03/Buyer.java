package chap07.sec03;

import java.util.ArrayList;

public class Buyer {
	int money;
	int bonusPoint;

	ArrayList<Product> cart = new ArrayList<Product>();

//	Product[] cart = new Product[10]; /// 카트에 상품 들어감 - 스마트폰, 컴퓨터, 티비 가 들어감- product 타입을 상속받음
	// product 타입의 배열을 넣을 수 있는 배열이 만들어짐 - > 객체 생성 안됨
	// 생성된 객체를 담을 수 있는 배열만 만들어짐
	int i = 0; // 카트 배열에 사용할 인덱스

	Buyer() {
		money = 5000;
		bonusPoint = 0;
	}
	// 다형성은 부모클래스 이름으로 자식클래스 객체를 불러다 쓰는 것
	// 부모클래스 타입의 변수
	// 매개변수 형태로 다형성 지원되는 경우가 가장 많음
	// 실행파일에서는 자식클래스 이름의 객체를 가지고 자식클래스에 넣어주고, 받는 건 부모클래스로 받음
	// ** 메소드와 변수는 부모클래스 타입을 쓴다

	void buy(Product p) { //
		cart.add(p);
		// p타입으로는 자식클래스에서 유일하게 정의해놓은 ex 기능 , 램 은 접근 할 수 없다.
		// 자식클래스에서 고유하게 정의해놓은 것 -> 부모이름으로 접근 할 수 있는건 부모클래스에서 선언해놓은 변수와 메소드
		// 부모클래스 이름으로 매개변수p 정의 했더니 -> buy 메소드 많을 필요 없음
		// 프로덕트 클래스를 상속받지 않는 상품은 매장에 존재하지 않음. 따라서 바이 메소드는 하나만 있으면 됨
		// 얘들을 판매했다면, 판매에 대한 결과 출력하려고 필요한 절차 수행 위해 일반 변수로 구매금액합계, 구매목록 계산하려고 했더니
		// 일반 변수로는 불가능(?)
		// 구매된 목록을 보관하려면 (왜 보관이 필요? 반품할 수 있기 떄문에) - > 구매목록에 있는 것들 반품
		// 판매수량도 정리할 수 있음
		// tv, computer, tv 가 아니라 tv2, copmuter 1개로 정리가능
		// -> 이건 product 클래스에 가격, 보너스만 했지만, 판매수량을 멤버변수로 정의하고 구매수량을 입력받아서 이 값을 넣어주면 됨.
		// (수량체크 가능) .. 나중에.......................
		// list 라는 스트링 변수에 저장 가능 -> 단순히 목록만 사용 가능하지만, 나중을 위해 배열에 저장 - 배열에 저장해도 refund 할 수 있음
		
		// 배열은 크기 고정해야함. 크기가 가변적인 arraylist 사용할거임(배열이긴 한데 크기가 가변적임, 그리고 저장할 수 있는 데이터타입도 다양하게 운용가능)
		// 배열은 배열로 선언된 객체타입만 저장가능함
		// 꺼내올때는 get 메소드, 넣을 때는 add method 사용 .
		// 취급하고자 하는 변수의 타입 사용
		// add 하면 차례대로 인덱스 부여 되어 자동으로 차례대로 (배열크기도 안정해줘도 되고 , i++ 이렇게 안해도 됨)
		
		// 기능이 강화된 for 문을 쓰면 제어변수 없이 꺼내올 수도 있음
		
		
		// money = money - p.price;
//		bonusPoint += p.bonusPoint;
//		cart[i++] = p;

		// 카트 배열이 10개 만들어지는데,
//		System.out.println(p + "를 구입했습니다.");
	}

//	
//	void buy(Tv t) {
//		money = money - t.price;
//		bonusPoint += t.bonusPoint;
//		System.out.println(t + "를 구입했습니다.");
//	}
//
//	void buy(Computer c) {
//		money = money - c.price;
//		bonusPoint += c.bonusPoint;
//		System.out.println(c + "를 구입했습니다.");
//	}
//
//	void buy(SmartPhone s) {
//		money = money - s.price;
//		bonusPoint += s.bonusPoint;
//		System.out.println(s + "를 구입했습니다.");
//	}

	void summary() { // 전체구매금액합계
		int sum = 0;
		String list = "";// 구매목록

		for (int i = 0; i < cart.size(); i++)
//		for (Product p : cart) {
			if (cart.get(i) != null) {
				sum = sum + cart.get(i).price;
				bonusPoint += cart.get(i).price / 10;
				list += cart.get(i).toString() + ", "; // p.toString 인데 생략된것 -> 문자열 출력
			}
		System.out.println("구매목록 : " + list);
		System.out.println("구매금애 합계 : " + sum);
		System.out.println("보너스포인트 : " + bonusPoint);
		System.out.println("남은 돈 : " + (money - sum));

	}
}
