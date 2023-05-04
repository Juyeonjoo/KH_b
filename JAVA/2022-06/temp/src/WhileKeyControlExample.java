import java.io.IOException;

public class WhileKeyControlExample {

	public static void main(String[] args) throws IOException {
		boolean run = true;
		int speed = 0;
		int keyCode = 0;
		
		
		while(run) { //run flag 변수, break대신.
			
			if(keyCode!=13 && keyCode!=10) {
				System.out.println("---------------------------------");
				System.out.println("1.증속 | 2. 감속 | 3. 중지");
				System.out.println("---------------------------------");//출력후 다음행 이동
				System.out.print("선택: ");// 선택 : 에 커서가 있다.
			}//if
			
			//키보드로부터 1개의 자판의 코드를 읽어내는 문장
			keyCode = System.in.read(); //4byte로 약속.
//			System.out.println("**** keyCode: " + keyCode); //>13읽고 if가고, 내용없어서 다시 10,> 조건식 아무것도 없어서 출력안함.> 대기 상탤빠짐
//			if(keyCode ==13 || keyCode == 10) {
//				continue; //while문이라면 조건식으로 보낸다. (위에)
			
			if(keyCode != 49 && keyCode != 50 && keyCode != 51) {
				continue;
//				                                                         
			}//if
			
			if(keyCode == 49){// 키보드에서 누른 키가 1이면
				
				speed++;
				
				System.out.println("현재 속도 =" +speed);
			} else if (keyCode == 50) { //키보드에서 누른 키가 2이면
				speed --;
				System.out.println("현재 속도" + speed);
			} else if (keyCode == 51) {//키보드에서 누른 키가 3이면 
				run = false;
			}// if-else if
			}// while
			
			System.out.println("프로그램 종료");
	} //main
} //end class
