package chap05.sec02;

import java.util.Scanner;

public class OneDimArrayExample02 {
	public static void main(String[] args) {
		OneDimArray02 od2 = new OneDimArray02();
		od2.setName(); // 입력하기 위해 호출
		od2.getName(); //
		od2.exchange();
	}
}

//예제 2. 키보드로 5명의 친구이름 입력 받아 배열에 저장하고 역순으로 출력하시오.
//예제 3, 예제 2의 첫번째 친구이름과 마지막 친구 이름을 서로 바꾸시오.
class OneDimArray02 {
	Scanner sc = new Scanner(System.in);
	String[] name = new String[5]; // name 은 멤버변수라 동일 클래스 안에서 가능

// 여기서 name 은 문자열이 들어있는 주소값이 들어가있음  -주소를 따라가면 문자열이 저장되어있는 다섯개의 기억공간 존재함
// 키보드로 입력받으라고 했으니까 기억공간 만들어야함/

	public void setName() {// name 은 멤버변수라 동일 클래스 안에서 가능하기때문에 setName()안에 Name 안써도 됨
		for (int i = 0; i < name.length; i++) {
			System.out.print((i + 1) + "친구 이름 입력 : ");
			name[i] = sc.nextLine();
		}

	}

	public void getName() {
//		for(int i=name.length-1; i>=0; i--) {
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[(name.length - 1) - i]);

		}

	}

	public void exchange() {
		String temp = null;
		temp = name[0];
		name[0] = name[4];
		name[4] = temp;

		for (String str : name) {
			System.out.printf("%5s", str);
		}
	}

}