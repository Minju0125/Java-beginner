package chapter11.sec01;

import java.sql.Wrapper;

public class StringExample {

	public static void main(String[] args) {
		//1. substring(int sindex, int eindx)
		//2. �⺻ ������Ÿ�� => ���ڿ��� ��ȯ
		//	=> String.valueOf(�⺻Ÿ���ڷ�);
		//  => �⺻ ������ Ÿ�� + ""
		
		// int 100�� ���ڿ��� ��ȯ
		String str1 = String.valueOf(100); //�׷� �� 100�� ���ڿ��� ��ȯ�Ǿ� �����
		String str2 = 100 + "" ; //�̷��� �ص� 100�� ���ڿ��� ��ȯ�� (�⺻������+���ڿ��� ����� ���ڿ�)
		
		///////////////////////////////////////////////////////////////////////////////
		// ���ڿ��� => �⺻ ������ Ÿ������ ��ȯ (wrapper Ŭ���� ���)
		// Wrapper.parse �⺻Ÿ�Ը� (�ش繮�ڿ�) ��ȣ���� ���ڿ� �ڷḦ �⺻Ÿ������ �ٲپ���
		// �⺻Ÿ�Կ� �ش�Ǵ� Wrapper Ŭ������ ����ؾ��� ! (wrapper Ŭ������ 8���� ����) Wrapper Ŭ���� ù���ڴ� �빮��
		
		// 25.5 �� ���ڿ��� ��ȯ
		double num1 = Double.parseDouble("25.5");
		

	}

}
