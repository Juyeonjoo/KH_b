package Dec01;

import java.io.FileInputStream;
import java.io.InputStream;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReadExample2 {

	//핵심 포인트: 파일 입력스트림에서 바이트를 읽을 때
//	***양동이로 푸자
	public static void main(String[] args) throws Exception {
		@Cleanup("close")
		InputStream is = new FileInputStream("C:/Users/user1/TTT.java");
		int readByteNo;		//실제 입력스트림에서 읽어낸 바이트 개수를 저장하는 변수
		byte[] readBytes = new byte[];	//양동이 생성(크기 3)
		String data = "";
		
		while(true) { //무한루프
			readByteNo = is.read(readBytes);//인자로 주어진 양동이로 퍼냄
//			(매개변수 없는 read는 손으로 퍼내는 것)
			//파일의 끝(EOF, End-Of-File)을 만나면 무한루프 종료시킴
			if(readByteNo == -1) break; //탈출 조건
			
			//양동이에 저장된 바이트를 가지고 문자열 조각(Token)을 만들어서
			//계속 이전의 token과 이어 붙임
			data += new String(readBytes, 0, readByteNo);
		}//while
		
		System.out.print(data);		//최종 문자열 출력
		is.close();			//입력스트림 자원 객체 해제
		
	}//main
} //end class
