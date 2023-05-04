
//final 필드(=final 상수)
public class Person {

	// 1. 필드 (고유속성/상태/부품)
	
	final String nation = "Korea";
	final String ssn;
	String name;
	
	// 2. 생성자
	public Person(String ssn, String name) {
		this.ssn = ssn;	//이 단계에서 ssn final 초기화되어서 그 다음에 값 못바꿈		
		this.name = name;// 초기하 언제나 가능
	} //Constructor
} //end class
