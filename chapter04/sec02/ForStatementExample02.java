package chapter04.sec02;

import java.util.Scanner;

public class ForStatementExample02 {

	public static void main(String[] args) {
		ForStatement02 fs02 = new ForStatement02();
//		fs02.numberOfVowels();
		fs02.fibonacciNumber();

	}

}

class ForStatement02 {
	Scanner sc = new Scanner(System.in); // 스캐너는 클래스 타입

	public void numberOfVowels() {

//(예제 6)  키보드로 단어를 입력 받아 단어에 포함된 모음 (a,e,i,o,i)의 수를 출력하시오.
//		메소드 안에서 선언되는 지역변수 선언할 때에는 반드시 초기화해야함.
//		문자의 수를 체크할 때에는 1부터 카운팅 (length) // index 는 순번인데 0번부터 -> length보다 index는 하나 작은 수
//		string 문자열에서 한글자 추출 -> char (문자)
//		charAt(인덱스) 인덱스 위치의 글자를 하나 추출해서 캐릭터로 반환하시오 라는 메소드
//		스트링 클래스에 속한 한글자 문자를 반환하는 메소드

		int count = 0; // 모음의 갯수 세기 위해

		System.out.println("단어 입력 : ");
		String word = sc.nextLine();

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' 
				|| word.charAt(i) == 'i' || word.charAt(i) == 'o'
				|| word.charAt(i) == 'u') {
				count++;
				}
		}

		System.out.println(word + "에 포함된 모음의 수는 " + count);

	}

//	예제 7 ) 1-50 사이에 존재하는 fiboncacci 수열을 출력하시오.
//	** fibonacci 수열 : 첫 수와 두번째수가 1로 주어지고 그 다음부터 전 두수의 합이 현재수가 되는 수열
//		==> 자료 검색 알고리즘에 사용 (피보나치 검색)

	public void fibonacciNumber() {
		int ppNum = 1; // 전전수
		int pNum = 1; // 전수
		int currNum = 0; // 현재수

		System.out.printf("%3d%3d", 1, 1); // 형식지정 문자열 지정 % // 3d 를 두번 출력할것이기 때문에 ,1,1
		for (int i = 1; i < 50; i++) { // 여기서 i는 아무의미 없고 카운팅만 해주는 수
			currNum = ppNum + pNum;
			if (currNum >= 50) {
				break; // break 자기가 속한 반복문 (for문). switch-case 나감.
			} else {
				System.out.printf("%3d", currNum);
				ppNum = pNum; // 아래줄과 순서 바뀌면 x - 주의하기 !
				pNum = currNum;
			}

		}
	}
}

