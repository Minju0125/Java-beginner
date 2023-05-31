package chapter11.sec02;

import java.util.ArrayList;

public class ArrayListExample02 {

	public static void main(String[] args) {
		// 제너릭 : 컬렉션 프레임 워크 객체에 저장되는 데이터를 제한함
		// 입력자료를 검사하여 오류를 최소화 시킴
		// 사용형식
		// 컬렉션객체 <타입> 변수 = new 컬렉션객체 <타입>();
		// -> 여기 이 <타입>은 객체 타입이어야함. (하나의 객체 종류만)
		// <타입>을 기술하면 입력하는 데이터 타입이 이 타입으로 제한됨.

		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동"); // String을 상속받는 객체는 ㄱㅊ
		list.add("대전시 중구 계룡로 846");
//		list.add(100); // 데이터가 문자열이 아니면 입력 불가능함 !!!!
//		list.add(new Person("정몽주")); // 불가능함. (괄호안의 타입이 String 으로 제한되어있기 때문에)
		
		ArrayList<Person> list1 = new ArrayList<Person> (); // 아까 만든 Pesron 클래스 객체만 가능
		
	}

}
