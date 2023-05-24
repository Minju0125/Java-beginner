package chapter05.sec02.exam09;

public class ArrayCopyExample {

	public static void main(String[] args) {
		
		String[] oldStrArray = {"java", "array", "copy"};
		String[] newStrArray = new String[5]; // new 연산자를 이용해 배열을 생성했을 경우, 초기화값이 기본적으로 할당된다.
											// String 배열이기 때문에 초기값은 null 값

		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
			// 이 메소드의 의미는 oldStrArray의 0번째 인덱스 복사하여, newStrArray의 0번째 로 붙여넣겠다. oldStrArray의 길이만큼 !
		
		for(int i = 0; i<newStrArray.length; i++) {
			System.out.print(newStrArray[i]+",");
		}
		
	}

}
