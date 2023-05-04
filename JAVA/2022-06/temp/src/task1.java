//1. 문자열을 입력받는다
//2. 배열을 생성한다.
//3. 만약 사용자가 입력한 값이 0~4의 값과 4 > 0의 값이 동일하면 에너그렘이다.
//4. 동일하지 않다면 에너그램이 아니다.

import java.util.Arrays;
import java.util.Scanner;

public class task1 {
	public static void main(String[] args) {
		
		System.out.println("입력");

		
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		char[] charArr =name.toCharArray();
		System.out.println(Arrays.toString(charArr));
		
		
		int i = 0;
	
		for(i = 0; i < charArr.length; i++){
		if ( charArr[i] == charArr[(charArr.length)-(i+1)] );

			}// for
		System.out.println("에너그램입니다.");
		
		
	} // main 
} // end class
