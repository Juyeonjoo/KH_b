package Nov24;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ArrayListExample {
public static void main(String[] args) {
	//1. List 컬렉션 생성(Lvalue: 인터페이스 = Rvalue: 구현객체)

	List<String> list = new ArrayList<>();			//다형성1
	
	//2. 새로운 요소객체의 추가					//다형성2
	list.add("Java");
	list.add("JDBC");
	list.add("Sevlet/JSP");
	list.add(2, "Database");			//밀고땡기는 현상발생
	list.add("iBATIS");
	
	log.info("1. list: {} ", list);
	
	// 3. 현재 list 컬렉션의 크기(즉, 요소의개수) 출력
	int size = list.size();			//목록의크기 반환해주는 size
	log.info("총 객체수: {}", + size);
	log.info("");
	
	//4. 특정 인덱스 요소 삭제
	String skill = list.get(2);		//내가지정되어있는 인터페이스 달라
	log.info("3. 2: " + skill);
	log.info("");
	
	//5. List 컬렉션의 순회(traverse) 및 검색
//	for(int i =0; i<list.size(); i++) {
//		String str = list.get(i);
//		
//		log.info(i + ":" + str);
//	}//classical for 
	
	//enhance for
	
	for(String element : list ) {
		log.info(element);
	}//enhance for
	
	log.info("");
	
	//6. 특정 인덱스 요소 삭제
	list.remove(2);				//2번 인덱스 요소 삭제되면서 뒤의 모든 요소가 땡겨짐
	list.remove(2);				//이전 삭제에 의해서 이전 요소가 모두 땡겨진 상태이므로
								// 2번 인덱스 다시 사용 가능(단점)
	list.remove("iBATIS");
	
	log.info("4. list: {}", list);
	
	//7. 현재 List 컬렉션의 모든 요소  출력
	list.forEach(log::info);
	
	}//main
}//end class
