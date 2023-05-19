package chapter06.sec01;

public class CircleExample {

	public static void main(String[] args) {
		Circle circle = new Circle() ;
		circle.radius=10.2;
		circle.x=300;
		circle.y=500;  // circle에 있는 radius,x,y를 초기화하겠다?
		
		/* Circle 클래스에서 radius, x, y가 모두 디폴트로 설정되었다. chapter06이라는 동일한 패키지에 존재하기 때문에 불러올 수 있음.
		 *  (자기 클래스에서만 쓸 수 있는 private을 썼다면 여기서 못씀)
		 */
		
		
		circle.getPoint(); 
		//getPoint() 메소드를 실행하고, 해당 메소드가 끝나면 반환값을 가지고 다시 여기로 돌아옴 => 출력 명령이 있었기 때문에 여기서 이 메소드의 반환값은 프린트스크린 어쩌구
		circle.getCircumference(); 
		 
		
		
		// 아래 둘중 한가지 방법
		double res = circle.getArea();
//		System.out.println("원의 넓이 : " + circle.getArea();
	}

}
