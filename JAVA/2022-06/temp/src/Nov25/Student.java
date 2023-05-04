package Nov25;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@EqualsAndHashCode

public class Student {

	public int sno;
	public String name;
	
//	public boolean equals(Object obj) {
//		if(obj instanceof Student) {
//			Student studnet 
//		}
//	} //equals 랑 밑에 해시코드도 있어야하는데 @EqualsAndHashCode 로 대체
	
}//end class
