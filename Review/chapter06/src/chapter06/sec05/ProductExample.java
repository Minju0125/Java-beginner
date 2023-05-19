package chapter06.sec05;

public class ProductExample {
	
	public static void main(String[] args) {
		Product p1 = new Product ("볼펜"); 
		System.out.println(p1); // p1.toString 이 생략된것
		
		Product p2 = new Product ("지우개"); // 이렇게 하면 따로 저장공간이 만들어짐
		System.out.println(p2);
		
		Product p3 = new Product ("포스트잇"); // 이렇게 하면 따로 저장공간이 만들어짐
		System.out.println(p3);
		System.out.println(p1);
		
	}

}

//상품 코드는 1001부터 자동생성되어 pid 에 저장
//	이 생성자 메소드에서 
class Product {
	static long pid=1000; //멤버변수는 초기하하지 않으면 자동초기화
	String pName;
	
	Product(){}
	Product(String pName){		 // 객체가 생성될 때 1씩 부여
			pid++;
			this.pName = pName;
	}
	
	@Override
	public String toString() {  // 오버라이드는 반드시 퍼블릭 / 부모가 퍼블릭, 자식은 퍼블릭 보다 좁혀서 사용할 수 없다 , 오버라이드는 재정의
		return "제품번호 : " + pid + "\n제품명 : " + pName ;				// 해당 클래스가 가지고 있는 정보를 문자열로 만들어서 반환 
				
//		게터, 투스트링 메소드
//		게터는 변수하나하나, 투스트링은 얘네를 묶어서
	}
	
	
}