package Nov24;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class Worker extends Person {
	
	public Worker(String name) {
		super(name);
		
		//자식 타입의 생성자에서 부모타입의 생성자 호출은 가장 첫 행
		log.trace("constructor({}) invoked.", name );
	} // constructor
} // end class
