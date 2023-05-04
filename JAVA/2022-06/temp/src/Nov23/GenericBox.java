package Nov23;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Log4j2
@ToString
@NoArgsConstructor

public class GenericBox<T> {//Type Parameter T 를 하나 가지는 제네릭 타입의 클래스
							// 이 클래스 참조 타입을 "사용시" "구체타입을 지정"
private T t;

}
//private T t;
//
//public T get() { 
//	log.trace("get({}) invoked.", t);
//
//	return t;
//} //get
//
//public void set(T t) {
//	log.trace("set({}) invoked.", t);
//	
//	this.t = t;
//}//set