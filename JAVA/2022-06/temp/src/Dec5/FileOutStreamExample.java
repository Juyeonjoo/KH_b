package Dec5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileOutStreamExample {

	public static void main(String[] args) throws Exception {
		
		String sourceFileName = "C:/Temp/TTT2.txt";
		String targetFileName = "C:/Temp/TTT3.txt";
		
		@Cleanup("close")
		FileInputStream fis = new FileInputStream(sourceFileName);
		log.info("Size of source file: {}", fis.available());
		
		@Cleanup
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo;
		byte[] readBytes = new byte[100];				//바가지 생성
//		byte[] readBytes = new byte[fis.available()];	//읽을 바가지만큼 
		
		int counter = 0;
		while((readByteNo = fis.read(readBytes)) != -1) {	//바가지로 읽어내고
			fos.write(readBytes,0, readByteNo);				//바가지로 출력
			//readByteNo 인덱스(length)는 포함되지 않는다.
			log.info("\t + counter: {}", ++counter);		//반복이니까 증감연산자 앞에
		}//while
		
		fos.flush();	//출력버퍼에 잔류 가능한 바이트들을 강제로 flush
		
		//자원 해제
		fos.close();
		fis.close();
		
		// 닫는 순서: 아래에서 위로,
		
		log.info("File Copy Finished.");
		
	}//main 
}// end class
