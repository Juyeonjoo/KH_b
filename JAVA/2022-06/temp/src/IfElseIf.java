
public class IfElseIf {

	public static void main(String[] args) {
		
		int score = 65;
		
		// 다중 if 조건문 = > 왜 다중? => 판정할 조건식이 2개 이상일 때 사용
		if(score >= 90) {  // if 블록
			System.out.println("점수가 100~90 입니다.");
			System.out.println("등급은 A 입니다.");
			
		} else if(score >= 80) { //else if 블록 : 다음 조건식을 구성하는 블록
			System.out.println("점수가 80~90 입니다.");
			System.out.println("등급은 B입니다.");
			
		} else if (score >= 70 ) { //else if 블록 : 다음 조건식을 구성하는 블록
			System.out.println("점수가 70~79 입니다.");
			System.out.println("등급은 C 입니다.");
			
		} 
		
		  else { //else블록: 위의 모든 조건식이 모두 false 일때 수행
		  System.out.println("점수가 70 미만입니다."); 
		  System.out.println("등급은 D 입니다."); }
		  //if-else if-else
		
	} // main
} //end-class
