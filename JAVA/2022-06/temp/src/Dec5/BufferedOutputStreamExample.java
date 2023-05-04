package Dec5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BufferedOutputStreamExample {

	//핵심 포인트: Base 출력 스트림(OutputStream/Writer)에
	//성능보조스트림(BufferedOutputStream/BufferedWriter)을 붙이면 성능대폭향상
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = null;		//Base 입력스트릠
		FileOutputStream fos = null;	//Base 출력스트릠
		
		BufferedInputStream bis = null;	//성능보조입력스트림
		BufferedOutputStream bos = null;//성능보조출력스트림	
		
		int data = -1;
		long start = 0;
		long end = 0;
		
		fis = new FileInputStream(".exe");		//Base 입력스트림 생성
		bis = new BufferedInputStream(fis);	//성능입력보조스트림 연결
		
		//Base 출력스트림 생성
		//참조변수의 선언과 초기화가 분리되면 Cleanup 어노테이션 못씀>try with resource 사용
		fos = new FileOutputStream("copy.exe");
		
		try(fis;bis;fos;){		//선언과 초기화가 분리되었다면, 이렇게 못쓴다. try(fis;bis;fos;)
		start = System.currentTimeMillis();
		
			while((data = bis.read()) != -1) {
				fos.write(data);
			}//while
				
			fos.flush();
		
			end = System.currentTimeMillis();
			log.info("사용하지 않았을 때: "+ (end-start) + "ms");
		}//try-with-resources
			
//			fos.close();		//Base 출력스트림 해제
//			bis.close();		//성능보조입력스트림 해제
//			fis.close();		//Base 입력스트림 해제
			
	}//main
}//end class
