package Dec5;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import lombok.Cleanup;


public class InputStreamReaderExample {

	//핵심 포인트: 바이트 기반의 입력스트림(InputStream) => 문자 기반 입력스트림(Reader)
	//으로 자동변환해주는 보조스트림에 대해서 알자
	public static void main(String[] args) throws Exception {
//		@Cleanup : 표준 자원(표준 입력/출력/에러) 는 절대 닫으면 안된다.
		InputStream is = System.in; 	//표준 입력(System.in = in의 타입은 inputStream, 바이트기반)
		
		//바이트 기반 입력스트림(InputStream)>문자 기반입력스트림으로 자동변환해주는
		//보조 스트림 생성(이때, 생성자 매개변수로 base 스트림을 넣는다.)
		//주면, "보조스트림 체인"이 형성된다.
		@Cleanup
		Reader reader = new InputStreamReader(is, "UTF-8");
		
		int readCharNo;
		char[] cbuf = new char[100];		//바가지도 문자기반의 배열로 바뀜.
		while((readCharNo=reader.read(cbuf)) != -1) {
			String data = new String (cbuf, 0, readCharNo);
			System.out.println(data);
		}//while
		
		//자원해제: 핵심포인트2 - 보조스트림을 사용하는 경우,
		//			그림과 같이 프로그램에 가까운 보조스트림부터 차례대로
		//			보조스트렘 체인을 닫고 마지막으로 base 스트림을 닫는다.
		reader.close();		//보조스트림 해제
//		is.close(); 		//base 스트림 해제	(표준입력시스템 닫으면 안됨)	
	}//main
}//end class
