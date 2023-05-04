import java.util.Scanner;

public class DoWhileExample {

	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");

	
		//이전 예제에서 우리는 사용자의 키보드를 입력받기 위해서,
		// System.in.read(); 라는 실행문장을 이용했습니다.
		// 그런데 이 방식은 ㅈ기접 개발자가 자판의 key code값을 처리해야하는
		//불편함이 있어서 자주 사용하기 곤란
		
		//이러한 불편함을 해소할 수 있는게 "Scanner" 
		
		//"이 Scanner는 사용자가 입력을 1개 문자가 아니라, 문자열로도 쉽게 입력"
		//받을 수 있도록 실제 정수/실수 등의 기본 타입으로도 입력받을 수 있게 해줌
		//즉, 결국은 Scanner안에서는 System.in.read()가 사용되지만,
		// 개발자의 키코드 처리를 깔끔하게 함.
		Scanner scanner = new Scanner(System.in); //
		
		String inputString; // 문자열 변수 '선언', 초기화x 정의 x 
		
		do { //do while block
			System.out.print(">"); //Prompt 메시지 출력 
			
			//스캐너(Scanner)를 통해 사용자가 키보드로 입력한 행을
			//문자열로 입력받을 수가 있다.
			//그게 아래의 scanner.nextLine();실행문
			// 이 실행문장은 사용자가 입력한 값을 문자열(String타입)로 만들어 돌려줌
			inputString =scanner.nextLine(); //사용자가 입력한 행을 문자열로 읽음
			System.out.println(inputString);
		} while(! inputString.equals("q")); // 세미콜론 붙여야 함
		
		scanner.close();
		
		System.out.println();
		System.out.println("프로그램 종료");
	}
}
