package chap05.sec02;

public class SortAlgorithmExample {

	public static void main(String[] args) {
		// ���� ���� �迭�� �����ϰ� ũ������� �����Ͻÿ�.
		// �ڷ� : 35,80,25,69,44,51,19,97

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
		for(int i=0; i<target.length-1; i++) { // �� ȸ��
			for(int j=0; j<target.length-1-i; j++) { // �� �࿡�� ��
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