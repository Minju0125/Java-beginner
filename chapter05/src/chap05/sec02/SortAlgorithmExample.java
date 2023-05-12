package chap05.sec02;

public class SortAlgorithmExample {

	public static void main(String[] args) {
		// 다음 수를 배열에 저장하고 크기순으로 정렬하시오.
		// 자료 : 35,80,25,69,44,51,19,97

		int[] source = { 35, 80, 25, 69, 44, 51, 19, 97 };
		sortAlgorithm sa = new sortAlgorithm();
		sa.bubbleSort(source);

	}

}

class sortAlgorithm {
//	int[] source = new int [8] ;

	public void bubbleSort(int[] target) {
		boolean flag = false;
		int cnt = 0;
		for(int i=0; i<target.length-1; i++) { // 각 회전
			for(int j=0; j<target.length-1-i; j++) { // 한 행에서 비교
				if(target[j]>target[j+1]) {
					int temp = target[j];
					target[j] = target[j+1];
					target[j+1] = temp;
					flag =true;
				}
			}
			if (!flag) break;
		}
		for(int i=0; i<target.length; i++) {
			System.out.printf("%5d", target);
		}
		
		
	}
}