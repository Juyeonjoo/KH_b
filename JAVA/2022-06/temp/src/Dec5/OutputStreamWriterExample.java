package Dec5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

	//핵심포인트: 문자변환출력보조스트림에 대해서 알자
//	OutputStream = > Writer 로 변환
public class OutputStreamWriterExample {

	public static void main(String[] args) throws Exception {
		//Base 바이트 기반의 출력 스트림 생성
		FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
		
		//문자 변환출력보조스트림 생성
		Writer writer = new OutputStreamWriter(fos, "UTF-8");
		
		//출력시킬 문자 데ㅣㅇ터 준비
		String data = "바이트 출력 스트림을 문자 출력 스트림으로 변환";
		
		//문자변환출력보조스트림의 출력메소드로 문자 데이터 출력
//		=>바이트로 변환 / 출력
		writer.write(data);
		
		writer.flush();		//반드시 강제 flushing 수행 필요
		
		//자원해제: 보조스트림 체인의 역순으로 모두 닫아나가고, 마지막에
		//	Base 스트림까지 닫아줘야 한다.(*순서 지켜야 함*)
		writer.close();			//보조스트림해제
		fos.close();			//표준 자원이 아니기 때문에 반드시 base 스트림도 닫아줘야 함
		
		
		System.out.println("파일 저장이 끝났습니다.");
	}//main
}//end class
