package Nov29;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@Log4j2
@AllArgsConstructor

public class Person implements Comparable <Person>{

	public String name;
	public int age;
	
	@Override
	public int compareTo(Person obj) {
		log.trace("compareTo({}) invok", obj);
		
		//두 개의 값(즉,(1) 기준값, (2) 비교값)을 비교할 때,
		// 자바 언어에서는 통일성 있게, 아래 기준으로 값을 반환하게 되어있음.
//		(1) 기준값 < 비교값 => 음수값 반환(보통 -1 반환)
//		(2) 기준값 == 비교값 ->0 반환
//		(3) 기준값 > 비교값 = > 양수값 반환(보통 +1 반환)
//		현재 객체가 기준객체, Person, 매개변수에 전달된 객체가 비교객체
		///둘다 가지고 있는 나이로 기준을 둠.
		
		//두 사람의 나이를 가지고 대소를 따지게 구현됨
		if(age<obj.age) return -1;
		else if(age == obj.age)return 0;
		else return 0;
	} //compareTo
	
} //end class
