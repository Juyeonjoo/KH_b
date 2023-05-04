package Dec5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BufferedReaderExample {

	//핵심포인트: 성능보조스트림으로 이번에는 문자기반 입력스트림인 Reader에
//	Buffer(힙에 생성되는 임시 메모리 공간)을 생성하는 BufferedReader에 대해서 알아보자
	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in; 		//표준입력(SYstem.in -> inputStream)
		
		//보조스트림 체인 구성: 
		//1) base 스트림 > 2) 문자변화보조스트림 3) 성능보조스트림 연결
		@Cleanup Reader reader = new InputStreamReader(is);
		@Cleanup BufferedReader br = new BufferedReader(reader);
		
		log.info("1. 입력: ");				//Prompt Message
		String lineString = br.readLine();	//Blocking I/O
		
		log.info("2. 출력: " + lineString);
		
		//보조스트림 역순으로 자원 해제, 표준자원은 절대 닫지 말기.
		br.close();
		reader.close();
		
	}//main
}//end class
