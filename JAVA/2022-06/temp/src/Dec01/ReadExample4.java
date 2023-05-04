package Dec01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReadExample4 {

	public static void main(String[] args) throws Exception {
		@Cleanup
		Reader reader = new FileReader("C:/Temp/TTT2.txt", StandardCharsets.UTF_8);
		
		//문자 기반스트림에서 양동이는 byte[] 이 아니라, char[] 이다.
		
		char[] cbuf = new char[2];
		String data = "";
		
		
		//실제 읽어낸 문자개수를 반환(배열에는 실제 읽어낸 문자가 들어가고 read메소드의 리턴값은 읽어서 반환한다.>readCharNo)
		while(true) { //infinite loop
			int readCharNo = reader.read(cbuf); //Using Bucket,char[] array
			
			//Escape condition when countering EOF(End-Of-File, -1)
			if(readCharNo == -1) break;
			
			data += new String(cbuf, 0, readCharNo); //문자열 토큰생성및연결
			
		}//while
		
		System.out.println(data);
	}//main
}//end class
