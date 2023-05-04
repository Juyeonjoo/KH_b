
public class IfNestedExample {

	// 제어문의 중첩(Nested) : 제어문 블록 안에, 또 다른 제어문이 나온다.
	//중첩의 깊이(Depth) 제약은 없다.
	//주의 사항: 3depth 이상 나오게 하지 말 것
	
	public static void main(String [] args) {
		//아래의 실행문장 중요.
		int score = (int)(Math.random()*20) + 81; // *****//
		
		System.out.println("점수: " + score);
		
		String grade;
		
		if(score >= 90) {
			
			//중첩된 (Nested) if-else문
			if(score >= 95) {
				grade = "A+" ;
			} 
			else {
				grade = "A";
			}//Inner if-else 
			
		} else {
			
			//중첩된 (Nested) if-else문
			if(score >= 85) {
				grade = "B+";
			} else {
				grade = "B";
			} //Inner if-else
			
		} //Outer if-else
		
		System.out.println("학점: " + grade);
	} //main
} // end class
