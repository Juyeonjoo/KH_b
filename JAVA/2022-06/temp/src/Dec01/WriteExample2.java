package Dec01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WriteExample2 {

	//핵심포인트: 양동이째로 출력스트림에 쓰자
	public static void main(String[] args) throws Exception {
		
		@Cleanup("close")		//롬복의 자원해제 어노테이션
		OutputStream os = new FileOutputStream("C:/Temp/TTT2.txt", true);
		byte[] data = "가고싶다. ".getBytes();	//문자열> 바이트배열로 변환

		//바이트 배열을 매개변수로 받는, 양동이째로 한꺼번에 썼다.
		os.write(data);						//출력버퍼에쓰자
		os.flush();							//출력버퍼를 강제로 비우기(출력버퍼에 강제로쓰기)
		
//		================================
		//다중행 문자열 리터럴 생성 방법
		String multiline  = """															
				1. %s 행
					2. %s 행
				3. %s 행
				""".formatted("First", "Second", "Third");
		System.out.println(multiline);
		
		/*
		 *1. First 행
			2. Second 행
			3. Third 행
		 * */
	
	}//main
} // end class
