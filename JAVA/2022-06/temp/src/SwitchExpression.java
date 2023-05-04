
public class SwitchExpression {

	public static void main(String[] args) {
		
	// - (5) Switch Exrpression 연습 #5
	// 값을 생성하는 표현식의 역할 수행
	// 단, Lvalue가 없는 경우
		
		String myName = "Yoseph";
		
		String s = switch(myName) {
		
		// switch expression이 값을 생성하는 용도로 사용되는데,
		// Lvalue의 변수가 준비되지 않으면 (생략되면) Rvalue의 
		//switch expression은 무조건 오류
			case "Yoseph" -> "Yoseph"; //
			case "Trinity" -> "1000"; // ok
			// 각 case의 값은 고유해야 한다.
//			case "Trinity" -> "100";
			case "Pyramid" -> {	 		//ok
				String firstName = "Yoseph";
				String lastName = "Kim";
				
				yield firstName+ "," + lastName;
			}
			default 		-> myName; // = { yield myName; }
		};// switch expression
			
	
	} //main 
	
} // end class
	



// -- (1) 기존의 Switch 문 복습
// int value = 100;
/*
switch(value) {
case 100 : 
case 200 : 
case 300 : 
default	 : System.out.println(value); break;

} // switch

// -- (2) Switch Expression 문장 : 연습 #1
value = 1000;
switch(value) {
// 여러개의 값과 일치하게 하려면 쉼표(,)로 구분 	
case 100,200,300 -> { //실행문장을 여러개로 하고 싶으면
	
	System.out.println(value);
	System.out.println(value);
	System.out.println(value);
}
//실행문장은 오른쪽 화살표 기호 -> 우측 기술
// 실행문장이 0개 이상이라면, {} 중괄호 블록 구성하되,
// 가.1개의 실행문장은 {}중괄호 기호 생략하라
// 나. 0개의 실행문장이라면, {} 중괄호 안에 Pass 키워드(;;) 기술할 것
case 400 -> System.out.println(value);
// 생략 가능
		 //pass 
} // default
default -> {

} ////switch expression	

// --(3) Switch Expression 문장 : #연습2
//		값을 생성하는 표현식의 역할을 수행하자

value = 100;
boolean defaultValue = false;

boolean result = switch (value) {
case 100,200	-> true; // 값을 생성할 때 literal, 
case 300 		-> false;
default			-> defaultValue; // 변수로 값을 생성해도 ok

}; // switch expression

System.out.println("result = " + result);


// --(4) Switch Expression 문장, : 연습 #2
//값을 생성하는 표현식의 역할을 수행하자

//자바 14 부터 표준기능으로 포함된 Switch Expression에 대해서 배우자
public static void main(String[] args) {

int intValue = 4 ;

int result2 = switch(intValue) {

	case 4 -> {
								//연산식을 통해, 값을 생성하려면, yield 키워드로 생성
		yield 4 * 4 ;			//4의 2승(지수승 계산)
	}
	//1개 밖에 없는 값을 생성하는 실행문장 안에 yield 키워드가 있다면, 
	// {} 중괄호 기호를 생성할 때, yield 키워드까지 생략해야만 한다. 
	case 3 -> 3 * 3;
	
	case 5 -> 1000;
	
	case 6 -> intValue;
	
	default -> { // switch expression이 값을 생성하는 Rvalue역할을 한다면
		//	생략 불가
		//연산식을 통해 값을 생성하려면 yeild 키워드로 생성
		yield intValue * intValue;
	}
	
} // switch expression


System.out.println(result2);


*/
//단, 생성할 값을 복잡한 연산식을 통해 생성하자
