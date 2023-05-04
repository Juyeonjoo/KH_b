
public class IfElseExample {

	public static void main(String[] args) {
		
		int score = 85;
		
		if(score >= 90) { //조건식이 true일 때, 수행되는 블록
			
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A 입니다.");
			
		} else { // 조건식이 false 일 때 수행되는 블록

			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B 입니다.");
		} // if-else
		
	} // main 
} // end class
