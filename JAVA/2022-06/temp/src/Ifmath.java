
public class Ifmath {

	//주사위(주사위 눈 : 1~6까지)
	// 자바 언어에는 무작위수(=난수)를 생성하는 Random Number Generator가
	//이미 구현되어있고, 이를 이용하려면 "Math.random()"이란 코드를 실행하면 된다
	public static void main(String[] args) {
						// [0.0, 1.0)
		int num =(int)(Math.random()*6) + 1; // 우리가 지정한 범위내의 "무작위 정수" 획득
		
		if(num == 1) {
			
			System.out.println("1번이 나왔습니다.");
		}
		else if ( num ==2 ) {
			System.out.println("2번이 나왔습니다.");
		}
		else if ( num == 3 ) {
			System.out.println("3번이 나왔습니다.");
		}
		else if ( num ==4 ) {
			System.out.println("4번이 나왔습니다.");
		}
		else if ( num == 5 ) {
			System.out.println("5번이 나왔습니다.");
		} else {
			System.out.println("6번이 나왔습니다.");
		} //if-else if-else
	
		} //main
} // end class
