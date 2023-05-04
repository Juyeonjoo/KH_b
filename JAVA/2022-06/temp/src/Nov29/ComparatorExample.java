package Nov29;

import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ComparatorExample {

	//우리가 만든 비교자(comparator)를 어떻게 작용해야 대소비교가 불가능한
	//다른 참조타이을 TreeSet/TreeMap에 사용가능하게 할까?
	
	public static void main(String[] args) {
		
//		TreeSet<Fruit> treeSet = new TreeSet<>();
		
		//Fruit 이 Comparable 을 구현하지 않았기 때문에 예외 발생
		
//		treeSet.add(new Fruit("포도", 3000));
//		treeSet.add(new Fruit("수박", 10000));
//		treeSet.add(new Fruit("딸기", 6000));
		
//		> 이러한 에러가 발생한다. 
//		===================================
	
//1. TreeSet객체 생성: 요소의 타입이 Fruit(대소비교가 불가능한 타입)
		TreeSet<Fruit> treeSet = 
				//TreeSet 의 두번째 생성자인, Comparator 객체를 받는 생성자에 전달
				new TreeSet<>(new DescendingComparator());
		
//		2. 새로운 요소의 추가 = > 대소 비교가 발생 (using 우리가 제공한 비교자를 통해)
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		
		log.info(treeSet);
		
//		3. Traverse
		treeSet.forEach(log::info);
	}//main
} //end class
