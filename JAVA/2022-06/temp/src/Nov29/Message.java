package Nov29;

import lombok.AllArgsConstructor;
import lombok.ToString;
//선입선출(FIFO)의 자료 구조에 저장할 요소 객체


@ToString
@AllArgsConstructor

public class Message {
	
	public String command;
	public String to;
	
} //end class
