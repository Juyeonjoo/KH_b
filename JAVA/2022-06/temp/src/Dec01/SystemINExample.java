package Dec01;

import java.io.IOException;
import java.io.InputStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SystemINExample {

	//표준입력(즉,키보드)의 사용예: 사용자의 키보드 입력을 수신
	public static void main(String[] args) throws Exception {
		
		//이거 그대로 나와야 하니까 sysout으로, log.info는 이것저것 많이 찍혀나오니까
		System.out.println("===메뉴===");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");	
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료하기");
		System.out.println("메뉴를 선택하세요: ");
		
		InputStream is = System.in;				//표준입력(InputStream객체)
		
		
		//int java.io.InputStream.read() throws IOException
		char inputChar = (char) is.read();		//read() 1바이트만 읽음, 
		//1바이트를 읽지만 반환하는건 4byte int 
		// public abstract int read() throws IOException;
		
		switch(inputChar) {
		case '1'-> log.info("예금 조회를 선택하셨습니다.");			
		case '2'-> log.info("예금 출금을 선택하셨습니다.");			
		case '3'-> log.info("예금 입금을 선택하셨습니다.");
		case '4'-> log.info("종료 하기를 선택하셨습니다.");
		}// switch expression
		
	}//main
} //end class
