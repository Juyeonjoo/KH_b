package Nov28;

import java.util.NavigableSet;
import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TreeSetExample3 {

	//지정된 범위 탐색
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<>();
		
		treeSet.add("apple");			//set은 순서보장x 중복허용x , 넣자마자 중복 판정 알고리즘 작동
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		log.info("1. treeSet: {} ", treeSet);		//정렬된 결과
		
		log.info("[c~f로 시작하는 단어들을 검색]");
		//subSet: 부분 범위 집합 얻는 메소드
		//NavigableSet<String> java.util.TreeSet.subSet(
//									String fromElement, 
//									boolean fromInclusive, 
//									String toElement, 
//									boolean toInclusive)
		NavigableSet<String> rangeSet = treeSet.subSet("cherry", true, "forever", true);
		
		log.info("2. rangeSet: {}", rangeSet); // 굳이 traverse하지 않아도 잘 나옴.
//		for(String word: rangeSet) {
//			log.info(word);
//		}//enhanced for
		
		rangeSet.forEach(log::info);
	}//main
} //end class
