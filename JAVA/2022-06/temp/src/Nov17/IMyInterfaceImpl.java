package Nov17;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
//해당 인터페이스를 implements하는 구현 클래스
public abstract class IMyInterfaceImpl implements IMyInterface {

	//상속받은 추상메소드(강제규격)대로 재정의
	//더이상 추상메소드가 아니라, 재정의(구현)했기 때문에
	//abstract 키워드 삭제해줘야 함
	@Override
	public void abstractMethod() {
				log.trace("abstractMethod() invoked.");
				
	}//abstractMethod
	
//	부모타입인 Interface로부터 public default 메소드가 상속된다
	//가. 상속되기 때문에 마음에 안들면 얼마든지 재정의할 수 있다.
	//나. 인터페이스 타입의 참조변수.디폴트메소드를 호출하면, 다형성2에 의해서
	//		인터페이스에 선언된 public default 메소드는 가려지고(hidden)
//			자식타입인 "구현클래스"에 "재정의"된 메소드가 무조건 호출된다.
//	다. 상속받는 것도 싫고 재정의하는 것도 싫고 아예 디폴트 메소드 자체가 있다는게 마음에 안들면,
//	인터페이스에 선언된 default 메소드를 아예 abstract 메소드로 바꿔버릴 수 있다.
//	>> 구현클래스 조차 추상 클래스로 변경해야한다(쓰이지 않는다.)
	
//	@Override
//	public void defaultMethod() {
//			log.trace("defaultMethod() invoked.");
//	}// default method
	
	public abstract void defaultMethod();
	
	
} // end class
