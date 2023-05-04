package Nov25;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashMapExample {

	public static void main(String[] args) {

		//	1. Map 컬렉션 생성
		//	Map<K,V> 2개의 파라미터를 가짐: K = key, V= value 의 타입 결정

		Map<String, Integer> map = new HashMap<String, Integer>();

		//key : String, value : Integer

		//		for(Map.Entry<String, Integer> element : map) {
		//			//Can only iterate over an array or an instance of java.lang.Iterable
		//		}

		//		2. 요소를 키 = 값 쌍의 형태로 저장
		//		이때 바로 키 객체에 대해서 중복 판정 알고리즘이 수행된다.
		map.put("신용권", 85);
		map.put("홍길동", 90);	//***
		map.put("동장군", 80);
		map.put("홍길동", 95);	//***

		//set은 처음에 넣은걸 저장하고 다음거는 못들어오게했는데
		//map은 중복되면 나중값을 엎어친다.그래서 홍길동 90이 아닌 95 (Overwrite)

		log.info("1. map: {}", map);
		log.info("2. 총 Entry 수: {} " + map.size());

		//		3. 요소의 검색 : 키를 갖고 값을 획득, by Map.get(key)
		log.info("3. 홍길동(키)의 값 : {} ",map.get("홍길동")); // 값을 끄집어 낼 때 get
		log.info("");

		//		4. Map 컬렉션 순회
		//4-1. Map 컬렉션에서 키들만 Set 컬렉션으로 추출
		Set<String> keySet = map.keySet(); //키들만 뽑아서 Set 으로 반환해라

		for(String key : keySet) {
			Integer value = map.get(key);
			log.info("\t" + key + " : " + value);
		} //enhanced for
		//4-2. 키들만 저장되어있는 Set 컬렉션에서, 반복자(Iterator) 획득
		Iterator<String> keyIterator = keySet.iterator();

		//4-3. Map 컬렉션 순회 using 키들이 저장되어 있는 반복자(Iterator) 이용
		//		while(keyIterator.hasNext()){
		//
		//			String key = keyIterator.next(); // 키 획득
		//			Integer value = map.get(key);	// 키를 이용하여 값 획득
		//			log.info("\t " + key + " : " + value );
		//		} //while

		//		5.요소 삭제 by Map.remove(key);
		map.remove("홍길동");
		log.info("4. 총 Entry 수: {}", map.size());

		//		6. Map 컬렉션의 또 다른 순회 방법
		//		6-1. Map컬렉션에 저장된 모든 Map.Entry 객체를 Set 컬렉션으로 획득
		//제네릭타입 인터페이스
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			String key = entry.getKey();
			int value = entry.getValue();

			log.info("\t" + key + " : " + value );
		}//enhanced for

		//		7.  Map 컬렉션 자원 해제
		map.clear();
		log.info("5. 총 Entry 수 : {}" , map.size());
	} //main

} //end class
