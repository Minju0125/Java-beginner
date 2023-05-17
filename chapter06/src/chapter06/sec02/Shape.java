package chapter06.sec02;

public class Shape {
	
	
	String kind = "오각형"; // 도형의 종류
	int height = 50;
	int width = 15; // 직접초기화

	// 초기화 블록 사용
	{
		kind = "타원형";
		height = 70;
	} // 직접 초기화 된 데이터가 없어지고 여기서 초기화한 데이터가 들어감

	Shape(String kind, int width) {
		this.kind = kind;
		this.width = width; // 생성자 메소드 - 최종적으로 적용
	}

	
//세방법의 순서가 바뀌어도 생성자 메소드로 초기화 한 값이 출력?????????????
	
	@Override // 잘 모르겠움
	public String toString() {
		return "도형 : " + kind + "\n가로 : " + width + "\n세로 : " + height;
	}

}
