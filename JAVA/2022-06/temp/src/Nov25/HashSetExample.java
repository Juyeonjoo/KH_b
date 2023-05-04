package Nov25;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashSetExample {

	/*
	Set 컬렉션 성질:
	(1) 순서를 보장하지 않는다.
	(2) 중복을 허용하지 않는다.
	(3) 하나의 null값이 요소로 허용된다(의미없음)
	*/
	public static void main(String[] args) {
//		1. 컬렉션 생성
		@Cleanup("clear")
		Set<String> set = new HashSet<String>();
		
//		2. 새로운 요소 추가
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBAtIS");
		
//		3. 컬렉션 크기 획득
		int size = set.size();
		log.info("총 객체수: " + size);
		
//		4. Iterator(반복자)객체를 획득해서
//		이를 이용하여 Set 컬렉션 순회(traverse) => But useless
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			log.info("\t" + element);
		}//while
		
//		5. 요소삭제(인덱스번호가 없기 때문에 아래와 같이)
		set.remove("JDBC");
		set.remove("iBAtIS");
	
//		6. 요소삭제 후, 다시 순회 및 요소 출력
		log.info("2. 총 객체수: "+ set.size());
	
		for(String element : set) {
			log.info("\t" + element);
		} //enhanced for
		
		set.forEach(log::info);			//Set컬렉션 순회의 끝판왕
		
//		7. 컬렉션 자원해제
//		set.clear();
		log.info("3. set: {}", set);
		
		if(set.isEmpty()) {
			log.info("비어있음");
		}//if
	} //main
} //end class
