package Nov23;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

public class Util {

	public static <T extends Number> int compare(T t1,T t2) {
		log.trace("compare({}, {} ) invoked.", t1, t2);
		
		double v1 = t1.doubleValue();
		
		double v2 = t2.doubleValue();
		
		//자바 표준 라이브러리에서는 두 개의 기본 타입의 값을 비교할 때
		// 비교 결과를 아래와 같이 통일성 있게 구현하고 있다.
		//(1) 만일 v1 < v2 라면, => 마이너스 값 반환(보통-1로 반환)
		//(2) 만일 v1 == v2 라면, => 0 반환
		//(3) 만일 v1 > v2 라면, => 플러스 값 반환(보통+1로 반환)
		return Double.compare(v1, v2);	//Double Wrapper 클래스에 compare라는 정적 메소드
	}//compare
	
} //end class



//아래와 같이 특정기능들을 수행하는 '정적' 메소드들이 구성된
//클래스를 보통 '유틸리티 클래스' 라고 부른다.
//public static <T> Box2<T> boxing(T t){
//	
//	Box2<T> box = new Box2<T>();
//	box.setObj(t);
//	
//	return box;
//} //boxing