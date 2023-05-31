/* Collection ��ü
 -List, Set, Map���� �з� -- Map�� �����ϱ� �������,,,,,, 
 
  1) List : �������� (1���� �迭 ����) . �迭ó�� ��������. ������ �ִ� �������� �������� �������� �ߺ��� �����
	- ÷��(index)�� ����ϸ� �ߺ��� ����Ͽ� �ڷ� ����
	- ��ü�� ������
	- List�� interface �̰�
		�̸� ������ ��ü�� ArrayList, Vector, Stack, LinkedList, Queue ���� ������
	- ArrayList : ���� �θ� ���� (ArrayList�� Thread safe ���� ����)
	- �ֿ� �޼��� : //
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

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample01 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		Person p1 = new Person("�̼���");
		list.add("ȫ�浿"); // ������ �ٵ�
		list.add(100);
		list.add(false);
		list.add(p1);
		list.add(new Person("������"));

		/// arraylist �� ��ü�� ����ȴٰ� �ߴµ� �� �Ϲݵ����� Ÿ���� ����?
		// �갡 ����� �� �ڵ����� Int Ŭ���� ��ü�� ��ȯ�� -> ����ڽ� (�ڹ� 1.5���� �����Ǵ� ���)
		// false -> Boolean �̶�� ����Ŭ���� ��ü�� �ڵ� ����ȯ
		// ����ڰ� ���� Person �̶�� Ŭ���� ��ü�� �����ؼ� ������� �� ����

		System.out.println(list);

		System.out.println("\n[[�Ϲ� for��]]");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("\n[[����� ���� for��]]");
		for (Object obj : list) { // : �������� �迭 �Ǵ� �÷��������ӿ�ũ ��� ����. ����� �������� ���°� �پ��ϱ� ������ ��� Ŭ������ ���� Ŭ������ obj Ŭ������ ���·� ������.
			System.out.println(obj); // ArrayList���� �ϳ��� ������ ����ϴ� ���
		}
		
		
		System.out.println("\n[[�ݺ���(Iterator) ���]]");
		Iterator iter = list.iterator(); 
		while(iter.hasNext()) { // ���� �ڷᰡ �ִ���? ->> ������ �ٸ� �ڷ� ������
			System.out.println(iter.next());
		} //�ڷḦ �ϳ��� ���߸��� �ʰ�, �˻�
	}
}

class Person {
	String name;

	Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;

	}
}