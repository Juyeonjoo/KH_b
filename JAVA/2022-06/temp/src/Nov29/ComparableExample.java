package Nov29;

import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ComparableExample {

	//사용자정의 참조 타입의 객체를 TreesSet의 요소로 지정하기 위해서는
	//사용자정의 참조타입의 두 객체의 대소 비교가 가능해야 함
	public static void main(String[] args) {
		
		//1. Tree Set 객체 생성
		TreeSet<Person> treeSet = new TreeSet<>();
		
		//2. 컬렉션에 새로운 사람 추가
		// 이때 바로 기존 노드와 새로운 노드와 대소비교하여 이진 트리 구성
		treeSet.add(new Person("홍길동", 45));
		treeSet.add(new Person("감자", 25));
		treeSet.add(new Person("박지원", 31));
		
		log.info("1. treeSet: {}", treeSet);
		
		//3. 순회(traverse)
//		아래처럼 Set 컬렉션의 Iterator(반복자)를 얻어서 순회하는 코드 => 
//		old Not used But enhanced for statement used instead.
		//Iterator<Person> iterator = treeSet.iterator();
//		while(iterator.hasNest()){
//		Person person = iterator.next();
//		log.info(person.name + ":" + person.age);
//		}
		treeSet.forEach(log::info);
	}//main
} //end class
