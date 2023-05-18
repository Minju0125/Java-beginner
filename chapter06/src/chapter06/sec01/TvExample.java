package chapter06.sec01;

public class TvExample {
//문제5 ] 
//	main 메소드를 실행시켰을 때 제조회사, 생산년도, 크기를 출력하는 TV 클래스를 작성하시오
//	-tv클래스는 워크호스 클래스
//	-실제 출력하는건 코치 클래스

	public static void main(String[] args) {
		PrintTv p1 = new PrintTv("삼성", 2023, "300x200");
		System.out.println(p1);

//		PrintTv p2 = new PrintTv();
//		p2.setCompany("LG");
//		p2.setYear(2020);
//		p2.setWide("150x200");
//		System.out.println(p2);
		/*
		 * 이
		 * 렇게 쓰려면 public PrintTv() { }
		 * 
		 * public PrintTv(String company, int year, String Wide) { this.company =
		 * company; this.year = year; this.wide = wide; }
		 *  * 이렇게 써야함
		 * 
		 */

	}
}

class PrintTv {
	private String company;
	private int year;
	private String wide; // 멤버변수 있고, 값을 집어 넣어야함

	// 객체지향 방법은 주로 생성자 메소드
	//
	// 출력 내용이 몇개 안될 때에는 오버라이드 투 스트링 써도 됨
	// 너무 길어지면 별도의 출력메소드 작성하는게 좋음

//	public PrintTv() { // -> 이걸 왜 하더라?
//	} // 생성자 오버로딩은 클래스 이름과 생성자의 이름이 같아야 한다. 

	public PrintTv(String company, int year, String Wide) {
		this.company = company;
		this.year = year;
		this.wide = wide;
	} // public PrintTv() 두개의 사용을 잘 모르겠음

//	public void setCompany(String company) {
//		this.company = company;
//	}
//
//	public void setYear(int year) {
//		this.year = year;
//	}
//
//	public void setWide(String wide) {
//		this.wide = wide;

	// 이걸 왜 하더라

	// this, ovveride??

	@Override
	public String toString() {

		return "제조회사 : " + company + "\n년도 : " + year + "\n크기 : " + wide;
	}

}
