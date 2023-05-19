package chapter06.sec03;

public class AnimalExample {
	public static void main(String[] args) {
		Animal a1 = new Animal(); // 매개변수 없는 애가 호출됐는데
		System.out.println(a1.getKind());

//		a1.setKind("강아지");
//		System.out.println(a1.getKind());
//		
//		Animal a2= new Animal ("고양이"); //생성자 부를 때 매개변수 한개짜리 메소드를 호출하니까
//										// 두번째 기술해놓은 게 호출되는것 (?_)
//		System.out.println(a2.getKind());
//	
	}
}