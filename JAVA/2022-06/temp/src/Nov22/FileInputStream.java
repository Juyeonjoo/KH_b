package Nov22;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
//@NoArgsConstructor			//기본생성자 만드는 어노테이션
@AllArgsConstructor						//모든 필드를 매개변수로 받는 어노테이션
//어떤 클래스인가? 파일을 읽는 기능을 제공하는 클래스 
public class FileInputStream implements AutoCloseable { //AutoCloseable 인터페이스를 상속>Override 
	
	private String file;
	
	public void read() {
	log.info("read() invoked.");
	}//read()
	
	@Override
	public void close() throws Exception {
		log.info("close() invoked.");
	} // close

}//end class
