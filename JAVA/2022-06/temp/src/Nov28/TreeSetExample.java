package Nov28;

import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class TreeSetExample {

	
	public static void main(String[] args) {
		
		TreeSet<Integer> scores =  new TreeSet<>();
		
		scores.add(87);  // 오토박싱으로 기본값으로 넣어주면 됨
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		log.info("1.scores: {} ", scores);
//		===========================
		
		Integer score =null;
		
		score = scores.first();			//이미정렬이 되어있기 때문에 최저점수
		log.info("2. 가장 낮은 점수: {} ", score);
		
//		===========================
		
		score = scores.last();			
		log.info("3. 가장 높은 점수: {} ", score);
		
//		===========================	
		
		score = scores.lower(95);
		log.info("4. 95점 아래 점수: {}", score);
		
//		===========================
		
		score = scores.higher(95);
		log.info("5. 95점 위의 점수: {}", score);
//		===========================	
		
		score = scores.floor(95);
		log.info("6. 95점이거나 바로 아래 점수: {}", score);
		
//		===========================
		
		score = scores.ceiling(85);
		log.info("7. 85점이거나 바로 위의 점수: {}", score);
		
//		===========================	
		while(!scores.isEmpty()) {
			
			//Set 컬렉션의 요소 중에 가장 첫 번째 (낮은, Min)요소를 "끄집어" 낸다.
			score = scores.pollFirst(); 
		log.info("8. score : {}, 남은 객체수: {}, 남은 객체: {}", score, scores.size(), scores);
		
		}//while
	}//main
} //end class
