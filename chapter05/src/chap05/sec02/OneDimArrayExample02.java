package chap05.sec02;

import java.util.Scanner;

public class OneDimArrayExample02 {
	public static void main(String[] args) {
		OneDimArray02 od2 = new OneDimArray02();
		od2.setName(); // �Է��ϱ� ���� ȣ��
		od2.getName(); //
		od2.exchange();
	}
}

//���� 2. Ű����� 5���� ģ���̸� �Է� �޾� �迭�� �����ϰ� �������� ����Ͻÿ�.
//���� 3, ���� 2�� ù��° ģ���̸��� ������ ģ�� �̸��� ���� �ٲٽÿ�.
class OneDimArray02 {
	Scanner sc = new Scanner(System.in);
	String[] name = new String[5]; // name �� ��������� ���� Ŭ���� �ȿ��� ����

// ���⼭ name �� ���ڿ��� ����ִ� �ּҰ��� ������  -�ּҸ� ���󰡸� ���ڿ��� ����Ǿ��ִ� �ټ����� ������ ������
// Ű����� �Է¹������ �����ϱ� ������ ��������/

	public void setName() {// name �� ��������� ���� Ŭ���� �ȿ��� �����ϱ⶧���� setName()�ȿ� Name �Ƚᵵ ��
		for (int i = 0; i < name.length; i++) {
			System.out.print((i + 1) + "ģ�� �̸� �Է� : ");
			name[i] = sc.nextLine();
		}

	}

	public void getName() {
//		for(int i=name.length-1; i>=0; i--) {
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[(name.length - 1) - i]);

		}

	}

	public void exchange() {
		String temp = null;
		temp = name[0];
		name[0] = name[4];
		name[4] = temp;

		for (String str : name) {
			System.out.printf("%5s", str);
		}
	}

}