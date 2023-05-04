package Nov25;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashSetExample2 {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		
		log.info("1. set: {}", set);
	}//main
}
