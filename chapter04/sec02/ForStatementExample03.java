package chapter04.sec02;

public class ForStatementExample03 {

	public static void main(String[] args) {
		ForStatement03 fs03 = new ForStatement03();
		System.out.println("[1번도형]");
		fs03.shape01();
		System.out.println("\n[2번도형]");
		fs03.shape02();
		System.out.println("\n[3번도형]");
		fs03.shape03();
		System.out.println("\n[4번도형]");
		fs03.shape04();
		System.out.println("\n[5번도형]");
		fs03.shape05();
	}
}

class ForStatement03 {

	public void shape01() {
		for (int i = 0; i < 5; i++) { // 행을 담당
			for (int j = 0; j <= i; j++) { // i가 0이면 j는 0부터 // i가 1이면 j는 0부터 1까지 // ...
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void shape02() {
		for (int i = 0; i < 5; i++) { // 행을 담당
			for (int j = 0; j < i; j++) { // 공백 출력
				System.out.print(" ");
			} // 아래 for 문의 j와 다른 j (없어졌다가 다시 생긴 j)

			for (int j = 0; j <= (5 - i); j++) { // "*" 출력 담당
				System.out.print("*"); // (없어졌다가 다시 생긴 j)
			}
			System.out.println();
		}
	}

	public void shape03() {
		for (int i = 0; i < 5; i++) { // 행을 담당
			for (int j = 0; j < (4 - i); j++) { // 공백 출력
				System.out.print(" ");
			} // 아래 for 문의 j와 다른 j (없어졌다가 다시 생긴 j)

			for (int j = 0; j <= (i * 2) + 1; j++) { // "*" 출력 담당
				System.out.print("*"); // (없어졌다가 다시 생긴 j)
			}
			System.out.println();
		}
	}

	public void shape04() {
		for (int i = 0; i < 5; i++) { // 행을 담당
			for (int j = 0; j < (4 - i); j++) { // 공백 출력
				System.out.print(" ");
			} // 아래 for 문의 j와 다른 j (없어졌다가 다시 생긴 j)

			for (int j = 0; j <= i; j++) { // "*" 출력 담당
				System.out.print("*"); // (없어졌다가 다시 생긴 j)
			}
			System.out.println();
		}
	}

	public void shape05() {
		for (int i = 0; i < 5; i++) { // 행을 담당

			for (int j = 0; j < (5 - i); j++) { // "*" 출력 담당
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
