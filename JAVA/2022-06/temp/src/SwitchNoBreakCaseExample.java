
public class SwitchNoBreakCaseExample {
	//break문을 생략하며 fall through 발생 예제
	public static void main(String[] args) {
		
		//8<= ... <12(8+4) 사이의 정수 얻기
		int time = (int)(Math.random()*4) + 8;
		
		System.out.println("[현재 시간: " +time+  " 시]");
		
		time =11;
		switch(time) {
		default:
			System.out.println("외근을 나갑니다.");
			break;
			
		case 8:
			System.out.println("출근합니다.");
		case 9:
			System.out.println("회의를 합니다.");
		case 10:
			System.out.println("업무를 봅니다.");
			break;
			
		} //switch
	} //main 
} //end class
//
//[현재 시간: 8 시]
//출근합니다.
//회의를 합니다.
//업무를 봅니다.
//외근을 나갑니다.

//[현재 시간: 9 시]
//회의를 합니다.
//업무를 봅니다.
//외근을 나갑니다.

