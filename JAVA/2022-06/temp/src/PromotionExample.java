
public class PromotionExample {

	// 자동형변환(Promotion) 예제
	public static void main (String[] args) {
		//실행문장을 구성하는 Lvalue = Rvalue에서,
		//형 번환의 발생은, Rvalue에서 발생하는 것이지, Lvalue에서 발생하지 않는다.
		
		//리터럴(순수한 값)은 형변환 대상 자체가 안되고 그대로 밀어넣는다.
		
		byte byteValue = 10; //4byte, int 10 을 1 byte byte에 넣었음.
		
		int intValue = byteValue; //Rvalue는 1바이트, Lvalue는 4바이트라 잘 들어간다.(
		//자동형변환(작은타입 > 큰타입으로), Lvalue타입으로 
		
		System.out.println(intValue);

// ==================================================================
		
		char charValue = '가'; // 문자 리터럴, 한 문자를 보관하는 타입으로 2바이트 정수
		intValue = charValue; //문자열 리터럴, Lvalue(4) = Rvalue(2) : 자동형변환발생
		
		System.out.println("가의 유니코드 =" + intValue);

// ==================================================================

		intValue = 500;
		long longValue = intValue; //Lvalue(8) = Rvalue(4) :자동형변환
		
		System.out.println(longValue);// 500 
		
		// ==================================================================
		
		intValue = 200;
		double doubleValue = intValue; //Lvalue(8) = Rvalue(4) 자동형변환
		
		System.out.println(doubleValue); // 200.0

	}
}
