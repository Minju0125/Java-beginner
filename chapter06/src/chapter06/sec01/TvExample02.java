package chapter06.sec01;

public class TvExample02 {

	public static void main(String[] args) {
		TvExample tv = new TvExample();
		tv.setCompany("LG");
		tv.setYear(2020);
		tv.setWide("150x200");
		System.out.println(tv);
		
	}

}

class TvExample {
	private String company;
	private int year;
	private String wide;

	//오버로딩 : 같은 이름의 메소드를 매개변수의 타입이나 개수에 따라서 중복 정의
		// - 매개변수에 따라 특정 메소드가 호출되도록 하는것.
	
	// 기본생성자 , 생성자의 역할 : 초기화
	public void TvExample() {
	} // 기본생성자 - new 연산자를 통해 인스턴스화 될 때 호출
	// 매개변수가 있는 생성자가 있을 때에는 자동으로 기본 생성자를 만들어주지 않는다.
	// 따라서 기본생성자 추가해줘야함.

	// 기본 생성자를 추가하지 않으면
	// 존재하지 않는 생성자를 호출하고 있는 셈
	public void TvExample(String company, int year, String Wide) {
		this.company = company;
		this.year = year;
		this.wide = wide;
	}

}