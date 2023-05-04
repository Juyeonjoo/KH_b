
public class DenyLogicOperatorExample {

	//논리연산자(and, or,not) 중에, "부정"연산자(NOT) = > 연산자 기호: !
	public static void main(String[] args) {
		
		boolean play = true;
		System.out.println(play);
		
//		==================
		
		play = !play; // 토글(Toggle) 스위치의 개념.
		System.out.println(play);
//		==================
		
		play = !play;
		System.out.println(play);
	} //main
} // end class
