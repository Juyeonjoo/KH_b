
public class AssignmentOperatorExample {

	public static void main(String[] args ) {
		//복합대입연산자: 다른 연산자와 합쳐져서, "복합" 용어 사용
		// 각각의 연산자가 자신의 연산을 수행
		
		int result = 0;
		result +=10; //
		System.out.println("1. result=" + result);
		
		result -= 5;
		System.out.println("2. result=" + result);
		
		result *=3;
		System.out.println("3. result=" + result);
		
		result /= 5;
		System.out.println("4. result=" + result);
		
		result %= 3;
		System.out.println("5. result=" + result);
	} // main
} // end class
