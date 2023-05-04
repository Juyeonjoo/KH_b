package Dec5;

import java.io.FileReader;
import java.io.IOException;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileReaderExample {

	//문자 기반 입력스트림임 Reader 에 대해서 사용법 익히자
	public static void main(String[] args) throws IOException {
		
		//운영체제 공통의 파일 경로 구분자 (Path separator)는 Slant('/')임
		
		@Cleanup
		FileReader fr = new FileReader("C:/Temp/TTT2.txt");		
		
		char[] cbuf = new char[100];	//바가지
		
		int readCharNo;
		while((readCharNo=fr.read(cbuf)) != -1) {
			//char[] => String(Token) 으로 변환(도구: String 클래스의 생성자)
			String data = new String (cbuf, 0, readCharNo);
			System.out.print(data);
		}//while
		
		fr.close();
		
	}//main
}//end class
