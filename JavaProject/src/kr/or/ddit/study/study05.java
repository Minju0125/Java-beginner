package kr.or.ddit.study;

import java.util.Arrays;

public class study05 {

	public static void main(String[] args) {
		/*
		 * �迭�̶�?
		 * 
		 * - �迭�� ����Ÿ������, �л����� �̸�, ����, ���� ���� �� ���� �����͸� ȿ�������� ���� �� �ִ� �����̴�. - �迭�� ���� Ÿ����
		 * �����͵��� ���� index ��°�� ������ �迭�� ũ�⸸ŭ ���� �� �ִ�. - �ѹ� ������ ũ���� �迭�� ũ�⸦ ������ �Ұ����ϴ�. -
		 * �迭�� ũ�⸦ ��ȸ�� ���� length�� �̿��Ѵ�.
		 * 
		 * 1) �迭 ���� ��� -int[] ������ = new int [ũ��]; ��� ���� 0���� �ʱ�ȭ�Ǿ� �ִ�. -int[] ������ = new
		 * int []{1,2,3,4,5}; <- ũ�⸦ �������� �ʰ� ���� ���� -int[] ������ = {1,2,3,4,5}; ** int �� ����
		 * �ڷ����� ���� ����
		 * 
		 */
		// �پ��� ������� �迭�� �����غ���
		int[] nums1 = new int[5]; // ������ Ÿ�� �迭�� ���� 5�� ����
		// ������ Ÿ�� �迭�� �� index �ڸ��� ������� 1,2,3,4,5�� ����
		int[] nums2 = new int[] { 1, 2, 3, 4, 5 };
		// ������ Ÿ�� �迭�� �� index �ڸ��� ������� 1,2,3,4,5�� ����
		int[] nums3 = { 1, 2, 3, 4, 5 };

		// �迭�� ���� ����غ��ô�.
		System.out.println("nums1 : " + Arrays.toString(nums1));
		System.out.println("nums2 : " + Arrays.toString(nums2));
		System.out.println("nums3 : " + Arrays.toString(nums3));
		System.out.println("nums1 : " + nums1); // �̷��� �ϸ� �ּҰ� ��µ�

		// ���ѵ��� ������� �̸��� �迭�� �߰��غ��ô�.
		String[] names = { "���缮,", "�ڸ��", "������", "������", "�ϵ���", "��ȫö", "�漺��" };
		System.out.println("names.length : " + names.length);
		System.out.println("names : " + Arrays.toString(names));

		// �迭�� ���� index�� 0�̴�.

		// ���ѵ��� ������� �츮 305ȣ �л����� �̸����� �ٲ㺾�ô�.
		// �ڽ��� �翷�ڸ��� �ִ� ������ �̸��� �ٲ㺼�ǵ�, index 1,3,5���翡
		// �ش��ϴ� ��ġ�� �̸��� �����غ��ô�.
		names[1] = "������";
		names[3] = "�輮ȣ";
		names[5] = "������";
		System.out.println("[����]names : " + Arrays.toString(names));

		// ����1) �츮�� 305ȣ �л� �̸� 5���� �迭�� �����ϰ� index �� ¦����°�� ����ִ� �̸��� ������ּ���.

		String[] classs = { "�ڹ���", "������", "������", "��ҿ�", "�輮ȣ" };

		for (int i = 0; i < classs.length; i++) {
			if (i % 2 == 0) {
				System.out.println(classs[i] + " ");
			}
		}

		/*
		 * 2���� �迭 - �⺻���� �迭�� Ư¡�� �����ϹǷ� ������ �ǳʶٵ��� �Ѵ�.
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
		
		// ����2)
		// ĥ�ǿ� üũ�س��� ��ġ�� ���� '*'�� �����ؼ� ������ּ���.
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
		
		
		
		
		
		
		
		// ���� ���� ������ �ܰ��� �������� ���α׷�

	}
}
