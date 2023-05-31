package chapter11.sec03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		//자료저장
		map.put(1000, "홍길동");
		map.put(1001, "이순신");
		map.put(1002, "강감찬");
		
//		String name = (String)map.get("1001"); // Objcet 타입으로 되어있어서 String 타입으로 형변환 해야함. (downcasting) 이렇게 안하면
		String name = map.get(1001); //get(key) 해당맵에서 전달된 키에 대응하는 값을 반환함. 해당맵이 전달된 키를 포함한 매핑을 포함하고 있지 않으면 null 반환.
		System.out.println(name);
		
		Set<Integer> keySet = map.keySet(); //Set<K> keySet() 해당 맵에 포함되어 있는 모든 키로 만들어진 Set 객체를 반환함.
		Iterator<Integer> iter = keySet.iterator();
		while(iter.hasNext()) {
			Integer keys = iter.next();
			System.out.println(keys + "=>" + map.get(keys));
			
			//해당 맵에서 전달된 키와 같거나, 전달된 키보다 큰 키 중에서 가장 작은 키와 그에 대응하는 값의 엔트리를 반환함. 만약 해당하는 키가 없으면 null을 반환함.
			
			
		}
			

	}

}
