package Nov29;

import java.util.Comparator;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2

//우리에게 소스가 없는 Fruit 참조타입도 TreeSet/TreeMap에 사용 가능하도록 하려면
//아래와 같이 비교자(comparator)를 만들어 제공하면된다. 누구에게?
public class DescendingComparator implements Comparator<Fruit>{
		//내림차순 비교자
	
	@Override
	public int compare(Fruit o1, Fruit o2) {
		log.trace("compare{}, {} invoked.", o1, o2);

		if(o1.price < o2.price) return 1;
		else if(o1.price == o2.price) return 0;
		
		else return -1;
	}//compare
} //end class
