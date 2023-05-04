
public class LogicalOperatorExample {

	// 논리연산자의 활용 : 보통 비교연산자와 논리연산자가 함께 사용되어
	// '조건문'/'조건식'을 작성하게 된다.
	public static void main (String[] args) {

		//비교연산자
//		boolean result = 1> 0;
//		boolean result = 1< 0;
//		boolean result = 1 <= 0;
//		boolean result = 1 <= 0;
//		boolean result = 1 == 0;// = (동등비교연산자) 하나는 대입연산자이므로,
//		boolean result = (1 != 0);
		
		//논리연산자: AND(그리고, &| &&), OR (또는, | ||), NOT(부정, !)
	
//		boolean result = (100>0) & (10 > 30); //논리 곱, 둘다 T어야만 True
		
		//이미 첫번째 항으로 and연산자 값이 false라는것을 알 수 있으니 두 번째 항은 판단하지 않음 
//		boolean result = (10 > 30) && (100 > 0) ; //short circuit, &과 &&의 결과는 동일 
		
		
		//boolean result = (100>0) | (10 > 30);// 논리 합, |파이프, 둘중 한만 T면 T
		
//		boolean result = (100>0) || (10 > 30);//short circuit
		
//		boolean result = (10 > 30) ||(100>0) ;//short circuit
		
		//		boolean result = !(100<0); // false가 나옴.
		
		boolean result =!10; // 상수를 부정할 수 없다. boolean type만 not을 붙일 수 있다.
		System.out.println( result );
				
//		int charCode = 'a'; //???문자를 저장하는 타입 char
//		
//		// '>=', '<=':비교연산자, '()': 우선순위연산자, '&':논리연산자(and)
//		if(
//				
//			(charCode>=65) // 첫번째 조건식
//			& 				// 그리고(AND)
//			(charCode<=90) //두 번재 조건식
//			
//		) {//charCode 를 이용해서 비교	
//			System.out.println("대문자이군요.");
		}
	}

