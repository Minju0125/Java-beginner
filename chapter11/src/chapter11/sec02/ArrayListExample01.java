/* Collection 객체
 -List, Set, Map으로 분류 -- Map은 이해하기 힘들수도,,,,,, 
 
  1) List : 선형구조 (1차원 배열 구조) . 배열처럼 순서있음. 순서가 있는 데이터의 집합으로 데이터의 중복을 허용함
	- 첨자(index)를 사용하며 중복을 허용하여 자료 저장
	- 객체만 저장함
	- List는 interface 이고
		이를 구현한 객체가 ArrayList, Vector, Stack, LinkedList, Queue 등이 제공됨
	- ArrayList : 가장 널리 사용됨 (ArrayList는 Thread safe 하지 않음)
	- 주요 메서드 : 
		(1) add (Object obj) : ArrayList 에 저장
		(2) get (int idx) : ArrayList idx번째 저장된 자료 반환
		(3) contains(Object obj) : ArrayList에 obj가 있는지 여부 반환 (true/false)
		(4) boolean isEmpty() : ArrayList가 비어있는지 여부 번환
		(5) void clear() : 모든 객체 삭제
		(6) E remove(int idx) : idx번째 객체 삭제
		(7) boolean remove(Object obj) : obj 객체를 찾아 삭제
		(8) int size() : ArrayList에 존재하는 객체의 수 반환
		
		 1차원 배열, 데이터의 배열 길이가 자동으로 만들어짐
		 16보다 큰 수가 들어오면 자동으로 32 개가 됨
		 (초기값)기본 capacity 는 16 (16개의 공간이 자동으로 만들어짐)
		 	-> 17번째 데이터를 사용자가 집어넣으면 자동으로 32개 됨
		 	-> 33번째 ,, -> 64개
		 배열은 한번 설정해놓으면 그 크기 변경 불가 -> arrayList와의 가장큰 차이점
		 가장 널리 사용되는 배열이 arrayList -> 객체만 저장할 수 있는 객체 배열 (collection)
		
*/
package chapter11.sec02;

public class ArrayListExample01 {

	public static void main(String[] args) {

	}

}
