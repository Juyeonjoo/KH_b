package Nov23;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoxingMethodExample {

	public static void main(String[] args) {
		
		
		//제네릭 메소드 호출(사용할 때 > 구체타입 지정)
		// 구체타입으로 Integer 지정 > BoxMT>의 구체타입으로도 사용됨
		Box2<Integer> box1 = Util.<Integer>boxing(100);		//1st. method - till 7
//		Box2<Integer> box1 = Util.boxing(100);			//2nd. method (구체타입 생략) - since 8
		
		int intValue = box1.getObj();
		log.info("1. box: {}, intValue: {}", box1, intValue);
		
		Box2<String> box2 = Util.boxing("홍길동");
		String strValue = box2.getObj();
		log.info("2. box: {}, strValue: {}", box2, strValue);
	}//main
}//end class
