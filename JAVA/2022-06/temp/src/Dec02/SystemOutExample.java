package Dec02;

import java.io.IOException;
import java.io.OutputStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SystemOutExample {

	//핵심포인트: 표준자원인, 표준출력(System.out)이용해보자
	public static void main(String[] args) throws Exception {
		
		OutputStream os = System.out; 	//1. 표준출력을 참조 변수에 저장
		
		for(byte b = 48; b<58; b++) {	//2. ASCII 표준 테이블에서 48~57까지의 숫자를
			os.write(b);				//그대로 표준출력을 통해 출력하면 문자로 출력
		}//for
		
		os.write(10);					//0123456789, LF(Lined Feed, 행바꿈 문자) 출력

		//		==================================================
		for(byte b=97; b <123; b++) {	//2.ASCII테이블에서, 97~122까지의 숫자를
			os.write(b);				//그대로 표준출력을 통해 출력하면 문자로 출력
		}//for
		
		os.write(10);					//abcdefghijklmnopqrstuvwxyz, LF(Lined Feed, 행바꿈 문자) 출력
		
		
//		os.write(10000);					//아스키코드 바깥 입력하면 예상하지 못한 값 출력됨.	
		
		os.write(100);					//아무것도 출력되지 않음
		os.write(101);
		os.write(102);
		
//		for(int i = 128; i <=200; i++) {		//ASCII코드 범위외의 정수 출력
//			os.write(i);						
//		}//for
//		os.flush();
//		==================================================
		String hangul ="가나다라마바사아자차카타파하";
		byte [] hangulBytes = hangul.getBytes();		//String ->byte[]로 변환
		os.write(hangulBytes);  //byte[] 출력
		
//		os.flush();
	}//main
} //end class
