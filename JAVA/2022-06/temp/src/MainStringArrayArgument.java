import java.util.Arrays;

public class MainStringArrayArgument {
	
	//main 메소드의 매개변수에 있는 배열(STring[] args)의 정체와 용법
	public static void main(String[] args) {
		
		System.out.println(args.length); //2
		System.out.println(Arrays.toString(args));//Arrays 클래스, 배열 출력
		
		System.exit(100); //0: Normal Exit, Others: abnormal Exit
		
		if(args.length !=2) {
			
			System.out.println("프로그램의 사용법");
			System.out.println("java MAinstringArrayArguement num1 num2");
			
			//이 문장을 실행하면, 묻지도 따지지도 않고 그 즉시 프로그램 종료
			System.exit(0); // 이때 숫자 0을 Exit Code(종료 코드)라고 한다.
			
		}//if
		
		String strNum1 = args[0]; // "100"
		String strNum2 = args[1]; // "200"
		
		
		//"숫자형태"의 문자열 => 진짜 int 타입의 정수로 바꿔줌(=매핑, Mapping 이라고 함)
		int num1 = Integer.parseInt(strNum1); //java standard library에 있는 표준 class,
		int num2 = Integer.parseInt(strNum2); //Integer 클래스, parseInt 메소드, 
	
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	} //main
} // end class
