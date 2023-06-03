package kr.or.ddit.study;

import java.util.Arrays;

public class study05 {

	public static void main(String[] args) {
		/*
		 * 배열이란?
		 * 
		 * - 배열은 참조타입으로, 학생들의 이름, 나이, 성적 등의 숨 낳은 데이터를 효율적으로 넣을 수 있는 공간이다. - 배열은 같은 타입의
		 * 데이터들을 각각 index 번째의 공간에 배열의 크기만큼 넣을 수 있다. - 한번 설정된 크기의 배열은 크기를 수정이 불가능하다. -
		 * 배열의 크기를 조회할 때는 length를 이용한다.
		 * 
		 * 1) 배열 선언 방법 -int[] 변수명 = new int [크기]; 모든 값이 0으로 초기화되어 있다. -int[] 변수명 = new
		 * int []{1,2,3,4,5}; <- 크기를 지정하지 않고 값을 넣음 -int[] 변수명 = {1,2,3,4,5}; ** int 와 같은
		 * 자료형은 변경 가능
		 * 
		 */
		// 다양한 방법으로 배열을 선언해보자
		int[] nums1 = new int[5]; // 정수형 타입 배열을 공간 5로 선언
		// 정수형 타입 배열을 각 index 자리에 순서대로 1,2,3,4,5로 설정
		int[] nums2 = new int[] { 1, 2, 3, 4, 5 };
		// 정수형 타입 배열을 각 index 자리에 순서대로 1,2,3,4,5로 설정
		int[] nums3 = { 1, 2, 3, 4, 5 };

		// 배열의 값을 출력해봅시다.
		System.out.println("nums1 : " + Arrays.toString(nums1));
		System.out.println("nums2 : " + Arrays.toString(nums2));
		System.out.println("nums3 : " + Arrays.toString(nums3));
		System.out.println("nums1 : " + nums1); // 이렇게 하면 주소가 출력됨

		// 무한도전 멤버들의 이름을 배열로 추가해봅시다.
		String[] names = { "유재석,", "박명수", "정준하", "정형돈", "하동훈", "노홍철", "길성준" };
		System.out.println("names.length : " + names.length);
		System.out.println("names : " + Arrays.toString(names));

		// 배열은 시작 index가 0이다.

		// 무한도전 멤버들을 우리 305호 학생들의 이름으로 바꿔봅시다.
		// 자신의 양옆자리에 있는 사람들로 이름을 바꿔볼건데, index 1,3,5번재에
		// 해당하는 위치에 이름을 변경해봅시다.
		names[1] = "조현준";
		names[3] = "김석호";
		names[5] = "김태형";
		System.out.println("[변경]names : " + Arrays.toString(names));

		// 문제1) 우리반 305호 학생 이름 5명을 배열에 저장하고 index 가 짝수번째에 들어있는 이름만 출력해주세요.

		String[] classs = { "박민주", "이은솔", "김태형", "김소원", "김석호" };

		for (int i = 0; i < classs.length; i++) {
			if (i % 2 == 0) {
				System.out.println(classs[i] + " ");
			}
		}

		/*
		 * 2차원 배열 - 기본적인 배열의 특징과 동일하므로 내용은 건너뛰도록 한다.
		 * 
		 */
		String[][] str = new String[][] { { "0,0", "0,1", "0,2" }, { "1,0", "1,1", "1,2" }, { "2,0", "2,1", "2,2" } };
		for (int i = 0; i < str.length; i++) {
			System.out.print(Arrays.deepToString(str[i]) + " ");
			for (int j = 0; j < str[i].length; j++) {
				System.out.print(str[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("str.length " + str.length);
		System.out.println("str[0].length : " +str[0].length);
		System.out.println();
		
		// 문제2)
		// 칠판에 체크해놓은 위치의 값을 '*'로 변경해서 출력해주세요.
		// [ '*', '0,1', '*' ]
		// [ '*', '1,1', '*' ]
		// [ '*', '2,1', '*' ]
		
		for (int i =0; i<str.length; i++) {
			for(int j =0; j<str[i].length; j++) {
				if(j%2 == 0) {
					str[i][j] = "*";
				}
			}
			System.out.println(Arrays.toString(str[i]) + " ");
		}
		
		
		
		
		
		
		
		// 제일 많이 나오는 단골문제 성적관리 프로그램

	}
}
