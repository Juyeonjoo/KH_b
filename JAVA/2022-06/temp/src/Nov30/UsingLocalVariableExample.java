package Nov30;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UsingLocalVariableExample {

	public static void main(String...args) {
		//라이브러리 클래스의 인스턴스 메소드 호출
		UsingLocalVariable ulv = new UsingLocalVariable();
		
		ulv.method(20);
		
		
	}//main
} //end class
