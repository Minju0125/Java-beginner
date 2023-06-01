package chapter11.sec03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		//자료저장
		map.put(1000, "홍길동"); //Integer, String 클래스 객체
		map.put(1001, "이순신");
		map.put(1002, "강감찬");
		
//		String name = (String)map.get("1001"); // Objcet 타입으로 되어있어서 String 타입으로 형변환 해야함. (downcasting) 이렇게 안하면
		String name = map.get(1001); //get(key) 해당맵에서 전달된 키에 대응하는 값을 반환함. 해당맵이 전달된 키를 포함한 매핑을 포함하고 있지 않으면 null 반환.
		System.out.println(name);
		
							//map에 있는 keySet 메소드 호출하면 키만 모임 -> 키만 알면 value 는 알 수 있음* key가 주소를 가지고 있으니까.
		// key 는 순번은 없더라도 한군데에 모여있음
		//첫번째 자료부터 마지막 자료까지 알고 싶기 때문에 iterator와 while문을 사용한 반복문
		
		Set<Integer> keySet = map.keySet(); //Set<K> keySet() 해당 맵에 포함되어 있는 모든 키로 만들어진 Set 객체를 반환함.
		Iterator<Integer> iter = keySet.iterator();
		
		while(iter.hasNext()) { //hasNext : 꺼내올 다음 자료가 있는지 여부 (참.거짓)
			Integer keys = iter.next(); //next 메소드 : iterator에서 지정한 걸 가져오는 것 (타입은 제네릭) -> 
			System.out.println(keys + "=>" + map.get(keys)); //-> get메소드는 키에 따른 value 값을 가져옴
			//하나의 key, value(ex, 특정 상품번호) -> 하나만 키로 던져주면 찾을 수 있기 때문에 이터레이터 안 써도 됨
			
			//해당 맵에서 전달된 키와 같거나, 전달된 키보다 큰 키 중에서 가장 작은 키와 그에 대응하는 값의 엔트리를 반환함. 만약 해당하는 키가 없으면 null을 반환함.
			// 전체를 검색할 때는 iterator 사용해서 자료를 검색할 수 있음
			
		}
			

	}

}
