package Nov28;

import java.util.NavigableSet;
import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TreeSetExample2 {

	public static void main(String[] args) {
		
		
//	1. TreeSet 객체 생성
		
	TreeSet<Integer> scores = new TreeSet<>();
	
	//2. 새로운 요소 추가 = > 중복 검증(이중판정알고리즘), 이진트리 생성(정렬완성)
	scores.add(87);
	scores.add(98);
	scores.add(75);
	scores.add(95);
	scores.add(80);
	
	log.info("1. scores {}", scores);
	
	//3. 정렬결과 획득(내림차순 결과 획득) = Ascending(오름차순), Descending(내림차순)
	NavigableSet<Integer> descendingSet = scores.descendingSet(); //요소를 내림차순으로 , Set 결과로
	log.info("2. descendingSet {}", descendingSet);
	
	log.info("============내림차순============");
//	4. 정렬결과 출력(by순회(traverse))
	for(int score : descendingSet) { //integer도 되고, Integer도된다. 오토 언박싱
		log.info(score + " ");
	}//enhanced for
	log.info("============forEach 내림차순============");
	descendingSet.forEach(log::info);		//내부순회 , 최종처리메소드 forEach, log::info 메소드 참조, 람다식의 끝판왕
	//우리가 직접 순회코드를 만들지 않아도 forEach 안에서 자동으로 만든다.
	
	log.info("============오름차순============");
	
//	5. 오르차순 결과는 어떻게?
//	내림차순 결과셋을 돌려주는 메소드를 한번 더 호출하면 오름차순 결과
	NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();

	log.info("ascendingSet: {}", ascendingSet);
	
//	6. 정렬결과 출력(by순회(traverse))
	for(Integer score : ascendingSet) {
		log.info(score + " ");
	}//enhanced for
	
	}//main
} //end class
