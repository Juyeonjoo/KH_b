package Dec01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class ReadExample {
	//핵심포인트: 파일을 소스로, 파일의 데이터를 읽어보자(바이터 기반)
	public static void main(String[] args) throws Exception {
		
		//1. 바이트 기반의 파일 입력 스트림 객체 생성
		InputStream is = 
				
				//경로구분자(Path Separator) : 윈도우즈 ('\') 리눅스/맥/유닉스('/')
				//운영체제 상관없이 공통의 경로 구분지 : '/'
				//경로구분자란 폴더와 폴더를 구분해주는 기호
				new FileInputStream("C:/Users/user1/TTT.java"); // 다형성1
		//2. 파일로부터 얼마나 많은 바이트를 읽어내는지 저장하는 지역변수 선언
		int readByte;
		
		//3. 파일의 끝을 만날때까지, 계속해서 반복적으로 파일의 내용을 읽어서 콘솔에 출력
		while(true) { 	//무한루프
		
			readByte = is.read();	//파일입력스트림에서 1바이트를 읽어냄
			if(readByte == -1) {	//EOF : End Of-File
				
				break;	//탈출조건: 읽어낸 값이 -1이면 파일의 끝을 의미
		
				}//if
			
			//log를 읽기 위해서 
			System.out.print((char)readByte);		//읽어낸 바이트를 콘솔로 출력시 "문자"로 출력
		}//while
		//4. 모든 입/출력 스트림 객체는 소위 '자원객체이다.
		//즉, AutoClosable 하다. 때문에 다 사용하고 나면 반드시 닫아줘서 자원을 JVM으로 반납해야 함.
		is.close();
	}//main
	
} //end class
