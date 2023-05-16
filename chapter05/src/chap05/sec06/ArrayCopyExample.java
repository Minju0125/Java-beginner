package chap05.sec06;

import java.util.Arrays;

public class ArrayCopyExample {

	public static void main(String[] args) {
//		ArrayCopy ac = new ArrayCopy();// 객체 생성
//		ac.method1();
		DeepCopy dc = new DeepCopy();
//		dc.method1();
//		dc.method2();
		dc.method3();
	}

}

class ArrayCopy {
	// 옅은 복사
	public void method1() {
		int[] num = { 10, 20, 30, 40, 50 };
		for (int su : num) {
			System.out.println(su);
		}
		System.out.println("------------");
		method2(num);
		for (int su : num)// 이거 이해 안됨
			System.out.println(su);
	}

	public void method2(int[] tar) { // 주고 받는 다는게 무슨 의미
		tar[2] = 1000;

	}

}

class DeepCopy {
	// 1 for 문 이용
	public void method1() {
		int[] num = { 100, 200, 300, 400, 500 };
		int[] tar = new int[5];

		for (int i = 0; i < num.length; i++) {
			tar[i] = num[i];
		}
		tar[2] = 1000; // 여기서 바꿔도 원본 배열에서 변경되지 않음.
		System.out.println("num : " + Arrays.toString(num)); // Arrays 라는 클래스를 이용해서 배열명을 매개변수로.
		System.out.println("tar : " + Arrays.toString(tar));
	}

	public void method2() {
		int[] num = { 10, 20, 30, 40, 50 };
		int[] tar = new int[5];
		System.arraycopy(num, 0, tar, 0, num.length);

		tar[2] = 1000;
		System.out.println("num : " + Arrays.toString(num));
		System.out.println("tar : " + Arrays.toString(tar));
	}

	//3 clone 메소드
	public void method3() {
		int[] num = { 1, 2, 3, 4, 5 };
		int[] tar = new int[5];
		tar = num.clone(); // clone 객체 복사, 배열 복사 (object 클래스에 있음)

		tar[2] = 1000;
		System.out.println("num : " + Arrays.toString(num));
		System.out.println("tar : " + Arrays.toString(tar));
	}

}
