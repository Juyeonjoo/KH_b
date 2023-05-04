package Nov25;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@AllArgsConstructor
@Log4j2
@EqualsAndHashCode

public class Member {
	
	public String name;
	public int age;
	
	//Set과 Map Collection에서는 요소객체의 중복을 판정해서
	//중복된 객체는 아예저장시키지 않도록 구현되어있다.
	//따라서 중복을 허용하지 않는 Set의요소객체나 Map의 키 객체에 대해서
	//hashCode()메소드와 equals()메소드 2개로 이중 중복판정 알고리즘을 중복여부를 판정
	//합니다. 이때 hashCode(), equals() 2개의 메소드를 어디까지나 "비지니스 관점"으로
	//중복여부를 판정하도록 개발자가 직접 "재정의(Overriding)" 해야한다.
	
	//예: 두 회원객체의 중복여부
//	@Override
//	public boolean equals(Object obj) {
//		log.trace("equals({}) invoked." ,obj);
//		
//		if(obj instanceof Member) {
//			Member member = (Member) obj;
//			return member.name.equals(name) && (member.age==age);
//		} else {
//			return false;
//		}//if-else
//	}//equals
//	
//	@Override
//	public int hashCode() {	//객체의 OID생성(어디까지나 OOP관점 = > 비지니스관점으로 바꿔서)
//		log.trace("hashCode() invoked.");
//		
//		return name.hashCode() + age;
//	} //hashCode

}//end class
