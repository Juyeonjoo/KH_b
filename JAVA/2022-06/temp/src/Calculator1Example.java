
class Calculator1Example {

	public static void main(String[] args) {
		
		Calculator myCalc = new Calculator();
		System.out.println("myCalc : " + myCalc);	//myCalc : Calculator@24d46ca6
		
		//메소드 실행문법: <참조변수명><dot연산자><실행할 메소드명(전달인자)>
		//					참조변수.메소드(전달인자1, 인자2, ....);
		//					* 실행문장이므로 세미콜론(;)으로 마감처리함
		myCalc.powerOn();
		
		
//		===============
		
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1: " + result1);
		
//		===============
		//전달인자의 타입이, int가 아니라 byte 타입?
		
		byte x = 10;
		byte y = 4;
								//매개변수: int x, int,y
		double result2 = myCalc.divide(x,y);
		System.out.println("result2: " + result2);
		
		//결국 아래와 같이 메소드의 매개벼수와 전달인자 간의 관계는
		// 아래와 같이 메소드의 매개변수에 전달인자를 초기값으로 초기화 해주는
		// 매개변수의 정의와 같다.
		
		int x = byte x; //메소드 호출될때 넣어주는거다. 
		
		
	} //main
} // end class
