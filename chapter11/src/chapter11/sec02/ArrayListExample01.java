/* Collection ��ü
 -List, Set, Map���� �з� -- Map�� �����ϱ� �������,,,,,, 
 
  1) List : �������� (1���� �迭 ����) . �迭ó�� ��������. ������ �ִ� �������� �������� �������� �ߺ��� �����
	- ÷��(index)�� ����ϸ� �ߺ��� ����Ͽ� �ڷ� ����
	- ��ü�� ������
	- List�� interface �̰�
		�̸� ������ ��ü�� ArrayList, Vector, Stack, LinkedList, Queue ���� ������
	- ArrayList : ���� �θ� ���� (ArrayList�� Thread safe ���� ����)
	- �ֿ� �޼��� : 
		(1) add (Object obj) : ArrayList �� ����
		(2) get (int idx) : ArrayList idx��° ����� �ڷ� ��ȯ
		(3) contains(Object obj) : ArrayList�� obj�� �ִ��� ���� ��ȯ (true/false)
		(4) boolean isEmpty() : ArrayList�� ����ִ��� ���� ��ȯ
		(5) void clear() : ��� ��ü ����
		(6) E remove(int idx) : idx��° ��ü ����
		(7) boolean remove(Object obj) : obj ��ü�� ã�� ����
		(8) int size() : ArrayList�� �����ϴ� ��ü�� �� ��ȯ
		
		 1���� �迭, �������� �迭 ���̰� �ڵ����� �������
		 16���� ū ���� ������ �ڵ����� 32 ���� ��
		 (�ʱⰪ)�⺻ capacity �� 16 (16���� ������ �ڵ����� �������)
		 	-> 17��° �����͸� ����ڰ� ��������� �ڵ����� 32�� ��
		 	-> 33��° ,, -> 64��
		 �迭�� �ѹ� �����س����� �� ũ�� ���� �Ұ� -> arrayList���� ����ū ������
		 ���� �θ� ���Ǵ� �迭�� arrayList -> ��ü�� ������ �� �ִ� ��ü �迭 (collection)
		
*/
package chapter11.sec02;

public class ArrayListExample01 {

	public static void main(String[] args) {

	}

}
