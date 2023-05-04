package temp;

public class WhilePrintFrom1to10 {
	
	//1~10까지의 숫자를 차례대로 출력하는 예제
	public static void main(String[] args) {
		int sayHelloCount = 0;
		
		//아래와 같이 명시적으로 무한루프를 만드는 경우에는
		//반드시 탈출조건을 준비하고 코딩해야 한다. (ex, if문 GE
		
		boolean isExit = false; //무한루프를 종료시킬지 결정
								//소위 "플래그(flag) 변수"
//		while(true) { // infinite loop
		while(!isExit) { 	//infinite loop
		if(sayHelloCount ==10) {//전위, 10번 후위,11번
//			break;	// 이 문장으로 탈출할 수 있지만
			isExit = true; // 실전에서는 매끄러운탈출이 되기 위해 
							//플래그 변수 사용 많이 한다.
			continue; // Skip 처리 
			
			} //if
			System.out.println("Hello!!!");
			System.out.println(++sayHelloCount); // print후에
			
//			sayHelloCount++; // sayHelloCount 하나 올라가야 하기 때문에
		} //while
	} //main
} //end class
 