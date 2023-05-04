package Nov24;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Student extends Person{

	public Student(String name) {
		super(name);
		
		log.trace("constructor({}) invoked.", name );
	} //constructor
}//end class 
