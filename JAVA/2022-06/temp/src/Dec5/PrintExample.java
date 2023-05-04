package Dec5;

import java.util.Date;

public class PrintExample {

	//핵심포인트: PrintStream/Printwriter 보조스트림이 제공하는 메소드에 대해 익히자
	public static void main(String[] args) {
		//ystem.out => 표준출력(PrintStream)
		//printf - formatting
		System.out.printf("상품의 가격 : %d원\n", 123); 	//%d 정수값
		System.out.printf("상품의 가격 : %6d원\n", 123);	//%6d 여섯자리숫자로만들어줌, 오른쪽 정렬
		System.out.printf("상품의 가격 : %-6d원\n", 123);	//%-6d 왼쪽 정렬
		System.out.printf("상품의 가격 : %06d원\n", 123);	//남는 자릿수에 0을 넣겠다.
		
		System.out.printf("반지름이 %d 인 원의 넓: %10.2f\n", 10,Math.PI*10*10);
		//10자리 중에 2자리가 소숫점 이하 자리 수 입니ㅏㄷ.
		//가변인자.> 자바에서 유용하지는 않다.
		System.out.printf("%6d | %-10s | %10s\n", 1, "홍길동","도적" );
		//6자리 공간, 정수 넣고 왼쪽에 붙이고 문자열 오른쪽 정렬 도적 넣고, 
		
		//날짜와 시간 정보를 가지고 있는 달력객체(즉, 달력을 모델링해서 만든 클래스)
		Date now = new Date();		//생성자가 , 현재의 날짜와 시간 정보를 가지고 있는
		//달력객체를 생성!!!
		
		System.out.printf("오늘은 %tY년 %tm월 %td일 입니다\n", now, now, now); //%ty
		System.out.printf("오늘은 %1$tY년 %1$tm월 %1$td일 입니다\n", now);
		System.out.printf("현재 %1$tH시 %1$tM분 %1$tS초 입니다\n", now);
	}//main
	
}//end class
