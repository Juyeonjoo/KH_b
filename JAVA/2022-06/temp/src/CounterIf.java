
public class CounterIf {
	
	public static void main(String[] args) {
		
		int counter = 1;
		
		for (	;	;	) {
			if(counter <= 10) {
				
				System.out.println(counter);
				
			} else {
				
				break; // for문을 종료
			} //if-else
			
			counter ++;
		}//for 
		
		System.out.println("* counter: " + counter); //무한루프, 거짓일때의 나오는 값이 없다.
	}
}
