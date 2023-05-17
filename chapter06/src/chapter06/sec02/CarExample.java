package chapter06.sec02;

public class CarExample {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.setCompany("르노 자동차");
		c1.setAuto(true); //?
		System.out.println(c1); // 왜 자동만 나옴?
	}

}

class Car {
	private String company;
	private boolean isAuto; // 오토? true/false

	// Car class의 생성자 메소드 만들기
	Car() {
	}

	Car(String company, boolean isAuto) {
		this.company = company;
		this.isAuto = isAuto;

	}

	// 위 메뉴에 Source- 메뉴에 있음

	/*
	 * set 메소드 위의 멤버 변수의 값을 설정할 때 사용 (변경. 업데이트) (초기화할 때는 생성자 메소드 사용) 초기화 된 값을 변경할 때
	 * 사용 이거 쓰면 저 위에 있는 값을 변경 company, isAuto ex) 변경할 회사명을 가져와서 (매개변수) 저 위에 있는 멤버변수에
	 * 넣어줌
	 */

	public void setCompany(String company) {
		this.company = company;
	}

	public void setAuto(boolean isAuto) {
		this.isAuto = isAuto;
	}
	
	@Override
	public String toString() {
		String gearType=""; // 이 줄이 이해 안감
		if(isAuto) {// 참이면 // ?????아 !!
			gearType = "자동";
		}else {
			gearType = "수동";
		}
		return gearType;
	}

}
