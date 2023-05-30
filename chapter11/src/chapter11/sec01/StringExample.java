package chapter11.sec01;

import java.sql.Wrapper;

public class StringExample {

	public static void main(String[] args) {
		//1. substring(int sindex, int eindx)
		//2. 기본 데이터타입 => 문자열로 변환
		//	=> String.valueOf(기본타입자료);
		//  => 기본 데이터 타입 + ""
		
		// int 100을 문자열로 변환
		String str1 = String.valueOf(100); //그럼 이 100이 문자열로 변환되어 저장됨
		String str2 = 100 + "" ; //이렇게 해도 100이 문자열로 변환됨 (기본데이터+문자열의 결과는 문자열)
		
		///////////////////////////////////////////////////////////////////////////////
		// 문자열을 => 기본 데이터 타입으로 변환 (wrapper 클래스 사용)
		// Wrapper.parse 기본타입명 (해당문자열) 괄호안의 문자열 자료를 기본타입으로 바꾸어줌
		// 기본타입에 해당되는 Wrapper 클래스를 사용해야함 ! (wrapper 클래스는 8가지 존재) Wrapper 클래스 첫글자는 대문자
		
		// 25.5 를 문자열로 변환
		double num1 = Double.parseDouble("25.5");
		

	}

}
