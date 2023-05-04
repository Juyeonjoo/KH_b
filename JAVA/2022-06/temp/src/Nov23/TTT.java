package Nov23;

import java.util.Scanner;

public class TTT {
public static void main(String[] args) {
	
	try {
		
Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		System.out.println("두 수의 나눗셈 결과 : " + num1 / num2 );
		
	} catch(ArithmeticException e) {
		e.printStackTrace();
		System.out.println("부적절한 나눗셈을 시도했습니다.");
	} //try-catch
	
	ㅁㄱㄱ묘
}
		
}
