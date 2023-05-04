	
public class SignOperatorExample {

	public static void main(String[] args) {
		
		//부호 연산자(단항, Unary) 예제 : +, -
		// 목적: 변수값의 부호를 (1) 유지하거나, (2)로 바꿀때사용
		// 주의: 부호 연산자의 ㅅ나출 결과는 'int'타입이 된다.
		
		int x = -100;
		
		int result1 = +x; //부호 유지
		int result2 = -x;
		
		System.out.println("result1= " + result1); //result1= -100 
		System.out.println("result2= " + result2); //result2= 100

		// - 연산자> -로 인해서 부호가 바뀐 결과값은 정수연산, 정수연산은 기본 int타입
		//큰 타입을 작은 타입에 넣으려고 하니까 오류
		//소괄호안에 쪼갤 작은 타입 기재
		short  s = +100;
		
//		short result3 = -s; 컴파일 오류
		short result3 = (short) -s; //컴파일 에러
		int result4 = -s; // 왜 4byte인 int? 로만 될까
		
		System.out.println("result3= " + result3); //result3= -100
		System.out.println(result4);
		
	}
}
