package chap05.sec03;

import java.util.Random;
import java.util.Scanner;

public class Word5Scaramble {

	public static void main(String[] args) {
		WordScramble ws = new WordScramble();
		String str = ws.WordSelection();// 단어 반환 받은 것을 저장 (선택된 단어)
//		System.out.println(str); // 이거만 하면 임의의 문자열(단어) 반환됨
		
		String question = ws.shuffle(str);// str을 가지고 셔플 메소드 호출 (섞인 단어)
		System.out.println("제시어 : " + question); // 제시어
		ws.answer(str);

//	

	}

}

class WordScramble { // 여기서 이건 워크호스 클래스
	private String[] word = { "hope", "apple", "banana", "orange", "love" };

	public String WordSelection() { //반환된 값을 호출
		Random rnd = new Random();
		int idx = rnd.nextInt(5); // 범위 지정해서 난수 발생 (0~4 사이의 정수형 난수)
		return word[idx]; // 반환?한걸 위에서 반환 받아야함

	}

	public String shuffle(String str) {// ** 반환하고자 하는 타입은 문자열이나, // 여기서 괄호한의 string str의믜?
		char[] ch = str.toCharArray(); // 문자열을 문자 배열로 변환 시 사용되는 메소드
		for (int i = 0; i < 1000; i++) { // 1000번 섞음
			int r = (int) (Math.random() * ch.length); // (캐릭터 배열의 크기-1) 만큼
			char temp = ch[0];
			ch[0] = ch[r];
			ch[r] = temp;
			// **여기서 반환되는 타입은 문자 배열이기 때문에 문자열로 변환 해야함
		}

		return (new String(ch));

	}

	public void answer(String question) { // 반환되는거필요없으므로 void
		Scanner sc = new Scanner(System.in);
		int count = 0; // 시도 횟수 - 반복횟수를 예상하고 정해놓지 않은채 반복 할 것이기 때문에 while 문 사용
		while (true) {
			System.out.print("\n정답 : ");
			String str = sc.nextLine(); // 문자열로 입력받음
			count++;
			if (str.equals(question)) {
				System.out.println("*****************");
				System.out.println("정답입니다....");
				System.out.println("시도횟수 : " + count);
				System.out.println("*****************");
			} else {
				System.out.println("*****************");
				System.out.println("정답이 아닙니다....");
			}
			break;
		}

	}

}