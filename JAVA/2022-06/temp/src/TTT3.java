
public class TTT3 {

	public static void main(String[] args) {
		
		int counter = 1;
		
		// 1. 초기식은 생략 가능
		// 2. Counter 변수는 꼭 초기식에서 정의할 필요 없다.
		for(	; counter <= 10; counter++) { // 초기식 생략 가능, main에서 생성 가능
			
			System.out.println(counter);
		} //for 
		System.out.println(" * counter : " + counter );
		
	} //main
} //end class
