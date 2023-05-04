
public class OperationPromotionExample {

	public static void main(String[] args) {
		
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		byte byteValue3 = (byte)(byteValue1 + byteValue2); // 컴파일 에러, 
// 모든 정수연산의 결과 = > 정수로 나오고 int 타입으로 시작
		
		//-- 그릇 준비 ----표현식 (값1개 생성) ------
		int intValue1 = byteValue1 + byteValue2; //Rvalue는 연산식
		System.out.println(intValue1);
		System.out.println(byteValue3);
	
		System.out.println(100+100);
		System.out.println(100-100);
		System.out.println(100*100); //곱셈연산자 : *
		System.out.println(10/3); //3 나눗셈연산자 : 절삭되어 나온다.
		System.out.println(10.0 / 3);// 정수연산자가 될 수 없다. 3.3333333333333335
		System.out.println(10 / 3.0);// 3.3333333333333335
		System.out.println(100%100);
		
// ============================================
		char charValue1 = 'A' ; // 'A'문자에 할당된 정수값이 저장
		char charValue2 = 1; //?? char 타입도 분명 "정수"타입임>문자코드값저장
		
		//컴파일 에러 => 원인:정수연산의 결과 => 정수(int)타입
		char charValue3 = (char) (charValue1 + charValue2);// Lvalue(char,2) = Rvalue(int,4)
						
						//Rvalue : 정수연산의 결과 => 정수(int 타입)
		int intValue2 = charValue1 + charValue2;
		
		//여기서 '+' 연산자 = > "문자열 연결 연산자" : 두 문자열을 이어주는 연산수행
		System.out.println("1. 유니코드= " + intValue2);
		System.out.println("2. 출력문자= " + (char) intValue2);
		System.out.println((char)102);
		System.out.println((int)'f'); //102
		
		char temp = 102; // 'f'
		System.out.println(temp);
		System.out.print(charValue3);

		System.out.println("==============");
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4);//2 

		int intValue5 = 10;
		double doubleValue = intValue5 / 4.0;
		//int intValue6 = 10/4.0; //컴파일 에러
		System.out.println(doubleValue);//2.5
	

	}
}
