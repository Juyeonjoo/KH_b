
public class IfExample {

	// 점수에 따라 등급을 출력하는 예제, 물론 등급은 A,B만 있다는 가정
	public static void main(String [] args){

		int score = 0;
		
		
		// 위의 변수선언문과 그 다음의 실행문장 또는 제어문 사이는 공백 2개 행 //을 넣어준다.
		if (score >= 90) { 
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A 입니다.");
		} //if
		
		if(score < 90) { // 중괄호 기호 생략하지 말것, 만약 {}없으면 if문과 상관없는 문장이 되어버림.
			System.out.println("점수가 90보다 작습니다.");

		} //if2
		
		System.out.println("등급은 B입니다.");
		
		//조건에 따라, 실행시킬 문장이 하나도 없다면,
		//아래와 같이 바로 세미콜론(;)으로 마감 처리
		if (score == 0); // 동등비교연산자,if문이지 실행문x, if문을 실행시킬 실행문장이 없다면 ;(중괄호 생략이 아님)
			
	
	} //main
}//end class
