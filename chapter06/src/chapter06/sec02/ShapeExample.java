package chapter06.sec02;

public class ShapeExample {

	public static void main(String[] args) {
	Shape s1= new Shape("삼각형", 100);
	System.out.println(s1);
	
	Shape s2= new Shape("사각형", 10);
	System.out.println(s2);


//	Shape s2= new Shape();
//	System.out.println(s2.kind); 
					//멤버변수는 객체가 생성될 때 초기화 !
					// 이 때 여기 안에 있는 변수 kind, width, height 가 다 초기화 일어남	근데 직접 부여하니까 오각형
	
	
	}

}
