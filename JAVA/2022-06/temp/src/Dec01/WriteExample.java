package Dec01;

import java.io.FileOutputStream;
import java.io.OutputStream;

import lombok.Cleanup;

public class WriteExample {

	//핵심포인트: 파일에 대한 출력스트림을 생성하고 1바이트씩 출력시킨다.
	public static void main(String[] args) throws Exception {
		
		//1. 바이트기반의 출력 스트림 생성
		@Cleanup("close")
		OutputStream os = new FileOutputStream("C:/Temp/TTT2.txt");

		//2. 문자열 = > 바이트 열(바이트 타입의 배열)로 변환
		byte[] data = "안녕".getBytes();		//getBytes 메소드 잘 숙지하기
		//다국어 문자는 최소한 2바이트가 필요, 
		for(int i =0; i<data.length; i++) {
			os.write(data[i]);		//1바이트씩, 파일 출력 스트림에 쓰기
		} //for
		
		//출력버퍼에 잔류가능한 바이트들을 모두 강제로 출력스트림에 쓰기함
		os.flush();
//		os.close(); 롬복에게 맡김
		
	}//main
} //end class
