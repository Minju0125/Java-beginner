package chap07.sec04;

public abstract class Shape {

	String kind;// 도형의 종류
	
	Shape(String kind){
		this.kind = kind;
	}
	
	//draw라는 메소드
	public abstract void draw(); // 이게 추상메소드 -> 삼각형, 사각형, 오각형마다 그리는 방법은 다르니까 추상멧소드로 정의함
	
	@Override // 추상메소드를 상속받는 
	public String toString() {
		return kind; // ?
		
	}
}
