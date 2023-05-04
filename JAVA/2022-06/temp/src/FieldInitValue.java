public class FieldInitValue { // 라이브러리 클래스
	
	//(1) 기본타입 필드
	
	byte byteField;				//byte(정수) => 초기값이 없고 생성자도 초기화해주지 않으면
								//				생성된 객체안의 이 필드의 값은, 타입별기본값을 가짐
		
	short shortField;			//Ditto. => 0			
	int intField;				// Ditto.=> 0
	long longField;				// Ditto.=> 0
	
	boolean booleanField;		// Ditto.=>false
	char charField;				// Ditto."/u0000" => (빈문자, ' ' ), \\u는 유니코드(UTF-8문자집합)
	
	float floatField;			// Ditto.=> 0.0F
	double doubleField;			// Ditto.=> 0.0
	
	//(2) 참조타입 필드
	int[] arrField;				//Ditto. => null
	String referenceField;		//Ditto. => null

}//end class
