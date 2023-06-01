package chapter11.sec03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		//�ڷ�����
		map.put(1000, "ȫ�浿"); //Integer, String Ŭ���� ��ü
		map.put(1001, "�̼���");
		map.put(1002, "������");
		
//		String name = (String)map.get("1001"); // Objcet Ÿ������ �Ǿ��־ String Ÿ������ ����ȯ �ؾ���. (downcasting) �̷��� ���ϸ�
		String name = map.get(1001); //get(key) �ش�ʿ��� ���޵� Ű�� �����ϴ� ���� ��ȯ��. �ش���� ���޵� Ű�� ������ ������ �����ϰ� ���� ������ null ��ȯ.
		System.out.println(name);
		
							//map�� �ִ� keySet �޼ҵ� ȣ���ϸ� Ű�� ���� -> Ű�� �˸� value �� �� �� ����* key�� �ּҸ� ������ �����ϱ�.
		// key �� ������ ������ �ѱ����� ������
		//ù��° �ڷ���� ������ �ڷ���� �˰� �ͱ� ������ iterator�� while���� ����� �ݺ���
		
		Set<Integer> keySet = map.keySet(); //Set<K> keySet() �ش� �ʿ� ���ԵǾ� �ִ� ��� Ű�� ������� Set ��ü�� ��ȯ��.
		Iterator<Integer> iter = keySet.iterator();
		
		while(iter.hasNext()) { //hasNext : ������ ���� �ڷᰡ �ִ��� ���� (��.����)
			Integer keys = iter.next(); //next �޼ҵ� : iterator���� ������ �� �������� �� (Ÿ���� ���׸�) -> 
			System.out.println(keys + "=>" + map.get(keys)); //-> get�޼ҵ�� Ű�� ���� value ���� ������
			//�ϳ��� key, value(ex, Ư�� ��ǰ��ȣ) -> �ϳ��� Ű�� �����ָ� ã�� �� �ֱ� ������ ���ͷ����� �� �ᵵ ��
			
			//�ش� �ʿ��� ���޵� Ű�� ���ų�, ���޵� Ű���� ū Ű �߿��� ���� ���� Ű�� �׿� �����ϴ� ���� ��Ʈ���� ��ȯ��. ���� �ش��ϴ� Ű�� ������ null�� ��ȯ��.
			// ��ü�� �˻��� ���� iterator ����ؼ� �ڷḦ �˻��� �� ����
			
		}
			

	}

}
