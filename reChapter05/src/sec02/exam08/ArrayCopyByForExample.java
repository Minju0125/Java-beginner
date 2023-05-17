package sec02.exam08;

public class ArrayCopyByForExample {
// 배열 복사
	public static void main(String[] args) {
		int[] oldIntArray = { 1, 2, 3 };
		int[] newIntArray = new int[5];// new 연산자로 배열을 처음 생성할 경우 배열은 자동적으로 기본값으로 초기화된다.

		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
				//oldIntArray[0], oldIntArray[1]. oldIntArray[2] 값이 다섯칸 짜리 newIntArray 배열에 들어감  
				//값이 들어가지 않은 newIntArray[3], newIntArray[4]에는 0이 들어감
					//int 배열은 초기값 0, String 배열은 초기값 null
		}
		for (int i = 0; i < newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ",");
		}

	}

}
