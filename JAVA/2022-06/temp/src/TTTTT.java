import java.util.Scanner;

public class TTTTT {

	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");

		Scanner scanner = new Scanner(System.in); //
		
		String inputString; // 문자열 변수 '선언', 초기화x 정의 x 
		
		do { //do while block
			System.out.print(">"); //Prompt 메시지 출력, println아님
			
			//스캐너(Scanner)를 통해 사용자가 키보드로 입력한 행을
			//문자열로 입력받을 수가 있다.
			//그게 아래의 scanner.nextLine();//실행문, 문자열로 생성.
			// 이 실행문장은 사용자가 입력한 값을 문자열(String타입)로 만들어 돌려줌
			inputString =scanner.nextLine(); //사용자가 입력한 행을 문자열로 읽음
			System.out.println(inputString);
		} while(! inputString.equals("q")); // 세미콜론 붙여야 함, 조건식
		
		scanner.close();
		
		System.out.println();
		System.out.println("프로그램 종료");
	}
}