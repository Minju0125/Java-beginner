package chap02.sec03; // �� Ŭ������ �ִ� ��ġ : package~

import java.util.Scanner;

//import java.util.Scanner;




public class CastExample01 {

	public static void main(String[] args) {
		// Ű����� ���� �ϳ��� �Է� �޾� �� ������ �����ڵ带 ����Ͻÿ�.
		// ��ĳ��Ŭ����
		
		Scanner sc = new Scanner (System.in);// ������ �޼��� // import �ؾ��� -> �ۿ� �ִ� �� �� Ŭ���� ������ �������� �� export�� �ڹٿ� ����
		System.out.print("���� �ϳ� �Է� : "); // ���ٿ��� �޼��� ��µǰ� �� �ٿ��� ����ϱ� ����
		
//		char ch1 = (char)sc.nextInt();
		char ch2 = (char)Integer.parseInt(sc.nextLine());
		System.out.println("character : " + ch2 );
		
		
		// �ڹٴ� Ŭ������ ���� 
		// �ڹٿ��� Ŭ���� �ۿ��� ���� �� �ִ� �� 2�� ��� : import, class
		// ����: package - import (���� �ٲ�� ����) // - ��ü ���� (��)sc // 
		// ���� ����ϰ��� �ϴ� ����� ������ �ִ� Ŭ������ ���� Ŭ������ �ҷ� ���� ���� (import)
		

	}

}
