package Dec01;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReadExample3 {

	public static void main(String[] args) throws Exception {
		
		InputStream is = new FileInputStream("C:/Users/user1/TTT.java");
		int readByteNo;
		byte[] readBytes = new byte[8];		//양동이 크기 8바이트
		
		//양동이를 있는 그대로 쓰지 않고 양동이 일부 크기만으로 푸게 만듦
		readByteNo = is.read(readBytes, 2, 3);//offset = 2, length3

//		for(int i =0; i<readBytes.length; i++) {
//			System.out.println(readBytes[i]);
//		}//for
		
		//배열 전체를 출력해주는 코드
		log.info("readBytes: \n "
				+ "{}", Arrays.toString(readBytes));
		
//		is.close();		//수동으로 자원 해제
		
	}//main
} //end class
