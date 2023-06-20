package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

// 문제1) 5명의 별명을 입력 받아 ArrayList에 저장하고, 이들 중 별명의 길이가 제일 긴 별명을 출력 (단, 별명의 길이는 모두 다르게 입력)
  


public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList <String > list = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			System.out.print("[사람" +(i+1) + "의 별명] ");
			list.add(sc.nextLine());
		}
		
		for(int i=0; i<5; i++) {
			System.out.println(list.get(i).length()); // 배열에 저장하고 배열의 크기 비교?
		}
		
		
	}

}
