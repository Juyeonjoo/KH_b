package Dec01;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WriteExample5 {

	//핵심포인트: 문자기반 출력스트림에 문자출력시 양동이를 이용해서 출력
	public static void main(String[] args) throws Exception {
		
		@Cleanup
		Writer writer = new FileWriter("C:/Temp/TTT2.txt", StandardCharsets.UTF_8, true);
		
		//문자기반의 출력스트림은 문자열을 그대로 출력스트림에 write해주는
		//메소드 즉 write(String)가 있다. 때문에 더이상 양동이를 만들어
//		출력하지 않아도 된다.
		writer.write("jj");	//실제로는 출력버퍼(8KB)에 쓰기 수행

		writer.flush();		//출력버퍼에는 잔류가능한 문자들을 모두 강제로 내보내기 

	}//main
}//end class
