package Dec5;

import java.io.FileInputStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileInputSTreamExample {

	//핵심포인트 : 파일 입력 수행을 위해 FileInputStream의 사용법을 알자
	//주의 : 실제 파일이 존재해야 한다
//	=> Otherwise, FileNotFoundException
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/TTT2.txt");
			
			int data;
			//입력스트림(강에물이 흐르듯이 파일 데이터인 바이트가 흘러나오는 것)
			//으로부터 손으로 1바이틕 퍼내겠다
			while( (data =fis.read() )!= -1 ){		//EOF(-1)
				System.out.write(data);
				//void java.io.PrintStream.write(int b)
				//write : 바가지의 offset rank
			}//while
			
			fis.close();
		}catch (Exception e) {
			e.printStackTrace();
		}//try-catch
	}//main

} //end class
