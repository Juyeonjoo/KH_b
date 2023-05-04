package Dec5;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BufferedInputStreamExample {

	//핵심포인트: 성능을 대폭 향상시키는 성능보조스트림에 대해서 배우자
	// BufferedInputStream/ BufferedOutputStream
	// 즉, 입/출력스트림에 버퍼를 생성함으로써 성능을 향상시킴
	public static void main(String[] args) throws Exception {
		
		//성능에 관한 측정 시도
		long start = 0;
		long end = 0;
		
//		===================================
		@Cleanup
		FileInputStream fis1 = new FileInputStream("C:/Temp/TTT2.txt");
		
		start = System.currentTimeMillis();
		
			while(fis1.read() != -1) {}
			
		end = System.currentTimeMillis();
		
		log.info("1. when no using input buffer" + (end-start) + "ms");
//		fis1.close();
		
//		===================================
		@Cleanup
		FileInputStream fis2 = new FileInputStream("C:/Temp/TTT2.txt");
		
		//성능보조스트림 생성
		@Cleanup
		BufferedInputStream bis = new BufferedInputStream(fis2);
		//입력스트림에 없는 buffer, 보조 
		//출력스트림에는 이중으로
		start = System.currentTimeMillis();
		
			while(bis.read() != -1) {}
		
		end = System.currentTimeMillis();
		
		log.info("2. when using input buffer:" + (end-start) + "ms");

	}//main
}//end class