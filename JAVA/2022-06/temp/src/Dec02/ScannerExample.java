package Dec02;

import java.util.Scanner;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class ScannerExample {

	//핵심포인트 : 표준입력처리를 대신해주는 Scanner 클래스
	public static void main(String[] args) {
		//1. 표준입력(System.in) 처리를 대신해줘야하기 때문에
		//생성자 매개변수에 표준 입력 전달
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("문자열 입력>");		//To show a prompt message
		
		
		//스캐너의 nextXXX메소드는 실제 사용자가 콘솔에서 입력과 엔터키를 누르기까지
		// 프로그램 실행흐름(쓰레드)를 중지시킴(blocking)
		//콘솔의 사용자 입력을 문자열로 반환
		String inputString = scanner.nextLine();		//<<-nextline기다림
		//Blocking I/O : 입력하지 않으면 무한정 기다린다.
		//<=> Non-Blocking => New IO(NIO)
		log.info("1. inputString: {}", inputString);
		System.out.println();
		
//		=========================================
		
		System.out.println("정수 입력>");
		int inputInt = scanner.nextInt();
		System.out.println();
				
//		=========================================
		
		System.out.println("실수 입력");
		byte inputByte = scanner.nextByte();
		System.out.println();
		
	}//main
}//end class
