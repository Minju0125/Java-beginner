package kr.or.ddit.study;

import java.util.Random;

public class study04 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 반복문 while 연습해보기 반복문 while 문을 이용해서 0-9까지의 숫자를 차례대로 출력해봅시다.
		 */

		int a = 0;
		while (a < 10) {
			System.out.println(a + "");
			a++;
		}

		System.out.println();
		// 무한반복되는 while문을 만들 수 있다.
		// while(true) : 무한반복을 실행하는 while문
		// 무한반복되는 while문 안에서 조건절을 통해 빠져나오기
		// 0-100까지의 % 달성률에 따라 콘솔창에 결과가 출력되고 100%일 떄 종료시켜봅시다.

		while (true) { // 무조건 참 조건이기 떄문에 반복문 while 이 무한반복된다.
			a++;
			if (a == 30) {
				System.out.println(a + "% 달성했습니다! ");

			} else if (a == 50) {

				System.out.println(a + "% 달성했습니다! ");
			} else if (a == 80) {

				System.out.println(a + "% 달성했습니다! ");
			} else if (a == 100) {
				System.out.println(a + "% 달성했습니다! ");
				System.out.println("무한 반복중인 while 문을 종료합니다!");
				break;
			}

		}

		/*
		 * 핸드폰 배터리 잔량에 따라서, 핸드폰 상태가 출력됩ㄴ디ㅏ. 이때, 배터리 잔량이 10% 미만일 때는 급속 충전기가 연결이 되어 배터리
		 * 잔량이 100%가 됩니다. 하지만, 배터리 잔량이 0%가 될때는 핸드폰이 종료횝니다.
		 * 
		 * [배터리 잔량에 따른 결과 출력] 내 배터리 잔량이 0% 일때 : [상태] 배터리가 없습니다. 핸드폰을 종료합니다. 잔량이 10% 이상
		 * 30% 미만 : [상태] 배터리 충전이 필요합니다! 잔량이 30% 이상 50% 미만 : [상태] 배터리가 충분치 않습니다! 잔량이 50%
		 * 이상 80% 미만 : [상태] 배터리가 아직은 버틸만 합니다! 잔량이 80%이상 100% 미만 : [상태] 배터리가 아주 충분합니다.
		 * 잔량이 100%일 때: [상태] 배터리 Full 충전!
		 */

		int battery = 0;
		while (true) { // 무한반복
			battery = new Random().nextInt(101);
			System.out.printf("[잔량%d]", battery);

			if (battery >= 1 && battery < 10) {
				System.out.println("[상태] 급속 충전기 연결");
				for(int i=0; i<10; i++) {
					Thread.sleep(200);
					System.out.print("■");
				}
				
			} else if (battery >= 10 && battery < 30) {
				System.out.println("[상태] 배터리 충전이 필요합니다!");
			} else if (battery >= 30 && battery < 50) {
				System.out.println("[상태] 배터리가 충분치 않습니다!");
			} else if (battery >= 50 && battery < 80) {
				System.out.println("[상태] 배터리가 아직은 버틸만 합니다!");
			} else if (battery >= 80 && battery < 100) {
				System.out.println("[상태] 배터리가 아주 충분합니다.");
			} else if (battery == 100) {
				System.out.println("[상태] 배터리 Full 충전!");
			}
			if (battery == 0) {
				System.out.println("[상태] 배터리가 없습니다. 핸드폰을 종료합니다!");
				break;
			}
			
			Thread.sleep(300);

		}
	}
}
