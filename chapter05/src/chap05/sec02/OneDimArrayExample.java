package chap05.sec02;

public class OneDimArrayExample {

	public static void main(String[] args) {

		int score[] = {80,75,95,80,88};
		
		OneDimArray od = new OneDimArray();
		od.method1();
		System.out.println("\n합계" +od.addArray(score));
//		int sum=od.addArray(score); 
		
			//od 클래스 객체에 addarray score를 ??????

	}

}

class OneDimArray {

	public void method1() {
		// 정수 5개를 저장하는 배열을 생성하고, 10,20,30,40,50을 저장한 후 출력하시오.
		int[] num1 = null;
		num1 = new int [5];
		
//		char[] num2 = new char[5]; // char 는 초기화하지 않았을 경우 공백 출력
								 // boolean은 false 값 출력
		char[] num2;// 배열 선언
		num2 = new char[] {'a','b','c','d','e'};
		
		char[] num4 = new char [] {'a','b','c','d','e'};
		
		char[] num5 = {'a','b','c','d','e'}; // new 가 생략되어진 것 (배열과 string 클래스에서만 생략 가능)
											// 자동으로 컴파일
											// 이걸 가장 많이 씀
		
		boolean[] num3 = new boolean [5]; 
		
		
		for(int i=0; i<num2.length; i++) {
			System.out.print(num3[i] + ",");
		}
		
		System.out.println(num3); // 참조형 변수이기 때문에 일반 값을 저장할 수 없음.
		

	}


	public int addArray(int[] jumsu) {
		int sum = 0;
		for(int i=0; i<jumsu.length; i++) {
			sum+=jumsu[i];
			
		}
		return sum;
	}
}