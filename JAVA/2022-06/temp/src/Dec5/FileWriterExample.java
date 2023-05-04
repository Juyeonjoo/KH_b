package Dec5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileWriterExample {

	public static void main(String[] args) throws Exception {
		
		File file = new File ("C:/Temp/TTT7.txt");
		FileWriter fw = new FileWriter(file,true);	//두번째 매개변수: 추가모드(append)
		
		try (fw;) {	//fw는 try-with 블록 끝에서 만나면 자원해제됨.

		fw.write("FileWriter는 한글로된 " + "\r\n");
		fw.write("문자열을 바로 출력할 수 있다." + "\r\n");
		
		fw.flush();		//강제 flush 반드시 한번 수행
		
		log.info("File Write Done.");
		}//try-with-resources
		//try-with는 단독으로 사용 가능.
		
	}//main
}//end class
