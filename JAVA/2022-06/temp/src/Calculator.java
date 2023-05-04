
public class Calculator {
	// 1. 필드


	// 2. 생성자

		public Calculator(){
			;;
		}
		
	//  3. 메소드

	int plus(int x, int y) {
		//메소드 호출 로그
		System.out.println("Calculator::plus(int,int) invoked.");
		
		int result = x + y;
		
		return result;
	} // plus
	
	double avg(int x, int y) {
		System.out.println("Calculator::avg(int, int) invoked.");
		
		
		//*** 주의사항 ***
		// 같은 클래스 내부에 선언된 다른 메소드를 호출할 때에는,
		// 아래와 같이 메소드명 만으로 호출 가능.
		
		//그러나 필드와 동일한 원칙으로 아래와 같이 메소드 호출하지 말기
		// 대신, this.메소드명/this.필드명으로 사용할 것
		
//		double sum = plus(x,y);			// xx: 관례 안따름
		double sum = this.plus(x,y);	// ok: 관례따름
		double result= sum / 2;
		
		return result;
	} //avg
	
	void execute() {
		System.out.println("Calculator::execute() invoked.");
		
		//같은 클래스에 선언된 다른 메소드 호출
//		double result = avg(7,10); 			//xx : 관례 안따름
		double result = this.avg(7,10);		//ok : 관례 따름
		
		this.println("실행결과: " + result);		//클래스의 구성멤버를 사용할 때는 this.
	} // execute
	
	void println(String message) {
		
		System.out.println("Calculator::println() invoked.");
		
		System.out.println(message);
	} // println
	
} //end class	


//	
//	double divide(int x, int y) {
//		System.out.println("Calculator::divide(int, int) invoked.");
//
//}		
//		double result = (double)x / (double)y;
//		
//		return result;
//	} // divide
//	
//	void powerOff() {
//		System.out.println("Calculator::powerOff() invoked.");
////		System.out.println("전원을 끕니다.");
//	} //powerOff
