package Nov29;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

//MyFunctionalInterface의 구현클래스 생성
public class MyFunctionalInterfaceImpl 
	implements MyFunctionalInterface {

	@Override
	public void method() {
		log.trace("method() invoked.");
	} //method()
}//end class
