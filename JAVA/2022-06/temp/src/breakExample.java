
public class breakExample {

	//주사위를 던져서 6이라는 눈이 나오면, 프로그램 종료
	public static void main(String[] args) {
		
		TTT:while(true) {//무한루프
			int num = (int)(Math.random()*6) + 1; //주사위를 던진다.
			System.out.println(num); //주사위 눈 출력
			
			// 무한루프의 "탈출 조건"
			if(num == 6) {//만일 주사위 눈이 6이 나오면
				break TTT; //반복문을 깨트리고 나오라(주의! 조건문은 상관없음)
				
			}// if
	
		}//while
	
		System.out.println("프로그램 종료");
	
	} // main
	
}// end class
