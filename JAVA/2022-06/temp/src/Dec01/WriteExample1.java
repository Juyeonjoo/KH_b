package Dec01;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WriteExample1 {

	public static void main(String[] args) throws Exception {
		
		//핵심포인트: 문자기반의 출력스트림인 FileWriter 객체를 사용해보자
		@Cleanup
		Writer writer = new FileWriter("C:/Temp/TTT2.txt", StandardCharsets.UTF_8, true);
		
//		=============================================
		//문자열(String) = > char[] 배열로 변환
//		char[] data = "홍길동".toCharArray(); //getBytes에 대응되는, 캐릭터타입의 메소드를 만들어주는
//		for(int i = 0; i<data.length; i++) {
//			writer.write(data[i]);			//한 문자씩 출력
//		}//for
//		=============================================
		writer.write("홍길동");				//write(String)메소드 이용해서 출력(한줄인데)
		
		writer.flush();		//출력버퍼의(8kb)의 강제 flushing

	}//main
} //end class
