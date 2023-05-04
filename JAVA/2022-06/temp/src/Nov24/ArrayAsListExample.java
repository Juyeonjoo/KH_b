package Nov24;

import java.util.Arrays;
import java.util.List;

import lombok.extern.log4j.Log4j2;
@Log4j2

public class ArrayAsListExample {
	//Arrays help class 메소드 중에 값의 목록으로 List객체를 생성해주는
	//=> asList() 메소드
	//1. ArrayList 객체 생성 by Arrays 의 asList 메소드
	public static void main(String[] args) {
		
		List<String> list1 = Arrays.<String>asList("홍길동", "신용권", "감자바");
		
		log.info("list: "+ list1);
		
		for(String name: list1) {
			log.info(name);
		} //enhanced for 
//		===========================
//		Auto-Boxing을 이용해서 int 기본타입의 값들로 Integer객체를
		//요소로 가지는 List 컬렉션을 ArrayList로 객체생성
		List<Integer> list2 = Arrays.asList(1,2,3);
		for(int value : list2) {
			log.info(value);
		} //enhanced for
	}//main
}//end class
